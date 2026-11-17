package com.datajpa.learning.fundamentals.encapsulation;

/** Run directly with Java; no database or Spring context required. */
public class ProductStockChecks {
    public static void main(String[] args) {
        rejects(() -> new Product("Coffee", -1));
        rejects(() -> new Product(" ", 0));
        rejects(() -> new Product(null, 0));

        Product product = new Product("Coffee", 10);
        product.addStock(5);
        stockIs(product, 15);
        product.reduceStock(3);
        stockIs(product, 12);
        for (int invalid : new int[] {0, -1, Integer.MIN_VALUE}) {
            rejects(() -> product.addStock(invalid));
            rejects(() -> product.reduceStock(invalid));
            stockIs(product, 12);
        }
        rejects(() -> product.reduceStock(13));
        stockIs(product, 12);
        product.reduceStock(12);
        stockIs(product, 0);
        rejects(() -> product.reduceStock(1));
        stockIs(product, 0);

        Product full = new Product("Full", Integer.MAX_VALUE);
        rejects(() -> full.addStock(1));
        stockIs(full, Integer.MAX_VALUE);
        System.out.println("PASS: stock rules, boundaries, and unchanged state after rejection.");
    }

    private static void stockIs(Product product, int expected) {
        if (product.getStockQuantity() != expected) {
            throw new AssertionError("Expected stock " + expected);
        }
    }

    private static void rejects(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException expected) {
            return;
        }
        throw new AssertionError("Expected invalid operation to be rejected.");
    }
}
