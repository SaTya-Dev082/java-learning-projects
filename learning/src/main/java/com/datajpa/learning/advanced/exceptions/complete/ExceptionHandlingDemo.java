package com.datajpa.learning.advanced.exceptions.complete;

import com.datajpa.learning.advanced.exceptions.propagation.ExceptionPropagationDemo;
import com.datajpa.learning.advanced.exceptions.propagation.InsufficientStockException;
import com.datajpa.learning.advanced.exceptions.propagation.OrderService;
import com.datajpa.learning.advanced.exceptions.propagation.Product;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExceptionHandlingDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("=== 1. throw / custom unchecked / propagation / specific catches ===");
        ExceptionPropagationDemo.main(args);

        // Files ជា fixtures បណ្ដោះអាសន្នសម្រាប់ Demo; មិនកែឯកសាររបស់អ្នក។
        Path folder = Files.createTempDirectory("java-exceptions-lesson-");
        Path valid = folder.resolve("valid.txt");
        Path invalid = folder.resolve("invalid.txt");
        try {
            Files.writeString(valid, "3\n", StandardCharsets.UTF_8);
            Files.writeString(invalid, "abc\n", StandardCharsets.UTF_8);
            demonstrateCheckedException(folder.resolve("missing.txt"));

            Product product = new Product(10);
            OrderImportService imports = new OrderImportService(new QuantityFileReader(), new OrderService(product));
            demonstrateImport(imports, valid);
            demonstrateImport(imports, invalid);
            demonstrateImport(imports, folder.resolve("missing.txt"));
            System.out.println("Stock after imports: " + product.getStockQuantity());
        } finally {
            // finally សម្រាប់ cleanup រួម; file Reader ប្រើ try-with-resources ខាងក្នុង។
            Files.deleteIfExists(valid);
            Files.deleteIfExists(invalid);
            Files.deleteIfExists(folder);
            System.out.println("Temporary fixtures removed.");
        }
        demonstrateResourceOrder();
        demonstrateSuppressedExceptions();
        System.out.println("\nDemo continues after handled failures.");
    }

    private static void demonstrateCheckedException(Path missing) {
        System.out.println("\n=== 2. Checked IOException: throws -> catch ===");
        try {
            new QuantityFileReader().readQuantity(missing);
        } catch (IOException exception) {
            System.out.println("Caught checked exception: " + exception.getClass().getSimpleName());
        }
    }

    private static void demonstrateImport(OrderImportService imports, Path file) {
        System.out.println("\n=== 3. Import " + file.getFileName() + " ===");
        try {
            imports.importOrder(file);
            System.out.println("Import SUCCESS");
        } catch (InsufficientStockException exception) {
            System.out.println("Import REJECTED: " + exception.getMessage());
        } catch (IllegalArgumentException exception) {
            // NumberFormatException ក៏ត្រូវបានចាប់ ព្រោះវាជាកូន IllegalArgumentException។
            System.out.println("Invalid file content: " + exception.getMessage());
        } catch (OrderImportException exception) {
            System.out.println("Import unavailable: " + exception.getMessage());
            System.out.println("Original cause: " + exception.getCause().getClass().getSimpleName());
            // សម្រាប់មេរៀន: បង្ហាញ stack trace និង Caused by។ Production ប្រើ logger។
            exception.printStackTrace(System.out);
        } finally {
            System.out.println("finally: import attempt finished (not a success indicator).");
        }
        System.out.println("After try/catch/finally");
    }

    private static void demonstrateResourceOrder() throws IOException {
        System.out.println("\n=== 4. AutoCloseable: reverse close order ===");
        List<String> events = new ArrayList<>();
        try (ResourceProbe first = new ResourceProbe("first", events, false);
             ResourceProbe second = new ResourceProbe("second", events, false)) {
            first.use();
            second.use();
        }
        System.out.println(events);
    }

    private static void demonstrateSuppressedExceptions() {
        System.out.println("\n=== 5. Body failure + close failures ===");
        List<String> events = new ArrayList<>();
        try (ResourceProbe first = new ResourceProbe("first", events, true);
             ResourceProbe second = new ResourceProbe("second", events, true)) {
            first.use();
            second.use();
            throw new IOException("Read failed (primary)");
        } catch (IOException exception) {
            System.out.println("Primary: " + exception.getMessage());
            for (Throwable suppressed : exception.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
        System.out.println(events);
    }
}
