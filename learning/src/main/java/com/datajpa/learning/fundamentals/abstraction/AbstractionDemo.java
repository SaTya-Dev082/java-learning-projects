package com.datajpa.learning.fundamentals.abstraction;

public class AbstractionDemo {
    public static void main(String[] args) {
        // new ShippingService(...) មិនបាន ព្រោះ Class ជា abstract។
        ShippingService standard = new StandardShipping();
        ShippingService express = new ExpressShipping();

        System.out.println("=== Checkout: parcel weight 1500 grams ===");
        showShippingOption(standard, 1500);
        showShippingOption(express, 1500);

        System.out.println("\n=== Shared validation ===");
        try {
            showShippingOption(express, 0);
        } catch (IllegalArgumentException exception) {
            System.out.println("Quote rejected: " + exception.getMessage());
        }
    }

    // Checkout ប្រើតែ abstraction; មិនមានរូបមន្ត ឬ if តាមប្រភេទដឹកជញ្ជូន។
    public static void showShippingOption(ShippingService shipping, int weightGrams) {
        long cents = shipping.quoteCents(weightGrams);
        System.out.printf("%s: USD %d.%02d%n", shipping.getServiceName(), cents / 100, cents % 100);
    }
}
