package com.datajpa.learning.advanced.collections;

import java.util.Objects;

public final class Product {
    private final ProductKey key;
    private final String name;
    private final long priceCents;
    private int stock;

    public Product(ProductKey key, String name, long priceCents, int stock) {
        this.key = Objects.requireNonNull(key);
        if (name == null || name.isBlank() || priceCents < 0 || stock < 0) {
            throw new IllegalArgumentException("Invalid product name, price or stock.");
        }
        this.name = name;
        this.priceCents = priceCents;
        this.stock = stock;
    }

    public ProductKey getKey() { return key; }
    public String getName() { return name; }
    public long getPriceCents() { return priceCents; }
    public int getStock() { return stock; }

    public void reserve(int quantity) {
        if (quantity <= 0 || quantity > stock) {
            throw new IllegalArgumentException("Reservation requires positive quantity and enough stock.");
        }
        stock -= quantity;
    }

    @Override
    public String toString() {
        return key + ":" + name + "(cents=" + priceCents + ", stock=" + stock + ")";
    }
}
