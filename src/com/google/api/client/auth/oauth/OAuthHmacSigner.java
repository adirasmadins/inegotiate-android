package com.google.api.client.auth.oauth;

import com.google.api.client.auth.HmacSha;
import java.security.GeneralSecurityException;

public final class OAuthHmacSigner implements OAuthSigner {
    public String clientSharedSecret;
    public String tokenSharedSecret;

    public String getSignatureMethod() {
        return "HMAC-SHA1";
    }

    public String computeSignature(String signatureBaseString) throws GeneralSecurityException {
        StringBuilder keyBuf = new StringBuilder();
        String clientSharedSecret = this.clientSharedSecret;
        if (clientSharedSecret != null) {
            keyBuf.append(OAuthParameters.escape(clientSharedSecret));
        }
        keyBuf.append('&');
        String tokenSharedSecret = this.tokenSharedSecret;
        if (tokenSharedSecret != null) {
            keyBuf.append(OAuthParameters.escape(tokenSharedSecret));
        }
        return HmacSha.sign(keyBuf.toString(), signatureBaseString);
    }
}
