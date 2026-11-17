package com.datajpa.learning.fundamentals.polymorphism;

// ប្រភេទរួមសម្រាប់យានយន្តក្នុងមេរៀន Polymorphism។
public class Vehicle {
    private final String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String makeSound() {
        return "Generic vehicle sound";
    }
}
