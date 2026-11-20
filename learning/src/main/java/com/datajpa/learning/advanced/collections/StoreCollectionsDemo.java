package com.datajpa.learning.advanced.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class StoreCollectionsDemo {
    public static void main(String[] args) {
        System.out.println("\n=== 12. Store workflow: catalog / cart / unique codes / work queue ===");
        Catalog catalog = new Catalog();
        catalog.add(new Product(new ProductKey("P001"), "Coffee", 300, 10));
        catalog.add(new Product(new ProductKey("P002"), "Tea", 200, 5));
        catalog.add(new Product(new ProductKey("P003"), "Sold out", 100, 0));
        try {
            catalog.add(new Product(new ProductKey("P001"), "Duplicate", 999, 1));
        } catch (IllegalArgumentException expected) {
            System.out.println("Duplicate rejected: " + expected.getMessage());
        }
        // List preserves repeated selections; one duplicate is not automatically a mistake.
        List<String> cartCodes = List.of("P001", "P002", "P001");
        Set<String> uniqueForDisplay = new LinkedHashSet<>(cartCodes);
        System.out.println("Cart selections: " + cartCodes + "; distinct display codes: " + uniqueForDisplay);

        List<Product> available = new ArrayList<>(catalog.list());
        available.removeIf(product -> product.getStock() == 0);
        available.sort(Comparator.comparingLong(Product::getPriceCents).thenComparing(Product::getKey));
        System.out.println("Available products sorted by price: " + available);

        Product coffee = catalog.find(new ProductKey("P001")); // equals/hashCode make fresh key work.
        coffee.reserve(2);
        Queue<String> tasks = new ArrayDeque<>();
        tasks.offer("Pack 2 Coffee"); // Queue only after successful reservation.
        System.out.println("Stock after reservation: " + coffee.getStock());
        System.out.println("Next task: " + tasks.poll());
        System.out.println("No more tasks: " + tasks.poll());
    }
}
