# កំណត់ត្រាសង្ខេប — Java → Spring → Spring Boot

បានធ្វើបច្ចុប្បន្នភាព៖ 2026-11-20។ គ្របដណ្ដប់ Java OOP, Exception Handling, Generics និង Collections។ Collections ចំណុច 6–12 រៀនតាម note និងកូដតាមសំណើអ្នករៀន។
នេះមិនមែនជាការបញ្ជាក់ថាអ្នករៀនបានអនុវត្តដោយខ្លួនឯងគ្រប់ចំណុចទេ។

**របៀបអាន៖** ឧទាហរណ៍ខ្លះជា Class ពេញ ខ្លះជា Method ឬ Statements ដែលត្រូវដាក់ក្នុង Class/main ដែលពាក់ព័ន្ធ។ Class ឈ្មោះដូចគ្នាក្នុងមេរៀនផ្សេងគ្នាជាឧទាហរណ៍ដាច់ដោយឡែក មិនត្រូវ Copy ទាំងអស់ក្នុង File តែមួយទេ។ Collection examples ប្រើ `java.util.List` និង `java.util.ArrayList`; file examples ប្រើ imports ពី `java.io` និង `java.nio.file` តាមកូដ Project។

## 1. Class and Object

**និយមន័យ៖** Class ជាគំរូកំណត់ទិន្នន័យ និងមុខងារ។ Object ជា Instance ជាក់លាក់ដែលបង្កើតពី Class។ OOP ជាការរៀបចំកម្មវិធីតាម Objects និងទំនាក់ទំនងរបស់វា។

**Syntax / ឧទាហរណ៍៖**

```java
class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}
// ក្នុង main():
// Student dara = new Student("Dara");
```

**ការប្រើប្រាស់៖** តំណាងឱ្យ Student, Product, Customer ឬ Order ក្នុងប្រព័ន្ធ។
**កូដមេរៀន៖** `src/main/java/com/datajpa/learning/fundamentals/classobject/`។

### 1.1. Constructors

**និយមន័យ៖** Constructor រៀបចំ State ដំបូងពេលបង្កើត Object; ឈ្មោះដូច Class និងគ្មាន Return Type។

```java
public Student(String name) {
    this.name = name;
}
```

**ការប្រើប្រាស់៖** កំណត់ឈ្មោះពេល `new Student("Dara")`។ Constructor មិនត្រូវបានទទួលមរតកទេ។

### 1.2. Fields និង State

**និយមន័យ៖** Field ជា Variable ក្នុង Class; State ជាតម្លៃបច្ចុប្បន្នរបស់ Fields របស់ Object។

```java
private String name;
private int score;
```

**ឧទាហរណ៍៖** Object មួយមាន name = Dara និង score = 90; មួយទៀតមាន State ផ្សេង។

### 1.3. Methods និង Behavior

**និយមន័យ៖** Method កំណត់មុខងារ; Behavior ជាសកម្មភាពដែល Object អាចធ្វើ។

```java
public void changeName(String newName) {
    this.name = newName;
}
```

**ការប្រើប្រាស់៖** `dara.changeName("Visal")` ប្ដូរ State របស់ Object នោះ។ `void` មានន័យថាគ្មានតម្លៃ return។

### 1.4. this

**និយមន័យ៖** `this` យោងទៅ Object បច្ចុប្បន្ន។

```java
this.name = name;
```

**ពន្យល់៖** ខាងឆ្វេងជា Field របស់ Object; ខាងស្ដាំជា Parameter ក្នុង Constructor។

### 1.5. References និង Identity

**និយមន័យ៖** Reference ជាតម្លៃយោងទៅ Object; Identity ជាភាពជាវត្ថុដាច់ដោយឡែក ទោះ State ដូចគ្នា។

```java
Student first = new Student("Dara");
Student alias = first;
Student second = new Student("Dara");
System.out.println(first == alias);  // true
System.out.println(first == second); // false
```

**ចំណាំ៖** Variables ពីរអាចយោងទៅ Object តែមួយ។ `==` នៅទីនេះប្រៀបធៀប Reference identity មិនមែនឈ្មោះសិស្ស។

**ចំណុចគន្លឹះ៖** Class មួយបង្កើត Objects ច្រើនបាន; Fields រក្សា State; Methods ផ្ដល់ Behavior; Reference មិនមែនជា Object ខ្លួនឯង។

## 2. Encapsulation

**និយមន័យ៖** ដាក់ទិន្នន័យ និងមុខងារគ្រប់គ្រងវាជាមួយគ្នា ហើយកំណត់ការចូលប្រើ ដើម្បីឱ្យ State គោរពច្បាប់។

```java
class Product {
    private int stockQuantity;

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void reduceStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (quantity > stockQuantity) {
            throw new IllegalArgumentException("Not enough stock.");
        }
        stockQuantity -= quantity;
    }
}
```

**ការប្រើប្រាស់៖** ទប់ស្កាត់ការកែស្តុក ឬសមតុល្យដែលខុសច្បាប់។
**កូដមេរៀន៖** `fundamentals/encapsulation/`។ ឧទាហរណ៍ពេញមាន Constructor និង addStock។

### 2.1. private និង Getter

**និយមន័យ៖** `private` កំណត់ការចូលប្រើដោយផ្ទាល់; Getter ផ្ដល់មុខងារអានតម្លៃ។

```java
private int stockQuantity;
public int getStockQuantity() {
    return stockQuantity;
}
```

**ចំណាំ៖** មិនចាំបាច់បង្កើត Setter សម្រាប់គ្រប់ Field។ `setStockQuantity` ដែលមិនពិនិត្យច្បាប់អាចបើកផ្លូវឱ្យ State ខុស។

### 2.2. Validation មុន Mutation

**និយមន័យ៖** Validation ពិនិត្យតម្លៃ/ច្បាប់; Mutation ជាការកែ State។

```java
if (quantity <= 0 || quantity > stockQuantity) {
    throw new IllegalArgumentException("Invalid stock reduction.");
}
stockQuantity -= quantity;
```

**ការប្រើប្រាស់៖** បដិសេធសំណើមុនកាត់ស្តុក។ បើ throw មុន mutation ស្តុកនៅដដែល។

### 2.3. ការពារ Integer Overflow

**និយមន័យ៖** លទ្ធផលលេខគត់ដែលលើសកម្រិត int អាចវិលទៅតម្លៃខុស ដោយមិនបោះ Exception សម្រាប់ `+` ធម្មតា។

```java
if (quantity > Integer.MAX_VALUE - stockQuantity) {
    throw new IllegalArgumentException("Stock exceeds supported limit.");
}
stockQuantity += quantity;
```

**លក្ខខណ្ឌ៖** ប្រើក្រោយពិនិត្យ quantity > 0 និងរក្សា stockQuantity >= 0។ `Integer.MAX_VALUE` = 2,147,483,647។

**ចំណុចគន្លឹះ៖** private ការពារការកែដោយផ្ទាល់; validation ក្នុង Methods ការពារច្បាប់អាជីវកម្ម។

## 3. Inheritance

**និយមន័យ៖** Class កូនទទួល Members ដែលអនុញ្ញាតពី Class មេ តាមទំនាក់ទំនង **is-a**។

```java
class Vehicle {
    private final String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void start() {
        System.out.println(model + " starting");
    }
}

class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }
}
```

**ការប្រើប្រាស់៖** Car គឺជា Vehicle; បែងចែកមុខងាររួមដែលសមនឹងប្រភេទកូន។
**កូដមេរៀន៖** `fundamentals/inheritance/`។

### 3.1. Superclass, Subclass និង extends

**និយមន័យ៖** Vehicle ជា Superclass; Car ជា Subclass; extends ប្រកាសការទទួលមរតក។

```java
class Motorcycle extends Vehicle {
    public Motorcycle(String model) {
        super(model);
    }
}
```

