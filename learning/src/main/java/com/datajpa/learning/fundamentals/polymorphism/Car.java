package com.datajpa.learning.fundamentals.polymorphism;

public class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }

    // @Override ឱ្យ compiler ពិនិត្យថាយើងពិតជា Override Method របស់មេ។
    @Override
    public String makeSound() {
        return "Car horn: Beep beep!";
    }

    public void openTrunk() {
        System.out.println(getModel() + " trunk is open.");
    }
}
