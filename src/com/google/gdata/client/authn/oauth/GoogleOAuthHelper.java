package com.google.gdata.client.authn.oauth;

import com.google.gdata.client.authn.oauthproxy.OAuthProxyRequest;

public class GoogleOAuthHelper extends OAuthHelper {
    private static String accessTokenUrl;
    private static String requestTokenUrl;
    private static String revokeTokenUrl;
    private static String userAuthorizationUrl;

    static {
        requestTokenUrl = OAuthProxyRequest.DEFAULT_REQUEST_TOKEN_URL;
        userAuthorizationUrl = OAuthProxyRequest.DEFAULT_AUTHORIZATION_URL;
        accessTokenUrl = OAuthProxyRequest.DEFAULT_ACCESS_TOKEN_URL;
        revokeTokenUrl = "https://www.google.com/accounts/AuthSubRevokeToken";
    }

    public GoogleOAuthHelper(OAuthSigner signer) {
        super(requestTokenUrl, userAuthorizationUrl, accessTokenUrl, revokeTokenUrl, signer);
    }

    GoogleOAuthHelper(OAuthSigner signer, OAuthHttpClient httpClient) {
        super(requestTokenUrl, userAuthorizationUrl, accessTokenUrl, revokeTokenUrl, signer, httpClient);
    }
}
