package com.datajpa.learning.advanced.generics;

import java.util.Objects;

public class NumericBox<T extends Number> {
    private final T value;

    public NumericBox(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public double asDouble() {
        // Bound ធានាថា T មាន Method doubleValue()។ មិនប្រើសម្រាប់គណនាប្រាក់។
        return value.doubleValue();
    }
}
