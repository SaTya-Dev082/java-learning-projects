# Polymorphism: same operation, different implementations

មេរៀននេះប្រើ package ថ្មី ដើម្បីរក្សាឧទាហរណ៍ Inheritance មុននៅដដែល។
អានតាមលំដាប់៖ Vehicle → Car → Motorcycle → PolymorphismDemo។

## Reference type និង Object type

```java
Vehicle vehicle = new Car("Corolla");
```

- `Vehicle`៖ declared/reference type។ Compiler ប្រើវាពិនិត្យ Method ដែលអាចហៅបាន។
- `new Car(...)`៖ Object ជាក់ស្ដែងជា Car; មិនបានបង្កើត Vehicle object ទីពីរទេ។
- ការយោង Object កូនតាមប្រភេទមេហៅថា upcasting; មិនចាំបាច់ cast ដោយដៃ។
- `vehicle.makeSound()` ប្រើ `Car.makeSound()` នៅ runtime។
- ប្ដូរ reference ទៅ Motorcycle នឹងហៅ `Motorcycle.makeSound()`។

## Overriding និង runtime dispatch

Class កូន Override instance method ដែលមាន signature ត្រូវគ្នា។
ក្នុងឧទាហរណ៍នេះ Methods ទាំងអស់មានឈ្មោះ `makeSound`, គ្មាន parameter
និង return type `String`។ `@Override` ជួយរកកំហុស signature ពេល compile។

`announceArrival(Vehicle)` និង loop លើ `Vehicle[]` បង្ហាញថា code អ្នកប្រើ
អាចធ្វើការជាមួយប្រភេទរួម ដោយមិនចាំបាច់ពិនិត្យប្រភេទជាក់ស្ដែងមុនហៅ Method។
ក្នុងប្រព័ន្ធពិត គំនិតនេះអាចប្រើសម្រាប់ notification ឬ payment implementations។

## កម្រិតដែលត្រូវយល់

- `Vehicle` reference មិនអាចហៅ `openTrunk()` ព្រោះ Vehicle គ្មាន Method នេះ។
- `instanceof Car car` ពិនិត្យប្រភេទ និងផ្ដល់ Car reference ដោយសុវត្ថិភាព។
  វាមានក្នុង Demo សម្រាប់មុខងារជាក់លាក់; runtime dispatch មិនត្រូវការវាទេ។
- បើកូនមិន Override Method នោះ វាប្រើ implementation ដែលទទួលមរតក។
- Fields មិនប្រើ runtime dispatch ដូច instance methods ទេ។
- Static methods ត្រូវបាន hide; private methods មិនត្រូវបាន Override;
  final methods មិនអនុញ្ញាតឱ្យ Override។
- Overloading គឺឈ្មោះ Method ដូចគ្នា ប៉ុន្តែ parameters ខុសគ្នា;
  compiler ជ្រើស signature តាម declared types។ វាខុសពី Overriding ដែលរៀននៅទីនេះ។

## Run ពី folder learning

```sh
javac -encoding UTF-8 --release 21 -d target/polymorphism-demo src/main/java/com/datajpa/learning/fundamentals/polymorphism/*.java src/test/java/com/datajpa/learning/fundamentals/polymorphism/PolymorphismChecks.java
java -cp target/polymorphism-demo com.datajpa.learning.fundamentals.polymorphism.PolymorphismDemo
java -cp target/polymorphism-demo com.datajpa.learning.fundamentals.polymorphism.PolymorphismChecks
```

ឬចុច Run ក្បែរ main ក្នុង VS Code។ មិនត្រូវការ database ឬ Spring server។

លំហាត់៖ បន្ថែម `Truck extends Vehicle`, Override `makeSound()` ហើយដាក់វាក្នុង
fleet។ សាកល្បងថា `announceArrival()` មិនត្រូវការកែប្រែ។

មេរៀនបន្ទាប់៖ Abstraction។
