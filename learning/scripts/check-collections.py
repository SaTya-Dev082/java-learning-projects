"""Compile and run the complete Collections lesson without Spring or a database."""
from pathlib import Path
import subprocess
import tempfile

root = Path(__file__).resolve().parents[1]
package = "com.datajpa.learning.advanced.collections"
sources = list((root / "src/main/java/com/datajpa/learning/advanced/collections").glob("*.java"))
sources += list((root / "src/test/java/com/datajpa/learning/advanced/collections").glob("*.java"))

with tempfile.TemporaryDirectory(prefix="collections-checks-") as output:
    subprocess.run(["javac", "--release", "21", "-encoding", "UTF-8", "-Xlint:all", "-Werror",
                    "-d", output, *map(str, sources)], check=True)
    for main in ["CollectionsDemo", "CollectionsChecks"]:
        subprocess.run(["java", "-cp", output, f"{package}.{main}"], check=True)

print("All Collections session checks passed.")
