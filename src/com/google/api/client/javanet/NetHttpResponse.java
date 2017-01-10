package com.google.api.client.javanet;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

final class NetHttpResponse extends LowLevelHttpResponse {
    private final HttpURLConnection connection;
    private final ArrayList<String> headerNames;
    private final ArrayList<String> headerValues;
    private final int responseCode;
    private final String responseMessage;

    NetHttpResponse(HttpURLConnection connection) throws IOException {
        this.headerNames = new ArrayList();
        this.headerValues = new ArrayList();
        this.connection = connection;
        this.responseCode = connection.getResponseCode();
        this.responseMessage = connection.getResponseMessage();
        List<String> headerNames = this.headerNames;
        List<String> headerValues = this.headerValues;
        for (Entry<String, List<String>> entry : connection.getHeaderFields().entrySet()) {
            String key = (String) entry.getKey();
            if (key != null) {
                for (String value : (List) entry.getValue()) {
                    if (value != null) {
                        headerNames.add(key);
                        headerValues.add(value);
                    }
                }
            }
        }
    }

    public int getStatusCode() {
        return this.responseCode;
    }

    public InputStream getContent() throws IOException {
        HttpURLConnection connection = this.connection;
        return HttpResponse.isSuccessStatusCode(this.responseCode) ? connection.getInputStream() : connection.getErrorStream();
    }

    public String getContentEncoding() {
        return this.connection.getContentEncoding();
    }

    public long getContentLength() {
        String string = this.connection.getHeaderField(HttpHeaders.CONTENT_LENGTH);
        return string == null ? -1 : Long.parseLong(string);
    }

    public String getContentType() {
        return this.connection.getHeaderField(HttpHeaders.CONTENT_TYPE);
    }

    public String getReasonPhrase() {
        return this.responseMessage;
    }

    public String getStatusLine() {
        String result = this.connection.getHeaderField(0);
        return (result == null || !result.startsWith("HTTP/1.")) ? null : result;
    }

    public int getHeaderCount() {
        return this.headerNames.size();
    }

    public String getHeaderName(int index) {
        return (String) this.headerNames.get(index);
    }

    public String getHeaderValue(int index) {
        return (String) this.headerValues.get(index);
    }
}
