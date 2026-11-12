package com.datajpa.learning.fundamentals.classobject;

public class ClassObjectDemo {

    public static void main(String[] args) {
        // new បង្កើត Object។ dara និង sophea ជា variables ដែលយោងទៅ Objects។
        Student dara = new Student("Dara", 20, 90);
        Student sophea = new Student("Sophea", 21, 85);

        System.out.println("\n=== Initial state ===");
        dara.displayInfo();
        sophea.displayInfo();

        // ហៅ Methods ដើម្បីប្ដូរ State របស់ Object ទី១។
        dara.changeName("Visal");
        dara.changeScore(95);

        System.out.println("\n=== After changing Dara's object ===");
        dara.displayInfo();
        // State របស់ Object ទី២ មិនបានផ្លាស់ប្ដូរទេ។
        sophea.displayInfo();

        // Object ថ្មីមាន State ដូច Object ទី១ ប៉ុន្តែជា Object ផ្សេង។
        Student anotherStudent = new Student("Visal", 20, 95);
        System.out.println("\n=== Same state, different identity ===");
        dara.displayInfo();
        anotherStudent.displayInfo();
        // == សម្រាប់ references ពិនិត្យថាយោងទៅ Object តែមួយឬអត់។
        System.out.println("Same object? " + (dara == anotherStudent));
    }
}
