package com.google.api.client.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class LogContent implements HttpContent {
    private final String contentEncoding;
    private final long contentLength;
    private final String contentType;
    private final HttpContent httpContent;

    LogContent(HttpContent httpContent, String contentType, String contentEncoding, long contentLength) {
        this.httpContent = httpContent;
        this.contentType = contentType;
        this.contentLength = contentLength;
        this.contentEncoding = contentEncoding;
    }

    public void writeTo(OutputStream out) throws IOException {
        ByteArrayOutputStream debugStream = new ByteArrayOutputStream();
        this.httpContent.writeTo(debugStream);
        byte[] debugContent = debugStream.toByteArray();
        HttpTransport.LOGGER.config(new String(debugContent));
        out.write(debugContent);
    }

    public String getEncoding() {
        return this.contentEncoding;
    }

    public long getLength() {
        return this.contentLength;
    }

    public String getType() {
        return this.contentType;
    }

    public static boolean isTextBasedContentType(String contentType) {
        return contentType != null && (contentType.startsWith("text/") || contentType.startsWith("application/"));
    }
}
