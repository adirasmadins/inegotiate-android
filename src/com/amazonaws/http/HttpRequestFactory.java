package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.util.HttpUtils;
import com.google.common.net.HttpHeaders;
import java.net.URI;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

class HttpRequestFactory {
    private static final String DEFAULT_ENCODING = "UTF-8";

    HttpRequestFactory() {
    }

    private void configureHeaders(HttpRequestBase httpRequestBase, Request<?> request, ExecutionContext executionContext, ClientConfiguration clientConfiguration) {
        URI endpoint = request.getEndpoint();
        String host = endpoint.getHost();
        if (HttpUtils.isUsingNonDefaultPort(endpoint)) {
            host = host + ":" + endpoint.getPort();
        }
        httpRequestBase.addHeader(HttpHeaders.HOST, host);
        for (Entry entry : request.getHeaders().entrySet()) {
            if (!(((String) entry.getKey()).equalsIgnoreCase(HttpHeaders.CONTENT_LENGTH) || ((String) entry.getKey()).equalsIgnoreCase(HttpHeaders.HOST))) {
                httpRequestBase.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (httpRequestBase.getHeaders(HttpHeaders.CONTENT_TYPE) == null || httpRequestBase.getHeaders(HttpHeaders.CONTENT_TYPE).length == 0) {
            httpRequestBase.addHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=" + DEFAULT_ENCODING.toLowerCase());
        }
        if (executionContext != null && executionContext.getContextUserAgent() != null) {
            httpRequestBase.addHeader(HttpHeaders.USER_AGENT, createUserAgentString(clientConfiguration, executionContext.getContextUserAgent()));
        }
    }

    private String createUserAgentString(ClientConfiguration clientConfiguration, String str) {
        return clientConfiguration.getUserAgent().contains(str) ? clientConfiguration.getUserAgent() : clientConfiguration.getUserAgent() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str;
    }

    private HttpEntity newBufferedHttpEntity(HttpEntity httpEntity) {
        try {
            return new BufferedHttpEntity(httpEntity);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to create HTTP entity: " + e.getMessage(), e);
        }
    }

    private HttpEntity newStringEntity(String str) {
        try {
            return new StringEntity(str);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to create HTTP entity: " + e.getMessage(), e);
        }
    }

    HttpRequestBase createHttpRequest(Request<?> request, ClientConfiguration clientConfiguration, HttpEntity httpEntity, ExecutionContext executionContext) {
        HttpRequestBase httpRequestBase;
        boolean z = false;
        String uri = request.getEndpoint().toString();
        if (request.getResourcePath() != null && request.getResourcePath().length() > 0) {
            if (!request.getResourcePath().startsWith("/")) {
                uri = uri + "/";
            }
            uri = uri + request.getResourcePath();
        } else if (!uri.endsWith("/")) {
            uri = uri + "/";
        }
        String encodeParameters = HttpUtils.encodeParameters(request);
        boolean z2 = request.getContent() != null;
        if (!(request.getHttpMethod() == HttpMethodName.POST) || z2) {
            z = true;
        }
        if (encodeParameters != null && r3) {
            uri = uri + "?" + encodeParameters;
        }
        HttpRequestBase httpPost;
        if (request.getHttpMethod() == HttpMethodName.POST) {
            httpPost = new HttpPost(uri);
            if (request.getContent() != null || encodeParameters == null) {
                httpPost.setEntity(new RepeatableInputStreamRequestEntity(request));
            } else {
                httpPost.setEntity(newStringEntity(encodeParameters));
            }
            httpRequestBase = httpPost;
        } else if (request.getHttpMethod() == HttpMethodName.PUT) {
            httpPost = new HttpPut(uri);
            httpPost.getParams().setParameter("http.protocol.expect-continue", Boolean.valueOf(true));
            if (httpEntity != null) {
                httpPost.setEntity(httpEntity);
            } else if (request.getContent() != null) {
                HttpEntity repeatableInputStreamRequestEntity = new RepeatableInputStreamRequestEntity(request);
                if (request.getHeaders().get(HttpHeaders.CONTENT_LENGTH) == null) {
                    repeatableInputStreamRequestEntity = newBufferedHttpEntity(repeatableInputStreamRequestEntity);
                }
                httpPost.setEntity(repeatableInputStreamRequestEntity);
            }
            httpRequestBase = httpPost;
        } else if (request.getHttpMethod() == HttpMethodName.GET) {
            httpRequestBase = new HttpGet(uri);
        } else if (request.getHttpMethod() == HttpMethodName.DELETE) {
            httpRequestBase = new HttpDelete(uri);
        } else if (request.getHttpMethod() == HttpMethodName.HEAD) {
            httpRequestBase = new HttpHead(uri);
        } else {
            throw new AmazonClientException("Unknown HTTP method name: " + request.getHttpMethod());
        }
        configureHeaders(httpRequestBase, request, executionContext, clientConfiguration);
        return httpRequestBase;
    }
}
