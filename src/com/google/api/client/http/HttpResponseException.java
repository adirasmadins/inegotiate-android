package com.google.api.client.http;

import java.io.IOException;

public final class HttpResponseException extends IOException {
    static final long serialVersionUID = 1;
    public final HttpResponse response;

    public HttpResponseException(HttpResponse response) {
        super(computeMessage(response));
        this.response = response;
    }

    public static String computeMessage(HttpResponse response) {
        String statusMessage = response.statusMessage;
        int statusCode = response.statusCode;
        if (statusMessage == null) {
            return String.valueOf(statusCode);
        }
        return new StringBuilder(statusMessage.length() + 4).append(statusCode).append(' ').append(statusMessage).toString();
    }
}
