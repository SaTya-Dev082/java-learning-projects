# Encapsulation: Product stock

គោលដៅ៖ Object គ្រប់គ្រង State របស់ខ្លួនតាមច្បាប់។

- `private stockQuantity`៖ មិនអនុញ្ញាតកែស្តុកដោយផ្ទាល់។
- `getStockQuantity()`៖ មើលស្តុក ដោយមិនប្ដូរវា។
- Constructor៖ ស្តុកដំបូងមិនអាចអវិជ្ជមាន; ឈ្មោះមិនអាចទទេ។
- `addStock(quantity)`៖ ចំនួនត្រូវធំជាង 0 និងមិនលើសកម្រិត int។
- `reduceStock(quantity)`៖ ចំនួនត្រូវធំជាង 0 និងមិនលើសស្តុក។
- ពិនិត្យមុនកែ State៖ បើបដិសេធ ស្តុកនៅដដែល។
- គ្មាន Setter ដែលអនុញ្ញាតឱ្យរំលងច្បាប់ទាំងនេះ។

`IllegalArgumentException` ប្រាប់ថាតម្លៃបញ្ចូលមិនត្រឹមត្រូវ។ Demo ប្រើ
`try/catch` ដើម្បីបង្ហាញមូលហេតុ ហើយបន្តដំណើរការ។ Exception Handling
នឹងរៀនលម្អិតនៅដំណាក់កាលទី២។

នេះជា plain Java example សម្រាប់ប្រើក្នុងកម្មវិធីមួយដំណើរការតាមលំដាប់។
ប្រព័ន្ធលក់ដែលមានការទិញក្នុងពេលតែមួយត្រូវការការគ្រប់គ្រង concurrency
និង database transactions ដែលយើងនឹងរៀនពេលក្រោយ។

Run `EncapsulationDemo.main()` ក្នុង IDE ឬពី folder `learning`៖

```sh
javac -encoding UTF-8 --release 21 -d target/encapsulation-demo src/main/java/com/datajpa/learning/fundamentals/encapsulation/*.java src/test/java/com/datajpa/learning/fundamentals/encapsulation/ProductStockChecks.java
java -cp target/encapsulation-demo com.datajpa.learning.fundamentals.encapsulation.EncapsulationDemo
java -cp target/encapsulation-demo com.datajpa.learning.fundamentals.encapsulation.ProductStockChecks
```

លំហាត់៖ បង្កើតផលិតផលដែលមានស្តុក 0, បន្ថែម 8, លក់ 8 រួចសាកលក់ 1 ទៀត។
ពិនិត្យថាសំណើចុងក្រោយត្រូវបានបដិសេធ ហើយស្តុកនៅតែ 0។
