package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

public class AbortMultipartUploadRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private String key;
    private String uploadId;

    public AbortMultipartUploadRequest(String str, String str2, String str3) {
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

    public String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public AbortMultipartUploadRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public AbortMultipartUploadRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public AbortMultipartUploadRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }
}
