package com.smalik.webflux;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;

public class Greeting {

    private String message;
    private Instant time;
    private String host;

    public Greeting(String message) {
        try {
            this.host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            this.host = "UNKNOWN";
        }
        this.message = message;
        this.time = Instant.now();
    }

    public String getMessage() {
        return message;
    }

    public Instant getTime() {
        return time;
    }

    public String getHost() {
        return host;
    }
}
