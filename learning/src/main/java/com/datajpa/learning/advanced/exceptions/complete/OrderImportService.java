package com.datajpa.learning.advanced.exceptions.complete;

import com.datajpa.learning.advanced.exceptions.propagation.OrderService;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;

public class OrderImportService {
    private final QuantityFileReader reader;
    private final OrderService orders;

    public OrderImportService(QuantityFileReader reader, OrderService orders) {
        this.reader = Objects.requireNonNull(reader);
        this.orders = Objects.requireNonNull(orders);
    }

    public void importOrder(Path file) {
        final int quantity;
        try {
            quantity = reader.readQuantity(file);
        } catch (IOException exception) {
            // បន្ថែម business context ហើយរក្សា original cause សម្រាប់ diagnosis។
            throw new OrderImportException("Cannot read order quantity file: " + file.getFileName(), exception);
        }
        // គ្មាន catch ទូទៅ: invalid input និង stock errors បន្តទៅ boundary។
        orders.placeOrder(quantity);
    }
}
