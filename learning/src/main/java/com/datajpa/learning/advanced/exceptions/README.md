# Exception Handling — whole-session guide

## Coverage និងលំដាប់អាន

| ចំណុច | កូដ |
|---|---|
| throw / propagation / specific try-catch | propagation/Product, OrderService, ExceptionPropagationDemo |
| Custom unchecked exception | propagation/InsufficientStockException |
| Checked IOException និង throws | complete/QuantityFileReader.readQuantity |
| Unchecked input errors | Integer.parseInt និង validation ក្នុង QuantityFileReader |
| Exception wrapping និង cause | complete/OrderImportException, OrderImportService |
| finally | complete/ExceptionHandlingDemo.demonstrateImport |
| try-with-resources និង file I/O | complete/QuantityFileReader |
| AutoCloseable និង reverse close order | complete/ResourceProbe និង demonstrateResourceOrder |
| Suppressed Exceptions | demonstrateSuppressedExceptions និង CompleteExceptionChecks |
| Stack Trace / Caused by | demonstrateImport ពេល missing file |
| Real-world boundary handling | OrderImportService និង demonstrateImport |

## File import flow

Input file មានបន្ទាត់តែមួយ ជាចំនួនទំនិញវិជ្ជមាន។
Demo បង្កើត files បណ្ដោះអាសន្នដោយខ្លួនឯង និងសម្អាតក្រោយប្រើ។

1. QuantityFileReader បើក BufferedReader ក្នុង try-with-resources។
2. readLine អាចបោះ checked IOException។ readQuantity ប្រកាស throws IOException;
   throws មិនដោះស្រាយបញ្ហា ហើយមិនបោះ Exception ដោយខ្លួនឯង។
3. parseInt អាចបោះ NumberFormatException (unchecked)។ Empty, nonpositive ឬ multiple lines
   ត្រូវបដិសេធ។ Reader ត្រូវបាន close ទោះ read ឬ parse បរាជ័យ។
4. OrderImportService catch តែ IOException ហើយ wrap ជា OrderImportException ដោយរក្សា cause។
5. បើអានបាន វាហៅ OrderService.placeOrder ដែលអាចបោះ InsufficientStockException។
6. Boundary ចាប់ប្រភេទជាក់លាក់ បង្ហាញ error; មិនបង្ហាញ SUCCESS សម្រាប់ការបរាជ័យ។
7. finally បង្ហាញ attempt finished ទោះ success/failure។ វាមិនមែនជា success indicator។
8. កូដក្រោយ try/catch/finally បន្ត បើកន្លែងទាំងនោះបញ្ចប់តាមធម្មតា។

Demo stock ចាប់ផ្ដើម 10: valid file "3" → stock 7; invalid/missing files → នៅ 7។
Exception មិន rollback State ដោយខ្លួនឯង។ ឧទាហរណ៍នេះ validate មុនកាត់ស្តុក។

## Checked និង Unchecked

Exception កើតនៅ runtime ទាំងពីរប្រភេទ។ Checked មាន compiler rule ថាត្រូវ catch ឬ declare throws។
IOException ជា checked។ RuntimeException និងកូនជា unchecked; NumberFormatException
ជាកូន IllegalArgumentException ដូច្នេះ catch មេអាចចាប់វាបាន។ Error ក៏ជា unchecked
ប៉ុន្តែមិនប្រើសម្រាប់ business failures ធម្មតា។
Custom Exception អាច extends Exception សម្រាប់ checked ឬ RuntimeException សម្រាប់ unchecked។

## Stack Trace, Cause និង Suppressed

- បន្ទាត់ដំបូងបង្ហាញប្រភេទ Exception និង message។
- `at ...File.java:line` បង្ហាញ call stack: មើលទីតាំងបោះ និង code របស់យើងដែលហៅវា។
- `Caused by` បង្ហាញ original failure ដែល wrapper រក្សាតាម super(message, cause)។
- `getCause()` អានមូលហេតុ; `getSuppressed()` អានបញ្ហាបន្ថែមពេល cleanup។
- Body failure នៅតែ primary; close failures ជា suppressed។
  Resources បិទបញ្ច្រាសពីការបើក។ បើ body ជោគជ័យ ប៉ុន្តែ close បរាជ័យ
  close failure ក៏អាចធ្វើឱ្យ try-with-resources បញ្ចប់ដោយ Exception។

## finally និង practices ក្នុង Project ពិត

- finally ជាទូទៅដំណើរការពេលចាកចេញពី try/catch រួមទាំង return ឬ Exception។
  កុំសន្មតថាវាធានាប្រតិបត្តិក្នុង JVM termination, process kill ឬ crash។
- កុំ return ក្នុង finally ឬបោះ Exception ថ្មីដោយមិនគិត ព្រោះវាអាចលាក់លទ្ធផល/បញ្ហាដើម។
- ប្រើ try-with-resources សម្រាប់ AutoCloseable ជំនួស close ដោយដៃក្នុង finally។
- ចាប់ប្រភេទជាក់លាក់ ដែលអ្នកអាចដោះស្រាយ ឬបន្ថែម context បាន។ កុំ catch ហើយលាក់ចោល។
- បើ catch ច្រើនប្រភេទដែលជាមេ/កូន ដាក់កូនមុនមេ។
- កុំ retry គ្រប់ Exception; invalid input និង insufficient stock មិនជួសជុលដោយ retry ភ្លាមៗទេ។
- Demo printStackTrace ដើម្បីរៀនអាន។ Production ប្រើ logger នៅកន្លែងមាន context
  និងកុំបង្ហាញ stack trace/internal paths ទៅ API users។
- main declares IOException សម្រាប់ fixture setup/cleanup ដែលមិនគួរលាក់ជាជោគជ័យ។
  cleanup ដោយ Files.deleteIfExists ក៏អាចបរាជ័យបាន; នេះជា demo fixtures មិនមែន production storage workflow។

មេរៀននេះជា local in-memory stock/file example មិនមាន DB transaction ឬ external service។
Spring global exception handler នឹងរៀននៅដំណាក់កាល Backend API តាមផែនការ។

## Run ពី folder learning

```sh
javac -encoding UTF-8 --release 21 -d target/exceptions-session src/main/java/com/datajpa/learning/advanced/exceptions/propagation/*.java src/main/java/com/datajpa/learning/advanced/exceptions/complete/*.java src/test/java/com/datajpa/learning/advanced/exceptions/propagation/PropagationChecks.java src/test/java/com/datajpa/learning/advanced/exceptions/CompleteExceptionChecks.java
java -cp target/exceptions-session com.datajpa.learning.advanced.exceptions.complete.ExceptionHandlingDemo
java -cp target/exceptions-session com.datajpa.learning.advanced.exceptions.propagation.PropagationChecks
java -cp target/exceptions-session com.datajpa.learning.advanced.exceptions.CompleteExceptionChecks
```

ក្នុង VS Code ចុច Run ក្នុង complete/ExceptionHandlingDemo.java ដើម្បីមើល whole-session demo។
Stack trace សម្រាប់ missing file គឺ expected teaching output មិនមែនការដំណើរការដួលទេ។

លំហាត់៖ ប្ដូរ valid file ទៅ "20" ហើយពន្យល់ថា reader, stock validation,
catch និង finally ដំណើរការតាមលំដាប់ណា។
