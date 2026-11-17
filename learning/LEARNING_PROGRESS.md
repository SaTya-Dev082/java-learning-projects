# កំណត់ត្រាសិក្សា Java → Spring → Spring Boot

ចាប់ផ្ដើមតាមដាន៖ 2026-11-11

## របៀបរៀន

- ពន្យល់ជាភាសាខ្មែរ និងរក្សាពាក្យបច្ចេកទេសជាភាសាអង់គ្លេស។
- រៀននិយមន័យ គោលបំណង និងឧទាហរណ៍ជីវិតពិតជាមុន។
- ចាប់ផ្ដើម Coding នៅពេលអ្នករៀនប្រាប់ថាយល់ និងចង់អនុវត្ត។
- កត់ត្រាការយល់ទ្រឹស្ដី និងការអនុវត្តដោយឡែកពីគ្នា។ មិនសន្មតថាបានយល់ដោយសារតែបានពន្យល់រួចទេ។
- ធ្វើបច្ចុប្បន្នភាពឯកសារនេះពេលបញ្ចប់មេរៀន ឬពេលអ្នករៀនបញ្ជាក់ពីវឌ្ឍនភាព។

## ស្ថានភាពបច្ចុប្បន្ន

- បានព្រមព្រៀងលើផែនការសិក្សា។
- Class និង Object៖ អ្នករៀនបានបញ្ជាក់ថាយល់ទ្រឹស្ដី រួមទាំង State និង Behavior។
- ការអនុវត្តកំពុងរៀន៖ បានបង្កើត និងសាកដំណើរការឧទាហរណ៍ Student នៅ fundamentals/classobject។ អ្នករៀនមិនទាន់បញ្ជាក់ថាបានអនុវត្តដោយខ្លួនឯងទេ។
- Encapsulation៖ អ្នករៀនបានយល់គោលបំណងការពារ State។ បានបង្កើត Product, EncapsulationDemo និងផ្ទៀងផ្ទាត់ច្បាប់ស្តុក។ អ្នករៀនមិនទាន់បញ្ជាក់ការអនុវត្តដោយខ្លួនឯង។
- លំដាប់ត្រឹមត្រូវ៖ Class/Object → Encapsulation → Inheritance → Polymorphism → Abstraction → Interface → Composition។
- ជំហានបន្ទាប់៖ ពិនិត្យកូដ Encapsulation រួចរៀននិយមន័យ Inheritance។
- Project សម្រាប់អនុវត្តនៅពេលក្រោយ៖ ប្រព័ន្ធគ្រប់គ្រងការបញ្ជាទិញ និងស្តុកទំនិញ។

## ផែនការតាមដាន

ស្ថានភាព៖ មិនទាន់ចាប់ផ្ដើម / កំពុងរៀន / បានយល់ / ត្រូវរំលឹក។
ការអនុវត្ត៖ មិនទាន់ធ្វើ / កំពុងធ្វើ / បានធ្វើ។

| ល.រ. | ប្រធានបទ | ទ្រឹស្ដី | ការអនុវត្ត |
|---|---|---|---|
| 1 | Java OOP: Class, Object, Encapsulation, Inheritance, Polymorphism, Abstraction, Interface, Composition | កំពុងរៀន | កំពុងធ្វើ |
| 2 | Advanced Java: Exceptions, Generics, Collections, equals/hashCode, Immutability | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ |
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
| Inheritance | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ | — |
| Polymorphism | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ | — |
| Abstraction | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ | — |
| Interface | កំពុងរៀន | មិនទាន់ធ្វើ | បានណែនាំនិយមន័យបន្តិច ត្រូវរៀនតាមលំដាប់ក្រោយ Abstraction |
| Composition | មិនទាន់ចាប់ផ្ដើម | មិនទាន់ធ្វើ | — |

## ប្រវត្តិសិក្សា

| កាលបរិច្ឆេទ | សកម្មភាព | លទ្ធផល | ជំហានបន្ទាប់ |
|---|---|---|---|
| 2026-11-11 | បង្កើតផែនការតាមដានការសិក្សា | បានព្រមព្រៀងលំដាប់មេរៀន និងរបៀបរៀន | ចាប់ផ្ដើមនិយមន័យ Class និង Object |

| 2026-11-17 | Encapsulation: Product stock | បានយល់ទ្រឹស្ដី; Demo និង stock checks ដំណើរការជោគជ័យ | អនុវត្តកូដ រួចបន្ត Inheritance |
