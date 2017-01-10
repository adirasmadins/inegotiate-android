package com.google.api.client.http;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

final class GZipContent implements HttpContent {
    private final String contentType;
    private final HttpContent httpContent;

    GZipContent(HttpContent httpContent, String contentType) {
        this.httpContent = httpContent;
        this.contentType = contentType;
    }

    public void writeTo(OutputStream out) throws IOException {
        GZIPOutputStream zipper = new GZIPOutputStream(out);
        this.httpContent.writeTo(zipper);
        zipper.finish();
    }

    public String getEncoding() {
        return "gzip";
    }

    public long getLength() {
        return -1;
    }

    public String getType() {
        return this.contentType;
    }
}
