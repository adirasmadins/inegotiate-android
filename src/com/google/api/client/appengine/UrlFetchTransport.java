package com.google.api.client.appengine;

import com.google.api.client.http.LowLevelHttpTransport;
import java.io.IOException;

public final class UrlFetchTransport extends LowLevelHttpTransport {
    public static final UrlFetchTransport INSTANCE;
    public Double deadline;

    public UrlFetchTransport() {
        this.deadline = Double.valueOf(20.0d);
    }

    static {
        INSTANCE = new UrlFetchTransport();
    }

    public boolean supportsHead() {
        return true;
    }

    public UrlFetchRequest buildDeleteRequest(String url) throws IOException {
        return new UrlFetchRequest(this, "DELETE", url);
    }

    public UrlFetchRequest buildGetRequest(String url) throws IOException {
        return new UrlFetchRequest(this, "GET", url);
    }

    public UrlFetchRequest buildHeadRequest(String url) throws IOException {
        return new UrlFetchRequest(this, "HEAD", url);
    }

    public UrlFetchRequest buildPostRequest(String url) throws IOException {
        return new UrlFetchRequest(this, "POST", url);
    }

    public UrlFetchRequest buildPutRequest(String url) throws IOException {
        return new UrlFetchRequest(this, "PUT", url);
    }
}
