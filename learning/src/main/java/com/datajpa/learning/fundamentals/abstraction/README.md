# Abstraction: shipping quotes at checkout

បរិបទ៖ Checkout ត្រូវបង្ហាញថ្លៃដឹកជញ្ជូនធម្មតា និងរហ័ស។
វាស្នើតម្លៃតាម `ShippingService` ដោយមិនចាំបាច់ដឹងរូបមន្តរបស់សេវានីមួយៗ។
តម្លៃក្នុងឧទាហរណ៍ជាតម្លៃសន្មត មិនមែនតម្លៃរបស់ក្រុមហ៊ុនដឹកជញ្ជូនពិត។

## អានតាមលំដាប់

1. `ShippingService`: Abstract Class មាន constructor, private state, concrete methods និង abstract method។
2. `StandardShipping` និង `ExpressShipping`: Concrete Classes ផ្ដល់រូបមន្តផ្សេងគ្នា។
3. `AbstractionDemo`: Checkout ធ្វើការតាមប្រភេទរួម។

## គំនិតសំខាន់

- មិនអាច `new ShippingService(...)` ដោយផ្ទាល់។ អាចប្រើវាជា reference type បាន។
- `protected abstract calculateFeeCents(...)` គ្មាន body; Concrete Class ត្រូវអនុវត្ត។
- `quoteCents(...)` មាន implementation រួម ហើយហៅ abstract method ដែលកូនអនុវត្ត។
- `final` រារាំងការប្ដូរ public operation នេះ ដូច្នេះគ្រប់សេវាឆ្លងកាត់ validation ដូចគ្នា។
- `protected` អនុញ្ញាត subclasses និង code ក្នុង package ចូលប្រើ;
  checkout គួរប្រើ public `quoteCents`។ នេះមិនមែនជា security boundary ទេ។
- `super(...)` រៀបចំ State របស់មេ នៅពេលបង្កើត Object កូន។
- `@Override` បញ្ជាក់ការអនុវត្ត abstract method។
- Abstraction គឺអ្នកហៅប្រើមុខងារ quote ដោយមិនដឹងរូបមន្ត;
  Polymorphism គឺ Java ជ្រើសរូបមន្តរបស់ Object កូននៅ runtime។

លំដាប់ `quoteCents`: ពិនិត្យទម្ងន់ → គណនាតាមកូន → ពិនិត្យលទ្ធផល → return។
រចនាបែបនេះគេហៅថា Template Method pattern; ចាំរៀនលម្អិតនៅដំណាក់កាល Design Patterns។

## ច្បាប់គណនា

- Input ជាក្រាម និងត្រូវធំជាង 0។ 1001 ក្រាមគិតជា 2 គីឡូក្រាម។
- Standard: USD 2 + USD 1 × គីឡូក្រាមដែលគិតថ្លៃ។
- Express: USD 5 + USD 2 × គីឡូក្រាមដែលគិតថ្លៃ។
- រក្សាប្រាក់ជា `long` cents (100 cents = USD 1) ដើម្បីមិនប្រើ floating-point សម្រាប់ប្រាក់។
- `999L` ធ្វើឱ្យការបូកប្រើ long ដើម្បីមិន overflow នៅទម្ងន់ int ធំបំផុត។

ក្នុងប្រព័ន្ធពិត សមស្របប្រើ Abstract Class ពេល implementations មាន workflow
និង State/helper រួមដែលមានន័យ។ បើគ្រាន់តែត្រូវការកិច្ចសន្យា អាចជ្រើស Interface
ដែលយើងនឹងរៀនបន្ទាប់។ Demo នេះគណនាតម្លៃក្នុង memory មិនទាន់បង្កើត shipment
ឬទាក់ទង courier API ទេ។

## Run ពី folder learning

```sh
javac -encoding UTF-8 --release 21 -d target/abstraction-demo src/main/java/com/datajpa/learning/fundamentals/abstraction/*.java src/test/java/com/datajpa/learning/fundamentals/abstraction/ShippingChecks.java
java -cp target/abstraction-demo com.datajpa.learning.fundamentals.abstraction.AbstractionDemo
java -cp target/abstraction-demo com.datajpa.learning.fundamentals.abstraction.ShippingChecks
```

ក្នុង VS Code អាចចុច Run ក្បែរ main ក្នុង `AbstractionDemo`។
លំហាត់៖ បន្ថែម EconomyShipping ដែលមានរូបមន្តផ្ទាល់ខ្លួន រួចប្រើ
`showShippingOption` ដដែលដោយមិនកែ Method នោះ។

មេរៀនបន្ទាប់៖ Interface។
