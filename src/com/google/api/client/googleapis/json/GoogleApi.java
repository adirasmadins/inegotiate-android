package com.google.api.client.googleapis.json;

import com.google.api.client.escape.CharEscapers;
import com.google.api.client.googleapis.GoogleTransport;
import com.google.api.client.googleapis.json.DiscoveryDocument.ServiceDefinition;
import com.google.api.client.googleapis.json.DiscoveryDocument.ServiceMethod;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.repackaged.com.google.common.base.Preconditions;
import com.google.api.client.util.DataUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public final class GoogleApi {
    public String name;
    public ServiceDefinition serviceDefinition;
    public HttpTransport transport;
    public String version;

    public GoogleApi() {
        this.transport = GoogleTransport.create();
    }

    public void load() throws IOException {
        this.serviceDefinition = (ServiceDefinition) DiscoveryDocument.load(this.name).apiDefinition.get(this.version);
        Preconditions.checkNotNull(this.serviceDefinition, "version not found: %s", this.version);
    }

    public HttpRequest buildRequest(String fullyQualifiedMethodName, Object parameters) throws IOException {
        String name = this.name;
        String version = this.version;
        HttpTransport transport = this.transport;
        ServiceDefinition serviceDefinition = this.serviceDefinition;
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(version);
        Preconditions.checkNotNull(transport);
        Preconditions.checkNotNull(fullyQualifiedMethodName);
        if (serviceDefinition == null) {
            load();
        }
        ServiceMethod method = serviceDefinition.getResourceMethod(fullyQualifiedMethodName);
        String str = "method not found: %s";
        Preconditions.checkNotNull(method, r20, fullyQualifiedMethodName);
        HttpRequest request = transport.buildRequest();
        request.method = method.httpMethod;
        HashMap<String, String> requestMap = new HashMap();
        for (Entry<String, Object> entry : DataUtil.mapOf(parameters).entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                requestMap.put(entry.getKey(), value.toString());
            }
        }
        GenericUrl genericUrl = new GenericUrl(serviceDefinition.baseUrl);
        String pathUrl = method.pathUrl;
        StringBuilder pathBuf = new StringBuilder();
        int cur = 0;
        int length = pathUrl.length();
        while (cur < length) {
            int next = pathUrl.indexOf(123, cur);
            if (next == -1) {
                pathBuf.append(pathUrl.substring(cur));
                break;
            }
            pathBuf.append(pathUrl.substring(cur, next));
            int close = pathUrl.indexOf(125, next + 2);
            String varName = pathUrl.substring(next + 1, close);
            cur = close + 1;
            String value2 = (String) requestMap.remove(varName);
            if (value2 == null) {
                throw new IllegalArgumentException("missing required path parameter: " + varName);
            }
            pathBuf.append(CharEscapers.escapeUriPath(value2));
        }
        genericUrl.appendRawPath(pathBuf.toString());
        genericUrl.putAll(requestMap);
        request.url = genericUrl;
        return request;
    }
}
