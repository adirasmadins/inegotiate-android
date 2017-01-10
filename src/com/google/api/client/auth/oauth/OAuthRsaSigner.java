package com.google.api.client.auth.oauth;

import com.google.api.client.auth.RsaSha;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;

public final class OAuthRsaSigner implements OAuthSigner {
    public PrivateKey privateKey;

    public String getSignatureMethod() {
        return "RSA-SHA1";
    }

    public String computeSignature(String signatureBaseString) throws GeneralSecurityException {
        return RsaSha.sign(this.privateKey, signatureBaseString);
    }
}
