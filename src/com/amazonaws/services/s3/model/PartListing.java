package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.List;

public class PartListing {
    private String bucketName;
    private Owner initiator;
    private boolean isTruncated;
    private String key;
    private Integer maxParts;
    private Integer nextPartNumberMarker;
    private Owner owner;
    private Integer partNumberMarker;
    private List<PartSummary> parts;
    private String storageClass;
    private String uploadId;

    public String getBucketName() {
        return this.bucketName;
    }

    public Owner getInitiator() {
        return this.initiator;
    }

    public String getKey() {
        return this.key;
    }

    public Integer getMaxParts() {
        return this.maxParts;
    }

    public Integer getNextPartNumberMarker() {
        return this.nextPartNumberMarker;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public Integer getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public List<PartSummary> getParts() {
        if (this.parts == null) {
            this.parts = new ArrayList();
        }
        return this.parts;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setInitiator(Owner owner) {
        this.initiator = owner;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMaxParts(int i) {
        this.maxParts = Integer.valueOf(i);
    }

    public void setNextPartNumberMarker(int i) {
        this.nextPartNumberMarker = Integer.valueOf(i);
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setPartNumberMarker(int i) {
        this.partNumberMarker = Integer.valueOf(i);
    }

    public void setParts(List<PartSummary> list) {
        this.parts = list;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
