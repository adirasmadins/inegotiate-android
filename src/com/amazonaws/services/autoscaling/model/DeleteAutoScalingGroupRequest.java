package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteAutoScalingGroupRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private Boolean forceDelete;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteAutoScalingGroupRequest)) {
            return false;
        }
        DeleteAutoScalingGroupRequest deleteAutoScalingGroupRequest = (DeleteAutoScalingGroupRequest) obj;
        if (((deleteAutoScalingGroupRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteAutoScalingGroupRequest.getAutoScalingGroupName() != null && !deleteAutoScalingGroupRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        return ((deleteAutoScalingGroupRequest.isForceDelete() == null ? 1 : 0) ^ (isForceDelete() == null ? 1 : 0)) == 0 ? deleteAutoScalingGroupRequest.isForceDelete() == null || deleteAutoScalingGroupRequest.isForceDelete().equals(isForceDelete()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public Boolean getForceDelete() {
        return this.forceDelete;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31;
        if (isForceDelete() != null) {
            i = isForceDelete().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isForceDelete() {
        return this.forceDelete;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setForceDelete(Boolean bool) {
        this.forceDelete = bool;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.forceDelete != null) {
            stringBuilder.append("ForceDelete: " + this.forceDelete + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteAutoScalingGroupRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public DeleteAutoScalingGroupRequest withForceDelete(Boolean bool) {
        this.forceDelete = bool;
        return this;
    }
}
