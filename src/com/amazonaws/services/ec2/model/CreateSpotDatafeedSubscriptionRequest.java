package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreateSpotDatafeedSubscriptionRequest extends AmazonWebServiceRequest {
    private String bucket;
    private String prefix;

    public CreateSpotDatafeedSubscriptionRequest(String str) {
        this.bucket = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateSpotDatafeedSubscriptionRequest)) {
            return false;
        }
        CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest = (CreateSpotDatafeedSubscriptionRequest) obj;
        if (((createSpotDatafeedSubscriptionRequest.getBucket() == null ? 1 : 0) ^ (getBucket() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createSpotDatafeedSubscriptionRequest.getBucket() != null && !createSpotDatafeedSubscriptionRequest.getBucket().equals(getBucket())) {
            return false;
        }
        return ((createSpotDatafeedSubscriptionRequest.getPrefix() == null ? 1 : 0) ^ (getPrefix() == null ? 1 : 0)) == 0 ? createSpotDatafeedSubscriptionRequest.getPrefix() == null || createSpotDatafeedSubscriptionRequest.getPrefix().equals(getPrefix()) : false;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getBucket() == null ? 0 : getBucket().hashCode()) + 31) * 31;
        if (getPrefix() != null) {
            i = getPrefix().hashCode();
        }
        return hashCode + i;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateSpotDatafeedSubscriptionRequest withBucket(String str) {
        this.bucket = str;
        return this;
    }

    public CreateSpotDatafeedSubscriptionRequest withPrefix(String str) {
        this.prefix = str;
        return this;
    }
}
