package com.datajpa.learning.fundamentals.abstraction;

/** Abstraction សម្រាប់ស្នើតម្លៃដឹកជញ្ជូនក្នុង checkout។ */
public abstract class ShippingService {
    private final String serviceName;

    // Constructor មេត្រូវបានហៅពេលបង្កើត Object កូន។
    protected ShippingService(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    // Public operation រួម: អ្នកហៅមិនត្រូវដឹងរូបមន្តរបស់ប្រភេទដឹកជញ្ជូន។
    // final ការពារមិនឱ្យកូន Override ហើយរំលងការពិនិត្យរួម។
    public final long quoteCents(int weightGrams) {
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero.");
        }
        long feeCents = calculateFeeCents(weightGrams);
        if (feeCents < 0) {
            throw new IllegalStateException("Shipping fee must not be negative.");
        }
        return feeCents;
    }

    // គ្មាន body: Concrete Class ត្រូវផ្ដល់រូបមន្តគណនា។
    protected abstract long calculateFeeCents(int weightGrams);

    // Concrete helper រួម: បង្គត់ទម្ងន់ឡើងជាគីឡូក្រាមពេញ។
    protected final long billableKilograms(int weightGrams) {
        return (weightGrams + 999L) / 1000;
    }
}