**ចំណាំ៖** Class មួយ extend Class មេបានមួយ។ កុំជ្រើស Inheritance គ្រាន់តែដោយ Fields ស្រដៀងគ្នា។

### 3.2. super និង Constructor មេ

**និយមន័យ៖** `super(...)` ហៅ Constructor មេ ដើម្បីរៀបចំផ្នែក State ដែលមេគ្រប់គ្រង។

```java
public Car(String model) {
    super(model);
}
```

**ការប្រើប្រាស់៖** កំណត់ model មុនប្រើ Object កូន។ Constructors មិនត្រូវបានទទួលមរតក។

### 3.3. Inherited Methods និង private Fields

**និយមន័យ៖** កូនអាចប្រើ Methods ដែលបានទទួលមរតក; private Fields របស់មេមិនអាចចូលប្រើដោយផ្ទាល់ពីកូន។

```java
Car car = new Car("Corolla");
car.start();
System.out.println(car.getModel());
```

**ចំណុចគន្លឹះ៖** is-a ខុសពី has-a។ Car ទទួលមុខងារពី Vehicle មិនមែនទទួលមុខងារជាក់លាក់របស់ Motorcycle។

## 4. Polymorphism

**និយមន័យ៖** ប្រើប្រភេទរួមជាមួយ Objects ផ្សេងៗ ហើយ Instance Method ដែលបាន Override ត្រូវបានជ្រើសតាម Object នៅ Runtime។

```java
class Vehicle {
    public String makeSound() {
        return "Generic sound";
    }
}
class Car extends Vehicle {
    @Override
    public String makeSound() {
        return "Beep!";
    }
}
// ក្នុង main():
// Vehicle vehicle = new Car();
// System.out.println(vehicle.makeSound()); // Beep!
```

**ការប្រើប្រាស់៖** ប្រើ operation រួមសម្រាប់ payment/notification implementations ផ្សេងៗ។
**កូដមេរៀន៖** `fundamentals/polymorphism/`។

### 4.1. Overriding និង @Override

**និយមន័យ៖** កូនផ្ដល់ការអនុវត្ត Instance Method ដែលមាន signature ត្រូវគ្នាជាមួយមេ។ Annotation ជួយ Compiler ពិនិត្យ។

```java
@Override
public String makeSound() {
    return "Beep!";
}
```

**ចំណាំ៖** មិនអាចបន្ថយ access visibility។ final methods មិនអាច Override; private methods មិនត្រូវបាន Override; static methods ប្រើ hiding។

### 4.2. Upcasting និង Reference/Object Types

**និយមន័យ៖** Upcasting យោងទៅ Object កូនតាមប្រភេទមេ។ Reference type កំណត់ Method ដែល Compiler អនុញ្ញាតឱ្យហៅ។

```java
Vehicle vehicle = new Car();
String sound = vehicle.makeSound();
```

**ពន្យល់៖** Reference type គឺ Vehicle; Object type គឺ Car។ ការជ្រើស Override ប្រើ Car នៅ Runtime។

### 4.3. instanceof និងមុខងារជាក់លាក់

**និយមន័យ៖** instanceof ពិនិត្យថា Object អាចប្រើជាប្រភេទដែលស្នើបានឬអត់។

```java
// ប្រើ Car ក្នុងមេរៀន Project ដែលមាន openTrunk():
if (vehicle instanceof Car car) {
    car.openTrunk();
}
```

**ចំណាំ៖** null ផ្ដល់ false។ ការហៅ Method រួមដែល Override មិនត្រូវការ instanceof។

### 4.4. Overloading ខុសពី Overriding

**និយមន័យ៖** Overloading មានឈ្មោះ Method ដូចគ្នា តែ Parameters ខុស; Compiler ជ្រើស signature។ Overriding ផ្លាស់ប្ដូរការអនុវត្ត Method មេ។

```java
void print(String text) { }
void print(int number) { }
```

**ចំណុចគន្លឹះ៖** Runtime dispatch អនុវត្តចំពោះ overridable instance methods មិនមែន Fields ឬ static methods។

## 5. Abstraction

**និយមន័យ៖** ផ្ដល់មុខងារចាំបាច់ឱ្យអ្នកហៅប្រើ ដោយមិនតម្រូវឱ្យដឹងព័ត៌មានលម្អិតនៃការអនុវត្ត។

```java
abstract class ShippingService {
    public final long quoteCents(int grams) {
        if (grams <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }
        return calculateFeeCents(grams);
    }

    protected abstract long calculateFeeCents(int grams);
}
class StandardShipping extends ShippingService {
    @Override
    protected long calculateFeeCents(int grams) {
        return 200L + 100L * ((grams + 999L) / 1000);
    }
}
```

**ការប្រើប្រាស់៖** Checkout ស្នើ quote ដោយមិនដឹងរូបមន្ត; 1500g គិតជា 2kg → 400 cents។ តម្លៃសន្មតសម្រាប់មេរៀន។
**កូដមេរៀន៖** `fundamentals/abstraction/` មានការពិនិត្យលទ្ធផល និង Express implementation ផង។

### 5.1. Abstract Class និង Concrete Class

**និយមន័យ៖** Abstract Class មិនអាចបង្កើត Instance ដោយផ្ទាល់។ Concrete Class មាន implementation គ្រប់គ្រាន់ និងអាចបង្កើត Instance។

```java
ShippingService shipping = new StandardShipping();
// new ShippingService(); // Compile error
```

### 5.2. Abstract Method

**និយមន័យ៖** Method គ្មាន Body ដែលទុកឱ្យ Concrete Subclass ផ្ដល់ការអនុវត្ត។

```java
protected abstract long calculateFeeCents(int grams);
```

**ចំណាំ៖** Abstract Class អាចមាន Fields, Constructor និង Methods ដែលមាន Body ផងដែរ។

### 5.3. protected, final និង Workflow រួម

**និយមន័យ៖** protected អនុញ្ញាត same-package និង subclass access តាមច្បាប់ Java។ final Method មិនអាច Override។

```java
public final long quoteCents(int grams) {
    if (grams <= 0) throw new IllegalArgumentException("Invalid weight");
    return calculateFeeCents(grams);
}
```

**ការប្រើប្រាស់៖** កូនផ្ដល់រូបមន្ត ប៉ុន្តែមិនរំលង validation ក្នុង public operation។ រចនានេះជាគំរូ Template Method ដែលនឹងរៀនលម្អិតពេល Design Patterns។

**ចំណុចគន្លឹះ៖** Abstraction ជាគំនិត; abstract class និង interface ជាឧបករណ៍។ ប្រើ Abstract Class ពេលមាន State/workflow រួមដែលសមហេតុផល។

## 6. Interface

**និយមន័យ៖** កិច្ចសន្យាដែលកំណត់មុខងាររួមសម្រាប់ Classes អនុវត្ត។

```java
interface NotificationService {
    void send(String recipient, String message);
}
class EmailNotification implements NotificationService {
    @Override
    public void send(String recipient, String message) {
        System.out.println("EMAIL DEMO: " + message);
    }
}
```

**ការប្រើប្រាស់៖** Email/SMS ផ្ដល់ operation send ដូចគ្នា ប៉ុន្តែរបៀបផ្ញើផ្សេង។ ឧទាហរណ៍មេរៀនគ្រាន់តែ Console មិនផ្ញើពិត។
**កូដមេរៀន៖** `fundamentals/interfaces/`។

### 6.1. implements និង public Methods

**និយមន័យ៖** implements បញ្ជាក់ថា Class គោរពកិច្ចសន្យា។ Method declaration គ្មាន Body ក្នុង Interface ខាងលើជា public abstract។

```java
@Override
public void send(String recipient, String message) {
    System.out.println(message);
}
```

