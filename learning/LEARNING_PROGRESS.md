# កំណត់ត្រាសិក្សា Java → Spring → Spring Boot

ចាប់ផ្ដើមតាមដាន៖ 2026-11-11

## របៀបរៀន

- ពន្យល់ជាភាសាខ្មែរ និងរក្សាពាក្យបច្ចេកទេសជាភាសាអង់គ្លេស។
- រៀននិយមន័យ គោលបំណង និងឧទាហរណ៍ជីវិតពិតជាមុន។
- ចាប់ផ្ដើម Coding នៅពេលអ្នករៀនប្រាប់ថាយល់ និងចង់អនុវត្ត។
- កត់ត្រាការយល់ទ្រឹស្ដី និងការអនុវត្តដោយឡែកពីគ្នា។ មិនសន្មតថាបានយល់ដោយសារតែបានពន្យល់រួចទេ។
- ធ្វើបច្ចុប្បន្នភាពឯកសារនេះពេលបញ្ចប់មេរៀន ឬពេលអ្នករៀនបញ្ជាក់ពីវឌ្ឍនភាព។
- មេរៀននីមួយៗត្រូវមាននិយមន័យ Syntax និងឧទាហរណ៍។ ពេលស្នើអនុវត្តកូដ គ្របដណ្ដប់គ្រប់ចំណុចក្នុង session ហើយសង្ខេបក្នុង SHORT_DEFINITIONS_KH.md តាមលេខធំ/រង (1, 1.1...) ជាមួយការប្រើប្រាស់ និងចំណុចប្រុងប្រយ័ត្ន។

- សម្រាប់គ្រប់មេរៀនបន្ត៖ ពន្យល់និយមន័យ ចំណុចរង ការប្រើញឹកញាប់ និងបរិបទ Project ពិត។ ពេល Coding ពន្យល់តួនាទីកូដ លំហូរជោគជ័យ/កំហុស និងលទ្ធផល បន្ទាប់មកសាកល្បង និង push។

## ស្ថានភាពបច្ចុប្បន្ន

- បានព្រមព្រៀងលើផែនការសិក្សា។
- Class និង Object៖ អ្នករៀនបានបញ្ជាក់ថាយល់ទ្រឹស្ដី រួមទាំង State និង Behavior។
- ការអនុវត្តកំពុងរៀន៖ បានបង្កើត និងសាកដំណើរការឧទាហរណ៍ Student នៅ fundamentals/classobject។ អ្នករៀនមិនទាន់បញ្ជាក់ថាបានអនុវត្តដោយខ្លួនឯងទេ។
- Encapsulation៖ អ្នករៀនបានយល់គោលបំណងការពារ State។ បានបង្កើត Product, EncapsulationDemo និងផ្ទៀងផ្ទាត់ច្បាប់ស្តុក។ អ្នករៀនមិនទាន់បញ្ជាក់ការអនុវត្តដោយខ្លួនឯង។
- លំដាប់ត្រឹមត្រូវ៖ Class/Object → Encapsulation → Inheritance → Polymorphism → Abstraction → Interface → Composition។
- Inheritance៖ បានពន្យល់ is-a និងកែការយល់ច្រឡំជាមួយ has-a។ បានបង្កើត និងដំណើរការ Vehicle/Car/Motorcycle។
- Polymorphism៖ អ្នករៀនបានឆ្លើយត្រូវអំពី runtime dispatch ទៅ Car។ បានបន្ថែម Demo និង Checks នៅ fundamentals/polymorphism។
- Abstraction៖ អ្នករៀនបានឆ្លើយត្រូវថា Concrete Class អាចបង្កើត Object បាន។ បានបង្កើត shipping quote example និង Checks។
- Interface៖ អ្នករៀនឆ្លើយត្រូវថា EmailNotification ត្រូវអនុវត្ត send()។ បានបង្កើត notification contract, console implementations និង order confirmation checks។
- Composition៖ បានពន្យល់ has-a និងកែការយល់ច្រឡំថា Payment ជា Order។ បានបង្កើត OrderService ដែល delegate ទៅ PaymentService និង Checks។
- Exception Handling៖ បានរៀននិយមន័យ Checked/Unchecked, throws, Custom Exceptions និង try-with-resources។ បានអនុវត្ត throw/propagation/try-catch ជាមួយស្តុក។
- Exception Handling whole session៖ មានកូដ Checked/Unchecked, throws, custom exception, propagation, try/catch/finally, file try-with-resources, cause/stack trace និង suppressed exceptions។ Demo និង checks ជោគជ័យ។
- Generics៖ បានរៀនគ្រប់ចំណុចក្នុង session និងបង្កើត whole-session demo, runtime checks និង compile rejection checks។
- និយមន័យខ្លីពីមេរៀនដំបូង៖ SHORT_DEFINITIONS_KH.md។
- Collections៖ ចំណុច 1–5 បានពន្យល់ក្នុងឆាត; តាមសំណើអ្នករៀន ចំណុច 6–12 បញ្ចប់ជានិយមន័យខ្លីក្នុង note និង whole-session code។
- ជំហានបន្ទាប់៖ ពិនិត្យកូដ Collections; បន្ទាប់គឺ equals/hashCode លម្អិត និង Immutability។ មិនទាន់បញ្ជាក់ការយល់ចំណុចដែលរៀនតាម note ឬការអនុវត្តដោយខ្លួនឯងថាបញ្ចប់ទេ។
- Project សម្រាប់អនុវត្តនៅពេលក្រោយ៖ ប្រព័ន្ធគ្រប់គ្រងការបញ្ជាទិញ និងស្តុកទំនិញ។

