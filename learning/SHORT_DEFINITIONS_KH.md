# និយមន័យខ្លី — Java → Spring → Spring Boot

ចម្លងផ្នែកណាមួយខាងក្រោមសម្រាប់កត់ត្រាបាន។ បញ្ជីនេះមិនមែនជាការបញ្ជាក់ថាអ្នករៀន
បានអនុវត្តគ្រប់មេរៀនដោយខ្លួនឯងទេ។

## 1. Java OOP — បានពន្យល់ និងមានឧទាហរណ៍កូដ

- OOP: របៀបរៀបចំកម្មវិធីជុំវិញ Objects ដែលមានទិន្នន័យ និងមុខងារ។
- Class: គំរូកំណត់ Fields និង Methods របស់ Objects មួយប្រភេទ។
- Object: Instance ជាក់លាក់របស់ Class ដែលមាន State និង Identity ផ្ទាល់ខ្លួន។
- State: តម្លៃទិន្នន័យបច្ចុប្បន្នរបស់ Object។
- Behavior: សកម្មភាពដែល Object អាចធ្វើតាម Methods។
- Identity: ភាពជាវត្ថុដាច់ដោយឡែក ទោះ State ដូច Object ផ្សេងក៏ដោយ។
- Field: Variable ដែលប្រកាសក្នុង Class សម្រាប់រក្សាទុកទិន្នន័យ។
- Method: មុខងារដែលកំណត់ការងារមួយក្នុង Class/Interface។
- Constructor: ផ្នែកសម្រាប់រៀបចំ Object នៅពេលបង្កើត; មិនមាន Return Type។
- Reference: តម្លៃដែលយោងទៅ Object; Variables ច្រើនអាចយោងទៅ Object តែមួយ។
- this: យោងទៅ Object បច្ចុប្បន្ន។
- Encapsulation: ដាក់ទិន្នន័យ និងមុខងារគ្រប់គ្រងវាជាមួយគ្នា ហើយកំណត់ការចូលប្រើតាមច្បាប់។
- private: កម្រិតចូលប្រើដែលកំណត់តែក្នុងបរិបទ Class ដែលប្រកាសវា។
- Getter: Method អានតម្លៃ; មិនចាំបាច់មាន Setter សម្រាប់គ្រប់ Field ទេ។
- Validation: ពិនិត្យតម្លៃ និងច្បាប់អាជីវកម្មមុនទទួល ឬកែ State។
- Inheritance: Class កូនទទួល Members ដែលអនុញ្ញាតពី Class មេ តាមទំនាក់ទំនង is-a។
- Superclass / Subclass: Class មេ / Class កូន។
- extends: បញ្ជាក់ទំនាក់ទំនងទទួលមរតក ឬ Bound របស់ Type Parameter តាមបរិបទ។
- super(...): ហៅ Constructor របស់ Class មេ។
- Overriding: Class កូនផ្ដល់ការអនុវត្តថ្មីសម្រាប់ Instance Method ដែលទទួលមរតក។
- Polymorphism: ប្រើប្រភេទរួមធ្វើការជាមួយ Objects ផ្សេងៗ; Instance Method ដែល Override ជ្រើសតាម Object នៅ Runtime។
- Upcasting: យោងទៅ Object កូនតាមប្រភេទមេ។
- instanceof: ពិនិត្យថា Object អាចប្រើជាប្រភេទជាក់លាក់បានឬអត់; null ផ្ដល់ false។
- Abstraction: ផ្ដល់មុខងារដែលត្រូវប្រើ ដោយមិនតម្រូវអ្នកហៅឱ្យដឹងព័ត៌មានលម្អិតនៃការអនុវត្ត។
- Abstract Class: Class ដែលមិនអាចបង្កើត Instance ដោយផ្ទាល់; អាចមាន State, Constructor និងកូដរួម។
- Abstract Method: Method គ្មាន Body ដែល Concrete Subclass ត្រូវអនុវត្ត បើមិនទាន់មាន implementation ទទួលមរតក។
- Concrete Class: Class មិន abstract ដែលមានការអនុវត្តគ្រប់ Abstract Methods ហើយអាចបង្កើត Instance។
- Interface: កិច្ចសន្យាអំពីមុខងាររួម ដែល Classes អាចអនុវត្ត។
- implements: បញ្ជាក់ថា Class អនុវត្ត Interface។
- Object Composition: ផ្សំ Objects ដោយ Object មួយរក្សា/ប្រើ Object ផ្សេង ដើម្បីបំពេញការងារ។
- has-a: ទំនាក់ទំនងមាន/ប្រើ Object ផ្សេង; មិនមែនគ្រប់ has-a សុទ្ធតែជា UML Composition តឹងរ៉ឹងទេ។
- UML Composition: ទំនាក់ទំនង whole-part ដែលភ្ជាប់ ownership និង lifecycle របស់ផ្នែកនឹងម្ចាស់។
- Delegation: ប្រគល់ការងារទៅ Object ដែលទទួលខុសត្រូវ។
- Constructor Injection: ទទួល Dependency ពីខាងក្រៅតាម Constructor។

