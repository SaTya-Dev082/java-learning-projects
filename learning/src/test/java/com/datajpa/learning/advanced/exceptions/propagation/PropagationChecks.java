package com.datajpa.learning.advanced.exceptions.propagation;

public class PropagationChecks {
    public static void main(String[] args) {
        Product product = new Product(10);
        OrderService orders = new OrderService(product);
        boolean reachedSuccess = false;
        try {
            orders.placeOrder(20);
            reachedSuccess = true;
        } catch (InsufficientStockException exception) {
            if (exception.getRequested() != 20 || exception.getAvailable() != 10) {
                throw new AssertionError("Exception must preserve requested and available quantities.");
            }
        }
        if (reachedSuccess || product.getStockQuantity() != 10) {
            throw new AssertionError("Rejected order must skip success and preserve stock.");
        }
        orders.placeOrder(3);
        if (product.getStockQuantity() != 7) {
            throw new AssertionError("A later valid request must still succeed.");
        }
        for (int invalid : new int[] {0, -5}) {
            try {
                orders.placeOrder(invalid);
                throw new AssertionError("Expected IllegalArgumentException.");
            } catch (IllegalArgumentException expected) {
                if (product.getStockQuantity() != 7) {
                    throw new AssertionError("Invalid input must preserve stock.");
                }
            }
        }
        orders.placeOrder(7);
        if (product.getStockQuantity() != 0) {
            throw new AssertionError("Buying all remaining stock must be allowed.");
        }
        System.out.println("PASS: propagation, skipped success, unchanged stock, and later requests.");
    }
}
