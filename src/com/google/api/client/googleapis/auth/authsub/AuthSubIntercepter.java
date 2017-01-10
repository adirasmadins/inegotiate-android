package com.google.api.client.googleapis.auth.authsub;

import com.google.api.client.http.HttpExecuteIntercepter;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;

final class AuthSubIntercepter implements HttpExecuteIntercepter {
    private final PrivateKey privateKey;
    private final String token;

    AuthSubIntercepter(String token, PrivateKey privateKey) {
        this.token = token;
        this.privateKey = privateKey;
    }

    public void intercept(HttpRequest request) throws IOException {
        try {
            String header;
            String token = this.token;
            PrivateKey privateKey = this.privateKey;
            if (token == null) {
                header = null;
            } else if (privateKey == null) {
                header = AuthSub.getAuthorizationHeaderValue(token);
            } else {
                header = AuthSub.getAuthorizationHeaderValue(token, privateKey, request.method, request.url.build());
            }
            request.headers.authorization = header;
        } catch (GeneralSecurityException e) {
            IOException wrap = new IOException();
            wrap.initCause(e);
            throw wrap;
        }
    }
}
