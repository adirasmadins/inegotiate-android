package com.google.api.client.json.rpc2;

import com.amazonaws.javax.xml.transform.OutputKeys;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonHttpContent;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Strings;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;

public final class JsonRpcHttpTransport {
    public String accept;
    public String contentType;
    public GenericUrl rpcServerUrl;
    public HttpTransport transport;

    public JsonRpcHttpTransport() {
        this.transport = new HttpTransport();
        this.contentType = "application/json-rpc";
        this.accept = this.contentType;
    }

    public HttpRequest buildPostRequest(JsonRpcRequest request) {
        return internalExecute(request);
    }

    public HttpRequest buildPostRequest(List<JsonRpcRequest> requests) {
        return internalExecute(requests);
    }

    public HttpRequest buildGetRequest(JsonRpcRequest request) throws IOException {
        HttpRequest httpRequest = this.transport.buildGetRequest();
        GenericUrl url = this.rpcServerUrl.clone();
        httpRequest.url = url;
        url.set(OutputKeys.METHOD, request.method);
        url.set("id", request.id);
        OutputStream byteStream = new ByteArrayOutputStream();
        JsonGenerator generator = Json.JSON_FACTORY.createJsonGenerator(byteStream, JsonEncoding.UTF8);
        try {
            Json.serialize(generator, request.params);
            url.set("params", Strings.fromBytesUtf8(Base64.encode(byteStream.toByteArray())));
            return httpRequest;
        } finally {
            generator.close();
        }
    }

    private HttpRequest internalExecute(Object data) {
        HttpRequest httpRequest = this.transport.buildPostRequest();
        httpRequest.url = this.rpcServerUrl;
        JsonHttpContent content = new JsonHttpContent();
        content.contentType = this.contentType;
        httpRequest.headers.accept = this.accept;
        content.data = data;
        httpRequest.content = content;
        return httpRequest;
    }
}
