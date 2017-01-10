package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetObjectRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private String key;
    private List<String> matchingETagConstraints;
    private Date modifiedSinceConstraint;
    private List<String> nonmatchingEtagConstraints;
    private ProgressListener progressListener;
    private long[] range;
    private ResponseHeaderOverrides responseHeaders;
    private Date unmodifiedSinceConstraint;
    private String versionId;

    public GetObjectRequest(String str, String str2) {
        this(str, str2, null);
    }

    public GetObjectRequest(String str, String str2, String str3) {
        this.matchingETagConstraints = new ArrayList();
        this.nonmatchingEtagConstraints = new ArrayList();
        setBucketName(str);
        setKey(str2);
        setVersionId(str3);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
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

    public ProgressListener getProgressListener() {
        return this.progressListener;
    }

    public long[] getRange() {
        return this.range;
    }

    public ResponseHeaderOverrides getResponseHeaders() {
        return this.responseHeaders;
    }

    public Date getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMatchingETagConstraints(List<String> list) {
        this.matchingETagConstraints = list;
    }

    public void setModifiedSinceConstraint(Date date) {
        this.modifiedSinceConstraint = date;
    }

    public void setNonmatchingETagConstraints(List<String> list) {
        this.nonmatchingEtagConstraints = list;
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.progressListener = progressListener;
    }

    public void setRange(long j, long j2) {
        this.range = new long[]{j, j2};
    }

    public void setResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        this.responseHeaders = responseHeaderOverrides;
    }

    public void setUnmodifiedSinceConstraint(Date date) {
        this.unmodifiedSinceConstraint = date;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public GetObjectRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GetObjectRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public GetObjectRequest withMatchingETagConstraint(String str) {
        this.matchingETagConstraints.add(str);
        return this;
    }

    public GetObjectRequest withModifiedSinceConstraint(Date date) {
        setModifiedSinceConstraint(date);
        return this;
    }

    public GetObjectRequest withNonmatchingETagConstraint(String str) {
        this.nonmatchingEtagConstraints.add(str);
        return this;
    }

    public GetObjectRequest withProgressListener(ProgressListener progressListener) {
        setProgressListener(progressListener);
        return this;
    }

    public GetObjectRequest withRange(long j, long j2) {
        setRange(j, j2);
        return this;
    }

    public GetObjectRequest withResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        setResponseHeaders(responseHeaderOverrides);
        return this;
    }

    public GetObjectRequest withUnmodifiedSinceConstraint(Date date) {
        setUnmodifiedSinceConstraint(date);
        return this;
    }

    public GetObjectRequest withVersionId(String str) {
        setVersionId(str);
        return this;
    }
}
