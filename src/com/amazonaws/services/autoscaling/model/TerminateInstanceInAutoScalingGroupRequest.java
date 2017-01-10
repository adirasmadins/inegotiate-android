package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class TerminateInstanceInAutoScalingGroupRequest extends AmazonWebServiceRequest {
    private String instanceId;
    private Boolean shouldDecrementDesiredCapacity;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TerminateInstanceInAutoScalingGroupRequest)) {
            return false;
        }
        TerminateInstanceInAutoScalingGroupRequest terminateInstanceInAutoScalingGroupRequest = (TerminateInstanceInAutoScalingGroupRequest) obj;
        if (((terminateInstanceInAutoScalingGroupRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (terminateInstanceInAutoScalingGroupRequest.getInstanceId() != null && !terminateInstanceInAutoScalingGroupRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        return ((terminateInstanceInAutoScalingGroupRequest.isShouldDecrementDesiredCapacity() == null ? 1 : 0) ^ (isShouldDecrementDesiredCapacity() == null ? 1 : 0)) == 0 ? terminateInstanceInAutoScalingGroupRequest.isShouldDecrementDesiredCapacity() == null || terminateInstanceInAutoScalingGroupRequest.isShouldDecrementDesiredCapacity().equals(isShouldDecrementDesiredCapacity()) : false;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public Boolean getShouldDecrementDesiredCapacity() {
        return this.shouldDecrementDesiredCapacity;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31;
        if (isShouldDecrementDesiredCapacity() != null) {
            i = isShouldDecrementDesiredCapacity().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isShouldDecrementDesiredCapacity() {
        return this.shouldDecrementDesiredCapacity;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setShouldDecrementDesiredCapacity(Boolean bool) {
        this.shouldDecrementDesiredCapacity = bool;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.shouldDecrementDesiredCapacity != null) {
            stringBuilder.append("ShouldDecrementDesiredCapacity: " + this.shouldDecrementDesiredCapacity + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public TerminateInstanceInAutoScalingGroupRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public TerminateInstanceInAutoScalingGroupRequest withShouldDecrementDesiredCapacity(Boolean bool) {
        this.shouldDecrementDesiredCapacity = bool;
        return this;
    }
}
