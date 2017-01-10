package com.google.api.client.auth.oauth;

import com.google.api.client.http.HttpExecuteIntercepter;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;

final class OAuthAuthorizationHeaderIntercepter implements HttpExecuteIntercepter {
    OAuthParameters oauthParameters;

    OAuthAuthorizationHeaderIntercepter() {
    }

    public void intercept(HttpRequest request) throws IOException {
        this.oauthParameters.computeNonce();
        this.oauthParameters.computeTimestamp();
        try {
            this.oauthParameters.computeSignature(request.method, request.url);
            request.headers.authorization = this.oauthParameters.getAuthorizationHeader();
        } catch (GeneralSecurityException e) {
            IOException io = new IOException();
            io.initCause(e);
            throw io;
        }
    }
}
