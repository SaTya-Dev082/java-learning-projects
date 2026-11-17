package com.datajpa.learning.fundamentals.composition;

/** Local simulation only: no bank calls or real money transfers. */
public class SimulatedPaymentService implements PaymentService {
    private final boolean approve;

    public SimulatedPaymentService(boolean approve) {
        this.approve = approve;
    }

    @Override
    public boolean pay(String orderId, long amountCents) {
        System.out.println("[PAYMENT DEMO] " + orderId + ": " + amountCents
                + " cents -> " + (approve ? "APPROVED" : "DECLINED"));
        return approve;
    }
}
