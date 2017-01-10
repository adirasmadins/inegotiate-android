package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

public class GenericBucketRequest extends AmazonWebServiceRequest {
    private final String bucket;

    public GenericBucketRequest(String str) {
        this.bucket = str;
    }

    public String getBucket() {
        return this.bucket;
    }
}
