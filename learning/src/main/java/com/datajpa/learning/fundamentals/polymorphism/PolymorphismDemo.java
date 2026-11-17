package com.datajpa.learning.fundamentals.polymorphism;

public class PolymorphismDemo {
    public static void main(String[] args) {
        // Upcasting: Vehicle reference យោងទៅ Car object ដោយស្វ័យប្រវត្តិ។
        Vehicle vehicle = new Car("Corolla");
        System.out.println("=== Parent reference, child object ===");
        System.out.println(vehicle.makeSound()); // Car.makeSound()

        // Variable ដដែលអាចយោងទៅ Object ប្រភេទកូនផ្សេង។
        vehicle = new Motorcycle("Wave");
        System.out.println(vehicle.makeSound()); // Motorcycle.makeSound()

        System.out.println("\n=== One operation, different objects ===");
        Vehicle[] fleet = {
            new Vehicle("General vehicle"),
            new Car("Corolla"),
            new Motorcycle("Wave")
        };
        for (Vehicle member : fleet) {
            announceArrival(member);
        }

        // Reference type កំណត់ថា compiler អនុញ្ញាតហៅ Method ណាខ្លះ។
        Vehicle carAsVehicle = new Car("Camry");
        // carAsVehicle.openTrunk(); // មិន compile: Vehicle គ្មាន openTrunk()។

        // ពេលត្រូវការមុខងាររបស់ Car ជាក់លាក់ ប្រើ type check មុន។
        if (carAsVehicle instanceof Car car) {
            car.openTrunk();
        }
        // ការហៅ makeSound() ខាងលើមិនត្រូវការ cast ឬ instanceof ទេ។
    }

    // អ្នកហៅអាចផ្ដល់ Vehicle ឬ subclass ណាមួយ។ គ្មាន if/switch តាមប្រភេទ។
    public static void announceArrival(Vehicle vehicle) {
        System.out.println(vehicle.getModel() + " -> " + vehicle.makeSound());
    }
}
