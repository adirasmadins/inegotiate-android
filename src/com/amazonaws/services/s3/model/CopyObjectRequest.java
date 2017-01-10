package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CopyObjectRequest extends AmazonWebServiceRequest {
    private AccessControlList accessControlList;
    private CannedAccessControlList cannedACL;
    private String destinationBucketName;
    private String destinationKey;
    private List<String> matchingETagConstraints;
    private Date modifiedSinceConstraint;
    private ObjectMetadata newObjectMetadata;
    private List<String> nonmatchingEtagConstraints;
    private String sourceBucketName;
    private String sourceKey;
    private String sourceVersionId;
    private String storageClass;
    private Date unmodifiedSinceConstraint;

    public CopyObjectRequest(String str, String str2, String str3, String str4) {
        this(str, str2, null, str3, str4);
    }

    public CopyObjectRequest(String str, String str2, String str3, String str4, String str5) {
        this.matchingETagConstraints = new ArrayList();
        this.nonmatchingEtagConstraints = new ArrayList();
        this.sourceBucketName = str;
        this.sourceKey = str2;
        this.sourceVersionId = str3;
        this.destinationBucketName = str4;
        this.destinationKey = str5;
    }

    public AccessControlList getAccessControlList() {
        return this.accessControlList;
    }

    public CannedAccessControlList getCannedAccessControlList() {
        return this.cannedACL;
    }

    public String getDestinationBucketName() {
        return this.destinationBucketName;
    }

    public String getDestinationKey() {
        return this.destinationKey;
    }

    public List<String> getMatchingETagConstraints() {
        return this.matchingETagConstraints;
    }

    public Date getModifiedSinceConstraint() {
        return this.modifiedSinceConstraint;
    }

    public ObjectMetadata getNewObjectMetadata() {
        return this.newObjectMetadata;
    }

    public List<String> getNonmatchingETagConstraints() {
        return this.nonmatchingEtagConstraints;
    }

    public String getSourceBucketName() {
        return this.sourceBucketName;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public String getSourceVersionId() {
        return this.sourceVersionId;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public Date getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public void setAccessControlList(AccessControlList accessControlList) {
        this.accessControlList = accessControlList;
    }

    public void setCannedAccessControlList(CannedAccessControlList cannedAccessControlList) {
        this.cannedACL = cannedAccessControlList;
    }

    public void setDestinationBucketName(String str) {
        this.destinationBucketName = str;
    }

    public void setDestinationKey(String str) {
        this.destinationKey = str;
    }

    public void setMatchingETagConstraints(List<String> list) {
        this.matchingETagConstraints = list;
    }

    public void setModifiedSinceConstraint(Date date) {
        this.modifiedSinceConstraint = date;
    }

    public void setNewObjectMetadata(ObjectMetadata objectMetadata) {
        this.newObjectMetadata = objectMetadata;
    }

    public void setNonmatchingETagConstraints(List<String> list) {
        this.nonmatchingEtagConstraints = list;
    }

    public void setSourceBucketName(String str) {
        this.sourceBucketName = str;
    }

    public void setSourceKey(String str) {
        this.sourceKey = str;
    }

    public void setSourceVersionId(String str) {
        this.sourceVersionId = str;
    }

    public void setStorageClass(StorageClass storageClass) {
        this.storageClass = storageClass.toString();
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setUnmodifiedSinceConstraint(Date date) {
        this.unmodifiedSinceConstraint = date;
    }

    public CopyObjectRequest withAccessControlList(AccessControlList accessControlList) {
        setAccessControlList(accessControlList);
        return this;
    }

    public CopyObjectRequest withCannedAccessControlList(CannedAccessControlList cannedAccessControlList) {
        setCannedAccessControlList(cannedAccessControlList);
        return this;
    }

    public CopyObjectRequest withDestinationBucketName(String str) {
        setDestinationBucketName(str);
        return this;
    }

    public CopyObjectRequest withDestinationKey(String str) {
        setDestinationKey(str);
        return this;
    }

    public CopyObjectRequest withMatchingETagConstraint(String str) {
        this.matchingETagConstraints.add(str);
        return this;
    }

    public CopyObjectRequest withModifiedSinceConstraint(Date date) {
        setModifiedSinceConstraint(date);
        return this;
    }

    public CopyObjectRequest withNewObjectMetadata(ObjectMetadata objectMetadata) {
        setNewObjectMetadata(objectMetadata);
        return this;
    }

    public CopyObjectRequest withNonmatchingETagConstraint(String str) {
        this.nonmatchingEtagConstraints.add(str);
        return this;
    }

    public CopyObjectRequest withSourceBucketName(String str) {
        setSourceBucketName(str);
        return this;
    }

    public CopyObjectRequest withSourceKey(String str) {
        setSourceKey(str);
        return this;
    }

    public CopyObjectRequest withSourceVersionId(String str) {
        setSourceVersionId(str);
        return this;
    }

    public CopyObjectRequest withStorageClass(StorageClass storageClass) {
        setStorageClass(storageClass);
        return this;
    }

    public CopyObjectRequest withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    public CopyObjectRequest withUnmodifiedSinceConstraint(Date date) {
        setUnmodifiedSinceConstraint(date);
        return this;
    }
}
