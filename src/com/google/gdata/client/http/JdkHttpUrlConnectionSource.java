package com.google.gdata.client.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class JdkHttpUrlConnectionSource implements HttpUrlConnectionSource {
    public static final JdkHttpUrlConnectionSource INSTANCE;

    static {
        INSTANCE = new JdkHttpUrlConnectionSource();
    }

    public HttpURLConnection openConnection(URL url) throws IOException {
        if (url.getProtocol().startsWith("http")) {
            return (HttpURLConnection) url.openConnection();
        }
        throw new IllegalArgumentException("Not an HTTP url: " + url);
    }
}