**ចំណាំ៖** Concrete Class ត្រូវមាន implementation; មិនអាចកាត់ public ចេញក្នុង implementation ខាងលើ។ Class អាច implement Interfaces ច្រើន។

### 6.2. Interface Reference

**និយមន័យ៖** Variable ប្រើ Interface type ដើម្បីយោងទៅ implementation ដែលគោរពកិច្ចសន្យា។

```java
NotificationService notifications = new EmailNotification();
notifications.send("student@example.com", "Order confirmed");
```

**ការប្រើប្រាស់៖** ប្ដូរ implementation ដោយកូដអ្នកហៅបន្តប្រើកិច្ចសន្យាដដែល។

### 6.3. Interface ខុសពី Abstract Class

**និយមន័យ៖** Interface គ្មាន Constructor/instance fields; Abstract Class អាចមាន។ Interface អាចមាន default/static/private methods ដែលមាន Body និង constants។

```java
interface NamedChannel {
    default String channelName() {
        return "Notification";
    }
}
```

**ចំណុចគន្លឹះ៖** ជ្រើស Interface សម្រាប់កិច្ចសន្យារួម។ មិនតម្រូវឱ្យ implementations មាន Class មេ ឬ State រួម។

## 7. Composition

**និយមន័យ៖** ផ្សំ Objects ឱ្យធ្វើការជាមួយគ្នា ដោយ Object មួយរក្សា/ប្រើ Object ផ្សេង តាមទំនាក់ទំនង **has-a**។

```java
interface PaymentService {
    boolean pay(String orderId, long cents);
}
class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = java.util.Objects.requireNonNull(paymentService);
    }

    public boolean placeOrder(String orderId, long cents) {
        if (cents <= 0) throw new IllegalArgumentException("Invalid total");
        return paymentService.pay(orderId, cents);
    }
}
```

**ការប្រើប្រាស់៖** OrderService ប្រើ PaymentService; Order មិនមែនជា Payment។
**កូដមេរៀន៖** `fundamentals/composition/` មានការពិនិត្យ orderId និង simulation approval/decline។

### 7.1. Delegation

**និយមន័យ៖** ប្រគល់ការងារជាក់លាក់ទៅ Object ដែលទទួលខុសត្រូវ។

```java
boolean paid = paymentService.pay(orderId, cents);
```

**ការប្រើប្រាស់៖** OrderService គ្រប់គ្រងលំហូរ; PaymentService គ្រប់គ្រងការទូទាត់។

### 7.2. Constructor Injection

**និយមន័យ៖** ទទួល Dependency ពីខាងក្រៅតាម Constructor។

```java
PaymentService payment = new SimulatedPaymentService(true);
OrderService orders = new OrderService(payment);
```

**ការប្រើប្រាស់៖** ផ្ដល់ implementation ពិត ឬ test fake ដោយមិនកែ OrderService។ នេះជា manual injection មិនត្រូវការ Spring។

### 7.3. Object Composition និង UML Composition

**និយមន័យ៖** Object composition ក្នុងកូដសំដៅការផ្សំ Objects។ UML Composition មាន whole-part ownership/lifecycle តឹងរ៉ឹងជាង។

```java
private final PaymentService paymentService;
```

**ចំណាំ៖** Field នេះមួយឯងមិនបញ្ជាក់ UML ownership ទេ ព្រោះ Dependency អាចបង្កើតពីខាងក្រៅ និងចែករំលែកបាន។

**ចំណុចគន្លឹះ៖** has-a ប្រើ field/delegation; is-a ប្រើ inheritance។ Simulation មិនទូទាត់ប្រាក់ពិត ឬរក្សាទុក Order ទេ។

## 8. Exception Handling

**និយមន័យ៖** ការឆ្លើយតបនឹង Exception ដែលរំខានលំហូរធម្មតា ដោយមិនលាក់ថាប្រតិបត្តិការបានបរាជ័យ។

```java
try {
    product.reduceStock(20);
    System.out.println("SUCCESS");
} catch (InsufficientStockException exception) {
    System.out.println(exception.getMessage());
}
```

**ការប្រើប្រាស់៖** Stock rejection, file errors និងការផ្ដល់លទ្ធផលសមស្របនៅ boundary។
**កូដមេរៀន៖** `advanced/exceptions/propagation/` និង `advanced/exceptions/complete/`។

### 8.1. throw

**និយមន័យ៖** បោះ Exception Object មួយ ហើយឈប់លំហូរធម្មតាត្រង់នោះ។

```java
if (quantity <= 0) {
    throw new IllegalArgumentException("Quantity must be positive.");
}
```

**ចំណាំ៖** បន្ទាត់បន្ទាប់តាមលំហូរធម្មតាត្រូវរំលង; throw មិន rollback State ដោយខ្លួនឯង។

### 8.2. try/catch និង Specific Handling

**និយមន័យ៖** try កំណត់ការងារ; catch ឆ្លើយតប Exception ដែលប្រភេទត្រូវគ្នា។

```java
try {
    orders.placeOrder(quantity);
} catch (InsufficientStockException exception) {
    System.out.println("Not enough stock");
} catch (IllegalArgumentException exception) {
    System.out.println("Invalid input");
}
```

**ចំណាំ៖** បើ catch ប្រភេទមេ/កូន ដាក់កូនមុនមេ។ កូដក្រោយប្លុកបន្តបានបើ handlers បញ្ចប់តាមធម្មតា; មិនត្រឡប់ទៅចំណុច throw ទេ។

### 8.3. Exception Propagation

**និយមន័យ៖** Exception បន្តតាមអ្នកហៅ Methods រហូតមាន handler ដែលត្រូវគ្នា។

```java
void placeOrder(int quantity) {
    product.reduceStock(quantity); // Exception អាចបន្តទៅអ្នកហៅ placeOrder
    System.out.println("Confirmed");
}
```

**លំហូរ៖** Product បោះ → OrderService មិនចាប់ → caller ចាប់; Confirmed ត្រូវរំលង។ បើមិនមាន handler, Thread នោះអាចបញ្ចប់ដោយ uncaught exception។

### 8.4. Checked Exceptions និង throws

**និយមន័យ៖** Compiler តម្រូវឱ្យ catch ឬ declare throws សម្រាប់ Checked Exception ដែលអាចបន្តចេញ។ Exception កើតនៅ Runtime មិនមែន Compile។

```java
int readQuantity(java.nio.file.Path file) throws java.io.IOException {
    String text = java.nio.file.Files.readString(file);
    return Integer.parseInt(text.trim());
}
```

**ការប្រើប្រាស់៖** File I/O ប្រើ IOException។ throws ប្រកាសការបញ្ជូនបន្ត មិនចាប់ ឬបោះ Exception ដោយខ្លួនឯង។

### 8.5. Unchecked Exceptions

**និយមន័យ៖** Compiler មិនបង្ខំ catch/throws; រួមមាន RuntimeException និងកូន ព្រមទាំង Error និងកូន។

```java
int quantity = Integer.parseInt("abc"); // NumberFormatException
```

**ចំណាំ៖** NumberFormatException ជាកូន IllegalArgumentException។ កុំប្រើ Error សម្រាប់ business failures ធម្មតា។

### 8.6. Custom Exceptions

**និយមន័យ៖** បង្កើត Exception type ដែលបង្ហាញបញ្ហាជាក់លាក់ក្នុងប្រព័ន្ធ។

```java
class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(int requested, int available) {
        super("Requested " + requested + ", available " + available);
    }
}
```

**ការប្រើប្រាស់៖** Quantity -5 → IllegalArgumentException; quantity 20 នៅស្តុក 10 → InsufficientStockException។ extends Exception ដោយផ្ទាល់នឹងជា Checked; extends RuntimeException ជា Unchecked។

### 8.7. finally

