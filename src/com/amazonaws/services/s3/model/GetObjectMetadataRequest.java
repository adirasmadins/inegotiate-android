package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

public class GetObjectMetadataRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private String key;
    private String versionId;

    public GetObjectMetadataRequest(String str, String str2) {
        setBucketName(str);
        setKey(str2);
    }

    public GetObjectMetadataRequest(String str, String str2, String str3) {
        this(str, str2);
        setVersionId(str3);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public GetObjectMetadataRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GetObjectMetadataRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public GetObjectMetadataRequest withVersionId(String str) {
        setVersionId(str);
        return this;
    }
}
