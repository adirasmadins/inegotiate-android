package com.google.api.client.javanet;

import com.google.api.client.http.LowLevelHttpTransport;
import java.io.IOException;

public final class NetHttpTransport extends LowLevelHttpTransport {
    public static final NetHttpTransport INSTANCE;
    public int connectTimeout;
    public int readTimeout;

    public NetHttpTransport() {
        this.connectTimeout = 20000;
        this.readTimeout = 20000;
    }

    static {
        INSTANCE = new NetHttpTransport();
    }

    public boolean supportsHead() {
        return true;
    }

    public NetHttpRequest buildDeleteRequest(String url) throws IOException {
        return new NetHttpRequest(this, "DELETE", url);
    }

    public NetHttpRequest buildGetRequest(String url) throws IOException {
        return new NetHttpRequest(this, "GET", url);
    }

    public NetHttpRequest buildHeadRequest(String url) throws IOException {
        return new NetHttpRequest(this, "HEAD", url);
    }

    public NetHttpRequest buildPostRequest(String url) throws IOException {
        return new NetHttpRequest(this, "POST", url);
    }

    public NetHttpRequest buildPutRequest(String url) throws IOException {
        return new NetHttpRequest(this, "PUT", url);
    }
}