**និយមន័យ៖** ប្លុកដែលជាទូទៅដំណើរការពេលចាកចេញពី try/catch ដើម្បី cleanup ឬកត់ត្រាការបញ្ចប់។

```java
try {
    imports.importOrder(file);
} finally {
    System.out.println("Attempt finished");
}
```

**ចំណាំ៖** Finished មិនមានន័យថា Success។ កុំ return ក្នុង finally ព្រោះអាចលាក់លទ្ធផល/Exception។ មិនធានាក្នុង process kill ឬ JVM termination។

### 8.8. try-with-resources និង AutoCloseable

**និយមន័យ៖** បិទ resource ដែល implements AutoCloseable ដោយហៅ close() ស្វ័យប្រវត្តិ។

```java
try (java.io.BufferedReader reader = java.nio.file.Files.newBufferedReader(file)) {
    String line = reader.readLine();
    System.out.println(line);
}
```

**ការប្រើប្រាស់៖** Reader ត្រូវបិទទោះ read/parse បរាជ័យ។ IOException នៅតែត្រូវ catch ឬ declare throws។ Resource initialization ដែលបរាជ័យមិនបង្កើត resource សម្រាប់ close ទេ; resources មុនដែលបើកបាននៅតែត្រូវបិទ។

### 8.9. Stack Trace

**និយមន័យ៖** បញ្ជីទីតាំងហៅ Methods ជួយរកកន្លែងបោះ Exception និងផ្លូវដែលនាំទៅបញ្ហា។

```java
exception.printStackTrace(); // teaching / local diagnosis
```

**ការប្រើប្រាស់៖** អានប្រភេទ/message រួច `at ...File.java:line` និង `Caused by`។ Production ប្រើ logger និងកុំបង្ហាញ internal trace ទៅ API users។

### 8.10. Cause និង Exception Wrapping

**និយមន័យ៖** Cause ជាបញ្ហាដើម; wrapping បន្ថែម context ដោយរក្សាបញ្ហាដើមជាប់ Exception ថ្មី។

```java
catch (java.io.IOException cause) {
    throw new OrderImportException("Cannot import order", cause);
}
```

**ចំណាំ៖** Constructor នៃ OrderImportException ត្រូវហៅ `super(message, cause)`។ អានមូលហេតុតាម `exception.getCause()`។

### 8.11. Reverse Close Order និង Suppressed Exceptions

**និយមន័យ៖** Resources បិទបញ្ច្រាសពីការបើក។ បើ body និង close សុទ្ធតែបរាជ័យ body exception នៅជា primary ហើយ close failures ត្រូវបានរក្សាជា suppressed។

```java
for (Throwable extra : exception.getSuppressed()) {
    System.out.println(extra.getMessage());
}
```

**ឧទាហរណ៍លំហូរ៖** open first → open second → body fails → close second → close first។ បើ body ជោគជ័យ តែ close បរាជ័យ close exception ក៏អាចបន្តចេញបាន។

### 8.12. Real-world Handling និង Rollback

**និយមន័យ៖** ចាប់នៅកន្លែងអាចឆ្លើយតប ឬបន្ថែម context; rollback ជាការលុបចោលការកែប្រែតាមយន្តការដាច់ដោយឡែក។

```java
if (quantity > stockQuantity) {
    throw new InsufficientStockException(quantity, stockQuantity);
}
stockQuantity -= quantity;
```

**ចំណុចគន្លឹះ៖** Validation មុន mutation រក្សាស្តុកពេលបដិសេធ។ កុំ catch ហើយលាក់បញ្ហា; កុំ retry input error ដោយគ្មានការកែ input។ Database rollback និង Spring handlers នឹងរៀននៅផ្នែកបន្ទាប់តាមផែនការ។

## 9. Generics

**និយមន័យ៖** ប្រើប្រភេទទិន្នន័យជាប៉ារ៉ាម៉ែត្ររបស់ Class, Interface ឬ Method ដើម្បីប្រើកូដឡើងវិញជាមួយ Type Safety។

```java
class Box<T> {
    private T value;
    public void setValue(T value) { this.value = value; }
    public T getValue() { return value; }
}
```

**ការប្រើប្រាស់៖** Typed collections, API responses, validators និង utility methods។
**កូដមេរៀន៖** `advanced/generics/`។ ផ្ទៀងផ្ទាត់ពី learning៖ `python3 scripts/check-generics.py`។

### 9.1. Type Safety

**និយមន័យ៖** Compiler ជួយបដិសេធការប្រើប្រភេទមិនត្រឹមត្រូវ មុន Runtime។

```java
Box<Integer> box = new Box<>();
box.setValue(10);
// box.setValue("Hello"); // Compile error
```

**ចំណាំ៖** មិនធានាតម្លៃវិជ្ជមាន មិន null ឬ runtime operations ទាំងអស់ជោគជ័យទេ។

### 9.2. Type Parameter និង Type Argument

**និយមន័យ៖** T ក្នុងការប្រកាសជា Type Parameter; Integer ពេលប្រើជា Type Argument។

```java
// declaration: class Box<T> { ... }
Box<Integer> quantity = new Box<>();
```

**ចំណាំ៖** T/E/K/V ជាឈ្មោះនិយម មិនមែន Keywords។

### 9.3. Generic Classes និង Nested Type Arguments

**និយមន័យ៖** Class ប្រកាសប្រភេទអថេរដើម្បីប្រើទិន្នន័យផ្សេងៗក្នុងរចនាសម្ព័ន្ធរួម។

```java
class ApiResponse<T> {
    private final T data;
    public ApiResponse(T data) { this.data = data; }
    public T getData() { return data; }
}
// ApiResponse<List<Product>> response = new ApiResponse<>(products);
```

**ការប្រើប្រាស់៖** Response សម្រាប់ Product មួយ ឬ List<Product> ដោយមិនចាំបាច់ Cast getData()។ Class ពេញក្នុង Project មាន message ផង។

### 9.4. Multiple Type Parameters

**និយមន័យ៖** Generic type មួយប្រកាស Type Parameters ច្រើន ដូចជា Key និង Value។

```java
class Pair<K, V> {
    final K key;
    final V value;
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
// Pair<String, Integer> stock = new Pair<>("Coffee", 10);
```

**ការប្រើប្រាស់៖** ភ្ជាប់ឈ្មោះ/លេខសម្គាល់ជាមួយតម្លៃ; Map<K,V> នឹងរៀនលម្អិតក្នុង Collections។

### 9.5. Generic Interfaces

**និយមន័យ៖** Interface កំណត់កិច្ចសន្យាដែលប្រើ Type Parameter។

```java
interface Validator<T> {
    boolean isValid(T value);
}
class ProductNameValidator implements Validator<String> {
    public boolean isValid(String value) {
        return value != null && !value.isBlank();
    }
}
```

**ការប្រើប្រាស់៖** Validators/Converters ដែលកំណត់ Input Type ច្បាស់។

### 9.6. Generic Methods

**និយមន័យ៖** Method ប្រកាស Type Parameter ផ្ទាល់ខ្លួនមុន Return Type; Class មិនចាំបាច់ជា Generic។

```java
public static <T> T valueOrDefault(T value, T fallback) {
    return value != null ? value : fallback;
}
```

**លទ្ធផល៖** valueOrDefault(null, 0) → 0; ទាំងពីរ null → null។ មិនជំនួស blank String ឬលេខអវិជ្ជមាន។

### 9.7. Diamond និង Type Inference

**និយមន័យ៖** Compiler សន្និដ្ឋាន Type Arguments ពីបរិបទ; Diamond <> ប្រើពេលបង្កើត Object។

```java
Box<String> name = new Box<>();
Integer stock = GenericUtils.valueOrDefault(null, 0);
String fallback = GenericUtils.<String>valueOrDefault(null, "Unknown");
```

