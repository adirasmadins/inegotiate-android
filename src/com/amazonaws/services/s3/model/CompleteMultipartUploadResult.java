package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import java.util.Date;

public class CompleteMultipartUploadResult implements ServerSideEncryptionResult, ObjectExpirationResult {
    private String bucketName;
    private String eTag;
    private Date expirationTime;
    private String expirationTimeRuleId;
    private String key;
    private String location;
    private String serverSideEncryption;
    private String versionId;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getETag() {
        return this.eTag;
    }

    public Date getExpirationTime() {
        return this.expirationTime;
    }

    public String getExpirationTimeRuleId() {
        return this.expirationTimeRuleId;
    }

    public String getKey() {
        return this.key;
    }

    public String getLocation() {
        return this.location;
    }

    public String getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setExpirationTime(Date date) {
        this.expirationTime = date;
    }

    public void setExpirationTimeRuleId(String str) {
        this.expirationTimeRuleId = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setServerSideEncryption(String str) {
        this.serverSideEncryption = str;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }
}
