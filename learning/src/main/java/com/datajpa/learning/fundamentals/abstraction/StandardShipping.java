package com.datajpa.learning.fundamentals.abstraction;

public class StandardShipping extends ShippingService {
    public StandardShipping() {
        super("Standard shipping");
    }

    @Override
    protected long calculateFeeCents(int weightGrams) {
        // តម្លៃសន្មតសម្រាប់មេរៀន: $2 + $1 ក្នុងមួយគីឡូក្រាមដែលគិតថ្លៃ។
        return 200L + 100L * billableKilograms(weightGrams);
    }
}
