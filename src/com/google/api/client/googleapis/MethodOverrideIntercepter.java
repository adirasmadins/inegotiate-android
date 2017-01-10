package com.google.api.client.googleapis;

import com.google.api.client.http.HttpExecuteIntercepter;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.gdata.client.GDataProtocol.Method;
import com.google.gdata.client.uploader.ResumableHttpFileUploader;
import java.util.HashSet;

public class MethodOverrideIntercepter implements HttpExecuteIntercepter {
    public static final HashSet<String> overriddenMethods;

    static {
        overriddenMethods = new HashSet();
        if (!HttpTransport.useLowLevelHttpTransport().supportsPatch()) {
            overriddenMethods.add(Method.PATCH);
        }
        if (!HttpTransport.useLowLevelHttpTransport().supportsHead()) {
            overriddenMethods.add("HEAD");
        }
    }

    public void intercept(HttpRequest request) {
        String method = request.method;
        if (overriddenMethods.contains(method)) {
            request.method = "POST";
            request.headers.set(ResumableHttpFileUploader.METHOD_OVERRIDE, method);
        }
    }

    public static void setAsFirstFor(HttpTransport transport) {
        transport.removeIntercepters(MethodOverrideIntercepter.class);
        transport.intercepters.add(0, new MethodOverrideIntercepter());
    }
}
