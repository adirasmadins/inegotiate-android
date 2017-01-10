package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceRequest;
import com.google.gdata.util.common.base.StringUtil;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class HttpRequest {
    private URI endpoint;
    private Map<String, String> headers;
    private InputStream inputStream;
    private HttpMethodName methodName;
    private AmazonWebServiceRequest originalRequest;
    private Map<String, String> parameters;
    private String resourcePath;
    private String serviceName;

    public HttpRequest(HttpMethodName httpMethodName) {
        this.parameters = new HashMap();
        this.headers = new HashMap();
        this.methodName = httpMethodName;
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public void addParameter(String str, String str2) {
        this.parameters.put(str, str2);
    }

    public InputStream getContent() {
        return this.inputStream;
    }

    public URI getEndpoint() {
        return this.endpoint;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public HttpMethodName getMethodName() {
        return this.methodName;
    }

    public AmazonWebServiceRequest getOriginalRequest() {
        return this.originalRequest;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void removeHeader(String str) {
        this.headers.remove(str);
    }

    public void setContent(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setEndpoint(URI uri) {
        this.endpoint = uri;
    }

    public void setOriginalRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        this.originalRequest = amazonWebServiceRequest;
    }

    public void setParameters(Map<String, String> map) {
        this.parameters = map;
    }

    public void setResourcePath(String str) {
        this.resourcePath = str;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getMethodName().toString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        stringBuilder.append(getEndpoint().toString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        stringBuilder.append("/" + (getResourcePath() != null ? getResourcePath() : StringUtil.EMPTY_STRING) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (!getParameters().isEmpty()) {
            stringBuilder.append("Parameters: (");
            for (String str : getParameters().keySet()) {
                stringBuilder.append(str + ": " + ((String) getParameters().get(str)) + ", ");
            }
            stringBuilder.append(") ");
        }
        if (!getHeaders().isEmpty()) {
            stringBuilder.append("Headers: (");
            for (String str2 : getHeaders().keySet()) {
                stringBuilder.append(str2 + ": " + ((String) getHeaders().get(str2)) + ", ");
            }
            stringBuilder.append(") ");
        }
        return stringBuilder.toString();
    }

    public HttpRequest withParameter(String str, String str2) {
        addParameter(str, str2);
        return this;
    }
}
