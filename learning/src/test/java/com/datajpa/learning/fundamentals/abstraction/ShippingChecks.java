package com.datajpa.learning.fundamentals.abstraction;

public class ShippingChecks {
    public static void main(String[] args) {
        ShippingService standard = new StandardShipping();
        ShippingService express = new ExpressShipping();
        expect(300, standard.quoteCents(1));
        expect(300, standard.quoteCents(1000));
        expect(400, standard.quoteCents(1001));
        expect(400, standard.quoteCents(1500));
        expect(700, express.quoteCents(1000));
        expect(900, express.quoteCents(1500));
        expect(214748600L, standard.quoteCents(Integer.MAX_VALUE));
        for (ShippingService service : new ShippingService[] {standard, express}) {
            for (int invalid : new int[] {0, -1, Integer.MIN_VALUE}) {
                try {
                    service.quoteCents(invalid);
                    throw new AssertionError("Expected invalid weight to be rejected.");
                } catch (IllegalArgumentException expected) {
                    // Both concrete services must follow the shared validation.
                }
            }
        }
        System.out.println("PASS: both pricing rules, kilogram boundaries, invalid and maximum weights.");
    }

    private static void expect(long expected, long actual) {
        if (expected != actual) {
            throw new AssertionError("Expected " + expected + ", got " + actual);
        }
    }
}
