package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class AWS3Signer extends AbstractAWSSigner {
    private static final String AUTHORIZATION_HEADER = "X-Amzn-Authorization";
    private static final String HTTPS_SCHEME = "AWS3-HTTPS";
    private static final String HTTP_SCHEME = "AWS3";
    private static final String NONCE_HEADER = "x-amz-nonce";
    protected static final DateUtils dateUtils;
    private static final Log log;
    private String overriddenDate;

    static {
        dateUtils = new DateUtils();
        log = LogFactory.getLog(AWS3Signer.class);
    }

    private String getSignedHeadersComponent(Request<?> request) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignedHeaders=");
        Object obj = 1;
        for (String str : getHeadersForStringToSign(request)) {
            if (obj == null) {
                stringBuilder.append(";");
            }
            stringBuilder.append(str);
            obj = null;
        }
        return stringBuilder.toString();
    }

    protected void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addHeader(Headers.SECURITY_TOKEN, aWSSessionCredentials.getSessionToken());
    }

    protected String getCanonicalizedHeadersForStringToSign(Request<?> request) {
        List headersForStringToSign = getHeadersForStringToSign(request);
        for (int i = 0; i < headersForStringToSign.size(); i++) {
            headersForStringToSign.set(i, ((String) headersForStringToSign.get(i)).toLowerCase());
        }
        SortedMap treeMap = new TreeMap();
        for (Entry entry : request.getHeaders().entrySet()) {
            if (headersForStringToSign.contains(((String) entry.getKey()).toLowerCase())) {
                treeMap.put(((String) entry.getKey()).toLowerCase(), entry.getValue());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry2 : treeMap.entrySet()) {
            stringBuilder.append(((String) entry2.getKey()).toLowerCase()).append(":").append((String) entry2.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }

    protected List<String> getHeadersForStringToSign(Request<?> request) {
        List<String> arrayList = new ArrayList();
        for (Entry key : request.getHeaders().entrySet()) {
            String str = (String) key.getKey();
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("x-amz") || toLowerCase.equals("host")) {
                arrayList.add(str);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    void overrideDate(String str) {
        this.overriddenDate = str;
    }

    protected boolean shouldUseHttpsScheme(Request<?> request) throws AmazonClientException {
        try {
            String toLowerCase = request.getEndpoint().toURL().getProtocol().toLowerCase();
            if (toLowerCase.equals("http")) {
                return false;
            }
            if (toLowerCase.equals("https")) {
                return true;
            }
            throw new AmazonClientException("Unknown request endpoint protocol encountered while signing request: " + toLowerCase);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to parse request endpoint during signing", e);
        }
    }

    public void sign(Request<?> request, AWSCredentials aWSCredentials) throws AmazonClientException {
        if (!(aWSCredentials instanceof AnonymousAWSCredentials)) {
            AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
            SigningAlgorithm signingAlgorithm = SigningAlgorithm.HmacSHA256;
            UUID.randomUUID().toString();
            String formatRfc822Date = dateUtils.formatRfc822Date(new Date());
            if (this.overriddenDate != null) {
                formatRfc822Date = this.overriddenDate;
            }
            request.addHeader(HttpHeaders.DATE, formatRfc822Date);
            request.addHeader("X-Amz-Date", formatRfc822Date);
            formatRfc822Date = request.getEndpoint().getHost();
            if (HttpUtils.isUsingNonDefaultPort(request.getEndpoint())) {
                formatRfc822Date = formatRfc822Date + ":" + request.getEndpoint().getPort();
            }
            request.addHeader(HttpHeaders.HOST, formatRfc822Date);
            if (sanitizeCredentials instanceof AWSSessionCredentials) {
                addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
            }
            String str = request.getHttpMethod().toString() + "\n" + getCanonicalizedResourcePath(request.getResourcePath()) + "\n" + getCanonicalizedQueryString(request.getParameters()) + "\n" + getCanonicalizedHeadersForStringToSign(request) + "\n" + getRequestPayloadWithoutQueryParams(request);
            byte[] hash = hash(str);
            log.debug("Calculated StringToSign: " + str);
            str = signAndBase64Encode(hash, sanitizeCredentials.getAWSSecretKey(), signingAlgorithm);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(HTTP_SCHEME).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            stringBuilder.append("AWSAccessKeyId=" + sanitizeCredentials.getAWSAccessKeyId() + ",");
            stringBuilder.append("Algorithm=" + signingAlgorithm.toString() + ",");
            stringBuilder.append(getSignedHeadersComponent(request) + ",");
            stringBuilder.append("Signature=" + str);
            request.addHeader(AUTHORIZATION_HEADER, stringBuilder.toString());
        }
    }
}
