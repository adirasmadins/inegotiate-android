package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;

public class InitiateMultipartUploadResult implements ServerSideEncryptionResult {
    private String bucketName;
    private String key;
    private String serverSideEncryption;
    private String uploadId;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public String getServerSideEncryption() {
        return this.serverSideEncryption;
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

    public void setServerSideEncryption(String str) {
        this.serverSideEncryption = str;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
