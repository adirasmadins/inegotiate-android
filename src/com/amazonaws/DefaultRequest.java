package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.google.gdata.util.common.base.StringUtil;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class DefaultRequest<T> implements Request<T> {
    private InputStream content;
    private URI endpoint;
    private Map<String, String> headers;
    private HttpMethodName httpMethod;
    private final AmazonWebServiceRequest originalRequest;
    private Map<String, String> parameters;
    private String resourcePath;
    private String serviceName;

    public DefaultRequest(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        this.parameters = new HashMap();
        this.headers = new HashMap();
        this.httpMethod = HttpMethodName.POST;
        this.serviceName = str;
        this.originalRequest = amazonWebServiceRequest;
    }

    public DefaultRequest(String str) {
        this(null, str);
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public void addParameter(String str, String str2) {
        this.parameters.put(str, str2);
    }

    public InputStream getContent() {
        return this.content;
    }

    public URI getEndpoint() {
        return this.endpoint;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public HttpMethodName getHttpMethod() {
        return this.httpMethod;
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

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }

    public void setEndpoint(URI uri) {
        this.endpoint = uri;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers.clear();
        this.headers.putAll(map);
    }

    public void setHttpMethod(HttpMethodName httpMethodName) {
        this.httpMethod = httpMethodName;
    }

    public void setParameters(Map<String, String> map) {
        this.parameters.clear();
        this.parameters.putAll(map);
    }

    public void setResourcePath(String str) {
        this.resourcePath = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getHttpMethod().toString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
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

    public Request<T> withParameter(String str, String str2) {
        addParameter(str, str2);
        return this;
    }
}
