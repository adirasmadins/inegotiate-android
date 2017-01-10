package com.google.gdata.client.authn.oauth;

public class GoogleOAuthParameters extends OAuthParameters {
    public static final String SCOPE_KEY = "scope";

    public String getScope() {
        return get(SCOPE_KEY, this.baseParameters);
    }

    public void setScope(String scope) {
        put(SCOPE_KEY, scope, this.baseParameters);
    }

    public boolean checkScopeExists() {
        return checkExists(SCOPE_KEY, this.baseParameters);
    }

    public void assertScopeExists() throws OAuthException {
        assertExists(SCOPE_KEY, this.baseParameters);
    }

    public void reset() {
        super.reset();
        remove(SCOPE_KEY, this.baseParameters);
    }
}
