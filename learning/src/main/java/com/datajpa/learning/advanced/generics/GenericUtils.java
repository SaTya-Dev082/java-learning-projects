package com.datajpa.learning.advanced.generics;

import java.util.List;
import java.util.Objects;

public final class GenericUtils {
    private GenericUtils() {
    }

    public static <T> T valueOrDefault(T value, T fallback) {
        return value != null ? value : fallback;
    }

    public static <T extends Comparable<T>> T max(T first, T second) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);
        return first.compareTo(second) >= 0 ? first : second;
    }

    // Multiple bounds: Class មុន Interface។
    public static <T extends Number & Comparable<T>> T maxNumber(T first, T second) {
        return max(first, second);
    }

    public static <T> T first(List<T> items) {
        if (items.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty.");
        }
        return items.get(0);
    }

    public static void printItems(List<?> items) {
        for (Object item : items) {
            System.out.println(item);
        }
    }

    public static void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
    }

    public static void addSampleQuantities(List<? super Integer> destination) {
        destination.add(10);
        destination.add(20);
        Object existing = destination.get(0); // អានធានាបានត្រឹម Object។
        System.out.println("First destination element: " + existing);
    }

    // PECS: source ផ្ដល់ T; destination ទទួល T។ Append មិន replace។
    public static <T> void copyItems(List<? extends T> source, List<? super T> destination) {
        for (T item : source) {
            destination.add(item);
        }
    }
}
