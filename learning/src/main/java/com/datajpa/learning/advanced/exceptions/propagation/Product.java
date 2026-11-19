package com.datajpa.learning.advanced.exceptions.propagation;

public class Product {
    private int stockQuantity;

    public Product(int initialStock) {
        if (initialStock < 0) {
            throw new IllegalArgumentException("Initial stock must not be negative.");
        }
        stockQuantity = initialStock;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void reduceStock(int quantity) {
        System.out.println("Product: checking requested quantity " + quantity);
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (quantity > stockQuantity) {
            // throw ឈប់លំហូរធម្មតា; បន្ទាត់កាត់ស្តុកខាងក្រោមត្រូវរំលង។
            throw new InsufficientStockException(quantity, stockQuantity);
        }
        stockQuantity -= quantity;
        System.out.println("Product: stock reduced to " + stockQuantity);
    }
}
