package com.datajpa.learning.advanced.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CollectionsChecks {
    public static void main(String[] args) throws Exception {
        List<Integer> quantities = new ArrayList<>(List.of(10, 20, 30));
        quantities.remove(1);
        quantities.remove(Integer.valueOf(10));
        check(quantities.equals(List.of(30)), "remove index vs value.");
        check(new ArrayList<>(100).isEmpty(), "Initial capacity is not size.");
        check(new ArrayList<>(new LinkedHashSet<>(List.of("C", "A", "C", "B")))
                .equals(List.of("C", "A", "B")), "Dedup must preserve first occurrence.");
        check(new ArrayList<>(new TreeSet<>(List.of(30, 10, 20, 10))).equals(List.of(10, 20, 30)), "Sorted set.");
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        check(map.put("A", 30) == 10 && map.get("A") == 30 && map.size() == 2, "put returns old value.");
        check(new ArrayList<>(map.keySet()).equals(List.of("A", "B")), "Update preserves insertion order.");
        map.put("NULL", null);
        check(map.getOrDefault("NULL", 99) == null && map.getOrDefault("MISSING", 99) == 99, "Null vs absent.");
        map.keySet().remove("B");
        check(!map.containsKey("B"), "Map keySet is a live view.");

        ProductKey firstKey = new ProductKey("A");
        ProductKey sameKey = new ProductKey("A");
        check(firstKey.equals(sameKey) && firstKey.hashCode() == sameKey.hashCode()
                && firstKey.compareTo(sameKey) == 0, "Equality, hashing and natural order agree.");
        check(new HashSet<>(List.of(firstKey, sameKey)).size() == 1, "Distinct objects with equal code deduplicate.");
        Catalog catalog = new Catalog();
        Product coffee = new Product(firstKey, "Coffee", 300, 10);
        catalog.add(coffee);
        rejects(IllegalArgumentException.class, () -> catalog.add(new Product(sameKey, "Duplicate", 1, 1)));
        check(catalog.find(sameKey) == coffee, "Duplicate must not replace original product.");
        rejects(IllegalArgumentException.class, () -> catalog.find(new ProductKey("MISSING")));
        rejects(IllegalArgumentException.class, () -> coffee.reserve(11));
        check(coffee.getStock() == 10, "Rejected reservation preserves stock.");
        List<Product> snapshot = catalog.list();
        rejects(UnsupportedOperationException.class, () -> snapshot.add(coffee));
        catalog.add(new Product(new ProductKey("B"), "Tea", 300, 0));
        check(snapshot.size() == 1, "Structural snapshot must not grow with catalog.");
        coffee.reserve(2);
        check(snapshot.get(0).getStock() == 8, "Shallow snapshot shares product references.");
        List<Product> visible = new ArrayList<>(catalog.list());
        visible.removeIf(product -> product.getStock() == 0);
        check(visible.equals(List.of(coffee)) && catalog.list().size() == 2, "Filtering copy must preserve catalog entries.");

        List<Product> equalPrices = new ArrayList<>(catalog.list());
        equalPrices.sort(Comparator.comparingLong(Product::getPriceCents).thenComparing(Product::getKey));
        check(equalPrices.get(0).getKey().equals(firstKey), "Tie-breaking by code.");
        TreeSet<Product> priceOnly = new TreeSet<>(Comparator.comparingLong(Product::getPriceCents));
        priceOnly.addAll(equalPrices);
        check(priceOnly.size() == 1, "TreeSet duplicate identity follows comparator, not object identity.");

        Queue<String> fifo = new ArrayDeque<>();
        fifo.offer("first"); fifo.offer("second");
        check(fifo.peek().equals("first") && fifo.size() == 2, "peek must not remove.");
        check(fifo.poll().equals("first") && fifo.poll().equals("second") && fifo.poll() == null, "FIFO/empty poll.");
        Deque<String> stack = new ArrayDeque<>();
        stack.push("first"); stack.push("second");
        check(stack.pop().equals("second"), "LIFO.");
        rejects(NullPointerException.class, () -> fifo.offer(null));
        Queue<ShippingTask> priority = new PriorityQueue<>();
        priority.add(new ShippingTask("normal", 2, 1));
        priority.add(new ShippingTask("urgent-first", 1, 2));
        priority.add(new ShippingTask("urgent-second", 1, 3));
        check(priority.remove().getOrderId().equals("urgent-first")
                && priority.remove().getOrderId().equals("urgent-second")
                && priority.remove().getOrderId().equals("normal"), "Priority and tie order.");

        List<Integer> editable = new ArrayList<>(List.of(1, 2, 3));
        Iterator<Integer> iterator = editable.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 2) iterator.remove();
        }
        check(editable.equals(List.of(1, 3)), "Iterator removal.");
        List<Integer> copy = new ArrayList<>(editable);
        List<Integer> view = Collections.unmodifiableList(editable);
        List<Integer> frozen = List.copyOf(editable);
        editable.set(0, 99);
        check(copy.get(0) == 1 && frozen.get(0) == 1 && view.get(0) == 99, "Copy vs backed view.");
        editable.subList(0, 1).set(0, 88);
        check(editable.get(0) == 88, "subList shares backing storage.");
        String[] array = {"A"};
        List<String> fixed = Arrays.asList(array);
        fixed.set(0, "B");
        check(array[0].equals("B"), "Arrays.asList is backed by array.");
        rejects(UnsupportedOperationException.class, () -> fixed.add("C"));
        rejects(NullPointerException.class, () -> List.copyOf(Arrays.asList("A", null)));

        // Deterministic result after all workers finish: atomic merge avoids lost increments.
        ConcurrentHashMap<String, Integer> counts = new ConcurrentHashMap<>();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        try {
            List<Future<?>> futures = new ArrayList<>();
            for (int worker = 0; worker < 4; worker++) {
                futures.add(pool.submit(() -> {
                    for (int i = 0; i < 1000; i++) counts.merge("A", 1, Integer::sum);
                }));
            }
            for (Future<?> future : futures) future.get();
        } finally {
            pool.shutdown();
        }
        check(counts.get("A") == 4000, "Concurrent merge must not lose increments.");
        System.out.println("PASS: list/set/map contracts, catalog integrity, queues, equality, views/copies and atomic merge.");
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static void rejects(Class<? extends RuntimeException> type, Runnable action) {
        try {
            action.run();
        } catch (RuntimeException actual) {
            if (type.isInstance(actual)) return;
            throw actual;
        }
        throw new AssertionError("Expected " + type.getSimpleName());
    }
}
