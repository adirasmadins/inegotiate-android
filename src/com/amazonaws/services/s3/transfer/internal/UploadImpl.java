package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.transfer.Upload;
import com.amazonaws.services.s3.transfer.model.UploadResult;
import java.util.concurrent.ExecutionException;

public class UploadImpl extends AbstractTransfer implements Upload {
    public UploadImpl(String str, TransferProgressImpl transferProgressImpl, ProgressListenerChain progressListenerChain, TransferStateChangeListener transferStateChangeListener) {
        super(str, transferProgressImpl, progressListenerChain, transferStateChangeListener);
    }

    public UploadResult waitForUploadResult() throws AmazonClientException, AmazonServiceException, InterruptedException {
        UploadResult uploadResult = null;
        while (true) {
            try {
                if (this.monitor.isDone() && uploadResult != null) {
                    return uploadResult;
                }
                uploadResult = (UploadResult) this.monitor.getFuture().get();
            } catch (ExecutionException e) {
                rethrowExecutionException(e);
                return null;
            }
        }
    }
}
