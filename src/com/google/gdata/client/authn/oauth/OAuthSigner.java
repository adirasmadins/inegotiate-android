package com.google.gdata.client.authn.oauth;

public interface OAuthSigner {
    String getSignature(String str, OAuthParameters oAuthParameters) throws OAuthException;

    String getSignatureMethod();
}
