package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.MultipleFileDownload;
import com.amazonaws.services.s3.transfer.Transfer;
import com.amazonaws.services.s3.transfer.TransferProgress;
import java.io.IOException;
import java.util.Collection;

public class MultipleFileDownloadImpl extends MultipleFileTransfer implements MultipleFileDownload {
    private final String bucketName;
    private final String keyPrefix;

    public MultipleFileDownloadImpl(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, String str2, String str3, Collection<? extends Download> collection) {
        super(str, transferProgress, progressListenerChain, collection);
        this.keyPrefix = str2;
        this.bucketName = str3;
    }

    public void abort() throws IOException {
        for (Transfer transfer : this.subTransfers) {
            ((Download) transfer).abort();
        }
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
