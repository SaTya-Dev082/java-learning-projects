package com.datajpa.learning.fundamentals.polymorphism;

public class Motorcycle extends Vehicle {
    public Motorcycle(String model) {
        super(model);
    }

    @Override
    public String makeSound() {
        return "Motorcycle horn: Peep peep!";
    }
}
