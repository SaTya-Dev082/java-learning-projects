package com.datajpa.learning.fundamentals.composition;

import java.util.Objects;

public class OrderService {
    // has-a: OrderService មាន reference ទៅអ្នកជួយធ្វើការទូទាត់។
    private final PaymentService paymentService;

    // ផ្ដល់ dependency ពីខាងក្រៅ; មិន extend PaymentService។
    public OrderService(PaymentService paymentService) {
        this.paymentService = Objects.requireNonNull(paymentService);
    }

    public boolean placeOrder(String orderId, long totalCents) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Order ID must not be blank.");
        }
        if (totalCents <= 0) {
            throw new IllegalArgumentException("Order total must be greater than zero.");
        }

        System.out.println("Preparing order: " + orderId);
        // Delegation: ប្រគល់ការងារទូទាត់ទៅ PaymentService។
        boolean paid = paymentService.pay(orderId, totalCents);
        if (!paid) {
            System.out.println("Order not confirmed: payment declined.");
            return false;
        }

        System.out.println("Order confirmed: " + orderId);
        return true;
    }
}
