package com.amazonaws.services.ec2.model;

public class S3Storage {
    private String aWSAccessKeyId;
    private String bucket;
    private String prefix;
    private String uploadPolicy;
    private String uploadPolicySignature;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof S3Storage)) {
            return false;
        }
        S3Storage s3Storage = (S3Storage) obj;
        if (((s3Storage.getBucket() == null ? 1 : 0) ^ (getBucket() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (s3Storage.getBucket() != null && !s3Storage.getBucket().equals(getBucket())) {
            return false;
        }
        if (((s3Storage.getPrefix() == null ? 1 : 0) ^ (getPrefix() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (s3Storage.getPrefix() != null && !s3Storage.getPrefix().equals(getPrefix())) {
            return false;
        }
        if (((s3Storage.getAWSAccessKeyId() == null ? 1 : 0) ^ (getAWSAccessKeyId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (s3Storage.getAWSAccessKeyId() != null && !s3Storage.getAWSAccessKeyId().equals(getAWSAccessKeyId())) {
            return false;
        }
        if (((s3Storage.getUploadPolicy() == null ? 1 : 0) ^ (getUploadPolicy() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (s3Storage.getUploadPolicy() != null && !s3Storage.getUploadPolicy().equals(getUploadPolicy())) {
            return false;
        }
        return ((s3Storage.getUploadPolicySignature() == null ? 1 : 0) ^ (getUploadPolicySignature() == null ? 1 : 0)) == 0 ? s3Storage.getUploadPolicySignature() == null || s3Storage.getUploadPolicySignature().equals(getUploadPolicySignature()) : false;
    }

    public String getAWSAccessKeyId() {
        return this.aWSAccessKeyId;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getUploadPolicy() {
        return this.uploadPolicy;
    }

    public String getUploadPolicySignature() {
        return this.uploadPolicySignature;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getUploadPolicy() == null ? 0 : getUploadPolicy().hashCode()) + (((getAWSAccessKeyId() == null ? 0 : getAWSAccessKeyId().hashCode()) + (((getPrefix() == null ? 0 : getPrefix().hashCode()) + (((getBucket() == null ? 0 : getBucket().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getUploadPolicySignature() != null) {
            i = getUploadPolicySignature().hashCode();
        }
        return hashCode + i;
    }

    public void setAWSAccessKeyId(String str) {
        this.aWSAccessKeyId = str;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setUploadPolicy(String str) {
        this.uploadPolicy = str;
    }

    public void setUploadPolicySignature(String str) {
        this.uploadPolicySignature = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.bucket != null) {
            stringBuilder.append("Bucket: " + this.bucket + ", ");
        }
        if (this.prefix != null) {
            stringBuilder.append("Prefix: " + this.prefix + ", ");
        }
        if (this.aWSAccessKeyId != null) {
            stringBuilder.append("AWSAccessKeyId: " + this.aWSAccessKeyId + ", ");
        }
        if (this.uploadPolicy != null) {
            stringBuilder.append("UploadPolicy: " + this.uploadPolicy + ", ");
        }
        if (this.uploadPolicySignature != null) {
            stringBuilder.append("UploadPolicySignature: " + this.uploadPolicySignature + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public S3Storage withAWSAccessKeyId(String str) {
        this.aWSAccessKeyId = str;
        return this;
    }

    public S3Storage withBucket(String str) {
        this.bucket = str;
        return this;
    }

    public S3Storage withPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public S3Storage withUploadPolicy(String str) {
        this.uploadPolicy = str;
        return this;
    }

    public S3Storage withUploadPolicySignature(String str) {
        this.uploadPolicySignature = str;
        return this;
    }
}
