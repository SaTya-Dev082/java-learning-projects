package com.datajpa.learning.fundamentals.composition;

public class CompositionChecks {
    public static void main(String[] args) {
        RecordingPayment payment = new RecordingPayment();
        OrderService orders = new OrderService(payment);
        if (!orders.placeOrder("ORD-TEST", 2500) || payment.calls != 1
                || !"ORD-TEST".equals(payment.orderId) || payment.amountCents != 2500) {
            throw new AssertionError("Order must delegate the correct payment once.");
        }
        payment.approve = false;
        if (orders.placeOrder("ORD-DECLINED", 1000) || payment.calls != 2) {
            throw new AssertionError("Declined payment must not confirm the order.");
        }
        for (String invalid : new String[] {null, "", " "}) {
            rejects(() -> orders.placeOrder(invalid, 100));
        }
        for (long invalid : new long[] {0, -1, Long.MIN_VALUE}) {
            rejects(() -> orders.placeOrder("ORD-INVALID", invalid));
        }
        if (payment.calls != 2) {
            throw new AssertionError("Invalid orders must never request payment.");
        }
        System.out.println("PASS: delegation, approval/decline handling, and validation before payment.");
    }

    private static void rejects(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException expected) {
            return;
        }
        throw new AssertionError("Expected invalid order to be rejected.");
    }

    private static class RecordingPayment implements PaymentService {
        private boolean approve = true;
        private int calls;
        private String orderId;
        private long amountCents;

        @Override
        public boolean pay(String orderId, long amountCents) {
            calls++;
            this.orderId = orderId;
            this.amountCents = amountCents;
            return approve;
        }
    }
}
