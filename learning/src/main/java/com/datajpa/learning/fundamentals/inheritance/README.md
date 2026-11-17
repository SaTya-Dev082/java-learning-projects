# Inheritance: Vehicle, Car, Motorcycle

អានកូដតាមលំដាប់៖ Vehicle → Car → Motorcycle → InheritanceDemo។

- `Vehicle` ជា Superclass; `Car` និង `Motorcycle` ជា Subclasses។
- `extends` បញ្ជាក់ថា Car **is a** Vehicle។ Car ជាប្រភេទ; `Corolla` ជាតម្លៃ model។
- `super(brand, model)` ហៅ Constructor របស់មេ។ Constructors មិនត្រូវបានទទួលមរតកទេ។
- `start()`, `displayInfo()` និង getters ជា public methods ដែលកូនទទួលមរតក។
- Fields `private` ក្នុង Vehicle មិនត្រូវបានទទួលមរតកដោយកូនទេ;
  Object កូនមាន State ដែល Constructor មេកំណត់ ហើយប្រើវាតាម Methods មេ។
- `openTrunk()` ស្ថិតក្នុង Car; Motorcycle មិនទទួលមុខងារនេះទេ។
- គំរូនេះសន្មតថា Car មានឃ្លុប និង Motorcycle មានជើងទម្រ។
  ជ្រើស hierarchy តាមប្រភេទយានយន្តដែលប្រព័ន្ធពិតរបស់អ្នកគាំទ្រ។

ពី folder `learning` ឬបើក `InheritanceDemo.main()` ក្នុង VS Code៖

```sh
javac -encoding UTF-8 --release 21 -d target/inheritance-demo src/main/java/com/datajpa/learning/fundamentals/inheritance/*.java
java -cp target/inheritance-demo com.datajpa.learning.fundamentals.inheritance.InheritanceDemo
```

លំហាត់៖ បង្កើត `Truck extends Vehicle` ហើយបន្ថែម `loadCargo()`។
ប្រើ `start()` ដែលបានទទួលមរតក ដោយមិនសរសេរវាឡើងវិញ។

មេរៀនបន្ទាប់៖ Polymorphism។
