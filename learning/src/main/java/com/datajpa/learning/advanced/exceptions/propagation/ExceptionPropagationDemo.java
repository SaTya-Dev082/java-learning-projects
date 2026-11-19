package com.datajpa.learning.advanced.exceptions.propagation;

public class ExceptionPropagationDemo {
    public static void main(String[] args) {
        Product product = new Product(10);
        OrderService orders = new OrderService(product);

        attemptOrder("Not enough stock", orders, product, 20);
        attemptOrder("Valid purchase", orders, product, 3);
        attemptOrder("Invalid quantity", orders, product, -5);
    }

    private static void attemptOrder(String label, OrderService orders, Product product, int quantity) {
        System.out.println("\n=== " + label + " ===");
        try {
            orders.placeOrder(quantity);
            // បង្ហាញតែពេល placeOrder() ត្រឡប់តាមធម្មតា។
            System.out.println("Caller: SUCCESS");
        } catch (InsufficientStockException exception) {
            System.out.println("Caller: REJECTED - requested " + exception.getRequested()
                    + ", available " + exception.getAvailable());
        } catch (IllegalArgumentException exception) {
            System.out.println("Caller: INVALID INPUT - " + exception.getMessage());
        }
        // បន្តក្រោយ try/catch ព្រោះ catches ខាងលើបញ្ចប់តាមធម្មតា។
        System.out.println("Caller: after try/catch; stock = " + product.getStockQuantity());
    }
}
