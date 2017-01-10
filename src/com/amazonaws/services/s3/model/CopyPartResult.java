package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import java.util.Date;

public class CopyPartResult implements ServerSideEncryptionResult {
    private String etag;
    private Date lastModifiedDate;
    private int partNumber;
    private String serverSideEncryption;
    private String versionId;

    public String getETag() {
        return this.etag;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public String getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setETag(String str) {
        this.etag = str;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public void setServerSideEncryption(String str) {
        this.serverSideEncryption = str;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }
}
