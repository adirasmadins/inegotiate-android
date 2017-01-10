package com.google.api.client.http;

import java.io.IOException;

public abstract class LowLevelHttpTransport {
    public abstract LowLevelHttpRequest buildDeleteRequest(String str) throws IOException;

    public abstract LowLevelHttpRequest buildGetRequest(String str) throws IOException;

    public abstract LowLevelHttpRequest buildPostRequest(String str) throws IOException;

    public abstract LowLevelHttpRequest buildPutRequest(String str) throws IOException;

    public boolean supportsHead() {
        return false;
    }

    public boolean supportsPatch() {
        return false;
    }

    public LowLevelHttpRequest buildHeadRequest(String url) throws IOException {
        throw new UnsupportedOperationException();
    }

    public LowLevelHttpRequest buildPatchRequest(String url) throws IOException {
        throw new UnsupportedOperationException();
    }
}
