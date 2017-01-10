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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class S3Signer extends AbstractAWSSigner {
    private static final Log log;
    private final String httpVerb;
    private final String resourcePath;

    static {
        log = LogFactory.getLog(S3Signer.class);
    }

    public S3Signer(String str, String str2) {
        this.httpVerb = str;
        this.resourcePath = str2;
        if (str2 == null) {
            throw new IllegalArgumentException("Parameter resourcePath is empty");
        }
    }

    protected void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addHeader(Headers.SECURITY_TOKEN, aWSSessionCredentials.getSessionToken());
    }

    public void sign(Request<?> request, AWSCredentials aWSCredentials) throws AmazonClientException {
        if (aWSCredentials == null || aWSCredentials.getAWSSecretKey() == null) {
            log.debug("Canonical string will not be signed, as no AWS Secret Key was provided");
            return;
        }
        AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
        if (sanitizeCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
        }
        request.addHeader(HttpHeaders.DATE, ServiceUtils.formatRfc822Date(new Date()));
        String makeS3CanonicalString = RestUtils.makeS3CanonicalString(this.httpVerb, this.resourcePath, request, null);
        log.debug("Calculated string to sign:\n\"" + makeS3CanonicalString + "\"");
        request.addHeader(HttpHeaders.AUTHORIZATION, "AWS " + sanitizeCredentials.getAWSAccessKeyId() + ":" + super.signAndBase64Encode(makeS3CanonicalString, sanitizeCredentials.getAWSSecretKey(), SigningAlgorithm.HmacSHA1));
    }
}