## ផែនការតាមដាន

ស្ថានភាព៖ មិនទាន់ចាប់ផ្ដើម / កំពុងរៀន / បានយល់ / ត្រូវរំលឹក។
ការអនុវត្ត៖ មិនទាន់ធ្វើ / កំពុងធ្វើ / បានធ្វើ។

| ល.រ. | ប្រធានបទ | ទ្រឹស្ដី | ការអនុវត្ត |
|---|---|---|---|
| 1 | Java OOP: Class, Object, Encapsulation, Inheritance, Polymorphism, Abstraction, Interface, Composition | កំពុងរៀន | កំពុងធ្វើ |
| 2 | Advanced Java: Exceptions, Generics, Collections, equals/hashCode, Immutability | កំពុងរៀន | កំពុងធ្វើ |
| 3 | Modern Java: Lambda, Functional Interface, Streams, Optional, Date/Time, Records | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ |
| 4 | JVM, Stack/Heap, Garbage Collection, Threads, Concurrency | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ |
| 5 | SOLID, Dependencies, Coupling/Cohesion, Design Patterns, Maven, Git | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ |
| 6 | Client/Server, HTTP, JSON, REST, SQL, Relationships, Indexes, Transactions | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ |
| 7 | Spring Core: IoC, DI, Beans, ApplicationContext, Configuration, Scopes, Lifecycle | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ |
| 8 | Spring Boot: Auto-configuration, Starters, Embedded Server, Properties, Profiles | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ |
| 9 | API: Spring MVC, Controller/Service/Repository, DTO, Validation, Error Handling | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ |
| 10 | JPA/Hibernate, Entity Relationships, Transactions, Migrations, Pagination, N+1 | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ |
| 11 | Authentication, Authorization, Spring Security, Password Hashing, Unit/Integration Tests | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ |
| 12 | Logging, Monitoring, Docker, CI/CD, Deployment, Caching, Messaging | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ |

## មេរៀនលម្អិត៖ Java OOP

| ប្រធានបទ | ទ្រឹស្ដី | ការអនុវត្ត | ចំណុចត្រូវរំលឹក |
|---|---|---|---|
| Class និង Object | បានយល់ | កំពុងធ្វើ | ពិនិត្យ Constructor, this, references និង Object identity ក្នុងឧទាហរណ៍ |
| Encapsulation | បានយល់ | កំពុងធ្វើ | private fields, getters, validation និងការរក្សា State ពេលបដិសេធ |
| Inheritance | កំពុងរៀន | កំពុងធ្វើ | ពិនិត្យ is-a, extends, super, private fields និង inherited methods; អ្នករៀនមិនទាន់បញ្ជាក់ការអនុវត្តដោយខ្លួនឯង |
| Polymorphism | បានយល់ | កំពុងធ្វើ | reference type vs object type, @Override, runtime dispatch; អ្នករៀនមិនទាន់បញ្ជាក់ការអនុវត្តដោយខ្លួនឯង |
| Abstraction | បានយល់ | កំពុងធ្វើ | abstract class/method, concrete implementation, shared workflow; អ្នករៀនមិនទាន់បញ្ជាក់ការអនុវត្តដោយខ្លួនឯង |
| Interface | បានយល់ | កំពុងធ្វើ | implements, public methods, interface reference និង constructor injection; អ្នករៀនមិនទាន់បញ្ជាក់ការអនុវត្តដោយខ្លួនឯង |
| Composition | កំពុងរៀន | កំពុងធ្វើ | has-a, delegation, constructor injection; រំលឹក Order មិនមែនជា Payment និងភាពខុសគ្នាជាមួយ UML ownership |

## ប្រវត្តិសិក្សា

