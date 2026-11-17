package com.datajpa.learning.fundamentals.inheritance;

// Car is a Vehicle: extends កំណត់ទំនាក់ទំនង Inheritance។
public class Car extends Vehicle {
    public Car(String brand, String model) {
        // ហៅ Constructor មេ ដើម្បីកំណត់ State ដែល Vehicle គ្រប់គ្រង។
        super(brand, model);
    }

    // មុខងារជាក់លាក់របស់ Car ក្នុងគំរូនេះ។
    public void openTrunk() {
        // brand និង model ជា private: ចូលប្រើតាម getters ដែលបានទទួលមរតក។
        System.out.println(getBrand() + " " + getModel() + " trunk is open.");
    }
}
