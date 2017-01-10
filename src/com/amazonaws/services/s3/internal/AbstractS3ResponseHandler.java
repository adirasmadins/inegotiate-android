package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.google.common.net.HttpHeaders;
import com.google.gdata.client.GDataProtocol.Header;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractS3ResponseHandler<T> implements HttpResponseHandler<AmazonWebServiceResponse<T>> {
    private static final Set<String> ignoredHeaders;
    private static final Log log;

    static {
        log = LogFactory.getLog(S3MetadataResponseHandler.class);
        ignoredHeaders = new HashSet();
        ignoredHeaders.add(HttpHeaders.DATE);
        ignoredHeaders.add(HttpHeaders.SERVER);
        ignoredHeaders.add(Headers.REQUEST_ID);
        ignoredHeaders.add(Headers.EXTENDED_REQUEST_ID);
    }

    public boolean needsConnectionLeftOpen() {
        return false;
    }

    protected AmazonWebServiceResponse<T> parseResponseMetadata(HttpResponse httpResponse) {
        AmazonWebServiceResponse<T> amazonWebServiceResponse = new AmazonWebServiceResponse();
        String str = (String) httpResponse.getHeaders().get(Headers.REQUEST_ID);
        String str2 = (String) httpResponse.getHeaders().get(Headers.EXTENDED_REQUEST_ID);
        Map hashMap = new HashMap();
        hashMap.put(ResponseMetadata.AWS_REQUEST_ID, str);
        hashMap.put(S3ResponseMetadata.HOST_ID, str2);
        amazonWebServiceResponse.setResponseMetadata(new S3ResponseMetadata(hashMap));
        return amazonWebServiceResponse;
    }

    protected void populateObjectMetadata(HttpResponse httpResponse, ObjectMetadata objectMetadata) {
        for (Entry entry : httpResponse.getHeaders().entrySet()) {
            String str = (String) entry.getKey();
            if (str.startsWith(Headers.S3_USER_METADATA_PREFIX)) {
                objectMetadata.addUserMetadata(str.substring(Headers.S3_USER_METADATA_PREFIX.length()), (String) entry.getValue());
            } else if (!ignoredHeaders.contains(str)) {
                if (str.equals(Header.LAST_MODIFIED)) {
                    try {
                        objectMetadata.setHeader(str, ServiceUtils.parseRfc822Date((String) entry.getValue()));
                    } catch (Throwable e) {
                        log.warn("Unable to parse last modified date: " + ((String) entry.getValue()), e);
                    }
                } else if (str.equals(HttpHeaders.CONTENT_LENGTH)) {
                    try {
                        objectMetadata.setHeader(str, Long.valueOf(Long.parseLong((String) entry.getValue())));
                    } catch (Throwable e2) {
                        log.warn("Unable to parse content length: " + ((String) entry.getValue()), e2);
                    }
                } else if (str.equals(Header.ETAG)) {
                    objectMetadata.setHeader(str, ServiceUtils.removeQuotes((String) entry.getValue()));
                } else if (str.equals(Headers.EXPIRATION)) {
                    new ObjectExpirationHeaderHandler().handle((ObjectExpirationResult) objectMetadata, httpResponse);
                } else {
                    objectMetadata.setHeader(str, entry.getValue());
                }
            }
        }
    }
}
