package com.datajpa.learning.fundamentals.abstraction;

public class ExpressShipping extends ShippingService {
    public ExpressShipping() {
        super("Express shipping");
    }

    @Override
    protected long calculateFeeCents(int weightGrams) {
        // តម្លៃសន្មតសម្រាប់មេរៀន: $5 + $2 ក្នុងមួយគីឡូក្រាមដែលគិតថ្លៃ។
        return 500L + 200L * billableKilograms(weightGrams);
    }
}