**ចំណាំ៖** អាចបញ្ជាក់ Method Type Argument ដោយដៃ។ Arguments ខុស runtime classes អាចត្រូវ inference ជាប្រភេទរួម មិនចាំបាច់មាន Class ដូចគ្នា។

### 9.8. Wrapper Classes និង Autoboxing

**និយមន័យ៖** Wrapper ជា Reference Type សម្រាប់ primitive; Autoboxing បម្លែង primitive ទៅ Wrapper ស្វ័យប្រវត្តិ។

```java
Box<Integer> box = new Box<>();
box.setValue(10); // int -> Integer
// Box<int> invalid; // Compile error
```

**ចំណាំ៖** Type Argument ត្រូវជាប្រភេទ Reference; unbox Integer ដែល null អាចបោះ NullPointerException។

### 9.9. Bounded Type Parameters

**និយមន័យ៖** កំណត់ Upper Bound ដើម្បីឱ្យ T មានមុខងារចាំបាច់។

```java
public static <T extends Number> double toDouble(T value) {
    return value.doubleValue();
}
```

**ការប្រើប្រាស់៖** ទទួល Integer/Double; មិនទទួល String។ Bound មិនបដិសេធ null; double conversion អាចបាត់ precision មិនសមសម្រាប់គណនាប្រាក់ដោយផ្ទាល់។

### 9.10. Interface Bounds និង Comparable

**និយមន័យ៖** Type Parameter ប្រើ extends សូម្បី Bound ជា Interface។ Comparable ផ្ដល់ compareTo សម្រាប់ប្រៀបធៀប។

```java
public static <T extends Comparable<T>> T max(T a, T b) {
    return a.compareTo(b) >= 0 ? a : b;
}
```

**លទ្ធផល៖** max(10, 20) → 20។ compareTo អវិជ្ជមាន/សូន្យ/វិជ្ជមាន បង្ហាញតូចជាង/ស្មើ/ធំជាង។ ឧទាហរណ៍សន្មត non-null។

### 9.11. Multiple Bounds

**និយមន័យ៖** តម្រូវឱ្យ T គោរព Class/Interfaces ច្រើន។ Class Bound បើមាន ត្រូវនៅមុន Interface Bounds។

```java
public static <T extends Number & Comparable<T>> T maxNumber(T a, T b) {
    return a.compareTo(b) >= 0 ? a : b;
}
```

**ការប្រើប្រាស់៖** Numeric utilities ដែលត្រូវការប្រៀបធៀបផង។

### 9.12. Invariance

**និយមន័យ៖** ទោះ S ជាកូន T ក៏ Generic<S> មិនមែនជាកូន Generic<T> ទេ។

```java
List<Integer> quantities = new ArrayList<>();
// List<Number> numbers = quantities; // Compile error
```

**ហេតុផល៖** បើអនុញ្ញាត numbers អាចបន្ថែម Double ចូល List<Integer> ហើយបំផ្លាញ Type Safety។

### 9.13. Unbounded Wildcard <?>

**និយមន័យ៖** ប្រភេទជាក់លាក់មួយដែលមិនស្គាល់ឈ្មោះនៅទីនោះ; មិនមែន Raw Type។

```java
List<?> items = List.of("Coffee");
Object item = items.get(0);
// items.add("Tea"); // Compile error
```

**ការប្រើប្រាស់៖** printItems ដែលមិនត្រូវដឹងប្រភេទ Element។ មិនផ្ទៀងផ្ទាត់ថា Elements ជា String នៅ Runtime។

### 9.14. Upper-bounded Wildcard <? extends T>

**និយមន័យ៖** List នៃ T ឬកូនរបស់ T; អាចអានជា T។

```java
List<? extends Number> source = new ArrayList<Integer>(List.of(10));
Number value = source.get(0);
// source.add(20); // Compile error
```

**ចំណាំ៖** មិនអាច add non-null តាម Reference នេះ; list អាចជា List<Double>។ វាមិនធ្វើឱ្យ List immutable ទេ។

### 9.15. Lower-bounded Wildcard <? super T>

**និយមន័យ៖** List នៃ T ឬប្រភេទមេរបស់ T; អាចបញ្ចូល T និងកូនរបស់ T។

```java
List<? super Integer> destination = new ArrayList<Number>();
destination.add(10);
Object value = destination.get(0);
// destination.add(2.5); // Compile error
```

**ចំណាំ៖** អានធានាបានត្រឹម Object ព្រោះ actual list អាចជា List<Object> ដែលមាន String ពីមុន។

### 9.16. PECS

**និយមន័យ៖** Producer Extends, Consumer Super: ប្រភពផ្ដល់តម្លៃប្រើ extends; គោលដៅទទួលប្រើ super។

```java
public static <T> void copyItems(
        List<? extends T> source, List<? super T> destination) {
    for (T item : source) {
        destination.add(item);
    }
}
```

**ការប្រើប្រាស់៖** List<Integer> → List<Number>។ Method append References មិន deep copy; destination ត្រូវគាំទ្រ add និងប្រើ Lists ដាច់គ្នាសម្រាប់ឧទាហរណ៍នេះ។

### 9.17. Raw Types និង Unchecked Warnings

**និយមន័យ៖** Raw Type លុបការបញ្ជាក់ Type Argument ពេលប្រើ Generic Type។ Unchecked Warning ប្រាប់ថា Compiler មិនអាចធានាសុវត្ថិភាពប្រភេទ។

```java
List raw = new ArrayList();
raw.add("Coffee"); // unchecked warning
```

**ចំណាំ៖** គាំទ្រកូដចាស់; ជៀសវាងក្នុងកូដថ្មី។ កុំប្រើ @SuppressWarnings ដោយមិនយល់មូលហេតុ។

### 9.18. Heap Pollution និង ClassCastException

**និយមន័យ៖** Heap Pollution ធ្វើឱ្យ Parameterized Reference ប៉ះទិន្នន័យខុសប្រភេទ; ClassCastException កើតពេល Runtime cast មិនអាចធ្វើបាន។

```java
List<Integer> quantities = new ArrayList<>();
List raw = quantities;
raw.add("Hello"); // intentionally unsafe
Integer quantity = quantities.get(0); // ClassCastException
```

**ការប្រើប្រាស់៖** ជាឧទាហរណ៍កំហុស មិនមែនរបៀបសរសេរកូដ production។

### 9.19. Type Erasure និងដែនកំណត់

**និយមន័យ៖** Compiler បម្លែង Type Parameters ទៅ Object ឬ leftmost Bound ហើយបន្ថែម casts/bridge methods តាមចាំបាច់។

```java
boolean sameClass = new ArrayList<String>().getClass()
        .equals(new ArrayList<Integer>().getClass()); // true
```

**ឧទាហរណ៍ដែលមិនអនុញ្ញាត៖**

```java
// new T();                  // Compile error
// new T[10];                // Compile error
// value instanceof List<String> // មិនអាចពិនិត្យបែបនេះសម្រាប់ Object ទូទៅ
// void process(List<String> a) { }
// void process(List<Integer> a) { } // erasure signature clash
```

**ចំណាំ៖** new T ក៏គ្មានការធានាថា T មាន constructor សមស្រប។ Metadata ខ្លះនៅសល់សម្រាប់ Reflection; មិនមែនព័ត៌មាន Generics បាត់ទាំងអស់។ Factory/Supplier ជាជម្រើសដែលនឹងរៀននៅពេលក្រោយ។

### 9.20. Generics vs Validation

**និយមន័យ៖** Generics ពិនិត្យប្រភេទ; Validation ពិនិត្យតម្លៃ និងច្បាប់អាជីវកម្ម។

```java
Box<Integer> box = new Box<>();
box.setValue(-10); // ប្រភេទត្រឹមត្រូវ
if (box.getValue() < 0) {
    throw new IllegalArgumentException("Stock must not be negative.");
}
```

