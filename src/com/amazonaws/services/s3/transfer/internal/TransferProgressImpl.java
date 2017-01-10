package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.transfer.TransferProgress;

public class TransferProgressImpl extends TransferProgress {
    public void setBytesTransfered(long j) {
        this.bytesTransfered = j;
    }

    public void setTotalBytesToTransfer(long j) {
        this.totalBytesToTransfer = j;
    }

    public synchronized void updateProgress(long j) {
        this.bytesTransfered += j;
    }
}
