package com.datajpa.learning.fundamentals.polymorphism;

public class PolymorphismChecks {
    public static void main(String[] args) {
        Vehicle reference = new Car("Corolla");
        expect("Car horn: Beep beep!", reference.makeSound());
        expect("Corolla", reference.getModel());

        reference = new Motorcycle("Wave");
        expect("Motorcycle horn: Peep peep!", reference.makeSound());

        Vehicle[] fleet = {new Vehicle("Base"), new Car("Car"), new Motorcycle("Bike")};
        String[] sounds = {"Generic vehicle sound", "Car horn: Beep beep!", "Motorcycle horn: Peep peep!"};
        for (int i = 0; i < fleet.length; i++) {
            expect(sounds[i], fleet[i].makeSound());
        }
        System.out.println("PASS: runtime dispatch through parent references and a mixed fleet.");
    }

    private static void expect(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Expected: " + expected + "; actual: " + actual);
        }
    }
}