| កាលបរិច្ឆេទ | សកម្មភាព | លទ្ធផល | ជំហានបន្ទាប់ |
|---|---|---|---|
| 2026-11-11 | បង្កើតផែនការតាមដានការសិក្សា | បានព្រមព្រៀងលំដាប់មេរៀន និងរបៀបរៀន | ចាប់ផ្ដើមនិយមន័យ Class និង Object |
| 2026-11-17 | Encapsulation: Product stock | បានយល់ទ្រឹស្ដី; Demo និង stock checks ដំណើរការជោគជ័យ | អនុវត្តកូដ រួចបន្ត Inheritance |
| 2026-11-17 | Inheritance: Vehicle/Car/Motorcycle | Demo compile និងដំណើរការជោគជ័យ | អនុវត្ត Inheritance រួចបន្ត Polymorphism |
| 2026-11-17 | Polymorphism: parent references and mixed fleet | Demo និង runtime dispatch checks ជោគជ័យ | អនុវត្ត Polymorphism រួចបន្ត Abstraction |
| 2026-11-17 | Abstraction: Standard/Express shipping quotes | Demo និង pricing/validation checks ជោគជ័យ | អនុវត្ត Abstraction រួចបន្ត Interface |
| 2026-11-17 | Interface: Email/SMS notification contract | Console Demo និង confirmation/validation checks ជោគជ័យ | អនុវត្ត Interface រួចបន្ត Composition |
| 2026-11-17 | Composition: OrderService uses PaymentService | Demo និង delegation/decline/validation checks ជោគជ័យ | អនុវត្ត Composition រំលឹក OOP រួចចូល Exception Handling |
| 2026-11-19 | throw/propagation/try-catch: stock requests | Demo និង checks ជោគជ័យ; មិនទាន់បញ្ជាក់ការអនុវត្តដោយអ្នករៀន | ពិនិត្យកូដ រួច finally និង Stack Trace/Cause |
| 2026-11-19 | Exception Handling whole-session implementation | File imports, finally, cause/stack trace, close order និង suppressed checks ជោគជ័យ | ពិនិត្យកូដទាំងមូល រួចបន្ត Generics |
| 2026-11-19 | Generics whole session + short definitions from first lesson | Demo/runtime checks និង compile rejection 12 ករណីជោគជ័យ | ពិនិត្យ Generics រួចបន្ត Collections |
| 2026-11-20 | រៀបចំកំណត់ត្រាឡើងវិញតាមទម្រង់លេខធំ/លេខរង | 9 ផ្នែកធំ និង 57 ចំណុចរង មាននិយមន័យ Syntax និងឧទាហរណ៍ | រំលឹក Generics មុនចូល Collections |
| 2026-11-20 | Collections whole-session implementation | Demo, catalog/queue/copy/equality checks និង atomic merge check ជោគជ័យ | ពិនិត្យកូដ; បន្ត equals/hashCode |

## មេរៀនលម្អិត៖ Generics

- បានពន្យល់៖ Type safety, Generic Classes/Interfaces/Methods, inference/diamond, bounds, invariance, wildcards/PECS, raw types/erasure និងការប្រើក្នុង Project។
- អ្នករៀនបានឆ្លើយត្រូវអំពី validation, type safety, bounds និង raw vs wildcard; wildcard read/write គួររំលឹកតាម Demo។
- កូដ៖ advanced/generics/GenericsDemo.java និង README.md។
- ផ្ទៀងផ្ទាត់៖ python3 scripts/check-generics.py ពី folder learning។
- ការអនុវត្តដោយអ្នករៀន៖ កំពុងធ្វើ មិនទាន់បញ្ជាក់ថាបញ្ចប់។

## មេរៀនលម្អិត៖ Collections

- ទ្រឹស្ដីក្នុងឆាត៖ Framework/Array, ArrayList, LinkedList, Sets និង Maps។
- ចំណុច 6–12៖ អ្នករៀនស្នើឱ្យរៀនតាមនិយមន័យខ្លី និងកូដ; មិនទាន់សួរផ្ទៀងផ្ទាត់ការយល់លម្អិត។
- កូដគ្របដណ្ដប់៖ Queue/Deque/PriorityQueue, iteration/removal, sorting, equality/keys, mutability/copies/views/null, selection/thread-safety basics និង workflow ហាង។
- ចំណុចគួររំលឹក៖ Set duplicate មិនកាត់ size; Map.put return Value ចាស់ មិនមែនថ្មី។
- Note៖ SHORT_DEFINITIONS_KH.md section 10 (10.1–10.25)។
- Run៖ python3 scripts/check-collections.py ពី folder learning; ក្នុង VS Code run CollectionsDemo ឬ StoreCollectionsDemo។
- ការអនុវត្តដោយអ្នករៀន៖ កំពុងធ្វើ មិនទាន់បញ្ជាក់ថាបញ្ចប់។
