package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.internal.InputSubstream;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import java.io.File;

public class UploadPartRequestFactory {
    private final String bucketName;
    private final File file;
    private final String key;
    private long offset;
    private final long optimalPartSize;
    private int partNumber;
    private final PutObjectRequest putObjectRequest;
    private long remainingBytes;
    private final String uploadId;

    public UploadPartRequestFactory(PutObjectRequest putObjectRequest, String str, long j) {
        this.partNumber = 1;
        this.offset = 0;
        this.putObjectRequest = putObjectRequest;
        this.uploadId = str;
        this.optimalPartSize = j;
        this.bucketName = putObjectRequest.getBucketName();
        this.key = putObjectRequest.getKey();
        this.file = TransferManagerUtils.getRequestFile(putObjectRequest);
        this.remainingBytes = TransferManagerUtils.getContentLength(putObjectRequest);
    }

    public synchronized UploadPartRequest getNextUploadPartRequest() {
        UploadPartRequest withInputStream;
        long min = Math.min(this.optimalPartSize, this.remainingBytes);
        boolean z = this.remainingBytes - min <= 0;
        int i;
        if (this.putObjectRequest.getInputStream() != null) {
            withInputStream = new UploadPartRequest().withBucketName(this.bucketName).withKey(this.key).withUploadId(this.uploadId).withInputStream(new InputSubstream(this.putObjectRequest.getInputStream(), 0, min, z));
            i = this.partNumber;
            this.partNumber = i + 1;
            withInputStream = withInputStream.withPartNumber(i).withPartSize(min);
        } else {
            withInputStream = new UploadPartRequest().withBucketName(this.bucketName).withKey(this.key).withUploadId(this.uploadId).withFile(this.file).withFileOffset(this.offset);
            i = this.partNumber;
            this.partNumber = i + 1;
            withInputStream = withInputStream.withPartNumber(i).withPartSize(min);
        }
        this.offset += min;
        this.remainingBytes -= min;
        withInputStream.setLastPart(z);
        withInputStream.setProgressListener(this.putObjectRequest.getProgressListener());
        return withInputStream;
    }

    public synchronized boolean hasMoreRequests() {
        return this.remainingBytes > 0;
    }
}
