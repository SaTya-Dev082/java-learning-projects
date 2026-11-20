package com.datajpa.learning.advanced.collections;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** In-memory, single-threaded catalog; not a database or concurrent inventory system. */
public final class Catalog {
    private final Map<ProductKey, Product> products = new LinkedHashMap<>();

    public void add(Product product) {
        Objects.requireNonNull(product);
        // Reject duplicates instead of silently replacing an existing product.
        Product existing = products.putIfAbsent(product.getKey(), product);
        if (existing != null) {
            throw new IllegalArgumentException("Duplicate product code: " + product.getKey());
        }
    }

    public Product find(ProductKey key) {
        Product product = products.get(Objects.requireNonNull(key));
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + key);
        }
        return product;
    }

    public List<Product> list() {
        // Unmodifiable structural snapshot; Product objects are still shared (shallow copy).
        return List.copyOf(products.values());
    }
}
