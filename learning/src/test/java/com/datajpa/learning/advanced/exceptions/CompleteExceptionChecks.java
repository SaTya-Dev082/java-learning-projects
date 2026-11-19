package com.datajpa.learning.advanced.exceptions;

import com.datajpa.learning.advanced.exceptions.complete.*;
import com.datajpa.learning.advanced.exceptions.propagation.OrderService;
import com.datajpa.learning.advanced.exceptions.propagation.Product;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CompleteExceptionChecks {
    public static void main(String[] args) throws IOException {
        Path directory = Files.createTempDirectory("exception-checks-");
        Path input = directory.resolve("quantity.txt");
        Product product = new Product(10);
        QuantityFileReader reader = new QuantityFileReader();
        OrderImportService imports = new OrderImportService(reader, new OrderService(product));
        try {
            Files.writeString(input, "3\n");
            imports.importOrder(input);
            check(product.getStockQuantity() == 7, "Valid import must reduce stock.");
            for (String invalid : new String[] {"", "abc\n", "0\n", "-1\n", "3\n4\n"}) {
                Files.writeString(input, invalid);
                try {
                    imports.importOrder(input);
                    throw new AssertionError("Invalid input was accepted.");
                } catch (IllegalArgumentException expected) {
                    check(product.getStockQuantity() == 7, "Invalid file must not change stock.");
                }
            }
            try {
                imports.importOrder(directory.resolve("missing.txt"));
                throw new AssertionError("Missing file was accepted.");
            } catch (OrderImportException expected) {
                check(expected.getCause() instanceof IOException, "Wrapper must preserve I/O cause.");
                check(product.getStockQuantity() == 7, "I/O failure must not change stock.");
            }
        } finally {
            Files.deleteIfExists(input);
            Files.deleteIfExists(directory);
        }

        List<String> events = new ArrayList<>();
        boolean finallyRan = false;
        IOException primary = new IOException("body failure");
        try (ResourceProbe first = new ResourceProbe("first", events, true);
             ResourceProbe second = new ResourceProbe("second", events, true)) {
            first.use();
            second.use();
            throw primary;
        } catch (IOException actual) {
            check(actual == primary, "Body exception must remain primary.");
            check(actual.getSuppressed().length == 2, "Both close failures must be preserved.");
            check("Cannot close second".equals(actual.getSuppressed()[0].getMessage()), "Second closes first.");
            check("Cannot close first".equals(actual.getSuppressed()[1].getMessage()), "First closes last.");
        } finally {
            finallyRan = true;
        }
        check(finallyRan, "finally must execute for handled failure.");
        check(events.equals(List.of("open first", "open second", "use first", "use second", "close second", "close first")),
                "Resources must close in reverse order even after failures.");
        System.out.println("PASS: file import, invalid input, cause preservation, finally, close order, suppressed exceptions.");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
