# Object composition: orders use payments

អាន៖ PaymentService → SimulatedPaymentService → OrderService → CompositionDemo។

- `OrderService` **has-a** `PaymentService` reference; វាមិនមែនជា PaymentService ទេ។
- `private final PaymentService paymentService` ជា dependency ដែល Object រក្សាទុក។
- Constructor ទទួល dependency ពីខាងក្រៅ (manual constructor injection)។
- `paymentService.pay(...)` ជា Delegation: ប្រគល់ការងារទូទាត់ទៅ Object ផ្សេង។
- OrderService ពិនិត្យសំណើ និងសម្រេចថាតើអាចបញ្ជាក់ order បានឬអត់។
- PaymentService implementation ទទួលខុសត្រូវចំពោះលទ្ធផលទូទាត់។
- ប្ដូរ payment implementation បាន ដោយមិនកែ OrderService។

## Flow

`placeOrder` → validate order → delegate payment → confirm if approved / return false if declined។
Invalid order ត្រូវបដិសេធមុនពេលហៅ payment។
Demo ប្រើ cents: 2500 cents = USD 25.00។

## Object composition និង UML Composition

នេះជាការផ្សំ Objects ក្នុងការរចនាកូដ។ PaymentService ត្រូវបានបង្កើតពីខាងក្រៅ
ហើយអាចចែករំលែកបាន ដូច្នេះកូដនេះមិនបញ្ជាក់ ownership/lifecycle តឹងរ៉ឹងតាម UML Composition ទេ។
Order **មិនមែនជា** Payment; service មួយគ្រាន់តែប្រើ service មួយទៀត។

## កម្រិតរបស់ឧទាហរណ៍

SimulatedPaymentService បង្ហាញ Console និងលទ្ធផលកំណត់ជាមុន។
មិនមានការទូទាត់ពិត, database, stock reservation ឬការរក្សាទុក order ទេ។
Production checkout ត្រូវគ្រប់គ្រង payment failures/timeouts, idempotency និង order state
ដើម្បីកុំទូទាត់ស្ទួន។ boolean នៅទីនេះប្រើសម្រាប់យល់ OOP ជាមុន។

## Run ពី folder learning

```sh
javac -encoding UTF-8 --release 21 -d target/composition-demo src/main/java/com/datajpa/learning/fundamentals/composition/*.java src/test/java/com/datajpa/learning/fundamentals/composition/CompositionChecks.java
java -cp target/composition-demo com.datajpa.learning.fundamentals.composition.CompositionDemo
java -cp target/composition-demo com.datajpa.learning.fundamentals.composition.CompositionChecks
```

ឬចុច Run ក្បែរ main ក្នុង CompositionDemo នៅ VS Code។
លំហាត់៖ បន្ថែម payment implementation ដែលបដិសេធចំនួនលើស 10000 cents
រួចផ្ដល់វាទៅ OrderService ដោយមិនកែ OrderService។

បន្ទាប់៖ រំលឹក Java OOP រួចចូល Exception Handling ក្នុងដំណាក់កាលទី២។