## 2. Exception Handling — បានពន្យល់ និងមានកូដ whole session

- Exception: Object តំណាងឱ្យករណីខុសប្រក្រតីដែលរំខានលំហូរធម្មតា។
- Exception Handling: កំណត់ការឆ្លើយតបពេលប្រតិបត្តិការបរាជ័យ។
- throw: បោះ Exception ជាក់លាក់ពីកូដ ហើយឈប់លំហូរធម្មតាត្រង់នោះ។
- throws: ប្រកាសប្រភេទ Exception ដែល Method អាចបញ្ជូនទៅអ្នកហៅ; មិនដោះស្រាយបញ្ហា។
- try: ប្លុកការងារដែលអាចភ្ជាប់ catch/finally ឬ resources។
- catch: ទទួល Exception ប្រភេទត្រូវគ្នា និងអនុវត្តការឆ្លើយតប។
- Propagation: Exception បន្តតាមអ្នកហៅ Methods រហូតដល់មាន Handler ដែលត្រូវគ្នា។
- Checked Exception: Compiler តម្រូវឱ្យ catch ឬ declare throws; ឧទាហរណ៍ IOException។
- Unchecked Exception: Compiler មិនតម្រូវ catch/throws; RuntimeException និងកូន ព្រមទាំង Error និងកូន។
- Custom Exception: Class Exception បង្កើតសម្រាប់បញ្ហាជាក់លាក់របស់ប្រព័ន្ធ។
- finally: កូដដែលជាទូទៅដំណើរការពេលចាកចេញពី try/catch សម្រាប់ cleanup; មិនធានាក្នុង process termination។
- try-with-resources: បិទធនធាន AutoCloseable ស្វ័យប្រវត្តិពេលចាកចេញពីប្លុក។
- AutoCloseable: Interface កំណត់ close() សម្រាប់បញ្ចប់ការប្រើធនធាន។
- Stack Trace: បញ្ជី call stack ដែលជួយរកទីតាំងបោះ Exception និងផ្លូវហៅ។
- Cause: Exception ដើមដែលបង្កឱ្យ Exception ថ្មីកើតឡើង។
- Exception Wrapping: បោះ Exception ថ្មីដោយបន្ថែម context និងរក្សា Cause ដើម។
- Suppressed Exception: បញ្ហាបន្ថែម ដូចជា close failure ដែលរក្សាជាប់ Primary Exception។
- Rollback: លុបចោលការផ្លាស់ប្ដូរតាមយន្តការជាក់លាក់; throw Exception មួយឯងមិន rollback State ស្វ័យប្រវត្តិទេ។

## 3. Generics — បានពន្យល់ និងមានកូដ whole session

