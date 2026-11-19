package com.datajpa.learning.advanced.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsChecks {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.setValue(-10);
        check(box.getValue() == -10, "Generics must not silently validate business values.");
        Validator<String> validator = new ProductNameValidator();
        check(validator.isValid("Coffee") && !validator.isValid(null) && !validator.isValid(" "), "Name rules.");
        Pair<String, Integer> pair = new Pair<>("Coffee", 10);
        check(pair.getKey().equals("Coffee") && pair.getValue() == 10, "Multiple parameters.");
        check(GenericUtils.valueOrDefault(null, 0) == 0, "Fallback.");
        check(GenericUtils.valueOrDefault(5, 0) == 5, "Existing value.");
        check(GenericUtils.valueOrDefault(null, null) == null, "Both null remain null.");
        check(new NumericBox<>(2.5).asDouble() == 2.5, "Number bound.");
        check(GenericUtils.max("Apple", "Coffee").equals("Coffee"), "Interface bound.");
        check(GenericUtils.maxNumber(10, 20) == 20, "Multiple bounds.");
        Product coffee = new Product("Coffee", 10);
        List<Product> source = List.of(coffee);
        List<Object> destination = new ArrayList<>();
        destination.add("existing");
        GenericUtils.copyItems(source, destination);
        check(destination.size() == 2 && destination.get(1) == coffee, "PECS appends same references.");
        ApiResponse<List<Product>> response = new ApiResponse<>("Success", source);
        check(GenericUtils.first(response.getData()) == coffee, "Nested types preserve product type.");
        rejects(IllegalArgumentException.class, () -> GenericUtils.first(List.of()));
        rejects(IllegalArgumentException.class, () -> new Product("Coffee", -1));
        rejects(NullPointerException.class, () -> new NumericBox<Integer>(null));
        rejects(UnsupportedOperationException.class, () -> GenericUtils.copyItems(List.of(1), List.of(2)));
        check(new Box<String>().getClass().equals(new Box<Integer>().getClass()), "Shared runtime class.");
        System.out.println("PASS: generic structures, bounds, inference, PECS, validation and runtime limitations.");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void rejects(Class<? extends RuntimeException> type, Runnable action) {
        try {
            action.run();
        } catch (RuntimeException actual) {
            if (type.isInstance(actual)) {
                return;
            }
            throw actual;
        }
        throw new AssertionError("Expected " + type.getSimpleName());
    }
}
