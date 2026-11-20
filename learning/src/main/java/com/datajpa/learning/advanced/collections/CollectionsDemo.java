package com.datajpa.learning.advanced.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsDemo {
    public static void main(String[] args) {
        lists();
        sets();
        maps();
        queues();
        iteration();
        sortingAndEquality();
        copiesAndNulls();
        concurrencyBasics();
        StoreCollectionsDemo.main(args);
    }

    private static void lists() {
        System.out.println("\n=== 1-3. Array / ArrayList / LinkedList ===");
        String[] array = {"Coffee", "Tea"};
        System.out.println("Fixed array length: " + array.length);
        List<String> products = new ArrayList<>(100); // Capacity 100; size 0.
        System.out.println("Initial list size: " + products.size());
        products.add("Coffee");
        products.add("Tea");
        products.add(1, "Milk");
        products.set(0, "Water");
        products.remove("Milk");
        System.out.println(products + "; first=" + products.get(0)
                + "; contains Tea=" + products.contains("Tea"));
        List<Integer> quantities = new ArrayList<>(List.of(10, 20, 30));
        quantities.remove(1); // remove index 1 (value 20).
        quantities.remove(Integer.valueOf(10)); // remove VALUE 10.
        System.out.println("After both remove overloads: " + quantities);
        products.clear();
        System.out.println("After clear, empty=" + products.isEmpty());
        Deque<String> linked = new LinkedList<>();
        linked.addLast("Pack");
        linked.addFirst("Check payment");
        System.out.println("LinkedList first: " + linked.removeFirst() + "; last=" + linked.peekLast());
    }

    private static void sets() {
        System.out.println("\n=== 4. HashSet / LinkedHashSet / TreeSet ===");
        Set<String> hash = new HashSet<>();
        hash.add("C");
        hash.add("A");
        hash.add("B");
        System.out.println("Duplicate added? " + hash.add("A") + "; size=" + hash.size());
        System.out.println("HashSet (order not guaranteed): " + hash);
        Set<String> ordered = new LinkedHashSet<>(List.of("C", "A", "B", "A"));
        System.out.println("Insertion order: " + ordered);
        System.out.println("Sorted: " + new TreeSet<>(ordered));
        NavigableSet<Integer> values = new TreeSet<>(List.of(10, 20, 30));
        System.out.println("first=" + values.first() + ", last=" + values.last()
                + ", lower20=" + values.lower(20) + ", floor20=" + values.floor(20)
                + ", ceiling25=" + values.ceiling(25) + ", higher20=" + values.higher(20));
    }

    private static void maps() {
        System.out.println("\n=== 5. Map variants / old value / null / views ===");
        Map<String, Integer> stocks = new HashMap<>();
        stocks.put("A", 10);
        stocks.put("B", 20);
        Integer previous = stocks.put("A", 30);
        System.out.println("put returns old=" + previous + "; new=" + stocks.get("A") + "; size=" + stocks.size());
        stocks.put("NULL_VALUE", null);
        System.out.println("getOrDefault existing-null=" + stocks.getOrDefault("NULL_VALUE", 0)
                + "; missing=" + stocks.getOrDefault("MISSING", 0));
        System.out.println("Has null mapping? " + stocks.containsKey("NULL_VALUE")
                + "; contains value20=" + stocks.containsValue(20));
        stocks.remove("NULL_VALUE");
        for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        Map<String, Integer> ordered = new LinkedHashMap<>();
        ordered.put("C", 30);
        ordered.put("A", 10);
        ordered.put("B", 20);
        ordered.put("A", 50); // Does not move A in insertion-order map.
        System.out.println("Insertion-order map: " + ordered);
        ordered.remove("A");
        ordered.put("A", 60);
        System.out.println("Remove/reinsert moves A: " + ordered);
        Map<String, Integer> access = new LinkedHashMap<>(16, 0.75f, true);
        access.put("A", 10);
        access.put("B", 20);
        access.put("C", 30);
        access.get("A");
        System.out.println("Access-order map (not automatic LRU eviction): " + access);
        NavigableMap<Integer, String> schedule = new TreeMap<>();
        schedule.put(300, "C");
        schedule.put(100, "A");
        schedule.put(200, "B");
        System.out.println("TreeMap: " + schedule + "; ceiling250=" + schedule.ceilingKey(250));
        stocks.putIfAbsent("A", 99); // Existing non-null A remains 30.
        stocks.computeIfAbsent("C", key -> 0);
        stocks.merge("C", 5, Integer::sum);
        System.out.println("putIfAbsent / computeIfAbsent / merge: " + stocks);
    }

    private static void queues() {
        System.out.println("\n=== 6. FIFO / stack / priority ===");
        Queue<String> orders = new ArrayDeque<>();
        orders.offer("ORD-001");
        orders.offer("ORD-002");
        System.out.println("peek=" + orders.peek() + "; poll=" + orders.poll() + "; remaining=" + orders);
        orders.clear();
        System.out.println("Empty poll=" + orders.poll() + "; peek=" + orders.peek());
        Deque<String> history = new ArrayDeque<>();
        history.push("Edit name");
        history.push("Edit price");
        System.out.println("Stack pop latest: " + history.pop());
        history.offerLast("Older task");
        System.out.println("Deque poll last: " + history.pollLast());
        Queue<ShippingTask> priority = new PriorityQueue<>();
        priority.offer(new ShippingTask("NORMAL", 2, 1));
        priority.offer(new ShippingTask("URGENT-1", 1, 2));
        priority.offer(new ShippingTask("URGENT-2", 1, 3));
        // Iteration/toString is NOT sorted; repeatedly poll to get priority order.
        while (!priority.isEmpty()) {
            System.out.println("Priority poll: " + priority.poll());
        }
    }

    private static void iteration() {
        System.out.println("\n=== 7. Safe iteration / Iterator / ListIterator / removeIf ===");
        List<String> codes = new ArrayList<>(List.of("A", "INVALID", "B"));
        for (String code : codes) {
            System.out.println("Read via for-each: " + code);
        }
        Iterator<String> iterator = codes.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("INVALID")) {
                iterator.remove(); // Remove using this iterator, not codes.remove().
            }
        }
        ListIterator<String> edits = codes.listIterator();
        while (edits.hasNext()) {
            if (edits.next().equals("A")) {
                edits.set("UPDATED-A");
                edits.add("AFTER-A");
            }
        }
        codes.removeIf(code -> code.startsWith("AFTER"));
        System.out.println("After safe edits: " + codes);
        Iterator<String> invalidated = codes.iterator();
        codes.add("C");
        try {
            invalidated.next(); // Deliberate fail-fast example, even with one thread.
        } catch (ConcurrentModificationException expected) {
            System.out.println("Expected ConcurrentModificationException after outside structural modification.");
        }
        // Do not depend on fail-fast detection as a correctness/thread-safety mechanism.
    }

    private static void sortingAndEquality() {
        System.out.println("\n=== 8-9. Comparable / Comparator / equals / hashCode ===");
        List<ProductKey> keys = new ArrayList<>(List.of(new ProductKey("B"), new ProductKey("A")));
        Collections.sort(keys); // Natural ordering via Comparable.
        System.out.println("Natural order: " + keys);
        List<Product> products = new ArrayList<>(List.of(
                new Product(new ProductKey("B"), "Tea", 300, 5),
                new Product(new ProductKey("A"), "Coffee", 300, 10)));
        Comparator<Product> byPriceThenCode = Comparator.comparingLong(Product::getPriceCents)
                .thenComparing(Product::getKey);
        products.sort(byPriceThenCode);
        System.out.println("Price then code: " + products);
        products.sort(byPriceThenCode.reversed());
        System.out.println("Reversed whole comparator: " + products);
        Set<ProductKey> unique = new HashSet<>();
        unique.add(new ProductKey("A"));
        unique.add(new ProductKey("A"));
        System.out.println("Different objects, same key -> size=" + unique.size());
        Set<Product> priceOnly = new TreeSet<>(Comparator.comparingLong(Product::getPriceCents));
        priceOnly.addAll(products);
        System.out.println("Price-only comparator treats equal prices as duplicates: size=" + priceOnly.size());
        // A sorted List preserves both. If a Set of identities is needed, use Set<ProductKey>.
    }

    private static void copiesAndNulls() {
        System.out.println("\n=== 10. Copies / views / null / shallow references ===");
        List<String> original = new ArrayList<>(List.of("A", "B", "C"));
        List<String> copy = new ArrayList<>(original);
        List<String> snapshot = List.copyOf(original);
        List<String> view = Collections.unmodifiableList(original);
        original.set(0, "CHANGED");
        System.out.println("copy=" + copy + "; snapshot=" + snapshot + "; live view=" + view);
        List<String> sub = original.subList(1, 3);
        sub.set(0, "UPDATED-B");
        System.out.println("subList updates backing list: " + original);
        String[] array = {"A", "B"};
        List<String> fixed = Arrays.asList(array);
        fixed.set(0, "UPDATED");
        System.out.println("Arrays.asList shares array: " + Arrays.toString(array));
        try {
            fixed.add("C");
        } catch (UnsupportedOperationException expected) {
            System.out.println("Fixed-size Arrays.asList cannot add/remove.");
        }
        Product product = new Product(new ProductKey("A"), "Coffee", 300, 10);
        List<Product> shallow = List.copyOf(List.of(product));
        product.reserve(1);
        System.out.println("Unmodifiable list still shares mutable Product: stock=" + shallow.get(0).getStock());
        List<String> nullable = new ArrayList<>();
        nullable.add(null);
        try {
            List.copyOf(nullable);
        } catch (NullPointerException expected) {
            System.out.println("List.copyOf rejects null elements.");
        }
        Map<String, Integer> backing = new HashMap<>(Map.of("A", 10));
        Set<String> liveKeys = backing.keySet();
        liveKeys.remove("A");
        System.out.println("Removing from keySet removes mapping: " + backing);
    }

    private static void concurrencyBasics() {
        System.out.println("\n=== 11. Thread-safety basics (not a full concurrency lesson) ===");
        Map<String, Integer> counts = new ConcurrentHashMap<>();
        counts.merge("P001", 1, Integer::sum);
        counts.merge("P001", 1, Integer::sum);
        System.out.println("Atomic per-key merge count: " + counts.get("P001"));
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        synchronizedList.add("A");
        // Individual methods synchronize; iteration still requires the wrapper's lock.
        synchronized (synchronizedList) {
            for (String value : synchronizedList) {
                System.out.println("Synchronized iteration: " + value);
            }
        }
    }
}
