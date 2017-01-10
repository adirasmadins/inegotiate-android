package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ListObjectsRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private String delimiter;
    private String marker;
    private Integer maxKeys;
    private String prefix;

    public ListObjectsRequest(String str, String str2, String str3, String str4, Integer num) {
        setBucketName(str);
        setPrefix(str2);
        setMarker(str3);
        setDelimiter(str4);
        setMaxKeys(num);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getMarker() {
        return this.marker;
    }

    public Integer getMaxKeys() {
        return this.maxKeys;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public void setMaxKeys(Integer num) {
        this.maxKeys = num;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public ListObjectsRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public ListObjectsRequest withDelimiter(String str) {
        setDelimiter(str);
        return this;
    }

    public ListObjectsRequest withMarker(String str) {
        setMarker(str);
        return this;
    }

    public ListObjectsRequest withMaxKeys(Integer num) {
        setMaxKeys(num);
        return this;
    }

    public ListObjectsRequest withPrefix(String str) {
        setPrefix(str);
        return this;
    }
}
