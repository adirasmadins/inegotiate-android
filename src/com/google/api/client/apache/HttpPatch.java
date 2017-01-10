package com.google.api.client.apache;

import com.google.gdata.client.GDataProtocol.Method;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

final class HttpPatch extends HttpEntityEnclosingRequestBase {
    public HttpPatch(String uri) {
        setURI(URI.create(uri));
    }

    public String getMethod() {
        return Method.PATCH;
    }
}
