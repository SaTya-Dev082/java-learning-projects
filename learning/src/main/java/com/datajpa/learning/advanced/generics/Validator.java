package com.datajpa.learning.advanced.generics;

public interface Validator<T> {
    boolean isValid(T value);
}
