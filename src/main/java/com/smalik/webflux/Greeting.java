package com.smalik.webflux;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;

public class Greeting {

    private String message;
    private Instant time;
    private String host;

    public Greeting(String message) throws UnknownHostException {
        this.time = Instant.now();
        this.host = InetAddress.getLocalHost().getHostName();
        this.message = message;
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
