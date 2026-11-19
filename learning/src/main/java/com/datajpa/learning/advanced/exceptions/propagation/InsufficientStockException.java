package com.datajpa.learning.advanced.exceptions.propagation;

// Custom Unchecked Exception: បញ្ហាច្បាប់អាជីវកម្ម មិនមែនចំនួនអវិជ្ជមាន។
public class InsufficientStockException extends RuntimeException {
    private final int requested;
    private final int available;

    public InsufficientStockException(int requested, int available) {
        super("Requested " + requested + ", but only " + available + " available.");
        this.requested = requested;
        this.available = available;
    }

    public int getRequested() {
        return requested;
    }

    public int getAvailable() {
        return available;
    }
}
