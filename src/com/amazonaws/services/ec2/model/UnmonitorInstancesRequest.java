package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UnmonitorInstancesRequest extends AmazonWebServiceRequest {
    private List<String> instanceIds;

    public UnmonitorInstancesRequest(List<String> list) {
        this.instanceIds = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnmonitorInstancesRequest)) {
            return false;
        }
        UnmonitorInstancesRequest unmonitorInstancesRequest = (UnmonitorInstancesRequest) obj;
        return ((unmonitorInstancesRequest.getInstanceIds() == null ? 1 : 0) ^ (getInstanceIds() == null ? 1 : 0)) == 0 ? unmonitorInstancesRequest.getInstanceIds() == null || unmonitorInstancesRequest.getInstanceIds().equals(getInstanceIds()) : false;
    }

    public List<String> getInstanceIds() {
        if (this.instanceIds == null) {
            this.instanceIds = new ArrayList();
        }
        return this.instanceIds;
    }

    public int hashCode() {
        return (getInstanceIds() == null ? 0 : getInstanceIds().hashCode()) + 31;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public UnmonitorInstancesRequest withInstanceIds(Collection<String> collection) {
        if (collection == null) {
            this.instanceIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instanceIds = arrayList;
        }
        return this;
    }

    public UnmonitorInstancesRequest withInstanceIds(String... strArr) {
        if (getInstanceIds() == null) {
            setInstanceIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getInstanceIds().add(add);
        }
        return this;
    }
}
