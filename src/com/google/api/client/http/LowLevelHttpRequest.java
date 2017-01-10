package com.google.api.client.http;

import java.io.IOException;

public abstract class LowLevelHttpRequest {
    public abstract void addHeader(String str, String str2);

    public abstract LowLevelHttpResponse execute() throws IOException;

    public abstract void setContent(HttpContent httpContent) throws IOException;
}
