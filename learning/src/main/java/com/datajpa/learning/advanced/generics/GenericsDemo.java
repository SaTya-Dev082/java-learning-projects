package com.datajpa.learning.advanced.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. Type safety / generic class / diamond ===");
        Box<String> nameBox = new Box<>();
        nameBox.setValue("Dara");
        String name = nameBox.getValue();
        System.out.println(name);
        Box<Integer> stockBox = new Box<>();
        stockBox.setValue(-10); // Compile បាន; business validation មិនមែនការងារ Generics។
        System.out.println("Type-correct, but invalid stock: " + stockBox.getValue());

        System.out.println("\n=== 2. Generic interface / multiple type parameters ===");
        Validator<String> validator = new ProductNameValidator();
        System.out.println("Coffee valid: " + validator.isValid("Coffee"));
        System.out.println("Blank valid: " + validator.isValid(" "));
        Pair<String, Integer> stock = new Pair<>("Coffee", 10);
        System.out.println(stock.getKey() + ": " + stock.getValue());

        System.out.println("\n=== 3. Generic methods / inference / explicit argument ===");
        Integer quantity = GenericUtils.valueOrDefault(null, 0);
        System.out.println("Fallback quantity: " + quantity);
        System.out.println(GenericUtils.<String>valueOrDefault(null, "Unknown"));

        System.out.println("\n=== 4. Single / interface / multiple bounds ===");
        System.out.println(new NumericBox<>(2.5).asDouble());
        System.out.println("Comparable max: " + GenericUtils.max("Apple", "Coffee"));
        System.out.println("Number & Comparable max: " + GenericUtils.maxNumber(10, 20));

        System.out.println("\n=== 5-6. Invariance / wildcard / PECS ===");
        List<Integer> quantities = new ArrayList<>(List.of(10, 20));
        // List<Number> numbers = quantities; // Compile error: invariance។
        List<?> unknown = quantities;
        GenericUtils.printItems(unknown);
        GenericUtils.printNumbers(quantities); // ? extends Number accepts List<Integer>។
        List<Object> destination = new ArrayList<>();
        destination.add("Existing label");
        GenericUtils.addSampleQuantities(destination); // ? super Integer accepts List<Object>។
        List<Number> archive = new ArrayList<>();
        GenericUtils.copyItems(quantities, archive);
        System.out.println("Copied quantities: " + archive);

        System.out.println("\n=== 7. Raw types / heap pollution / type erasure ===");
        RawTypePitfall.demonstrate();
        boolean sameRuntimeClass = new ArrayList<String>().getClass()
                .equals(new ArrayList<Integer>().getClass());
        System.out.println("Same runtime class despite different type arguments: " + sameRuntimeClass);
        Object candidate = List.of("Coffee");
        if (candidate instanceof List<?>) {
            System.out.println("It is a List; this does not check its element type.");
        }

        System.out.println("\n=== 8. Product catalog response / validation / mutability ===");
        List<Product> products = List.of(new Product("Coffee", 10), new Product("Tea", 5));
        ApiResponse<List<Product>> response = new ApiResponse<>("Success", products);
        Product first = GenericUtils.first(response.getData());
        System.out.println(response.getMessage() + ": " + first.getName());
        try {
            new Product("Coffee", -10);
        } catch (IllegalArgumentException exception) {
            System.out.println("Validation rejected: " + exception.getMessage());
        }
        try {
            List<? super Integer> unmodifiable = List.of(1, 2);
            unmodifiable.add(3); // Type-correct, but operation unsupported។
        } catch (UnsupportedOperationException exception) {
            System.out.println("Expected UnsupportedOperationException: List.of does not support add.");
        }
    }
}
