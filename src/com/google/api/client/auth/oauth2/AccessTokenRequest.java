package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.JsonHttpParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.gdata.model.gd.Reminder.Method;
import java.io.IOException;

public class AccessTokenRequest extends GenericData {
    public String authorizationServerUrl;
    @Key("client_id")
    public String clientId;
    public String clientSecret;
    @Key("grant_type")
    public String grantType;
    @Key
    public String scope;
    public boolean useBasicAuthorization;

    public static class AssertionGrant extends AccessTokenRequest {
        @Key
        public String assertion;
        @Key("assertion_type")
        public String assertionType;

        public AssertionGrant() {
            this.grantType = "assertion";
        }
    }

    public static class AuthorizationCodeGrant extends AccessTokenRequest {
        @Key
        public String code;
        @Key("redirect_uri")
        public String redirectUri;

        public AuthorizationCodeGrant() {
            this.grantType = "authorization_code";
        }
    }

    public static class RefreshTokenGrant extends AccessTokenRequest {
        @Key("refresh_token")
        public String refreshToken;

        public RefreshTokenGrant() {
            this.grantType = "refresh_token";
        }
    }

    public static class ResourceOwnerPasswordCredentialsGrant extends AccessTokenRequest {
        public String password;
        @Key
        public String username;

        public ResourceOwnerPasswordCredentialsGrant() {
            this.grantType = "password";
        }
    }

    public AccessTokenRequest() {
        this.grantType = Method.NONE;
        this.useBasicAuthorization = true;
    }

    public final HttpResponse execute() throws IOException {
        HttpTransport transport = new HttpTransport();
        transport.addParser(new JsonHttpParser());
        HttpRequest request = transport.buildPostRequest();
        if (this.useBasicAuthorization) {
            request.headers.setBasicAuthentication(this.clientId, this.clientSecret);
        } else {
            put("client_secret", (Object) this.clientSecret);
        }
        request.setUrl(this.authorizationServerUrl);
        UrlEncodedContent content = new UrlEncodedContent();
        content.data = this;
        request.content = content;
        return request.execute();
    }
}
