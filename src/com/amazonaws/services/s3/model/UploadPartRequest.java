package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.File;
import java.io.InputStream;

public class UploadPartRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private File file;
    private long fileOffset;
    private InputStream inputStream;
    private boolean isLastPart;
    private String key;
    private String md5Digest;
    private int partNumber;
    private long partSize;
    private ProgressListener progressListener;
    private String uploadId;

    public String getBucketName() {
        return this.bucketName;
    }

    public File getFile() {
        return this.file;
    }

    public long getFileOffset() {
        return this.fileOffset;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public String getKey() {
        return this.key;
    }

    public String getMd5Digest() {
        return this.md5Digest;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public ProgressListener getProgressListener() {
        return this.progressListener;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public boolean isLastPart() {
        return this.isLastPart;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileOffset(long j) {
        this.fileOffset = j;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLastPart(boolean z) {
        this.isLastPart = z;
    }

    public void setMd5Digest(String str) {
        this.md5Digest = str;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public void setPartSize(long j) {
        this.partSize = j;
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.progressListener = progressListener;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public UploadPartRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public UploadPartRequest withFile(File file) {
        setFile(file);
        return this;
    }

    public UploadPartRequest withFileOffset(long j) {
        setFileOffset(j);
        return this;
    }

    public UploadPartRequest withInputStream(InputStream inputStream) {
        setInputStream(inputStream);
        return this;
    }

    public UploadPartRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public UploadPartRequest withLastPart(boolean z) {
        setLastPart(z);
        return this;
    }

    public UploadPartRequest withMD5Digest(String str) {
        this.md5Digest = str;
        return this;
    }

    public UploadPartRequest withPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadPartRequest withPartSize(long j) {
        this.partSize = j;
        return this;
    }

    public UploadPartRequest withProgressListener(ProgressListener progressListener) {
        setProgressListener(progressListener);
        return this;
    }

    public UploadPartRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }
}
