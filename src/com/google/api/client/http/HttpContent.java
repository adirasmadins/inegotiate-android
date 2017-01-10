package com.google.api.client.http;

import java.io.IOException;
import java.io.OutputStream;

public interface HttpContent {
    String getEncoding();

    long getLength() throws IOException;

    String getType();

    void writeTo(OutputStream outputStream) throws IOException;
}
