package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TerminateInstancesRequest extends AmazonWebServiceRequest {
    private List<String> instanceIds;

    public TerminateInstancesRequest(List<String> list) {
        this.instanceIds = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TerminateInstancesRequest)) {
            return false;
        }
        TerminateInstancesRequest terminateInstancesRequest = (TerminateInstancesRequest) obj;
        return ((terminateInstancesRequest.getInstanceIds() == null ? 1 : 0) ^ (getInstanceIds() == null ? 1 : 0)) == 0 ? terminateInstancesRequest.getInstanceIds() == null || terminateInstancesRequest.getInstanceIds().equals(getInstanceIds()) : false;
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

    public TerminateInstancesRequest withInstanceIds(Collection<String> collection) {
        if (collection == null) {
            this.instanceIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instanceIds = arrayList;
        }
        return this;
    }

    public TerminateInstancesRequest withInstanceIds(String... strArr) {
        if (getInstanceIds() == null) {
            setInstanceIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getInstanceIds().add(add);
        }
        return this;
    }
}
