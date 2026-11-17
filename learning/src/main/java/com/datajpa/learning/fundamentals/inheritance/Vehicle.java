package com.datajpa.learning.fundamentals.inheritance;

// Superclass: ទិន្នន័យ និងមុខងាររួមរបស់យានយន្តក្នុងឧទាហរណ៍នេះ។
public class Vehicle {
    private final String brand;
    private final String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void start() {
        System.out.println(brand + " " + model + " is starting.");
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model);
    }
}
