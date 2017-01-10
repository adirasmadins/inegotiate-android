package com.amazonaws.services.s3.model;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import org.apache.http.client.methods.HttpRequestBase;

public class S3ObjectInputStream extends FilterInputStream {
    private final HttpRequestBase httpRequest;

    public S3ObjectInputStream(InputStream inputStream, HttpRequestBase httpRequestBase) {
        super(inputStream);
        this.httpRequest = httpRequestBase;
    }

    public void abort() throws IOException {
        getHttpRequest().abort();
        try {
            close();
        } catch (SocketException e) {
        }
    }

    public HttpRequestBase getHttpRequest() {
        return this.httpRequest;
    }
}
