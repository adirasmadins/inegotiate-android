package com.google.api.client.http;

import java.io.IOException;

public interface HttpParser {
    String getContentType();

    <T> T parse(HttpResponse httpResponse, Class<T> cls) throws IOException;
}
