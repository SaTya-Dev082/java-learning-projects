# Interface: order confirmation notifications

អាន៖ NotificationService → EmailNotification/SmsNotification → OrderConfirmationService → InterfaceDemo។

## កិច្ចសន្យា និងការអនុវត្ត

- `NotificationService` កំណត់ `send(recipient, message)`។ Declaration នេះគឺ public abstract។
- `implements` បញ្ជាក់ថា Class គោរពកិច្ចសន្យា; Concrete Class ត្រូវផ្ដល់ការអនុវត្ត។
- Methods ដែលអនុវត្តត្រូវជា `public`; `@Override` ជួយ compiler ពិនិត្យ signature។
- `NotificationService email = new EmailNotification()` ប្រើ Interface reference យោងទៅ Object ពិត។
- `OrderConfirmationService` ដឹងត្រឹមកិច្ចសន្យា ដោយមិនមាន if/switch តាម channel។
- Constructor ទទួល implementation ពីខាងក្រៅ។ នេះជា constructor dependency injection ដោយដៃ;
  មិនត្រូវការ Spring។ យើងនឹងរៀន Spring DI ពេលក្រោយ។
- ការមាន field `NotificationService` ក៏នាំទៅគំនិត has-a ដែលនឹងរៀនក្នុង Composition។

## ប្រើក្នុង Project ពិត

Order confirmation service អាចហៅក្រោយពេល order រក្សាទុកជោគជ័យ។
ឧទាហរណ៍នេះមិនរក្សាទុក order ហើយមិនទាក់ទង Email/SMS provider ទេ។
Implementations ទាំងពីរបង្ហាញតែ Console។ Production implementation អាចទាក់ទង provider
ហើយត្រូវកំណត់ច្បាប់ recipient validation, failures, retries និង duplicate delivery ឱ្យច្បាស់។

`NotificationChecks` ប្រើ recording implementation ដើម្បីពិនិត្យការផ្ញើមួយលើក
និងមាតិកាត្រឹមត្រូវ ដោយមិនផ្ញើសារទៅអ្នកណាម្នាក់។

## Interface និង Abstract Class

Interface គ្មាន constructor ឬ instance fields។ Class មួយ implement Interfaces ច្រើនបាន
ប៉ុន្តែ extend Class មេបានមួយ។ Interface អាចមាន default/static/private methods ដែលមាន body
និង constants ដែលជា public static final។

សម្រាប់ shipping មេរៀនមុន យើងជ្រើស Abstract Class ដើម្បីចែករំលែក workflow និង State។
សម្រាប់ notification នេះ យើងប្រើ Interface ដើម្បីផ្ដល់កិច្ចសន្យារួម ដោយមិនតម្រូវគ្រឹះ Class រួម។

## Run ពី folder learning

```sh
javac -encoding UTF-8 --release 21 -d target/interface-demo src/main/java/com/datajpa/learning/fundamentals/interfaces/*.java src/test/java/com/datajpa/learning/fundamentals/interfaces/NotificationChecks.java
java -cp target/interface-demo com.datajpa.learning.fundamentals.interfaces.InterfaceDemo
java -cp target/interface-demo com.datajpa.learning.fundamentals.interfaces.NotificationChecks
```

ឬចុច Run ក្បែរ main ក្នុង InterfaceDemo នៅ VS Code។
លំហាត់៖ បន្ថែម TelegramNotification ជា Console simulation ដែល implements NotificationService
រួចផ្ដល់វាទៅ OrderConfirmationService ដោយមិនកែ service នោះ។

មេរៀនបន្ទាប់៖ Composition។
