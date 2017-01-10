package com.google.api.client.javanet;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

final class NetHttpRequest extends LowLevelHttpRequest {
    private final HttpURLConnection connection;
    private HttpContent content;
    private final NetHttpTransport transport;

    NetHttpRequest(NetHttpTransport transport, String requestMethod, String url) throws IOException {
        this.transport = transport;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        this.connection = connection;
        connection.setRequestMethod(requestMethod);
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(false);
    }

    public void addHeader(String name, String value) {
        this.connection.addRequestProperty(name, value);
    }

    public LowLevelHttpResponse execute() throws IOException {
        HttpURLConnection connection = this.connection;
        HttpContent content = this.content;
        if (content != null) {
            connection.setDoOutput(true);
            addHeader(HttpHeaders.CONTENT_TYPE, content.getType());
            String contentEncoding = content.getEncoding();
            if (contentEncoding != null) {
                addHeader(HttpHeaders.CONTENT_ENCODING, contentEncoding);
            }
            long contentLength = content.getLength();
            if (contentLength >= 0) {
                addHeader(HttpHeaders.CONTENT_LENGTH, Long.toString(contentLength));
            }
            content.writeTo(connection.getOutputStream());
        }
        NetHttpTransport transport = this.transport;
        int readTimeout = transport.readTimeout;
        if (readTimeout >= 0) {
            connection.setReadTimeout(readTimeout);
        }
        int connectTimeout = transport.connectTimeout;
        if (connectTimeout >= 0) {
            connection.setConnectTimeout(connectTimeout);
        }
        connection.connect();
        return new NetHttpResponse(connection);
    }

    public void setContent(HttpContent content) {
        this.content = content;
    }
}
