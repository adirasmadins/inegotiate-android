package com.google.api.client.googleapis.json;

import com.google.api.client.googleapis.GoogleTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.Json;
import com.google.api.client.util.ArrayMap;
import com.google.api.client.util.Key;
import java.io.IOException;
import java.util.Map;
import org.codehaus.jackson.JsonParser;

public final class DiscoveryDocument {
    public final APIDefinition apiDefinition;

    public static final class APIDefinition extends ArrayMap<String, ServiceDefinition> {
    }

    public static final class ServiceDefinition {
        @Key
        public String baseUrl;
        @Key
        public Map<String, ServiceResource> resources;

        public ServiceMethod getResourceMethod(String methodIdentifier) {
            int dot = methodIdentifier.indexOf(46);
            ServiceResource resource = (ServiceResource) this.resources.get(methodIdentifier.substring(0, dot));
            return resource == null ? null : (ServiceMethod) resource.methods.get(methodIdentifier.substring(dot + 1));
        }

        String getResourceUrl(String methodIdentifier) {
            return this.baseUrl + getResourceMethod(methodIdentifier).pathUrl;
        }
    }

    public static final class ServiceMethod {
        @Key
        public String httpMethod;
        @Key
        public final String methodType;
        @Key
        public Map<String, ServiceParameter> parameters;
        @Key
        public String pathUrl;

        public ServiceMethod() {
            this.methodType = "rest";
        }
    }

    public static final class ServiceParameter {
        @Key
        public boolean required;
    }

    public static final class ServiceResource {
        @Key
        public Map<String, ServiceMethod> methods;
    }

    private DiscoveryDocument() {
        this.apiDefinition = new APIDefinition();
    }

    public static DiscoveryDocument load(String apiName) throws IOException {
        GenericUrl discoveryUrl = new GenericUrl("https://www.googleapis.com/discovery/0.1/describe");
        discoveryUrl.put("api", (Object) apiName);
        HttpRequest request = GoogleTransport.create().buildGetRequest();
        request.url = discoveryUrl;
        JsonParser parser = JsonCParser.parserForResponse(request.execute());
        Json.skipToKey(parser, apiName);
        DiscoveryDocument result = new DiscoveryDocument();
        Json.parseAndClose(parser, result.apiDefinition, null);
        return result;
    }
}
