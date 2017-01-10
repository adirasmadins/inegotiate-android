package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SetBucketNotificationConfigurationRequest extends AmazonWebServiceRequest {
    private String bucket;
    private BucketNotificationConfiguration bucketNotificationConfiguration;

    public SetBucketNotificationConfigurationRequest(BucketNotificationConfiguration bucketNotificationConfiguration, String str) {
        this.bucketNotificationConfiguration = bucketNotificationConfiguration;
        this.bucket = str;
    }

    public String getBucket() {
        return this.bucket;
    }

    public BucketNotificationConfiguration getBucketNotificationConfiguration() {
        return this.bucketNotificationConfiguration;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setBucketNotificationConfiguration(BucketNotificationConfiguration bucketNotificationConfiguration) {
        this.bucketNotificationConfiguration = bucketNotificationConfiguration;
    }
}
