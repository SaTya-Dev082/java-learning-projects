package com.datajpa.learning.advanced.generics;

public class Product {
    private final String name;
    private final int stockQuantity;

    public Product(String name, int stockQuantity) {
        if (!new ProductNameValidator().isValid(name)) {
            throw new IllegalArgumentException("Product name must not be blank.");
        }
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Stock must not be negative.");
        }
        this.name = name;
        this.stockQuantity = stockQuantity;
    }

    public String getName() {
        return name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public String toString() {
        return name + " (stock=" + stockQuantity + ")";
    }
}
