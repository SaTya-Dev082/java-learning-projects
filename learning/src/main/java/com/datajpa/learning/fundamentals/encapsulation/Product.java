package com.datajpa.learning.fundamentals.encapsulation;

/** Plain Java example: stock belongs to the product and changes through its rules. */
public class Product {
    private final String name;
    // private: កូដខាងក្រៅមិនអាចកែស្តុកដោយផ្ទាល់។
    private int stockQuantity;

    public Product(String name, int initialStock) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name must not be blank.");
        }
        if (initialStock < 0) {
            throw new IllegalArgumentException("Initial stock must not be negative.");
        }
        this.name = name;
        this.stockQuantity = initialStock;
    }

    public String getName() {
        return name;
    }

    // Getter អនុញ្ញាតឱ្យមើលស្តុក។ គ្មាន setStockQuantity ដែលរំលងច្បាប់។
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void addStock(int quantity) {
        requirePositive(quantity);
        if (quantity > Integer.MAX_VALUE - stockQuantity) {
            throw new IllegalArgumentException("Stock exceeds the supported limit.");
        }
        stockQuantity += quantity;
    }

    public void reduceStock(int quantity) {
        requirePositive(quantity);
        if (quantity > stockQuantity) {
            throw new IllegalArgumentException("Not enough stock.");
        }
        stockQuantity -= quantity;
    }

    private void requirePositive(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
    }
}
