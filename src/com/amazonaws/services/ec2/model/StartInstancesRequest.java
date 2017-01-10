package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StartInstancesRequest extends AmazonWebServiceRequest {
    private String additionalInfo;
    private List<String> instanceIds;

    public StartInstancesRequest(List<String> list) {
        this.instanceIds = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StartInstancesRequest)) {
            return false;
        }
        StartInstancesRequest startInstancesRequest = (StartInstancesRequest) obj;
        if (((startInstancesRequest.getInstanceIds() == null ? 1 : 0) ^ (getInstanceIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (startInstancesRequest.getInstanceIds() != null && !startInstancesRequest.getInstanceIds().equals(getInstanceIds())) {
            return false;
        }
        return ((startInstancesRequest.getAdditionalInfo() == null ? 1 : 0) ^ (getAdditionalInfo() == null ? 1 : 0)) == 0 ? startInstancesRequest.getAdditionalInfo() == null || startInstancesRequest.getAdditionalInfo().equals(getAdditionalInfo()) : false;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
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
        if (getAdditionalInfo() != null) {
            i = getAdditionalInfo().hashCode();
        }
        return hashCode + i;
    }

    public void setAdditionalInfo(String str) {
        this.additionalInfo = str;
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
        if (this.additionalInfo != null) {
            stringBuilder.append("AdditionalInfo: " + this.additionalInfo + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public StartInstancesRequest withAdditionalInfo(String str) {
        this.additionalInfo = str;
        return this;
    }

    public StartInstancesRequest withInstanceIds(Collection<String> collection) {
        if (collection == null) {
            this.instanceIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instanceIds = arrayList;
        }
        return this;
    }

    public StartInstancesRequest withInstanceIds(String... strArr) {
        if (getInstanceIds() == null) {
            setInstanceIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getInstanceIds().add(add);
        }
        return this;
    }
}
