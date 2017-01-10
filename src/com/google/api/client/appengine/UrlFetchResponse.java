package com.google.api.client.appengine;

import com.google.api.client.http.LowLevelHttpResponse;
import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

final class UrlFetchResponse extends LowLevelHttpResponse {
    private String contentEncoding;
    private long contentLength;
    private String contentType;
    private final HTTPResponse fetchResponse;
    private final ArrayList<String> headerNames;
    private final ArrayList<String> headerValues;

    UrlFetchResponse(HTTPResponse fetchResponse) {
        this.headerNames = new ArrayList();
        this.headerValues = new ArrayList();
        this.fetchResponse = fetchResponse;
        for (HTTPHeader header : fetchResponse.getHeaders()) {
            String name = header.getName();
            String value = header.getValue();
            if (!(name == null || value == null)) {
                this.headerNames.add(name);
                this.headerValues.add(value);
                if ("content-type".equalsIgnoreCase(name)) {
                    this.contentType = value;
                } else if ("content-encoding".equalsIgnoreCase(name)) {
                    this.contentEncoding = value;
                } else if ("content-length".equalsIgnoreCase(name)) {
                    try {
                        this.contentLength = Long.parseLong(value);
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
    }

    public int getStatusCode() {
        return this.fetchResponse.getResponseCode();
    }

    public InputStream getContent() {
        return new ByteArrayInputStream(this.fetchResponse.getContent());
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getReasonPhrase() {
        return null;
    }

    public String getStatusLine() {
        return null;
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
