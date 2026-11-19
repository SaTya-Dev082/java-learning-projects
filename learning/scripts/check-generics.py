"""Compile/run the whole lesson and verify intentionally invalid snippets separately."""
from pathlib import Path
import subprocess
import tempfile

ROOT = Path(__file__).resolve().parents[1]
PACKAGE = "com.datajpa.learning.advanced.generics"


def run(arguments):
    return subprocess.run(arguments, text=True, capture_output=True)


with tempfile.TemporaryDirectory(prefix="generics-checks-") as temporary:
    output = Path(temporary)
    sources = list((ROOT / "src/main/java/com/datajpa/learning/advanced/generics").glob("*.java"))
    sources += list((ROOT / "src/test/java/com/datajpa/learning/advanced/generics").glob("*.java"))
    compiled = run(["javac", "--release", "21", "-encoding", "UTF-8", "-Xlint:all", "-Werror",
                    "-d", str(output), *map(str, sources)])
    if compiled.returncode:
        raise SystemExit(compiled.stdout + compiled.stderr)
    for main in ["GenericsDemo", "GenericsChecks"]:
        result = run(["java", "-cp", str(output), f"{PACKAGE}.{main}"])
        print(result.stdout, end="")
        if result.returncode:
            raise SystemExit(result.stderr)

    # Bad examples stay outside src so the project itself remains compilable.
    invalid = {
        "WrongElement": 'void test() { Box<Integer> b = new Box<>(); b.setValue("Hello"); }',
        "PrimitiveArgument": 'Box<int> box;',
        "BoundViolation": 'NumericBox<String> box;',
        "Invariance": 'void test(List<Integer> a) { List<Number> b = a; }',
        "UnknownWrite": 'void test(List<?> a) { a.add("Hello"); }',
        "ExtendsWrite": 'void test(List<? extends Number> a) { a.add(1); }',
        "SuperWrongWrite": 'void test(List<? super Integer> a) { a.add(2.5); }',
        "SuperWrongRead": 'void test(List<? super Integer> a) { Integer b = a.get(0); }',
        "NewTypeParameter": '<T> T test() { return new T(); }',
        "GenericArray": '<T> T[] test() { return new T[10]; }',
        "RuntimeTypeCheck": 'boolean test(Object a) { return a instanceof List<String>; }',
        "ErasureClash": 'void test(List<String> a) {} void test(List<Integer> a) {}',
    }
    for name, body in invalid.items():
        source = output / f"{name}.java"
        source.write_text(f"import java.util.*;\nimport {PACKAGE}.*;\nclass {name} {{ {body} }}\n")
        result = run(["javac", "--release", "21", "-cp", str(output), "-d", str(output), str(source)])
        if result.returncode == 0:
            raise SystemExit(f"FAIL: expected compile rejection for {name}")
        print(f"PASS compile rejection: {name}")

    raw = output / "RawWarning.java"
    raw.write_text('import java.util.*; class RawWarning { void test() { List a = new ArrayList(); a.add("x"); } }')
    result = run(["javac", "--release", "21", "-Xlint:rawtypes,unchecked", "-Werror", str(raw)])
    if result.returncode == 0:
        raise SystemExit("FAIL: expected raw/unchecked warnings under -Werror")
    print("PASS: raw/unchecked warnings are rejected under -Werror.")

print("All Generics session checks passed.")
