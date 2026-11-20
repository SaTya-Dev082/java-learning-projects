package com.datajpa.learning.advanced.collections;

import java.util.Objects;

/** Stable key: equality, hashing and natural ordering all use code. */
public final class ProductKey implements Comparable<ProductKey> {
    private final String code;

    public ProductKey(String code) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Product code must not be blank.");
        }
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object other) {
        return this == other || other instanceof ProductKey key && code.equals(key.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public int compareTo(ProductKey other) {
        return code.compareTo(other.code);
    }

    @Override
    public String toString() {
        return code;
    }
}
