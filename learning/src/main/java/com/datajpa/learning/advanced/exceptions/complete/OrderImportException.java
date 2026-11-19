package com.datajpa.learning.advanced.exceptions.complete;

public class OrderImportException extends RuntimeException {
    public OrderImportException(String message, Throwable cause) {
        // រក្សា Cause ដើម; កុំបោះចោលដោយរក្សាតែ message។
        super(message, cause);
    }
}
