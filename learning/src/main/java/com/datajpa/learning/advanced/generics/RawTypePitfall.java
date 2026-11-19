package com.datajpa.learning.advanced.generics;

import java.util.ArrayList;
import java.util.List;

public final class RawTypePitfall {
    private RawTypePitfall() {
    }

    // Intentionally unsafe teaching example ONLY. Run checks script for actual compiler warnings.
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void demonstrate() {
        List<Integer> quantities = new ArrayList<>();
        List raw = quantities;
        raw.add("Hello"); // Heap pollution: ខុសនឹងប្រភេទ List<Integer>។
        try {
            Integer quantity = quantities.get(0); // Compiler-inserted cast fails at runtime។
            System.out.println(quantity);
        } catch (ClassCastException exception) {
            System.out.println("Expected ClassCastException from unsafe raw type.");
        }
    }
}
