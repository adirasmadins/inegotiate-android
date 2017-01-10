package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;

public class UploadPartResult implements ServerSideEncryptionResult {
    private String eTag;
    private int partNumber;
    private String serverSideEncryption;

    public String getETag() {
        return this.eTag;
    }

    public PartETag getPartETag() {
        return new PartETag(this.partNumber, this.eTag);
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public String getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public void setServerSideEncryption(String str) {
        this.serverSideEncryption = str;
    }
}
