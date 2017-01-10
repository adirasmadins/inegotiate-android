package com.google.api.client.http;

import java.io.IOException;

public interface HttpExecuteIntercepter {
    void intercept(HttpRequest httpRequest) throws IOException;
}
