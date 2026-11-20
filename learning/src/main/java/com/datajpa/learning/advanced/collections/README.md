# Collections — whole-session implementation

តាមសំណើអ្នករៀន ចំណុច 1–5 រៀនក្នុងឆាត; ចំណុច 6–12 រៀនតាម note និងកូដ។
មិនសន្មតថាអ្នករៀនយល់លម្អិត ឬអនុវត្តដោយខ្លួនឯងបញ្ចប់ទេ។
និយមន័យ/Syntax/ឧទាហរណ៍ខ្លីគ្រប់ផ្នែក៖ `learning/SHORT_DEFINITIONS_KH.md` section 10។

## Run ពី folder learning

```sh
python3 scripts/check-collections.py
```

Script compile Java 21 ជាមួយ `-Xlint:all -Werror`, run Demo និង checks។
ក្នុង VS Code ចុច Run លើ `CollectionsDemo.main()` សម្រាប់ whole-session demo;
ឬ `StoreCollectionsDemo.main()` សម្រាប់ workflow ហាងតែមួយ។ មិនត្រូវការ Spring/DB។

## តួនាទីឯកសារ

| ឯកសារ | ទំនួលខុសត្រូវ |
|---|---|
| ProductKey | immutable code; equals/hashCode/compareTo គោរពសមភាពដូចគ្នា |
| Product | តម្លៃ/ស្តុក; validation និង reserve ដែលមិនកែស្តុកពេលបដិសេធ |
| Catalog | LinkedHashMap lookup និង insertion order; បដិសេធ duplicate code |
| ShippingTask | Comparable: លេខ priority តូចមុន រួច sequence តូចមុន |
| CollectionsDemo | បង្ហាញគ្រប់មេរៀន និងករណីប្រុងប្រយ័ត្ន |
| StoreCollectionsDemo | ផ្សំ Map/List/Set/Queue/filter/sort ក្នុង workflow ហាង |
| CollectionsChecks | ពិនិត្យ business behavior និងករណីព្រំដែនដោយមិនមាន external service |

## Coverage និងលំដាប់ដំណើរការ

| Session | Method ក្នុង CollectionsDemo | អ្វីដែលឃើញ |
|---|---|---|
| 1. Framework / Array | lists | array length ថេរ vs list size |
| 2. List / ArrayList | lists | add/get/set/remove/contains/size/clear/isEmpty; capacity មិនមែន size |
| 3. LinkedList | lists | addFirst/addLast/removeFirst/peekLast |
| 4. Set implementations | sets | add duplicate return false; insertion order vs sorted order; range navigation |
| 5. Map implementations | maps | put Return ចាស់; null vs absent; ordering; access order; range lookup; updates |
| 6. Queue / Deque / PriorityQueue | queues | FIFO, empty poll, LIFO, priority/tie sequence |
| 7. Iteration | iteration | for-each, iterator.remove, ListIterator.set/add, removeIf, fail-fast |
| 8. Sorting | sortingAndEquality | Comparable natural order; Comparator price then code/reversed |
| 9. Equality | sortingAndEquality | stable code keys deduplicate; comparator-only price can discard product |
| 10. Copies/views/null | copiesAndNulls | mutable copy, unmodifiable snapshot, live view, subList, array view, shallow references |
| 11. Performance/thread safety | concurrencyBasics + note 10.23–10.24 | atomic per-key merge, synchronized wrapper iteration; performance table |
| 12. Real-world use | StoreCollectionsDemo | lookup, duplicates, cart, availability, sorting, stock reservation, task queue |

## កូដសំខាន់ និងមូលហេតុ

### Catalog.add

```java
Product existing = products.putIfAbsent(product.getKey(), product);
if (existing != null) {
    throw new IllegalArgumentException("Duplicate product code: " + product.getKey());
}
```

