package com.amazonaws.services.s3.model;

import java.io.InputStream;

public class S3Object {
    private static final long serialVersionUID = -2883501141593631181L;
    private String bucketName;
    private String key;
    private ObjectMetadata metadata;
    private S3ObjectInputStream objectContent;

    public S3Object() {
        this.key = null;
        this.bucketName = null;
        this.metadata = new ObjectMetadata();
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public S3ObjectInputStream getObjectContent() {
        return this.objectContent;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.metadata;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setObjectContent(S3ObjectInputStream s3ObjectInputStream) {
        this.objectContent = s3ObjectInputStream;
    }

    public void setObjectContent(InputStream inputStream) {
        setObjectContent(new S3ObjectInputStream(inputStream, this.objectContent != null ? this.objectContent.getHttpRequest() : null));
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public String toString() {
        return "S3Object [key=" + getKey() + ",bucket=" + (this.bucketName == null ? "<Unknown>" : this.bucketName) + "]";
    }
}
