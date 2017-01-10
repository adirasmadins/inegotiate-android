package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class BundleInstanceRequest extends AmazonWebServiceRequest {
    private String instanceId;
    private Storage storage;

    public BundleInstanceRequest(String str, Storage storage) {
        this.instanceId = str;
        this.storage = storage;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BundleInstanceRequest)) {
            return false;
        }
        BundleInstanceRequest bundleInstanceRequest = (BundleInstanceRequest) obj;
        if (((bundleInstanceRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (bundleInstanceRequest.getInstanceId() != null && !bundleInstanceRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        return ((bundleInstanceRequest.getStorage() == null ? 1 : 0) ^ (getStorage() == null ? 1 : 0)) == 0 ? bundleInstanceRequest.getStorage() == null || bundleInstanceRequest.getStorage().equals(getStorage()) : false;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public Storage getStorage() {
        return this.storage;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31;
        if (getStorage() != null) {
            i = getStorage().hashCode();
        }
        return hashCode + i;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.storage != null) {
            stringBuilder.append("Storage: " + this.storage + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BundleInstanceRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public BundleInstanceRequest withStorage(Storage storage) {
        this.storage = storage;
        return this;
    }
}
