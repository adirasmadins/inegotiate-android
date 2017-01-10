package com.google.api.client.googleapis.auth.oauth;

import com.google.api.client.auth.oauth.OAuthGetTemporaryToken;
import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.util.Key;
import com.google.gdata.client.authn.oauthproxy.OAuthProxyRequest;

public final class GoogleOAuthGetTemporaryToken extends OAuthGetTemporaryToken {
    @Key("xoauth_displayname")
    public String displayName;
    @Key
    public String scope;

    public GoogleOAuthGetTemporaryToken() {
        super(OAuthProxyRequest.DEFAULT_REQUEST_TOKEN_URL);
    }

    public OAuthParameters createParameters() {
        OAuthParameters result = super.createParameters();
        result.callback = this.callback;
        return result;
    }
}
