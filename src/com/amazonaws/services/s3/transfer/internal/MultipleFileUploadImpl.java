package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferProgress;
import com.amazonaws.services.s3.transfer.Upload;
import java.util.Collection;

public class MultipleFileUploadImpl extends MultipleFileTransfer implements MultipleFileUpload {
    private final String bucketName;
    private final String keyPrefix;

    public MultipleFileUploadImpl(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, String str2, String str3, Collection<? extends Upload> collection) {
        super(str, transferProgress, progressListenerChain, collection);
        this.keyPrefix = str2;
        this.bucketName = str3;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKeyPrefix() {
        return this.keyPrefix;
    }

    public void waitForCompletion() throws AmazonClientException, AmazonServiceException, InterruptedException {
        if (!this.subTransfers.isEmpty()) {
            super.waitForCompletion();
        }
    }
}
