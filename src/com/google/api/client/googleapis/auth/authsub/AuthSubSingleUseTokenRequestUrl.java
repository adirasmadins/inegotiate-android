package com.google.api.client.googleapis.auth.authsub;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public final class AuthSubSingleUseTokenRequestUrl extends GenericUrl {
    @Key("hd")
    public String hostedDomain;
    @Key("hl")
    public String language;
    @Key("next")
    public String nextUrl;
    @Key
    public String scope;
    @Key
    public int secure;
    @Key
    public int session;
    @Key("btmpl")
    public String template;

    public static class ResponseUrl extends GenericUrl {
        @Key
        public String token;

        public ResponseUrl(String url) {
            super(url);
        }
    }

    public AuthSubSingleUseTokenRequestUrl() {
        super("https://www.google.com/accounts/AuthSubRequest");
    }
}
