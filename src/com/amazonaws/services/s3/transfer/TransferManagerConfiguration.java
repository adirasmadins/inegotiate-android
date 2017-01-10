package com.amazonaws.services.s3.transfer;

public class TransferManagerConfiguration {
    private static final int DEFAULT_MINIMUM_UPLOAD_PART_SIZE = 5242880;
    private static final int DEFAULT_MULTIPART_UPLOAD_THRESHOLD = 16777216;
    private long minimumUploadPartSize;
    private int multipartUploadThreshold;

    public TransferManagerConfiguration() {
        this.minimumUploadPartSize = 5242880;
        this.multipartUploadThreshold = DEFAULT_MULTIPART_UPLOAD_THRESHOLD;
    }

    public long getMinimumUploadPartSize() {
        return this.minimumUploadPartSize;
    }

    public long getMultipartUploadThreshold() {
        return (long) this.multipartUploadThreshold;
    }

    public void setMinimumUploadPartSize(long j) {
        this.minimumUploadPartSize = j;
    }

    public void setMultipartUploadThreshold(int i) {
        this.multipartUploadThreshold = i;
    }
}
