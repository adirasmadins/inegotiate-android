package com.amazonaws.services.s3.transfer;

public abstract class TransferProgress {
    protected volatile long bytesTransfered;
    protected volatile long totalBytesToTransfer;

    public TransferProgress() {
        this.bytesTransfered = 0;
        this.totalBytesToTransfer = -1;
    }

    public long getBytesTransfered() {
        return this.bytesTransfered;
    }

    public synchronized double getPercentTransfered() {
        return getBytesTransfered() < 0 ? 0.0d : (((double) getBytesTransfered()) / ((double) getTotalBytesToTransfer())) * 100.0d;
    }

    public long getTotalBytesToTransfer() {
        return this.totalBytesToTransfer;
    }
}
