package com.datajpa.learning.advanced.generics;

// រចនាសម្ព័ន្ធ response ដូចគ្នា ប៉ុន្តែប្រភេទ data អាចខុសគ្នា។
public class ApiResponse<T> {
    private final String message;
    private final T data;

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
