package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringInputStream;
import com.google.gdata.util.common.base.StringUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public abstract class AbstractAWSSigner implements Signer {
    protected static final String DEFAULT_ENCODING = "UTF-8";

    protected abstract void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials);

    protected byte[] getBinaryRequestPayload(Request<?> request) {
        if (!HttpUtils.usePayloadForQueryParameters(request)) {
            return getBinaryRequestPayloadWithoutQueryParams(request);
        }
        String encodeParameters = HttpUtils.encodeParameters(request);
        if (encodeParameters == null) {
            return new byte[0];
        }
        try {
            return encodeParameters.getBytes(DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new AmazonClientException("Unable to encode string into bytes");
        }
    }

    protected InputStream getBinaryRequestPayloadStream(Request<?> request) {
        if (!HttpUtils.usePayloadForQueryParameters(request)) {
            return getBinaryRequestPayloadStreamWithoutQueryParams(request);
        }
        String encodeParameters = HttpUtils.encodeParameters(request);
        if (encodeParameters == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        try {
            return new ByteArrayInputStream(encodeParameters.getBytes(DEFAULT_ENCODING));
        } catch (UnsupportedEncodingException e) {
            throw new AmazonClientException("Unable to encode string into bytes");
        }
    }

    protected InputStream getBinaryRequestPayloadStreamWithoutQueryParams(Request<?> request) {
        try {
            InputStream content = request.getContent();
            if (content == null) {
                return new ByteArrayInputStream(new byte[0]);
            }
            if (content instanceof StringInputStream) {
                return (StringInputStream) content;
            }
            if (content.markSupported()) {
                return request.getContent();
            }
            throw new AmazonClientException("Unable to read request payload to sign request.");
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e.getMessage(), e);
        }
    }

    protected byte[] getBinaryRequestPayloadWithoutQueryParams(Request<?> request) {
        InputStream binaryRequestPayloadStreamWithoutQueryParams = getBinaryRequestPayloadStreamWithoutQueryParams(request);
        try {
            binaryRequestPayloadStreamWithoutQueryParams.mark(-1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[5120];
            while (true) {
                int read = binaryRequestPayloadStreamWithoutQueryParams.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.close();
                    binaryRequestPayloadStreamWithoutQueryParams.reset();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e.getMessage(), e);
        }
    }

    protected String getCanonicalizedEndpoint(URI uri) {
        String toLowerCase = uri.getHost().toLowerCase();
        return HttpUtils.isUsingNonDefaultPort(uri) ? toLowerCase + ":" + uri.getPort() : toLowerCase;
    }

    protected String getCanonicalizedQueryString(Request<?> request) {
        return HttpUtils.usePayloadForQueryParameters(request) ? StringUtil.EMPTY_STRING : getCanonicalizedQueryString(request.getParameters());
    }

    protected String getCanonicalizedQueryString(Map<String, String> map) {
        SortedMap treeMap = new TreeMap();
        treeMap.putAll(map);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            stringBuilder.append(HttpUtils.urlEncode(str, false));
            stringBuilder.append("=");
            stringBuilder.append(HttpUtils.urlEncode(str2, false));
            if (it.hasNext()) {
                stringBuilder.append("&");
            }
        }
        return stringBuilder.toString();
    }

    protected String getCanonicalizedResourcePath(String str) {
        return (str == null || str.length() == 0) ? "/" : HttpUtils.urlEncode(str, true);
    }

    protected String getRequestPayload(Request<?> request) {
        return newString(getBinaryRequestPayload(request));
    }

    protected String getRequestPayloadWithoutQueryParams(Request<?> request) {
        return newString(getBinaryRequestPayloadWithoutQueryParams(request));
    }

    protected byte[] hash(InputStream inputStream) throws AmazonClientException {
        try {
            DigestInputStream digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance("SHA-256"));
            do {
            } while (digestInputStream.read(new byte[ProgressEvent.PART_STARTED_EVENT_CODE]) > -1);
            return digestInputStream.getMessageDigest().digest();
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }

    protected byte[] hash(String str) throws AmazonClientException {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes(DEFAULT_ENCODING));
            return instance.digest();
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }

    protected byte[] hash(byte[] bArr) throws AmazonClientException {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }

    protected String newString(byte[] bArr) {
        try {
            return new String(bArr, DEFAULT_ENCODING);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to encode bytes to String", e);
        }
    }

    protected AWSCredentials sanitizeCredentials(AWSCredentials aWSCredentials) {
        String aWSAccessKeyId;
        String aWSSecretKey;
        String str = null;
        synchronized (aWSCredentials) {
            aWSAccessKeyId = aWSCredentials.getAWSAccessKeyId();
            aWSSecretKey = aWSCredentials.getAWSSecretKey();
            if (aWSCredentials instanceof AWSSessionCredentials) {
                str = ((AWSSessionCredentials) aWSCredentials).getSessionToken();
            }
        }
        String trim = aWSSecretKey != null ? aWSSecretKey.trim() : aWSSecretKey;
        aWSSecretKey = aWSAccessKeyId != null ? aWSAccessKeyId.trim() : aWSAccessKeyId;
        if (str != null) {
            str = str.trim();
        }
        return aWSCredentials instanceof AWSSessionCredentials ? new BasicSessionCredentials(aWSSecretKey, trim, str) : new BasicAWSCredentials(aWSSecretKey, trim);
    }

    protected byte[] sign(String str, byte[] bArr, SigningAlgorithm signingAlgorithm) throws AmazonClientException {
        try {
            return sign(str.getBytes(DEFAULT_ENCODING), bArr, signingAlgorithm);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    protected byte[] sign(byte[] bArr, byte[] bArr2, SigningAlgorithm signingAlgorithm) throws AmazonClientException {
        try {
            Mac instance = Mac.getInstance(signingAlgorithm.toString());
            instance.init(new SecretKeySpec(bArr2, signingAlgorithm.toString()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    protected String signAndBase64Encode(String str, String str2, SigningAlgorithm signingAlgorithm) throws AmazonClientException {
        try {
            return signAndBase64Encode(str.getBytes(DEFAULT_ENCODING), str2, signingAlgorithm);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    protected String signAndBase64Encode(byte[] bArr, String str, SigningAlgorithm signingAlgorithm) throws AmazonClientException {
        try {
            return new String(Base64.encodeBase64(sign(bArr, str.getBytes(DEFAULT_ENCODING), signingAlgorithm)));
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }
}
