package com.datajpa.learning.advanced.collections;

import java.util.Objects;

/** Lower priority number runs first; sequence breaks ties deterministically. */
public final class ShippingTask implements Comparable<ShippingTask> {
    private final String orderId;
    private final int priority;
    private final long sequence;

    public ShippingTask(String orderId, int priority, long sequence) {
        this.orderId = Objects.requireNonNull(orderId);
        this.priority = priority;
        this.sequence = sequence;
    }

    public String getOrderId() { return orderId; }

    @Override
    public int compareTo(ShippingTask other) {
        int byPriority = Integer.compare(priority, other.priority);
        return byPriority != 0 ? byPriority : Long.compare(sequence, other.sequence);
    }

    @Override
    public String toString() {
        return orderId + "(priority=" + priority + ")";
    }
}
