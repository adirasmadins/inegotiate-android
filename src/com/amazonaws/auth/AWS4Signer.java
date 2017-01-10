package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.HttpUtils;
import com.google.common.net.HttpHeaders;
import java.io.InputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class AWS4Signer extends AbstractAWSSigner {
    private static final String ALGORITHM = "AWS4-HMAC-SHA256";
    private static final String TERMINATOR = "aws4_request";
    private static final Log log;
    private Date overriddenDate;
    private String regionName;
    private String serviceName;

    static {
        log = LogFactory.getLog(AWS4Signer.class);
    }

    private String extractRegionName(URI uri) {
        return this.regionName != null ? this.regionName : AwsHostNameUtils.parseRegionName(uri);
    }

    private String extractServiceName(URI uri) {
        return this.serviceName != null ? this.serviceName : AwsHostNameUtils.parseServiceName(uri);
    }

    private String getCanonicalizedHeaderString(Request<?> request) {
        List<String> arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : arrayList) {
            stringBuilder.append(str.toLowerCase().replaceAll("\\s+", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR) + ":" + ((String) request.getHeaders().get(str)).replaceAll("\\s+", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private String getSignedHeadersString(Request<?> request) {
        List<String> arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : arrayList) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(";");
            }
            stringBuilder.append(str.toLowerCase());
        }
        return stringBuilder.toString();
    }

    protected void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addHeader(Headers.SECURITY_TOKEN, aWSSessionCredentials.getSessionToken());
    }

    void overrideDate(Date date) {
        this.overriddenDate = date;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void sign(Request<?> request, AWSCredentials aWSCredentials) throws AmazonClientException {
        if (!(aWSCredentials instanceof AnonymousAWSCredentials)) {
            AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
            if (sanitizeCredentials instanceof AWSSessionCredentials) {
                addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "UTC"));
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
            simpleDateFormat2.setTimeZone(new SimpleTimeZone(0, "UTC"));
            String extractRegionName = extractRegionName(request.getEndpoint());
            String extractServiceName = extractServiceName(request.getEndpoint());
            String host = request.getEndpoint().getHost();
            if (HttpUtils.isUsingNonDefaultPort(request.getEndpoint())) {
                host = host + ":" + request.getEndpoint().getPort();
            }
            request.addHeader(HttpHeaders.HOST, host);
            Date date = new Date();
            if (this.overriddenDate != null) {
                date = this.overriddenDate;
            }
            String format = simpleDateFormat2.format(date);
            host = simpleDateFormat.format(date);
            InputStream binaryRequestPayloadStream = getBinaryRequestPayloadStream(request);
            binaryRequestPayloadStream.mark(-1);
            String toHex = BinaryUtils.toHex(hash(binaryRequestPayloadStream));
            try {
                binaryRequestPayloadStream.reset();
                request.addHeader("X-Amz-Date", format);
                request.addHeader("x-amz-content-sha256", toHex);
                String str = request.getHttpMethod().toString() + "\n" + super.getCanonicalizedResourcePath(request.getResourcePath()) + "\n" + getCanonicalizedQueryString((Request) request) + "\n" + getCanonicalizedHeaderString(request) + "\n" + getSignedHeadersString(request) + "\n" + toHex;
                log.debug("AWS4 Canonical Request: '\"" + str + "\"");
                toHex = host + "/" + extractRegionName + "/" + extractServiceName + "/" + TERMINATOR;
                String str2 = sanitizeCredentials.getAWSAccessKeyId() + "/" + toHex;
                str = "AWS4-HMAC-SHA256\n" + format + "\n" + toHex + "\n" + BinaryUtils.toHex(hash(str));
                log.debug("AWS4 String to Sign: '\"" + str + "\"");
                byte[] sign = sign(str.getBytes(), sign(TERMINATOR, sign(extractServiceName, sign(extractRegionName, sign(host, ("AWS4" + sanitizeCredentials.getAWSSecretKey()).getBytes(), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256);
                String str3 = "Credential=" + str2;
                str = "SignedHeaders=" + getSignedHeadersString(request);
                request.addHeader(HttpHeaders.AUTHORIZATION, "AWS4-HMAC-SHA256 " + str3 + ", " + str + ", " + ("Signature=" + BinaryUtils.toHex(sign)));
            } catch (Throwable e) {
                throw new AmazonClientException("Unable to reset stream after calculating AWS4 signature", e);
            }
        }
    }
}