- Generics: ប្រើប្រភេទទិន្នន័យជាប៉ារ៉ាម៉ែត្ររបស់ Class, Interface ឬ Method។
- Type Safety: ការត្រួតពិនិត្យការប្រើប្រភេទឱ្យត្រឹមត្រូវ ដើម្បីកាត់បន្ថយកំហុស Runtime។
- Type Parameter: ឈ្មោះប្រភេទក្នុងការប្រកាស ដូចជា T ក្នុង class Box<T>។
- Type Argument: ប្រភេទដែលផ្ដល់ពេលប្រើ ដូចជា String ក្នុង Box<String>។
- Generic Class: Class ដែលប្រកាស Type Parameters ផ្ទាល់ខ្លួន។
- Generic Interface: Interface ដែលកិច្ចសន្យាប្រើ Type Parameters។
- Generic Method: Method ដែលប្រកាស Type Parameters មុន Return Type។
- Multiple Type Parameters: ប្រកាសប្រភេទច្រើន ដូចជា Pair<K, V>។
- Diamond Operator <>: ឱ្យ Compiler សន្និដ្ឋាន Type Arguments ពេលបង្កើត Object។
- Type Inference: Compiler សន្និដ្ឋានប្រភេទពី Arguments និងបរិបទ។
- Wrapper Class: Reference type សម្រាប់ primitive ដូចជា Integer សម្រាប់ int។
- Autoboxing: ការបម្លែង primitive ទៅ Wrapper ដោយស្វ័យប្រវត្តិ។
- Bounded Type Parameter: កំណត់ប្រភេទដែល T អនុញ្ញាត ដូចជា <T extends Number>។
- Multiple Bounds: តម្រូវឱ្យ T គោរព Bounds ច្រើន ដូចជា Number & Comparable<T>។
- Comparable<T>: កិច្ចសន្យាសម្រាប់ប្រៀបធៀបតម្លៃតាម compareTo។
- Invariance: S ជាកូន T មិនធ្វើឱ្យ Generic<S> ជាកូន Generic<T> ទេ។
- Wildcard ?: តំណាងឱ្យប្រភេទជាក់លាក់មួយដែលមិនកំណត់ឈ្មោះនៅទីនោះ។
- List<?>: List នៃប្រភេទមិនស្គាល់; អានជា Object ហើយមិនអាច add non-null តាម Reference នេះ។
- ? extends T: Upper-bounded wildcard; អានជា T បាន ប៉ុន្តែមិនអាច add non-null តាម Reference នេះ។
- ? super T: Lower-bounded wildcard; បន្ថែម T/កូនរបស់ T បាន ប៉ុន្តែអានធានាបានត្រឹម Object។
- PECS: Producer Extends, Consumer Super; ជំនួយជ្រើស Wildcard សម្រាប់អានពីប្រភព/បញ្ចូលទៅគោលដៅ។
- Raw Type: ប្រើ Generic Type ដោយមិនបញ្ជាក់ Type Argument ដូចជា List។
- Unchecked Warning: Compiler មិនអាចធានាសុវត្ថិភាពប្រភេទសម្រាប់ប្រតិបត្តិការមួយ។
- Heap Pollution: Reference នៃ Parameterized Type យោងទៅទិន្នន័យដែលមិនគោរពប្រភេទនោះ។
- Type Erasure: Compiler បម្លែង Type Parameters ទៅ Object ឬ Bounds និងបន្ថែម casts/bridge methods តាមចាំបាច់។
- ClassCastException: Runtime មិនអាច cast Reference ទៅប្រភេទដែលបានស្នើ។
- Unmodifiable List: List មិនអនុញ្ញាតប្រតិបត្តិការកែ Elements តាម API របស់វា; Objects ខាងក្នុងមិនចាំបាច់ immutable។
- Generics vs Validation: Generics ពិនិត្យប្រភេទ; Validation ពិនិត្យតម្លៃ និងច្បាប់អាជីវកម្ម។

## 4. ផែនការមេ — ទិដ្ឋភាពខ្លី មិនមែនបានរៀនអស់

1. Java OOP: រចនាទិន្នន័យ មុខងារ និងទំនាក់ទំនងរវាង Objects។
2. Advanced Java: Exceptions, Generics, Collections, equals/hashCode និង Immutability។ កំពុងរៀន; បន្ទាប់គឺ Collections។
3. Modern Java: Lambda, Functional Interfaces, Streams, Optional, Date/Time និង Records។ មិនទាន់រៀន។
4. JVM/Concurrency: របៀប Java ប្រតិបត្តិកូដ គ្រប់គ្រង Memory និងការងារច្រើនក្នុងពេលតែមួយ។ មិនទាន់រៀន។
5. Design/Tools: SOLID, Dependencies, Design Patterns, Maven និង Git។ មិនទាន់រៀនជាផ្នែកពេញលេញ។
6. Web/Database: HTTP, REST, JSON, SQL, Relationships, Indexes និង Transactions។ មិនទាន់រៀន។
7. Spring Core: Container គ្រប់គ្រង Objects និង Dependencies តាម IoC/DI។ មិនទាន់រៀនតាមផែនការ។
8. Spring Boot: ជួយរៀបចំ Spring application តាម Starters និង Auto-configuration។ មិនទាន់រៀនតាមផែនការ។
9. Backend API: រចនា endpoints, layers, DTOs, Validation និង Error Responses។ មិនទាន់រៀន។
10. Spring Database: Mapping និងការគ្រប់គ្រងទិន្នន័យតាម JPA/Hibernate និង Transactions។ មិនទាន់រៀនតាមផែនការ។
11. Security/Testing: ផ្ទៀងផ្ទាត់អត្តសញ្ញាណ កំណត់សិទ្ធិ និងផ្ទៀងផ្ទាត់អាកប្បកិរិយាកម្មវិធី។ មិនទាន់រៀនជាផ្នែកពេញលេញ។
12. Deployment/Operations: ដាក់ឱ្យប្រើប្រាស់ តាមដាន និងគ្រប់គ្រងកម្មវិធីដែលដំណើរការ។ មិនទាន់រៀន។
