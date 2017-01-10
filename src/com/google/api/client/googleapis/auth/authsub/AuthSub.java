package com.google.api.client.googleapis.auth.authsub;

import com.google.api.client.auth.RsaSha;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.SecureRandom;

public class AuthSub {
    private static final SecureRandom RANDOM;

    static {
        RANDOM = new SecureRandom();
    }

    public static String getAuthorizationHeaderValue(String token) {
        return getAuthSubTokenPrefix(token).toString();
    }

    public static String getAuthorizationHeaderValue(String token, PrivateKey privateKey, String requestMethod, String requestUrl) throws GeneralSecurityException {
        StringBuilder buf = getAuthSubTokenPrefix(token);
        if (privateKey != null) {
            String algorithm = privateKey.getAlgorithm();
            if ("RSA".equals(algorithm)) {
                long timestamp = System.currentTimeMillis() / 1000;
                String data = requestMethod + ' ' + requestUrl + ' ' + timestamp + ' ' + Math.abs(RANDOM.nextLong());
                buf.append(" sigalg=\"rsa-sha1\" data=\"").append(data).append("\" sig=\"").append(RsaSha.sign(privateKey, data)).append('\"');
            } else {
                throw new IllegalArgumentException("Only supported algorithm for private key is RSA: " + algorithm);
            }
        }
        return buf.toString();
    }

    private static StringBuilder getAuthSubTokenPrefix(String token) {
        return new StringBuilder("AuthSub token=\"").append(token).append('\"');
    }

    private AuthSub() {
    }
}
