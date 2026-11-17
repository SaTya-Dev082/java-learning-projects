package com.datajpa.learning.fundamentals.interfaces;

public class NotificationChecks {
    public static void main(String[] args) {
        RecordingNotification fake = new RecordingNotification();
        OrderConfirmationService orders = new OrderConfirmationService(fake);
        orders.sendConfirmation("ORD-123", "customer@example.com");
        if (fake.calls != 1 || !"customer@example.com".equals(fake.recipient)
                || !"Your order ORD-123 is confirmed.".equals(fake.message)) {
            throw new AssertionError("Confirmation must be delivered once with correct content.");
        }
        for (String invalid : new String[] {null, "", " "}) {
            rejects(() -> orders.sendConfirmation(invalid, "customer@example.com"));
            rejects(() -> orders.sendConfirmation("ORD-123", invalid));
        }
        if (fake.calls != 1) {
            throw new AssertionError("Invalid requests must not trigger a notification.");
        }
        System.out.println("PASS: contract substitution, confirmation content, and validation before send.");
    }

    private static void rejects(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException expected) {
            return;
        }
        throw new AssertionError("Expected invalid request to be rejected.");
    }

    // Test implementation: បង្ហាញថា consumer អាចប្រើ implementation ទី៣បាន។
    private static class RecordingNotification implements NotificationService {
        private int calls;
        private String recipient;
        private String message;

        @Override
        public void send(String recipient, String message) {
            calls++;
            this.recipient = recipient;
            this.message = message;
        }
    }
}
