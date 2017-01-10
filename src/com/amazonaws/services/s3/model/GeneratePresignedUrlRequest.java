package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.HttpMethod;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GeneratePresignedUrlRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private String contentType;
    private Date expiration;
    private String key;
    private HttpMethod method;
    private Map<String, String> requestParameters;
    private ResponseHeaderOverrides responseHeaders;

    public GeneratePresignedUrlRequest(String str, String str2) {
        this(str, str2, HttpMethod.GET);
    }

    public GeneratePresignedUrlRequest(String str, String str2, HttpMethod httpMethod) {
        this.requestParameters = new HashMap();
        this.bucketName = str;
        this.key = str2;
        this.method = httpMethod;
    }

    public void addRequestParameter(String str, String str2) {
        this.requestParameters.put(str, str2);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Date getExpiration() {
        return this.expiration;
    }

    public String getKey() {
        return this.key;
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public Map<String, String> getRequestParameters() {
        return this.requestParameters;
    }

    public ResponseHeaderOverrides getResponseHeaders() {
        return this.responseHeaders;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setExpiration(Date date) {
        this.expiration = date;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMethod(HttpMethod httpMethod) {
        this.method = httpMethod;
    }

    public void setResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        this.responseHeaders = responseHeaderOverrides;
    }

    public GeneratePresignedUrlRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GeneratePresignedUrlRequest withContentType(String str) {
        setContentType(str);
        return this;
    }

    public GeneratePresignedUrlRequest withExpiration(Date date) {
        setExpiration(date);
        return this;
    }

    public GeneratePresignedUrlRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public GeneratePresignedUrlRequest withMethod(HttpMethod httpMethod) {
        setMethod(httpMethod);
        return this;
    }

    public GeneratePresignedUrlRequest withResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        setResponseHeaders(responseHeaderOverrides);
        return this;
    }
}
