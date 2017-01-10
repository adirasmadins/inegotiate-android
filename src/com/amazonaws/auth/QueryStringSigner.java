package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.google.gdata.util.common.base.StringUtil;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

public class QueryStringSigner extends AbstractAWSSigner implements Signer {
    private Date overriddenDate;

    private String calculateStringToSignV1(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        SortedMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(map);
        for (String str : treeMap.keySet()) {
            stringBuilder.append(str);
            stringBuilder.append((String) treeMap.get(str));
        }
        return stringBuilder.toString();
    }

    private String calculateStringToSignV2(Request<?> request) throws AmazonClientException {
        URI endpoint = request.getEndpoint();
        Map parameters = request.getParameters();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("POST").append("\n");
        stringBuilder.append(getCanonicalizedEndpoint(endpoint)).append("\n");
        stringBuilder.append(getCanonicalizedResourcePath(request)).append("\n");
        stringBuilder.append(getCanonicalizedQueryString(parameters));
        return stringBuilder.toString();
    }

    private String getCanonicalizedResourcePath(Request<?> request) {
        String str = StringUtil.EMPTY_STRING;
        if (request.getEndpoint().getPath() != null) {
            str = str + request.getEndpoint().getPath();
        }
        if (request.getResourcePath() != null) {
            if (!(str.length() <= 0 || str.endsWith("/") || request.getResourcePath().startsWith("/"))) {
                str = str + "/";
            }
            str = str + request.getResourcePath();
        }
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        return str.startsWith("//") ? str.substring(1) : str;
    }

    private String getFormattedTimestamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return this.overriddenDate != null ? simpleDateFormat.format(this.overriddenDate) : simpleDateFormat.format(new Date());
    }

    protected void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addParameter("SecurityToken", aWSSessionCredentials.getSessionToken());
    }

    void overrideDate(Date date) {
        this.overriddenDate = date;
    }

    public void sign(Request<?> request, AWSCredentials aWSCredentials) throws AmazonClientException {
        sign(request, SignatureVersion.V2, SigningAlgorithm.HmacSHA256, aWSCredentials);
    }

    public void sign(Request<?> request, SignatureVersion signatureVersion, SigningAlgorithm signingAlgorithm, AWSCredentials aWSCredentials) throws AmazonClientException {
        if (!(aWSCredentials instanceof AnonymousAWSCredentials)) {
            String calculateStringToSignV1;
            AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
            request.addParameter("AWSAccessKeyId", sanitizeCredentials.getAWSAccessKeyId());
            request.addParameter("SignatureVersion", signatureVersion.toString());
            request.addParameter("Timestamp", getFormattedTimestamp());
            if (sanitizeCredentials instanceof AWSSessionCredentials) {
                addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
            }
            if (signatureVersion.equals(SignatureVersion.V1)) {
                calculateStringToSignV1 = calculateStringToSignV1(request.getParameters());
            } else if (signatureVersion.equals(SignatureVersion.V2)) {
                request.addParameter("SignatureMethod", signingAlgorithm.toString());
                calculateStringToSignV1 = calculateStringToSignV2(request);
            } else {
                throw new AmazonClientException("Invalid Signature Version specified");
            }
            request.addParameter("Signature", signAndBase64Encode(calculateStringToSignV1, sanitizeCredentials.getAWSSecretKey(), signingAlgorithm));
        }
    }
}
