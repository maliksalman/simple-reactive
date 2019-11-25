package com.smalik.webflux;

import java.time.Instant;

public class Greeting {

    private String message;
    private Instant time;

    public Greeting(String message) {
        this.time = Instant.now();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTime() {
        return time;
    }
}
