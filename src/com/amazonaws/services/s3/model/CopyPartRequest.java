package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CopyPartRequest extends AmazonWebServiceRequest {
    private String destinationBucketName;
    private String destinationKey;
    private Long firstByte;
    private Long lastByte;
    private final List<String> matchingETagConstraints;
    private Date modifiedSinceConstraint;
    private final List<String> nonmatchingEtagConstraints;
    private int partNumber;
    private String sourceBucketName;
    private String sourceKey;
    private String sourceVersionId;
    private Date unmodifiedSinceConstraint;
    private String uploadId;

    public CopyPartRequest() {
        this.matchingETagConstraints = new ArrayList();
        this.nonmatchingEtagConstraints = new ArrayList();
    }

    public String getDestinationBucketName() {
        return this.destinationBucketName;
    }

    public String getDestinationKey() {
        return this.destinationKey;
    }

    public Long getFirstByte() {
        return this.firstByte;
    }

    public Long getLastByte() {
        return this.lastByte;
    }

    public List<String> getMatchingETagConstraints() {
        return this.matchingETagConstraints;
    }

    public Date getModifiedSinceConstraint() {
        return this.modifiedSinceConstraint;
    }

    public List<String> getNonmatchingETagConstraints() {
        return this.nonmatchingEtagConstraints;
    }

    public int getPartNumber() {
        return this.partNumber;
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

    public Date getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setDestinationBucketName(String str) {
        this.destinationBucketName = str;
    }

    public void setDestinationKey(String str) {
        this.destinationKey = str;
    }

    public void setFirstByte(Long l) {
        this.firstByte = l;
    }

    public void setLastByte(Long l) {
        this.lastByte = l;
    }

    public void setMatchingETagConstraints(List<String> list) {
        this.matchingETagConstraints.clear();
        this.matchingETagConstraints.addAll(list);
    }

    public void setModifiedSinceConstraint(Date date) {
        this.modifiedSinceConstraint = date;
    }

    public void setNonmatchingETagConstraints(List<String> list) {
        this.nonmatchingEtagConstraints.clear();
        this.nonmatchingEtagConstraints.addAll(list);
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
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

    public void setUnmodifiedSinceConstraint(Date date) {
        this.unmodifiedSinceConstraint = date;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public CopyPartRequest withDestinationBucketName(String str) {
        setDestinationBucketName(str);
        return this;
    }

    public CopyPartRequest withDestinationKey(String str) {
        setDestinationKey(str);
        return this;
    }

    public CopyPartRequest withFirstByte(Long l) {
        this.firstByte = l;
        return this;
    }

    public CopyPartRequest withLastByte(Long l) {
        this.lastByte = l;
        return this;
    }

    public CopyPartRequest withMatchingETagConstraint(String str) {
        this.matchingETagConstraints.add(str);
        return this;
    }

    public CopyPartRequest withModifiedSinceConstraint(Date date) {
        setModifiedSinceConstraint(date);
        return this;
    }

    public CopyPartRequest withNonmatchingETagConstraint(String str) {
        this.nonmatchingEtagConstraints.add(str);
        return this;
    }

    public CopyPartRequest withPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public CopyPartRequest withSourceBucketName(String str) {
        this.sourceBucketName = str;
        return this;
    }

    public CopyPartRequest withSourceKey(String str) {
        this.sourceKey = str;
        return this;
    }

    public CopyPartRequest withSourceVersionId(String str) {
        this.sourceVersionId = str;
        return this;
    }

    public CopyPartRequest withUnmodifiedSinceConstraint(Date date) {
        setUnmodifiedSinceConstraint(date);
        return this;
    }

    public CopyPartRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }
}
