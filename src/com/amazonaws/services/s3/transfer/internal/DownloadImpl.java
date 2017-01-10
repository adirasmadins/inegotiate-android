package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazonaws.services.s3.transfer.TransferProgress;
import java.io.IOException;

public class DownloadImpl extends AbstractTransfer implements Download {
    S3Object s3Object;

    public DownloadImpl(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, S3Object s3Object, TransferStateChangeListener transferStateChangeListener) {
        super(str, transferProgress, progressListenerChain, transferStateChangeListener);
        this.s3Object = s3Object;
    }

    public synchronized void abort() throws IOException {
        this.monitor.getFuture().cancel(true);
        if (this.s3Object != null) {
            this.s3Object.getObjectContent().abort();
        }
        setState(TransferState.Canceled);
    }

    public String getBucketName() {
        return this.s3Object.getBucketName();
    }

    public String getKey() {
        return this.s3Object.getKey();
    }

    public ObjectMetadata getObjectMetadata() {
        return this.s3Object.getObjectMetadata();
    }

    public synchronized void setS3Object(S3Object s3Object) {
        this.s3Object = s3Object;
    }
}
