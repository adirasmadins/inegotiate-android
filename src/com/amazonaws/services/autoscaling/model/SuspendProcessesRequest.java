package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SuspendProcessesRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private List<String> scalingProcesses;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SuspendProcessesRequest)) {
            return false;
        }
        SuspendProcessesRequest suspendProcessesRequest = (SuspendProcessesRequest) obj;
        if (((suspendProcessesRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (suspendProcessesRequest.getAutoScalingGroupName() != null && !suspendProcessesRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        return ((suspendProcessesRequest.getScalingProcesses() == null ? 1 : 0) ^ (getScalingProcesses() == null ? 1 : 0)) == 0 ? suspendProcessesRequest.getScalingProcesses() == null || suspendProcessesRequest.getScalingProcesses().equals(getScalingProcesses()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public List<String> getScalingProcesses() {
        if (this.scalingProcesses == null) {
            this.scalingProcesses = new ArrayList();
        }
        return this.scalingProcesses;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31;
        if (getScalingProcesses() != null) {
            i = getScalingProcesses().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setScalingProcesses(Collection<String> collection) {
        if (collection == null) {
            this.scalingProcesses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.scalingProcesses = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.scalingProcesses != null) {
            stringBuilder.append("ScalingProcesses: " + this.scalingProcesses + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SuspendProcessesRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public SuspendProcessesRequest withScalingProcesses(Collection<String> collection) {
        if (collection == null) {
            this.scalingProcesses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.scalingProcesses = arrayList;
        }
        return this;
    }

    public SuspendProcessesRequest withScalingProcesses(String... strArr) {
        if (getScalingProcesses() == null) {
            setScalingProcesses(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getScalingProcesses().add(add);
        }
        return this;
    }
}
