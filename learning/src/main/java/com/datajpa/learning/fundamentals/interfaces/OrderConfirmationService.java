package com.datajpa.learning.fundamentals.interfaces;

import java.util.Objects;

/** Use after an order has been saved successfully. This class only notifies. */
public class OrderConfirmationService {
    // ពឹងលើកិច្ចសន្យា មិនពឹងលើ EmailNotification ឬ SmsNotification។
    private final NotificationService notificationService;

    public OrderConfirmationService(NotificationService notificationService) {
        this.notificationService = Objects.requireNonNull(notificationService);
    }

    public void sendConfirmation(String orderId, String recipient) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Order ID must not be blank.");
        }
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Recipient must not be blank.");
        }
        notificationService.send(recipient, "Your order " + orderId + " is confirmed.");
    }
}
