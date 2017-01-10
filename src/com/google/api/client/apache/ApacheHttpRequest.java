package com.google.api.client.apache;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import java.io.IOException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;

final class ApacheHttpRequest extends LowLevelHttpRequest {
    private final HttpClient httpClient;
    private final HttpRequestBase request;

    ApacheHttpRequest(HttpClient httpClient, HttpRequestBase request) {
        this.httpClient = httpClient;
        this.request = request;
    }

    public void addHeader(String name, String value) {
        this.request.addHeader(name, value);
    }

    public LowLevelHttpResponse execute() throws IOException {
        return new ApacheHttpResponse(this.httpClient.execute(this.request));
    }

    public void setContent(HttpContent content) throws IOException {
        ContentEntity entity = new ContentEntity(content.getLength(), content);
        entity.setContentEncoding(content.getEncoding());
        entity.setContentType(content.getType());
        ((HttpEntityEnclosingRequest) this.request).setEntity(entity);
    }
}
