package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AbstractAWSSigner;
import com.amazonaws.auth.SigningAlgorithm;
import com.amazonaws.services.s3.Headers;
import com.google.common.net.HttpHeaders;
import java.util.Date;

public class S3QueryStringSigner<T> extends AbstractAWSSigner {
    private final Date expiration;
    private final String httpVerb;
    private final String resourcePath;

    public S3QueryStringSigner(String str, String str2, Date date) {
        this.httpVerb = str;
        this.resourcePath = str2;
        this.expiration = date;
        if (str2 == null) {
            throw new IllegalArgumentException("Parameter resourcePath is empty");
        }
    }

    protected void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addParameter(Headers.SECURITY_TOKEN, aWSSessionCredentials.getSessionToken());
    }

    public void sign(Request<?> request, AWSCredentials aWSCredentials) throws AmazonClientException {
        AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
        if (sanitizeCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
        }
        String l = Long.toString(this.expiration.getTime() / 1000);
        String signAndBase64Encode = super.signAndBase64Encode(RestUtils.makeS3CanonicalString(this.httpVerb, this.resourcePath, request, l), sanitizeCredentials.getAWSSecretKey(), SigningAlgorithm.HmacSHA1);
        request.addParameter("AWSAccessKeyId", sanitizeCredentials.getAWSAccessKeyId());
        request.addParameter(HttpHeaders.EXPIRES, l);
        request.addParameter("Signature", signAndBase64Encode);
    }
}
