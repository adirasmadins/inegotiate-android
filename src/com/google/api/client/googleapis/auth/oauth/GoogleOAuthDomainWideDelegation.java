package com.google.api.client.googleapis.auth.oauth;

import com.google.api.client.googleapis.GoogleUrl;
import com.google.api.client.http.HttpExecuteIntercepter;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Key;
import com.google.gdata.client.authn.oauth.OAuthParameters;

public final class GoogleOAuthDomainWideDelegation implements HttpExecuteIntercepter {
    public String requestorId;

    public static final class Url extends GoogleUrl {
        @Key("xoauth_requestor_id")
        public String requestorId;

        public Url(String encodedUrl) {
            super(encodedUrl);
        }
    }

    public void intercept(HttpRequest request) {
        request.url.set(OAuthParameters.XOAUTH_REQUESTOR_ID_KEY, this.requestorId);
    }

    public void signRequests(HttpTransport transport, com.google.api.client.auth.oauth.OAuthParameters parameters) {
        transport.intercepters.add(this);
        parameters.signRequestsUsingAuthorizationHeader(transport);
    }
}