Catalog មិនរក្សា null values ដូច្នេះ existing មិន null មានន័យថាមាន Code រួច។
មិនប្រើ put ធម្មតាដែលជំនួសផលិតផលចាស់មុនដឹងថាស្ទួន។ Key ថ្មីដែលមាន Code ដូចគ្នា
រកផលិតផលចាស់បាន ព្រោះ ProductKey ផ្ដល់ equals/hashCode ត្រឹមត្រូវ។
Catalog នេះ single-threaded; putIfAbsent លើ LinkedHashMap មិនធ្វើឱ្យវា concurrent-safe។

### Available product list

```java
List<Product> available = new ArrayList<>(catalog.list());
available.removeIf(product -> product.getStock() == 0);
available.sort(Comparator.comparingLong(Product::getPriceCents).thenComparing(Product::getKey));
```

Copy structure ដើម្បី filter ដោយមិនលុបផលិតផលពី catalog។ removeIf លុបតែផលិតផលស្តុក 0
ក្នុងបញ្ជី copy។ sort រៀបតម្លៃតូចមុន; តម្លៃស្មើបំបែកតាម Code។ Objects នៅតែចែករំលែក។
Lambda `product -> ...` គឺលក្ខខណ្ឌសម្រាប់ Element; Method Reference `Product::getPriceCents`
ជាមុខងារដកតម្លៃប្រៀបធៀប។ Modern Java នឹងរៀនលម្អិតនៅពេលក្រោយ។

### Reservation and queue

```java
Product coffee = catalog.find(new ProductKey("P001"));
coffee.reserve(2);
tasks.offer("Pack 2 Coffee");
```

find បោះបញ្ហាបើ Code មិនមាន។ reserve ពិនិត្យចំនួន និងស្តុកមុនកែ State។
offer ដាក់ការងារក្រោយ reserve ត្រឡប់ធម្មតា។ poll យកការងារចាស់មុន; empty poll return null។
ឧទាហរណ៍ចាប់ផ្ដើម Coffee ស្តុក 10; reserve 2 → ស្តុក 8 → Pack task មួយ។

## កំហុសដែលបង្ហាញដោយចេតនា

- Invalidated ArrayList iterator បោះ ConcurrentModificationException: ចាប់ក្នុង Demo សម្រាប់បង្ហាញប៉ុណ្ណោះ។
  កុំសន្មតថា fail-fast តែងរកឃើញកំហុសទាំងអស់ ឬធ្វើឱ្យ thread-safe។
- Arrays.asList add បោះ UnsupportedOperationException; set បាន និងឃើញក្នុង array ដើម។
- List.copyOf ដែលមាន null បោះ NullPointerException។
- TreeSet<Product> comparator តម្លៃតែមួយទទួល Product តម្លៃស្មើតែមួយ៖ មិនមែនគំរូ Set identity ដែលគួរប្រើទេ។
  សម្រាប់ identity ប្រើ Set<ProductKey>; សម្រាប់បង្ហាញ sorted products ប្រើ List.sort។

## ការផ្ទៀងផ្ទាត់ និងកម្រិត

Checks ផ្ទៀងផ្ទាត់៖ remove overloads, ordered dedup, put old value, null mappings,
key equality, duplicate rejection ដោយរក្សាទិន្នន័យចាស់, missing lookup, failed reservation,
shallow snapshot, safe removal, sorted ties, FIFO/LIFO/priority, backed views និង null restrictions។
Concurrency check រង់ចាំ workers 4 × 1000 increments រួចពិនិត្យ ConcurrentHashMap.merge = 4000។
វាមិនមែនជា performance benchmark ហើយមិនបញ្ជាក់ថា inventory workflow ទាំងមូល thread-safe ទេ។

Demo សម្រាប់រៀនក្នុង Memory: មិនមាន DB persistence, unique constraint ពិត, payment,
durable message queue, crash recovery ឬ transaction។ List/Map snapshots ការពារតែ structure
មិនមែន deep immutability។ ConcurrentHashMap មិនធ្វើឱ្យ Product.reserve thread-safe។
ក្នុងប្រព័ន្ធពិតត្រូវរចនា transaction/concurrency ដោយឡែកនៅមេរៀនបន្ទាប់។

បន្ទាប់៖ equals/hashCode លម្អិត រួច Immutability តាមផែនការ។