**ការប្រើប្រាស់៖** Product constructor បដិសេធស្តុកអវិជ្ជមាន ទោះវាជា Integer ត្រឹមត្រូវតាម Generics។

### 9.21. Unmodifiable Collections

**និយមន័យ៖** Collection ដែលមិនអនុញ្ញាត operations កែប្រែមួយចំនួនតាម API របស់វា។ List.of មិនអនុញ្ញាត add/remove/set។

```java
List<? super Integer> values = List.of(1, 2);
values.add(3); // Compile បាន; Runtime UnsupportedOperationException
```

**ចំណាំ៖** Type correctness មិនធានាថា operation ត្រូវគាំទ្រទេ។ Objects ក្នុង List មិនចាំបាច់ immutable។

**ចំណុចគន្លឹះ៖** ប្រើប្រភេទច្បាស់ ជៀស Raw Types; ប្រើ Bound ពេលត្រូវការមុខងាររួម; ប្រើ PECS តាមទិសទិន្នន័យ; បែងចែក Type Safety ពី Validation និង Mutability។

## 10. Collections

**និយមន័យ៖** Java Collections Framework ជាសំណុំ Interfaces, Classes និងមុខងារសម្រាប់រក្សា ស្វែងរក កែ និងរៀបចំក្រុមទិន្នន័យ។

**ស្ថានភាព៖** ចំណុច 1–5 បានពន្យល់ក្នុងឆាត។ តាមសំណើអ្នករៀន ចំណុច 6–12 បង្ហាញជានិយមន័យខ្លី និងកូដ ដោយមិនទាន់ពិនិត្យការយល់លម្អិត។
**កូដមេរៀន៖** `advanced/collections/CollectionsDemo.java`; workflow ហាងក្នុង `StoreCollectionsDemo.java`។

### 10.1. Collection, Collections និង Map

**និយមន័យ៖** Collection<E> ជា Interface មូលដ្ឋានរបស់ List/Set/Queue។ Collections ជា Utility Class។ Map<K,V> រក្សា Key–Value ហើយមិន extend Collection។

```java
List<String> names = new ArrayList<>();
Map<String, Integer> stocks = new HashMap<>();
Collections.sort(names);
```

**ការប្រើប្រាស់៖** ជ្រើសកិច្ចសន្យាតាមតម្រូវការ ហើយប្រើ implementation សមស្រប។

### 10.2. Array និង ArrayList

**និយមន័យ៖** Array មានទំហំថេរក្រោយបង្កើត; ArrayList គ្រប់គ្រងទំហំដែលអាចប្រែប្រួល។

```java
String[] array = new String[2];
List<String> list = new ArrayList<>(100);
list.add("Coffee");
System.out.println(array.length); // 2
System.out.println(list.size());  // 1, មិនមែន 100
```

**ចំណាំ៖** 100 ជា Initial Capacity មិនមែនចំនួន Elements ឬទំហំអតិបរមា។ Array ទទួល primitives បាន; Generic List ប្រើ Wrappers ដូចជា Integer។

### 10.3. List Operations និង Index

**និយមន័យ៖** List មានលំដាប់តាមទីតាំង អនុញ្ញាតស្ទួន ហើយ Index ចាប់ពី 0។

```java
List<String> items = new ArrayList<>();
items.add("Coffee");
items.add(1, "Tea");
items.set(0, "Milk");
String first = items.get(0); // Milk
items.remove("Tea");
boolean exists = items.contains("Milk");
```

**ចំណាំ៖** add(index) បន្ថែម និងរំកិល Elements; set ជំនួសដោយ size ដដែល។ get/set/remove index ត្រូវ < size; add index អាច == size។ clear លុបទាំងអស់; isEmpty ពិនិត្យភាពទទេ។

### 10.4. remove Index vs Value

**និយមន័យ៖** remove(int) លុបតាមទីតាំង; remove(Object) លុបតម្លៃស្មើគ្នាដំបូង។

```java
List<Integer> values = new ArrayList<>(List.of(10, 20, 30));
values.remove(1);                    // [10, 30]
values.remove(Integer.valueOf(10));  // [30]
```

**ការប្រើប្រាស់៖** ប្រយ័ត្នពេល List<Integer> ព្រោះ literal int ជ្រើស Index overload។

### 10.5. LinkedList

**និយមន័យ៖** រក្សា Elements ក្នុង Nodes ដែលមានតំណមុន/ក្រោយ; អនុវត្តទាំង List និង Deque។

```java
Deque<String> tasks = new LinkedList<>();
tasks.addFirst("Check payment");
tasks.addLast("Pack");
String first = tasks.removeFirst();
```

**ចំណាំ៖** ចុងទាំងពីរ O(1); get(index) O(n) ព្រោះត្រូវដើរតាម Nodes។ បញ្ចូលកណ្ដាលមិនលឿនជានិច្ច ព្រោះត្រូវរកទីតាំងជាមុន។ បើ Iterator នៅទីតាំងស្រាប់ ការបញ្ចូល/លុបត្រង់នោះអាច O(1)។ ជាទូទៅ Queue/Stack ពិចារណា ArrayDeque មុន។

### 10.6. Set និង HashSet

**និយមន័យ៖** Set មិនរក្សា Elements ស្ទួន។ HashSet ប្រើ hashCode/equals ហើយមិនធានាលំដាប់។

```java
Set<String> codes = new HashSet<>();
codes.add("A");                  // true
codes.add("B");                  // true
boolean added = codes.add("A");  // false; size = 2
```

**ចំណាំ៖** ស្ទួនមិនលុបតម្លៃចាស់។ contains/remove ពិនិត្យតាមសមភាព។ Set គ្មាន get(index)។ In-memory dedup មិនជំនួស Database Unique Constraint។

### 10.7. LinkedHashSet

**និយមន័យ៖** មិនរក្សាស្ទួន ហើយរក្សាលំដាប់បញ្ចូលដំបូង។

```java
Set<String> codes = new LinkedHashSet<>(List.of("C", "A", "C", "B"));
System.out.println(codes); // [C, A, B]
```

**ការប្រើប្រាស់៖** លុបកូដស្ទួនក្នុង input ដោយរក្សាលំដាប់ដើម។ add ធម្មតាលើតម្លៃដែលមានរួចមិនផ្លាស់ទីវា។

### 10.8. TreeSet និង NavigableSet

**និយមន័យ៖** TreeSet រៀប Elements តាម Comparable ឬ Comparator; compare == 0 ចាត់ទុកថាស្ទួន។

```java
NavigableSet<Integer> values = new TreeSet<>(List.of(30, 10, 20));
System.out.println(values);   // [10, 20, 30]
Integer lower = values.lower(20);     // 10
Integer floor = values.floor(20);     // 20
Integer ceiling = values.ceiling(25); // 30
Integer higher = values.higher(20);   // 30
```

**ចំណាំ៖** first/last បោះ NoSuchElementException ពេលទទេ; navigation methods return null បើរកមិនឃើញ។ Natural ordering មិនទទួល null។ Comparator គួរស្រប equals។

### 10.9. Map និង HashMap

**និយមន័យ៖** Map រក្សាគូ Key–Value; Key មិនស្ទួន តែ Values អាចស្ទួន។ HashMap ប្រើ Hashing មិនធានាលំដាប់។

```java
Map<String, Integer> stocks = new HashMap<>();
stocks.put("A", 10);
Integer old = stocks.put("A", 30); // old = 10
Integer current = stocks.get("A"); // 30; size = 1
```

**ចំណាំ៖** put រក្សាថ្មី Return ចាស់។ get ទទួល Key មិនមែន Index; missing return null។ containsKey បែងចែក missing ពី existing-null mapping។ getOrDefault មិនជំនួស existing null។ containsValue ជាទូទៅ O(n)។

### 10.10. LinkedHashMap និង Access Order

