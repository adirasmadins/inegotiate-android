package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SetDesiredCapacityRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private Integer desiredCapacity;
    private Boolean honorCooldown;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetDesiredCapacityRequest)) {
            return false;
        }
        SetDesiredCapacityRequest setDesiredCapacityRequest = (SetDesiredCapacityRequest) obj;
        if (((setDesiredCapacityRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setDesiredCapacityRequest.getAutoScalingGroupName() != null && !setDesiredCapacityRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((setDesiredCapacityRequest.getDesiredCapacity() == null ? 1 : 0) ^ (getDesiredCapacity() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setDesiredCapacityRequest.getDesiredCapacity() != null && !setDesiredCapacityRequest.getDesiredCapacity().equals(getDesiredCapacity())) {
            return false;
        }
        return ((setDesiredCapacityRequest.isHonorCooldown() == null ? 1 : 0) ^ (isHonorCooldown() == null ? 1 : 0)) == 0 ? setDesiredCapacityRequest.isHonorCooldown() == null || setDesiredCapacityRequest.isHonorCooldown().equals(isHonorCooldown()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public Integer getDesiredCapacity() {
        return this.desiredCapacity;
    }

    public Boolean getHonorCooldown() {
        return this.honorCooldown;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDesiredCapacity() == null ? 0 : getDesiredCapacity().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31;
        if (isHonorCooldown() != null) {
            i = isHonorCooldown().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isHonorCooldown() {
        return this.honorCooldown;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setDesiredCapacity(Integer num) {
        this.desiredCapacity = num;
    }

    public void setHonorCooldown(Boolean bool) {
        this.honorCooldown = bool;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.desiredCapacity != null) {
            stringBuilder.append("DesiredCapacity: " + this.desiredCapacity + ", ");
        }
        if (this.honorCooldown != null) {
            stringBuilder.append("HonorCooldown: " + this.honorCooldown + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SetDesiredCapacityRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public SetDesiredCapacityRequest withDesiredCapacity(Integer num) {
        this.desiredCapacity = num;
        return this;
    }

    public SetDesiredCapacityRequest withHonorCooldown(Boolean bool) {
        this.honorCooldown = bool;
        return this;
    }
}
