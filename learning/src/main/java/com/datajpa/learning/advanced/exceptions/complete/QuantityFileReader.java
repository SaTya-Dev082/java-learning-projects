package com.datajpa.learning.advanced.exceptions.complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class QuantityFileReader {
    // Checked Exception: caller ត្រូវ catch IOException ឬប្រកាស throws បន្ត។
    public int readQuantity(Path file) throws IOException {
        // Reader ត្រូវបានបិទស្វ័យប្រវត្តិ ទោះ read/parse បរាជ័យ។
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line = reader.readLine();
            if (line == null || line.isBlank()) {
                throw new IllegalArgumentException("Quantity file must not be empty.");
            }
            // NumberFormatException ជា unchecked; មិនចាំបាច់ប្រកាស throws។
            int quantity = Integer.parseInt(line.trim());
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than zero.");
            }
            if (reader.readLine() != null) {
                throw new IllegalArgumentException("Expected exactly one quantity line.");
            }
            return quantity;
        }
    }
}
