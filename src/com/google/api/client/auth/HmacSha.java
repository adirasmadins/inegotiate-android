package com.google.api.client.auth;

import com.amazonaws.services.s3.internal.Constants;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Strings;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class HmacSha {
    public static String sign(String key, String data) throws GeneralSecurityException {
        SecretKey secretKey = new SecretKeySpec(Strings.toBytesUtf8(key), Constants.HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(Constants.HMAC_SHA1_ALGORITHM);
        mac.init(secretKey);
        return Strings.fromBytesUtf8(Base64.encode(mac.doFinal(Strings.toBytesUtf8(data))));
    }

    private HmacSha() {
    }
}