**និយមន័យ៖** តាមធម្មតារក្សាលំដាប់បញ្ចូល Keys; អាចបើកលំដាប់ចូលប្រើបាន។

```java
Map<String, Integer> access = new LinkedHashMap<>(16, 0.75f, true);
access.put("A", 10);
access.put("B", 20);
access.get("A"); // លំដាប់ B, A
```

**ចំណាំ៖** Constructor ធម្មតាជា insertion order; put Key ចាស់មិនផ្លាស់ទី។ លុបហើយបញ្ចូលវិញទៅចុង។ Access order ជាគ្រឹះ LRU ប៉ុន្តែមិនមាន auto-eviction ក្នុង code នេះ។

### 10.11. TreeMap និង NavigableMap

**និយមន័យ៖** រៀបតាម Keys មិនមែន Values។ compare == 0 ចាត់ទុកថាជា Key ដូចគ្នា។

```java
NavigableMap<Integer, String> schedule = new TreeMap<>();
schedule.put(100, "A");
schedule.put(300, "C");
Integer next = schedule.ceilingKey(250); // 300
```

**ការប្រើប្រាស់៖** ស្វែងរកមុន/ក្រោយតម្លៃមួយ។ មាន firstKey, lastKey, lowerKey, floorKey, ceilingKey, higherKey។ បើការងារច្រើនមានពេលដូចគ្នា ប្រើ List ជា Value ដើម្បីមិនជំនួសការងារចាស់។

### 10.12. Map Updates និង Entry Iteration

**និយមន័យ៖** putIfAbsent បញ្ចូលបើគ្មាន non-null mapping; computeIfAbsent គណនាតម្លៃបើ absent/null; merge បញ្ចូល ឬផ្សំជាមួយតម្លៃចាស់។

```java
stocks.putIfAbsent("A", 10);
stocks.computeIfAbsent("B", key -> 0);
stocks.merge("B", 5, Integer::sum);
for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

**ចំណាំ៖** `key -> 0` ជា Lambda; `Integer::sum` ជា Method Reference។ នៅទីនេះប្រើជារូបមន្តខ្លីសម្រាប់គណនាតម្លៃ; នឹងរៀនលម្អិតក្នុង Modern Java។ Default Map operations មិនធានា atomicity ពេលមាន Threads ច្រើនទេ។

### 10.13. Queue និង FIFO

**និយមន័យ៖** FIFO ដំណើរការ Element ដែលចូលមុនមុន។ Queue interface ក៏មាន implementation អាទិភាពដែលមិនមែន FIFO ដែរ។

```java
Queue<String> queue = new ArrayDeque<>();
queue.offer("Order A");
queue.offer("Order B");
String head = queue.peek(); // A; មិនលុប
String next = queue.poll(); // A; លុប
```

**Methods៖** offer/poll/peek ផ្ដល់ special result false/null ក្នុងករណីដែលកិច្ចសន្យាកំណត់; add/remove/element ប្រើ Exception សម្រាប់ capacity/full ឬ empty តាម operation។ poll/peek លើ empty return null; remove/element លើ empty បោះ NoSuchElementException។ ArrayDeque មិនមាន fixed capacity ក្នុង Constructor; offer ជាទូទៅ true។

### 10.14. Deque, ArrayDeque និង Stack

**និយមន័យ៖** Deque អនុញ្ញាតបន្ថែម/យកចេញចុងទាំងពីរ។ ArrayDeque ជា implementation សម្រាប់ FIFO ឬ LIFO ដោយមិនទទួល null។

```java
Deque<String> history = new ArrayDeque<>();
history.push("Edit name");
history.push("Edit price");
String undo = history.pop(); // Edit price
history.offerLast("Task");
String tail = history.pollLast();
```

**ការប្រើប្រាស់៖** Undo history ឬ task queue ក្នុង memory។ push/pop ជា LIFO; offerLast/pollFirst ជា FIFO។ pop លើទទេបោះ Exception; pollFirst/pollLast return null។ ជាទូទៅប្រើ Deque ជំនួស legacy Stack។

### 10.15. PriorityQueue

**និយមន័យ៖** យក Element តូចបំផុតតាម Natural Ordering/Comparator មុន មិនតាមលំដាប់បញ្ចូល។

```java
Queue<Integer> priorities = new PriorityQueue<>();
priorities.offer(3);
priorities.offer(1);
priorities.offer(2);
while (!priorities.isEmpty()) {
    System.out.println(priorities.poll()); // 1, 2, 3
}
```

**ចំណាំ៖** for-each/toString មិនធានា sorted order។ Priority ties មិនធានា FIFO; ShippingTask ក្នុង Project បន្ថែម sequence ដើម្បីបំបែក ties។ កុំកែ priority field ខណៈ Object នៅក្នុង queue។ មិនអនុញ្ញាត null។

### 10.16. for-each និង Iterator

**និយមន័យ៖** for-each សម្រាប់អានងាយ; Iterator តាមដានការដើរតាម Elements និងអាចលុប current element បើ implementation គាំទ្រ។

```java
Iterator<String> iterator = codes.iterator();
while (iterator.hasNext()) {
    if (iterator.next().equals("INVALID")) {
        iterator.remove();
    }
}
```

**ចំណាំ៖** ហៅ next មុន remove; remove បានមួយដងក្នុងមួយ next។ កុំធ្វើ codes.remove ក្នុង for-each របស់ collection ធម្មតា។

### 10.17. ListIterator និង removeIf

**និយមន័យ៖** ListIterator អាចដើរទៅមុខ/ក្រោយ និង set/add/remove តាមទីតាំង។ removeIf លុប Elements ដែល Predicate ផ្ដល់ true។

```java
ListIterator<String> edits = codes.listIterator();
while (edits.hasNext()) {
    if (edits.next().equals("A")) edits.set("UPDATED-A");
}
products.removeIf(product -> product.getStock() == 0);
```

**ការប្រើប្រាស់៖** សម្អាតបញ្ជីផលិតផលអស់ស្តុក។ Lambda ក្នុង removeIf មានន័យថា «ពិនិត្យផលិតផលនីមួយៗ»។ ការលុបអាចបរាជ័យបើ collection មិនគាំទ្រ mutation។

### 10.18. ConcurrentModificationException

**និយមន័យ៖** Fail-fast iterator អាចរកឃើញការកែ structure ក្រៅ iterator ក្នុងពេល iteration។ អាចកើតសូម្បី Thread មួយ។

```java
Iterator<String> iterator = codes.iterator();
codes.add("NEW");
iterator.next(); // ArrayList ក្នុង Demo បោះ ConcurrentModificationException
```

**ចំណាំ៖** Fail-fast ជា best effort មិនមែនការធានា Thread Safety; កុំប្រើវាជា flow-control ឬ catch ហើយបន្ត iteration ខូច។

### 10.19. Comparable និង Comparator

**និយមន័យ៖** Comparable កំណត់ Natural Ordering ក្នុង Class; Comparator ជាច្បាប់ប្រៀបធៀបពីខាងក្រៅ។

```java
Comparator<Product> byPriceThenCode = Comparator.comparingLong(Product::getPriceCents)
        .thenComparing(Product::getKey);
