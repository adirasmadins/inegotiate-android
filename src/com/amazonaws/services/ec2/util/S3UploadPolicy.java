package com.amazonaws.services.ec2.util;

import com.google.gdata.util.common.base.StringUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class S3UploadPolicy {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private String policySignature;
    private String policyString;

    public S3UploadPolicy(String str, String str2, String str3, String str4, int i) {
        Calendar instance = Calendar.getInstance();
        instance.add(12, i);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{").append("\"expiration\": \"").append(simpleDateFormat.format(instance.getTime())).append("\",").append("\"conditions\": [").append("{\"bucket\": \"").append(str3).append("\"},").append("{\"acl\": \"").append("ec2-bundle-read").append("\"},").append("[\"starts-with\", \"$key\", \"").append(str4).append("\"]").append("]}");
        try {
            this.policyString = base64Encode(stringBuilder.toString().getBytes(StringEncodings.UTF8));
            this.policySignature = signPolicy(str2, this.policyString);
        } catch (Throwable e) {
            throw new RuntimeException("Unable to generate S3 upload policy", e);
        }
    }

    private String base64Encode(byte[] bArr) throws UnsupportedEncodingException {
        return new String(Base64.encodeBase64(bArr), StringEncodings.UTF8).replaceAll("\\s", StringUtil.EMPTY_STRING);
    }

    private String signPolicy(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Key secretKeySpec = new SecretKeySpec(str.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac instance = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        instance.init(secretKeySpec);
        return base64Encode(instance.doFinal(str2.getBytes()));
    }

    public String getPolicySignature() {
        return this.policySignature;
    }

    public String getPolicyString() {
        return this.policyString;
    }
}
