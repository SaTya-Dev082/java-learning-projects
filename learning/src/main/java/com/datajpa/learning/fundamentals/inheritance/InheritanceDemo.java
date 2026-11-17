package com.datajpa.learning.fundamentals.inheritance;

public class InheritanceDemo {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla");
        Motorcycle motorcycle = new Motorcycle("Honda", "Wave");

        System.out.println("=== Car ===");
        // Methods រួម៖ មិនចាំបាច់សរសេរឡើងវិញក្នុង Car។
        car.displayInfo();
        car.start();
        car.openTrunk();

        System.out.println("\n=== Motorcycle ===");
        motorcycle.displayInfo();
        motorcycle.start();
        motorcycle.lowerKickstand();

        // motorcycle.openTrunk(); // មិន compile: Motorcycle មិនទទួលមុខងារ Car។
        // car.brand = "Other"; // មិន compile: Field ក្នុង Vehicle ជា private។
    }
}