products.sort(byPriceThenCode);
products.sort(byPriceThenCode.reversed());
```

**ការប្រើប្រាស់៖** រៀបតម្លៃ រួចបំបែក ties តាម Code។ reversed ខាងលើបញ្ច្រាសទាំង comparator chain។ List.sort/Collections.sort មាន stability សម្រាប់ elements ដែល compare ស្មើ។ ប្រើ Integer.compare/Long.compare ជំនួសការដកលេខដែលអាច overflow។

### 10.20. equals/hashCode និង Stable Keys

**និយមន័យ៖** equals កំណត់សមភាព; equal objects ត្រូវមាន hashCode ដូចគ្នា។ Hash ដូចគ្នាមិនធានាថា Objects ស្មើ។

```java
Set<ProductKey> keys = new HashSet<>();
keys.add(new ProductKey("A"));
keys.add(new ProductKey("A"));
System.out.println(keys.size()); // 1
```

**ចំណាំ៖** ProductKey ក្នុង Project ប្រើ final code សម្រាប់ equals/hashCode/compareTo ទាំងអស់។ កុំកែ field ដែលចូលរួមក្នុង equality/hash ពេល Object ជា HashMap key ឬ HashSet element ព្រោះ lookup អាចរកមិនឃើញ។ TreeSet/TreeMap ប្រើ compare == 0; Comparator តាមតម្លៃតែមួយអាចបាត់ផលិតផលដែលតម្លៃដូចគ្នា។ Product ក្នុង Demo មិន override equals; ប្រើ ProductKey សម្រាប់ identity set។

### 10.21. Copies, Views និង Unmodifiable Collections

**និយមន័យ៖** Copy មានរចនាសម្ព័ន្ធដាច់ពីដើម; backed view ចែករំលែករចនាសម្ព័ន្ធ/ទិន្នន័យ; unmodifiable មិនអនុញ្ញាតកែតាម reference នោះ។

```java
List<Product> mutableCopy = new ArrayList<>(original);
List<Product> snapshot = List.copyOf(original);
List<Product> liveView = Collections.unmodifiableList(original);
List<Product> range = original.subList(0, 1);
```

**ចំណាំ៖** Copy ទាំងនេះជា shallow: Product objects នៅតែចែករំលែក។ List.copyOf មិនប្ដូរតាម structure ដើម; unmodifiableList ជា live view។ subList កែឃើញក្នុងដើម; structural changes ក្រៅ view អាចធ្វើឱ្យការប្រើ view លែងកំណត់ច្បាស់។ Arrays.asList(array) ជា fixed-size backed view ដែល set បាន តែ add/remove មិនបាន។ Map.keySet/values/entrySet ក៏ជា views; លុបតាម view អាចលុប mapping ដើម។

### 10.22. null Policies

**និយមន័យ៖** Collection implementation នីមួយៗមានច្បាប់ null ខុសគ្នា។

```java
List<String> nullable = new ArrayList<>();
nullable.add(null); // បាន
// List.of("A", null); // NullPointerException
// List.copyOf(nullable); // NullPointerException
```

**ចំណាំ៖** ArrayList/LinkedList ទទួល null; HashSet/LinkedHashSet ទទួល null មួយ; HashMap/LinkedHashMap ទទួល null key មួយ និង null values។ Natural-order TreeSet/TreeMap មិនទទួល null element/key (TreeMap អាចមាន null values)។ Comparator ដែលគាំទ្រ null អាចផ្លាស់ប្ដូរច្បាប់ក្នុង Tree structures។ ArrayDeque/PriorityQueue មិនទទួល null; ConcurrentHashMap មិនទទួល null key/value; factory List.of/Set.of/Map.of មិនទទួល null។ កុំ unbox missing Integer ពី Map ដោយគ្មានការពិនិត្យ។

### 10.23. Performance និងការជ្រើសរើស

**និយមន័យ៖** Big-O ពិពណ៌នាកំណើនការងារតាមទំហំ input មិនមែនពេលវេលាពិតជាវិនាទី។

| តម្រូវការ | ជម្រើសទូទៅ | ចំណាយសំខាន់ |
|---|---|---|
| អានតាម Index | ArrayList | get O(1), add ចុង amortized O(1), កែ structure កណ្ដាល O(n) |
| បន្ថែម/លុបចុងទាំងពីរ | ArrayDeque | ជាទូទៅ amortized O(1) |
| ពិនិត្យ unique/membership | HashSet | expected O(1) ពេល hashing ល្អ |
| Unique តាម insertion order | LinkedHashSet | expected O(1), Memory បន្ថែម |
| Lookup តាម Key | HashMap | expected O(1) ពេល hashing ល្អ |
| Map តាម insertion/access order | LinkedHashMap | expected O(1), Memory បន្ថែម |
| Sorted/range lookup | TreeSet/TreeMap | add/get/contains/remove O(log n) តាម API |
| យកអាទិភាពមុន | PriorityQueue | offer/poll O(log n), peek O(1) |

**Syntax / ឧទាហរណ៍៖**

```java
Map<ProductKey, Product> lookup = new HashMap<>();
List<Product> display = new ArrayList<>();
Queue<String> pending = new ArrayDeque<>();
```

**ចំណាំ៖** កុំវាស់ល្បឿនតាម Demo តូច។ គិត access pattern, Memory, ordering និង thread ownership មុនជ្រើស។

### 10.24. Thread Safety ជាមូលដ្ឋាន

**និយមន័យ៖** Collections ធម្មតាមិនធានាសុវត្ថិភាពសម្រាប់ការកែពី Threads ច្រើន។ Concurrent implementation ឬ locking ត្រូវជ្រើសតាម operation។

```java
Map<String, Integer> counts = new ConcurrentHashMap<>();
counts.merge("P001", 1, Integer::sum); // Atomic update សម្រាប់ Key នេះ
```

**ចំណាំ៖** get រួច put ដាច់ពីគ្នាមិនក្លាយជា atomic workflow ទេ។ ConcurrentHashMap មិនធ្វើឱ្យ Product objects ឬ multi-key business transactions thread-safe។ synchronizedList ធ្វើ synchronized individual methods; ពេល iterate ត្រូវ lock wrapper ដដែល។ Concurrency នឹងរៀនលម្អិតនៅដំណាក់កាល JVM/Threads។

### 10.25. Project Workflow និងដែនកំណត់

**និយមន័យ៖** ផ្សំ Collections នីមួយៗតាមទំនួលខុសត្រូវរបស់វា ជំនួសការប្រើ structure មួយសម្រាប់គ្រប់ការងារ។

```java
Product coffee = catalog.find(new ProductKey("P001"));
coffee.reserve(2);
Queue<String> tasks = new ArrayDeque<>();
tasks.offer("Pack 2 Coffee"); // បន្ថែមក្រោយ reservation ជោគជ័យ
```

**លំហូរ៖** Catalog Map ស្វែងរក/បដិសេធ Code ស្ទួន → List រក្សាការជ្រើសទំនិញ → LinkedHashSet បង្ហាញ Codes មិនស្ទួន → filter/sort copy → reserve stock → FIFO task។
**ចំណាំ៖** List cart codes ស្ទួនអាចមានន័យថាជ្រើសផលិតផលច្រើនដង មិនត្រូវលុបស្ទួនដើម្បីគណនាចំនួនទិញដោយគ្មានច្បាប់។ Demo មិនមាន database, payment, durable queue, transaction ឬ thread-safe inventory។

**ចំណុចគន្លឹះ៖** List រក្សាលំដាប់/ស្ទួន; Set រក្សា uniqueness; Map lookup តាម Key; Queue/Deque គ្រប់គ្រងការយកការងារ។ រក្សា keys ឱ្យ stable, លុបដោយ iterator/removeIf, បែងចែក copies ពី views និង unmodifiable ពី deep immutability។

## ផ្នែកបន្ទាប់ក្នុងផែនការ — មិនទាន់បានរៀនពេញលេញ

equals/hashCode → Immutability → Modern Java → JVM/Concurrency → Design/Tools → Web/Database → Spring Core → Spring Boot → Backend API → JPA/Hibernate → Security/Testing → Deployment/Operations។

មេរៀនថ្មីនីមួយៗនឹងបន្ថែមនិយមន័យ Syntax ឧទាហរណ៍ ការប្រើប្រាស់ និងចំណុចគន្លឹះ តាមទម្រង់លេខធំ/លេខរងដូចឯកសារនេះ។
