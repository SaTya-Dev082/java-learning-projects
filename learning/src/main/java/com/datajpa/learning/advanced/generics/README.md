# Generics — whole-session guide

## Coverage / syntax / reading order

| ចំណុច | Syntax | កូដ |
|---|---|---|
| Type safety និង diamond | `Box<String> b = new Box<>()` | Box, Demo section 1 |
| Generic class | `class Box<T>` | Box, ApiResponse |
| Multiple parameters | `class Pair<K, V>` | Pair |
| Generic interface | `interface Validator<T>` | Validator, ProductNameValidator |
| Generic method / inference | `static <T> T ...` | GenericUtils.valueOrDefault |
| Explicit argument | `GenericUtils.<String>valueOrDefault(...)` | Demo section 3 |
| Class bound | `<T extends Number>` | NumericBox |
| Interface bound | `<T extends Comparable<T>>` | GenericUtils.max |
| Multiple bounds | `<T extends Number & Comparable<T>>` | GenericUtils.maxNumber |
| Invariance | `List<Integer>` មិនមែន `List<Number>` | Demo comment, compiler checks |
| Unbounded wildcard | `List<?>` | GenericUtils.printItems |
| Upper-bounded wildcard | `List<? extends Number>` | GenericUtils.printNumbers |
| Lower-bounded wildcard | `List<? super Integer>` | GenericUtils.addSampleQuantities |
| PECS | source extends / destination super | GenericUtils.copyItems |
| Raw types / heap pollution | `List raw` | RawTypePitfall |
| Type erasure | same runtime Class | Demo section 7, compiler checks |
| Real-world response / validation | `ApiResponse<List<Product>>` | Demo section 8, Product |
| Empty/null/unmodifiable cases | runtime validation | GenericsChecks |

## ដំណើរការឧទាហរណ៍ catalog

1. Product constructor ប្រើ Validator<String> ដើម្បីពិនិត្យឈ្មោះ និងពិនិត្យស្តុក >= 0។
2. Product objects ត្រូវដាក់ក្នុង List<Product>។ List.of មិនអនុញ្ញាត add/remove។
3. ApiResponse<List<Product>> រក្សា message និង list ដែលមានប្រភេទច្បាស់។ នេះមិនមែនជា HTTP server ទេ។
4. getData() return List<Product>; first() return Product ដោយមិនត្រូវ cast។
5. copyItems(source, destination) អាន Product ពី source ហើយ append ទៅ destination។
   វាចម្លង reference មិនមែន deep copy; destination ត្រូវគាំទ្រ add។ ប្រើ lists ដាច់គ្នា។
6. Box<Integer> ទទួល -10 បាន ព្រោះប្រភេទត្រឹមត្រូវ; Product បដិសេធ -10 ព្រោះ business rule។

## Methods សំខាន់ៗ

- valueOrDefault: value មិន null → value; បើ null → fallback។ ទាំងពីរ null → null។
  Inference អាចរក common supertype បើ arguments ខុសប្រភេទ; `<T>` មិនមានន័យថា
  runtime classes របស់ arguments ទាំងអស់ត្រូវតែដូចគ្នា។
- max: compareTo >= 0 → first; បើមិនដូច្នោះ → second; null ត្រូវបដិសេធ។
- NumericBox.asDouble: ប្រើ method ពី Number bound; conversion អាចបាត់ precision,
  ដូច្នេះមិនប្រើ double សម្រាប់គណនាប្រាក់ក្នុង project ពិត។
- printItems: អាន unknown element ជា Object។
- printNumbers: អានជា Number ពី List<Number/Integer/Double>។ មិនអាច add non-null តាម reference នេះ។
- addSampleQuantities: List<Integer/Number/Object> ទទួល Integer បាន;
  អានចេញធានាបានត្រឹម Object ព្រោះ list អាចមានទិន្នន័យផ្សេងពីមុន។
- first: empty → IllegalArgumentException; nonempty → item ទី១។ null list → NullPointerException។

Wildcard មិនធ្វើឱ្យ List immutable ទេ។ extends អាច remove/clear បើ list គាំទ្រ;
null អាចឆ្លងការត្រួតពិនិត្យប្រភេទ ប៉ុន្តែ implementation អាចបដិសេធវា។

## Raw types និង Type Erasure

RawTypePitfall មាន suppression តែនៅ method បង្ហាញកូដមិនសុវត្ថិភាពដោយចេតនា។
កុំប្រើវាជាគំរូ production។ Compiler checks ខាងក្រោមបង្ហាញ warnings ពិត ដោយគ្មាន suppression។
Raw reference ដាក់ String ចូល List<Integer>; ពេលអានជា Integer cast ដែល compiler បន្ថែម
នឹងបរាជ័យជា ClassCastException។ នេះគឺ heap pollution។

Erasure: unbounded T ប្រើ Object; bounded T ប្រើ leftmost bound (Number ក្នុង NumericBox)។
Compiler បន្ថែម casts និងអាចបង្កើត bridge methods ដើម្បីរក្សា polymorphism។ Generic metadata
មួយចំនួននៅក្នុង class files សម្រាប់ reflection ប៉ុន្តែមិនបង្កើត Class ផ្សេងសម្រាប់ Box<String>/Box<Integer>។

មិនអនុញ្ញាត៖ Box<int>, new T(), new T[10], instanceof List<String>,
overload តែ List<String>/List<Integer>។ ករណីទាំងនេះមាន compile rejection checks ដាច់ដោយឡែក។
Factory/Supplier អាចជាជម្រើសសម្រាប់ការបង្កើត T; នឹងរៀនពេល Functional Interfaces។

## Run / verify ពី folder learning

```sh
python3 scripts/check-generics.py
```

Script compile lesson ជាមួយ --release 21, -Xlint:all និង -Werror; run Demo និង runtime checks;
រួច compile snippets ខុសដោយចេតនា ដើម្បីបញ្ជាក់ការបដិសេធ 12 ករណី និង raw warnings។
Snippets ទាំងនោះបង្កើតក្នុង temporary directory មិនបំបែក project build។

ក្នុង VS Code ចុច Run ក្នុង GenericsDemo.java។ មិនត្រូវការ Spring/database។
កូដខ្លះប្រើ List ដើម្បីបង្ហាញ Generics; Collections នឹងរៀនលម្អិតបន្ទាប់។

លំហាត់៖ បង្កើត Validator<Integer> សម្រាប់ចំនួនស្តុក >= 0 ហើយប្រើជាមួយ response
ApiResponse<Integer>; សាក -1, 0, 10 និង null។
