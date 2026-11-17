package com.datajpa.learning.fundamentals.encapsulation;

public class EncapsulationDemo {
    public static void main(String[] args) {
        Product coffee = new Product("Coffee", 10);
        System.out.println("Initial stock: " + coffee.getStockQuantity());

        coffee.addStock(5);
        System.out.println("After receiving 5: " + coffee.getStockQuantity());

        coffee.reduceStock(3);
        System.out.println("After selling 3: " + coffee.getStockQuantity());

        // try/catch បង្ហាញមូលហេតុបដិសេធ ហើយអនុញ្ញាតឱ្យ Demo បន្តដំណើរការ។
        try {
            coffee.reduceStock(20);
        } catch (IllegalArgumentException exception) {
            System.out.println("Sale rejected: " + exception.getMessage());
        }

        try {
            coffee.addStock(-5);
        } catch (IllegalArgumentException exception) {
            System.out.println("Restock rejected: " + exception.getMessage());
        }

        System.out.println("Final stock (unchanged after rejection): " + coffee.getStockQuantity());
        // coffee.stockQuantity = -100; // មិនអាច compile ព្រោះ Field ជា private។
    }
}
