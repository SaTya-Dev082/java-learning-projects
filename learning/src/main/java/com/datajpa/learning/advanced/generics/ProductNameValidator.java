package com.datajpa.learning.advanced.generics;

public class ProductNameValidator implements Validator<String> {
    @Override
    public boolean isValid(String value) {
        return value != null && !value.isBlank();
    }
}
