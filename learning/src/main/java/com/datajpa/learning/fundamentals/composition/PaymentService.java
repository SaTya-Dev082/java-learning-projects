package com.datajpa.learning.fundamentals.composition;

public interface PaymentService {
    // true = approved, false = declined; amount ជា USD cents។
    boolean pay(String orderId, long amountCents);
}
