package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ListPartsRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private String key;
    private Integer maxParts;
    private Integer partNumberMarker;
    private String uploadId;

    public ListPartsRequest(String str, String str2, String str3) {
        this.bucketName = str;
        this.key = str2;
        this.uploadId = str3;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public Integer getMaxParts() {
        return this.maxParts;
    }

    public Integer getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMaxParts(int i) {
        this.maxParts = Integer.valueOf(i);
    }

    public void setPartNumberMarker(Integer num) {
        this.partNumberMarker = num;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public ListPartsRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public ListPartsRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public ListPartsRequest withMaxParts(int i) {
        this.maxParts = Integer.valueOf(i);
        return this;
    }

    public ListPartsRequest withPartNumberMarker(Integer num) {
        this.partNumberMarker = num;
        return this;
    }

    public ListPartsRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }
}
