package com.google.api.client.googleapis.auth.oauth;

import com.google.api.client.auth.oauth.OAuthGetAccessToken;
import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.gdata.client.authn.oauthproxy.OAuthProxyRequest;
import java.io.IOException;

public final class GoogleOAuthGetAccessToken extends OAuthGetAccessToken {
    public GoogleOAuthGetAccessToken() {
        super(OAuthProxyRequest.DEFAULT_ACCESS_TOKEN_URL);
    }

    public static void revokeAccessToken(OAuthParameters parameters) throws IOException {
        HttpTransport transport = new HttpTransport();
        parameters.signRequestsUsingAuthorizationHeader(transport);
        HttpRequest request = transport.buildGetRequest();
        request.setUrl("https://www.google.com/accounts/AuthSubRevokeToken");
        request.execute().ignore();
    }
}
