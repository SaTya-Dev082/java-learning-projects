package com.datajpa.learning.advanced.exceptions.complete;

import java.io.IOException;
import java.util.List;

// Teaching resource: events ធ្វើឱ្យមើលឃើញពេល open និង close។
public class ResourceProbe implements AutoCloseable {
    private final String name;
    private final List<String> events;
    private final boolean failOnClose;

    public ResourceProbe(String name, List<String> events, boolean failOnClose) {
        this.name = name;
        this.events = events;
        this.failOnClose = failOnClose;
        events.add("open " + name);
    }

    public void use() {
        events.add("use " + name);
    }

    @Override
    public void close() throws IOException {
        events.add("close " + name);
        if (failOnClose) {
            throw new IOException("Cannot close " + name);
        }
    }
}
