# throw, propagation, try/catch

អាន៖ InsufficientStockException → Product → OrderService → ExceptionPropagationDemo។
មេរៀននេះផ្ដោតលើ propagation; Checked Exceptions និង try-with-resources នឹងមានលំហាត់ផ្សេង។

## លំហូរកូដ

1. main បង្កើត Product ស្តុក 10 និង OrderService ដែលប្រើ Product នោះ។
2. attemptOrder ហៅ placeOrder ក្នុង try។
3. OrderService ប្រគល់ការកាត់ស្តុកទៅ Product.reduceStock។
4. Product ពិនិត្យមុនកែ State: <= 0 បោះ IllegalArgumentException;
   លើសស្តុកបោះ InsufficientStockException។
5. Exception បន្តពី Product ទៅ OrderService រួច attemptOrder ព្រោះគ្មាន catch កណ្ដាល។
6. catch ប្រភេទដែលត្រូវគ្នាបង្ហាញសារបដិសេធ។ កូដក្រោយ try/catch អាចបន្ត។

ករណី 20: ស្តុកនៅ 10; រំលងទាំង order confirmed និង SUCCESS។
ករណី 3 បន្ទាប់: ស្តុកចុះទៅ 7; បង្ហាញ order confirmed និង SUCCESS។
ករណី -5: ចាប់ IllegalArgumentException; ស្តុកនៅ 7។

## តួនាទីសំខាន់

- Custom Exception extends RuntimeException: unchecked មិនបង្ខំប្រកាស throws។
- super(message) ផ្ដល់សារទៅ Exception មេ; fields រក្សាចំនួនសម្រាប់អ្នកហៅ។
- throw បោះ Object Exception; throws គ្រាន់តែប្រកាសនៅ Method signature។
- catches បែងចែកប្រភេទបញ្ហា មិនប្រៀបធៀបអត្ថបទសារដើម្បីសម្រេចប្រភេទ។
- ចាប់នៅ caller ដែលអាចបង្ហាញលទ្ធផល; មិនចាប់ហើយលាក់ក្នុង Service។
- Exception មិន rollback State ដោយស្វ័យប្រវត្តិ។ State នៅដដែលព្រោះ validation នៅមុន mutation។
- បើ catch បោះ Exception ថ្មី កូដក្រោយប្លុកមិនចាំបាច់អាចបន្តដូច Demo ទេ។

នេះជាការកាត់ស្តុកក្នុង memory មិនមាន database/payment/order persistence ឬ concurrency។
ក្នុង Spring API យើងនឹងរៀនបម្លែង domain exception ទៅ HTTP response នៅ boundary រួម។

## Run ពី folder learning

```sh
javac -encoding UTF-8 --release 21 -d target/propagation-demo src/main/java/com/datajpa/learning/advanced/exceptions/propagation/*.java src/test/java/com/datajpa/learning/advanced/exceptions/propagation/PropagationChecks.java
java -cp target/propagation-demo com.datajpa.learning.advanced.exceptions.propagation.ExceptionPropagationDemo
java -cp target/propagation-demo com.datajpa.learning.advanced.exceptions.propagation.PropagationChecks
```

ឬចុច Run ក្បែរ main ក្នុង ExceptionPropagationDemo នៅ VS Code។
លំហាត់៖ ប្ដូរសំណើដំបូងទៅ 10 ហើយទស្សន៍ទាយលទ្ធផលសំណើទីពីរ មុន Run។
