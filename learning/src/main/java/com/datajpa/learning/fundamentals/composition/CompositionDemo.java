package com.datajpa.learning.fundamentals.composition;

public class CompositionDemo {
    public static void main(String[] args) {
        System.out.println("=== Approved payment ===");
        PaymentService approvedPayment = new SimulatedPaymentService(true);
        OrderService orders = new OrderService(approvedPayment);
        orders.placeOrder("ORD-001", 2500); // USD 25.00

        System.out.println("\n=== Declined payment ===");
        PaymentService declinedPayment = new SimulatedPaymentService(false);
        OrderService declinedOrders = new OrderService(declinedPayment);
        declinedOrders.placeOrder("ORD-002", 1200);

        System.out.println("\n=== Invalid order: no payment requested ===");
        try {
            orders.placeOrder("ORD-003", 0);
        } catch (IllegalArgumentException exception) {
            System.out.println("Order rejected: " + exception.getMessage());
        }
    }
}
