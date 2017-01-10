package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CancelBundleTaskRequest extends AmazonWebServiceRequest {
    private String bundleId;

    public CancelBundleTaskRequest(String str) {
        this.bundleId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CancelBundleTaskRequest)) {
            return false;
        }
        CancelBundleTaskRequest cancelBundleTaskRequest = (CancelBundleTaskRequest) obj;
        return ((cancelBundleTaskRequest.getBundleId() == null ? 1 : 0) ^ (getBundleId() == null ? 1 : 0)) == 0 ? cancelBundleTaskRequest.getBundleId() == null || cancelBundleTaskRequest.getBundleId().equals(getBundleId()) : false;
    }

    public String getBundleId() {
        return this.bundleId;
    }

    public int hashCode() {
        return (getBundleId() == null ? 0 : getBundleId().hashCode()) + 31;
    }

    public void setBundleId(String str) {
        this.bundleId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.bundleId != null) {
            stringBuilder.append("BundleId: " + this.bundleId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CancelBundleTaskRequest withBundleId(String str) {
        this.bundleId = str;
        return this;
    }
}
