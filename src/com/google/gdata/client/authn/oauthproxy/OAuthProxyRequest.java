package com.google.gdata.client.authn.oauthproxy;

import com.google.gdata.client.authn.oauthproxy.OAuthProxyProtocol.Header;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class OAuthProxyRequest extends HashMap<String, String> {
    public static final String DEFAULT_ACCESS_TOKEN_URL = "https://www.google.com/accounts/OAuthGetAccessToken";
    public static final String DEFAULT_AUTHORIZATION_URL = "https://www.google.com/accounts/OAuthAuthorizeToken";
    public static final String DEFAULT_REQUEST_TOKEN_URL = "https://www.google.com/accounts/OAuthGetRequestToken";
    public static final String DEFAULT_SERVICE_NAME = "google";
    public static final String DEFAULT_USE_TOKEN = "always";
    private String requestTokenUrl;
    private String scope;

    public OAuthProxyRequest() {
        setAccessTokenUrl(DEFAULT_ACCESS_TOKEN_URL);
        setAuthorizationUrl(DEFAULT_AUTHORIZATION_URL);
        setRequestTokenUrl(DEFAULT_REQUEST_TOKEN_URL);
        setServiceName(DEFAULT_SERVICE_NAME);
        setUseToken(DEFAULT_USE_TOKEN);
    }

    public String getAcessTokenUrl() {
        return (String) get(Header.X_OAUTH_ACCESS_TOKEN_URL);
    }

    public void setAccessTokenUrl(String value) {
        put(Header.X_OAUTH_ACCESS_TOKEN_URL, value);
    }

    public String getAuthorizationUrl() {
        return (String) get(Header.X_OAUTH_AUTHORIZATION_URL);
    }

    public void setAuthorizationUrl(String value) {
        put(Header.X_OAUTH_AUTHORIZATION_URL, value);
    }

    public String getDesiredCallbackUrl() {
        return (String) get(Header.X_OAUTH_DESIRED_CALLBACK_URL);
    }

    public void setDesiredCallbackUrl(String value) {
        put(Header.X_OAUTH_DESIRED_CALLBACK_URL, value);
    }

    public String getReceivedCallbackUrl() {
        return (String) get(Header.X_OAUTH_RECEIVED_CALLBACK_URL);
    }

    public void setReceivedCallbackUrl(String value) {
        put(Header.X_OAUTH_RECEIVED_CALLBACK_URL, value);
    }

    public String getRequestTokenUrl() {
        return (String) get(Header.X_OAUTH_REQUEST_TOKEN_URL);
    }

    public void setRequestTokenUrl(String value) {
        this.requestTokenUrl = value;
        storeRequestTokenUrl();
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String value) {
        this.scope = value;
        storeRequestTokenUrl();
    }

    public String getServiceName() {
        return (String) get(Header.X_OAUTH_SERVICE_NAME);
    }

    public void setServiceName(String value) {
        put(Header.X_OAUTH_SERVICE_NAME, value);
    }

    public String getState() {
        return (String) get(Header.X_OAUTH_STATE);
    }

    public void setState(String value) {
        put(Header.X_OAUTH_STATE, value);
    }

    public String getTokenName() {
        return (String) get(Header.X_OAUTH_TOKEN_NAME);
    }

    public void setTokenName(String value) {
        put(Header.X_OAUTH_TOKEN_NAME, value);
    }

    public String getUseToken() {
        return (String) get(Header.X_OAUTH_USE_TOKEN);
    }

    public void setUseToken(String value) {
        put(Header.X_OAUTH_USE_TOKEN, value);
    }

    private void storeRequestTokenUrl() {
        if (!(this.requestTokenUrl == null || this.scope == null)) {
            this.requestTokenUrl += (this.requestTokenUrl.indexOf(63) == -1 ? "?" : "&");
            try {
                this.requestTokenUrl += "scope=" + URLEncoder.encode(this.scope, StringEncodings.UTF8);
            } catch (UnsupportedEncodingException e) {
                throw new IllegalArgumentException(e);
            }
        }
        put(Header.X_OAUTH_REQUEST_TOKEN_URL, this.requestTokenUrl);
    }
}
