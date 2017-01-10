package com.amazonaws.http;

import com.amazonaws.Request;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.methods.HttpRequestBase;

public class HttpResponse {
    private InputStream content;
    private Map<String, String> headers;
    private final HttpRequestBase httpRequest;
    private final Request<?> request;
    private int statusCode;
    private String statusText;

    public HttpResponse(Request<?> request, HttpRequestBase httpRequestBase) {
        this.headers = new HashMap();
        this.request = request;
        this.httpRequest = httpRequestBase;
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public InputStream getContent() {
        return this.content;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public HttpRequestBase getHttpRequest() {
        return this.httpRequest;
    }

    public Request<?> getRequest() {
        return this.request;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public void setStatusText(String str) {
        this.statusText = str;
    }
}
