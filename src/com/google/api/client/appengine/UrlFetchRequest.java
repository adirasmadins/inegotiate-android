package com.google.api.client.appengine;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.appengine.api.urlfetch.FetchOptions.Builder;
import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.ResponseTooLargeException;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

final class UrlFetchRequest extends LowLevelHttpRequest {
    private HttpContent content;
    private final HTTPMethod method;
    private final HTTPRequest request;
    private final UrlFetchTransport transport;

    UrlFetchRequest(UrlFetchTransport transport, String requestMethod, String url) throws IOException {
        this.transport = transport;
        this.method = HTTPMethod.valueOf(requestMethod);
        this.request = new HTTPRequest(new URL(url), this.method, Builder.doNotFollowRedirects().disallowTruncate());
    }

    public void addHeader(String name, String value) {
        this.request.addHeader(new HTTPHeader(name, value));
    }

    public LowLevelHttpResponse execute() throws IOException {
        if (this.content != null) {
            addHeader(HttpHeaders.CONTENT_TYPE, this.content.getType());
            String contentEncoding = this.content.getEncoding();
            if (contentEncoding != null) {
                addHeader(HttpHeaders.CONTENT_ENCODING, contentEncoding);
            }
            long contentLength = this.content.getLength();
            if (contentLength >= 0) {
                addHeader(HttpHeaders.CONTENT_LENGTH, Long.toString(contentLength));
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            this.content.writeTo(out);
            this.request.setPayload(out.toByteArray());
        }
        double deadline = this.transport.deadline.doubleValue();
        if (deadline >= 0.0d) {
            this.request.getFetchOptions().setDeadline(Double.valueOf(deadline));
        }
        try {
            return new UrlFetchResponse(URLFetchServiceFactory.getURLFetchService().fetch(this.request));
        } catch (ResponseTooLargeException e) {
            IOException ioException = new IOException();
            ioException.initCause(e);
            throw ioException;
        }
    }

    public void setContent(HttpContent content) {
        this.content = content;
    }
}
