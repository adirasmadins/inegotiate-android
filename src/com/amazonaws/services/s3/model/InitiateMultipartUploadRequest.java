package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

public class InitiateMultipartUploadRequest extends AmazonWebServiceRequest {
    private AccessControlList accessControlList;
    private String bucketName;
    private CannedAccessControlList cannedACL;
    private String key;
    public ObjectMetadata objectMetadata;
    private StorageClass storageClass;

    public InitiateMultipartUploadRequest(String str, String str2) {
        this.bucketName = str;
        this.key = str2;
    }

    public InitiateMultipartUploadRequest(String str, String str2, ObjectMetadata objectMetadata) {
        this.bucketName = str;
        this.key = str2;
        this.objectMetadata = objectMetadata;
    }

    public AccessControlList getAccessControlList() {
        return this.accessControlList;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public CannedAccessControlList getCannedACL() {
        return this.cannedACL;
    }

    public String getKey() {
        return this.key;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public StorageClass getStorageClass() {
        return this.storageClass;
    }

    public void setAccessControlList(AccessControlList accessControlList) {
        this.accessControlList = accessControlList;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCannedACL(CannedAccessControlList cannedAccessControlList) {
        this.cannedACL = cannedAccessControlList;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.objectMetadata = objectMetadata;
    }

    public void setStorageClass(StorageClass storageClass) {
        this.storageClass = storageClass;
    }

    public InitiateMultipartUploadRequest withAccessControlList(AccessControlList accessControlList) {
        setAccessControlList(accessControlList);
        return this;
    }

    public InitiateMultipartUploadRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public InitiateMultipartUploadRequest withCannedACL(CannedAccessControlList cannedAccessControlList) {
        this.cannedACL = cannedAccessControlList;
        return this;
    }

    public InitiateMultipartUploadRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public InitiateMultipartUploadRequest withObjectMetadata(ObjectMetadata objectMetadata) {
        setObjectMetadata(objectMetadata);
        return this;
    }

    public InitiateMultipartUploadRequest withStorageClass(StorageClass storageClass) {
        this.storageClass = storageClass;
        return this;
    }
}
