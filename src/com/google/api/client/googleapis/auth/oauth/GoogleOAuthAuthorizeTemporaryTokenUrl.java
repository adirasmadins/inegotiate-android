package com.google.api.client.googleapis.auth.oauth;

import com.google.api.client.auth.oauth.OAuthAuthorizeTemporaryTokenUrl;
import com.google.api.client.util.Key;
import com.google.gdata.client.authn.oauthproxy.OAuthProxyRequest;

public final class GoogleOAuthAuthorizeTemporaryTokenUrl extends OAuthAuthorizeTemporaryTokenUrl {
    @Key("hd")
    public String hostedDomain;
    @Key("hl")
    public String language;
    @Key("btmpl")
    public String template;

    public GoogleOAuthAuthorizeTemporaryTokenUrl() {
        super(OAuthProxyRequest.DEFAULT_AUTHORIZATION_URL);
    }
}
