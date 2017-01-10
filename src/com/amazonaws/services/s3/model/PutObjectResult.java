package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import java.util.Date;

public class PutObjectResult implements ServerSideEncryptionResult, ObjectExpirationResult {
    private String eTag;
    private Date expirationTime;
    private String expirationTimeRuleId;
    private String serverSideEncryption;
    private String versionId;

    public String getETag() {
        return this.eTag;
    }

    public Date getExpirationTime() {
        return this.expirationTime;
    }

    public String getExpirationTimeRuleId() {
        return this.expirationTimeRuleId;
    }

    public String getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public String getVersionId() {
        return this.versionId;
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

    public void setServerSideEncryption(String str) {
        this.serverSideEncryption = str;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }
}
