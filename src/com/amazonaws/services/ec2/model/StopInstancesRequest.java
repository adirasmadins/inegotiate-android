package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StopInstancesRequest extends AmazonWebServiceRequest {
    private Boolean force;
    private List<String> instanceIds;

    public StopInstancesRequest(List<String> list) {
        this.instanceIds = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StopInstancesRequest)) {
            return false;
        }
        StopInstancesRequest stopInstancesRequest = (StopInstancesRequest) obj;
        if (((stopInstancesRequest.getInstanceIds() == null ? 1 : 0) ^ (getInstanceIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (stopInstancesRequest.getInstanceIds() != null && !stopInstancesRequest.getInstanceIds().equals(getInstanceIds())) {
            return false;
        }
        return ((stopInstancesRequest.isForce() == null ? 1 : 0) ^ (isForce() == null ? 1 : 0)) == 0 ? stopInstancesRequest.isForce() == null || stopInstancesRequest.isForce().equals(isForce()) : false;
    }

    public Boolean getForce() {
        return this.force;
    }

    public List<String> getInstanceIds() {
        if (this.instanceIds == null) {
            this.instanceIds = new ArrayList();
        }
        return this.instanceIds;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstanceIds() == null ? 0 : getInstanceIds().hashCode()) + 31) * 31;
        if (isForce() != null) {
            i = isForce().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isForce() {
        return this.force;
    }

    public void setForce(Boolean bool) {
        this.force = bool;
    }

    public void setInstanceIds(Collection<String> collection) {
        if (collection == null) {
            this.instanceIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.instanceIds = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceIds != null) {
            stringBuilder.append("InstanceIds: " + this.instanceIds + ", ");
        }
        if (this.force != null) {
            stringBuilder.append("Force: " + this.force + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public StopInstancesRequest withForce(Boolean bool) {
        this.force = bool;
        return this;
    }

    public StopInstancesRequest withInstanceIds(Collection<String> collection) {
        if (collection == null) {
            this.instanceIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instanceIds = arrayList;
        }
        return this;
    }

    public StopInstancesRequest withInstanceIds(String... strArr) {
        if (getInstanceIds() == null) {
            setInstanceIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getInstanceIds().add(add);
        }
        return this;
    }
}
