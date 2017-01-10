package com.amazonaws;

import com.amazonaws.handlers.RequestHandler;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.http.HttpRequest;
import java.net.URI;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public abstract class AmazonWebServiceClient {
    protected AmazonHttpClient client;
    protected ClientConfiguration clientConfiguration;
    protected URI endpoint;
    protected final List<RequestHandler> requestHandlers;

    public AmazonWebServiceClient(ClientConfiguration clientConfiguration) {
        this.clientConfiguration = clientConfiguration;
        this.client = new AmazonHttpClient(clientConfiguration);
        this.requestHandlers = Collections.synchronizedList(new LinkedList());
    }

    public void addRequestHandler(RequestHandler requestHandler) {
        this.requestHandlers.add(requestHandler);
    }

    @Deprecated
    protected <T> HttpRequest convertToHttpRequest(Request<T> request, HttpMethodName httpMethodName) {
        HttpRequest httpRequest = new HttpRequest(httpMethodName);
        for (Entry entry : request.getParameters().entrySet()) {
            httpRequest.addParameter((String) entry.getKey(), (String) entry.getValue());
        }
        for (Entry entry2 : request.getHeaders().entrySet()) {
            httpRequest.addHeader((String) entry2.getKey(), (String) entry2.getValue());
        }
        httpRequest.setServiceName(request.getServiceName());
        httpRequest.setEndpoint(request.getEndpoint());
        httpRequest.setResourcePath(request.getResourcePath());
        httpRequest.setOriginalRequest(request.getOriginalRequest());
        return httpRequest;
    }

    protected ExecutionContext createExecutionContext() {
        return new ExecutionContext(this.requestHandlers);
    }

    public void removeRequestHandler(RequestHandler requestHandler) {
        this.requestHandlers.remove(requestHandler);
    }

    public void setConfiguration(ClientConfiguration clientConfiguration) {
        this.clientConfiguration = clientConfiguration;
        this.client = new AmazonHttpClient(clientConfiguration);
    }

    public void setEndpoint(String str) throws IllegalArgumentException {
        if (!str.contains("://")) {
            str = this.clientConfiguration.getProtocol().toString() + "://" + str;
        }
        try {
            this.endpoint = new URI(str);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void shutdown() {
        this.client.shutdown();
    }
}
