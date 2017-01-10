package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteObjectRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private String key;

    public DeleteObjectRequest(String str, String str2) {
        setBucketName(str);
        setKey(str2);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public DeleteObjectRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public DeleteObjectRequest withKey(String str) {
        setKey(str);
        return this;
    }
}
