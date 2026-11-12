package com.datajpa.learning.fundamentals.classobject;

// Class: គំរូសម្រាប់បង្កើត Student objects។
public class Student {

    // Fields: រក្សាទុក State របស់ Student object នីមួយៗ។
    private String name;
    private int age;
    private int score;

    // Constructor: កំណត់ State ដំបូងនៅពេលបង្កើត Object។
    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // Behavior: ប្ដូរឈ្មោះរបស់ Object នេះ។
    public void changeName(String newName) {
        this.name = newName;
    }

    // Behavior: ប្ដូរពិន្ទុរបស់ Object នេះ។
    public void changeScore(int newScore) {
        this.score = newScore;
    }

    // Behavior: បង្ហាញ State បច្ចុប្បន្ន។
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Score: " + score);
    }
}
