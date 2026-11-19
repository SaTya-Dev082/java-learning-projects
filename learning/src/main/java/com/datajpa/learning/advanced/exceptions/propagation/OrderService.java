package com.datajpa.learning.advanced.exceptions.propagation;

import java.util.Objects;

public class OrderService {
    private final Product product;

    public OrderService(Product product) {
        this.product = Objects.requireNonNull(product);
    }

    public void placeOrder(int quantity) {
        System.out.println("OrderService: requesting stock");
        // គ្មាន catch: Exception បន្តទៅអ្នកហៅ placeOrder()។
        product.reduceStock(quantity);
        // មិនដំណើរការបើ reduceStock() បោះ Exception។
        System.out.println("OrderService: order confirmed");
    }
}
