package com.datajpa.learning.fundamentals.inheritance;

// Motorcycle និង Car ជា subclasses ផ្សេងគ្នារបស់ Vehicle។
public class Motorcycle extends Vehicle {
    public Motorcycle(String brand, String model) {
        super(brand, model);
    }

    public void lowerKickstand() {
        System.out.println(getBrand() + " " + getModel() + " kickstand is down.");
    }
}
