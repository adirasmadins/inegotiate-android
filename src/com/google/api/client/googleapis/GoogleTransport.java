package com.google.api.client.googleapis;

import com.google.api.client.http.HttpTransport;

public final class GoogleTransport {
    public static HttpTransport create() {
        HttpTransport transport = new HttpTransport();
        MethodOverrideIntercepter.setAsFirstFor(transport);
        transport.defaultHeaders = new GoogleHeaders();
        return transport;
    }

    private GoogleTransport() {
    }
}
