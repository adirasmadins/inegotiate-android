package com.google.api.client.googleapis.auth.authsub;

import com.google.api.client.googleapis.auth.AuthKeyValueParser;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Key;
import java.io.IOException;
import java.security.PrivateKey;

public final class AuthSubHelper {
    private final HttpTransport authSubTransport;
    private PrivateKey privateKey;
    private String token;
    private HttpTransport transport;

    public static final class SessionTokenResponse {
        @Key("Token")
        public String sessionToken;
    }

    public static final class TokenInfoResponse {
        @Key("Scope")
        public String scope;
        @Key("Secure")
        public boolean secure;
        @Key("Target")
        public String target;
    }

    public AuthSubHelper() {
        this.authSubTransport = new HttpTransport();
        this.authSubTransport.addParser(AuthKeyValueParser.INSTANCE);
    }

    public void setPrivateKey(PrivateKey privateKey) {
        if (privateKey != this.privateKey) {
            this.privateKey = privateKey;
            updateAuthorizationHeaders();
        }
    }

    public void setTransport(HttpTransport transport) {
        if (transport != this.transport) {
            this.transport = transport;
            updateAuthorizationHeaders();
        }
    }

    public void setToken(String token) {
        if (token != this.token) {
            this.token = token;
            updateAuthorizationHeaders();
        }
    }

    public String exchangeForSessionToken() throws IOException {
        HttpRequest request = this.authSubTransport.buildGetRequest();
        request.setUrl("https://www.google.com/accounts/AuthSubSessionToken");
        String sessionToken = ((SessionTokenResponse) request.execute().parseAs(SessionTokenResponse.class)).sessionToken;
        setToken(sessionToken);
        return sessionToken;
    }

    public void revokeSessionToken() throws IOException {
        HttpRequest request = this.authSubTransport.buildGetRequest();
        request.setUrl("https://www.google.com/accounts/AuthSubRevokeToken");
        request.execute().ignore();
        setToken(null);
    }

    public TokenInfoResponse requestTokenInfo() throws IOException {
        HttpRequest request = this.authSubTransport.buildGetRequest();
        request.setUrl("https://www.google.com/accounts/AuthSubTokenInfo");
        HttpResponse response = request.execute();
        if (response.getParser() != null) {
            return (TokenInfoResponse) response.parseAs(TokenInfoResponse.class);
        }
        throw new IllegalStateException(response.parseAsString());
    }

    private void updateAuthorizationHeaders() {
        HttpTransport transport = this.transport;
        if (transport != null) {
            setAuthorizationHeaderOf(transport);
        }
        HttpTransport authSubTransport = this.authSubTransport;
        if (authSubTransport != null) {
            setAuthorizationHeaderOf(authSubTransport);
        }
    }

    private void setAuthorizationHeaderOf(HttpTransport transoprt) {
        this.transport.intercepters.add(new AuthSubIntercepter(this.token, this.privateKey));
    }
}
