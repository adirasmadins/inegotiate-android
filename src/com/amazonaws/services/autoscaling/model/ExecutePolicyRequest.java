package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ExecutePolicyRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private Boolean honorCooldown;
    private String policyName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ExecutePolicyRequest)) {
            return false;
        }
        ExecutePolicyRequest executePolicyRequest = (ExecutePolicyRequest) obj;
        if (((executePolicyRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (executePolicyRequest.getAutoScalingGroupName() != null && !executePolicyRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((executePolicyRequest.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (executePolicyRequest.getPolicyName() != null && !executePolicyRequest.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        return ((executePolicyRequest.isHonorCooldown() == null ? 1 : 0) ^ (isHonorCooldown() == null ? 1 : 0)) == 0 ? executePolicyRequest.isHonorCooldown() == null || executePolicyRequest.isHonorCooldown().equals(isHonorCooldown()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public Boolean getHonorCooldown() {
        return this.honorCooldown;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPolicyName() == null ? 0 : getPolicyName().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31;
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

    public void setHonorCooldown(Boolean bool) {
        this.honorCooldown = bool;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.policyName != null) {
            stringBuilder.append("PolicyName: " + this.policyName + ", ");
        }
        if (this.honorCooldown != null) {
            stringBuilder.append("HonorCooldown: " + this.honorCooldown + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ExecutePolicyRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public ExecutePolicyRequest withHonorCooldown(Boolean bool) {
        this.honorCooldown = bool;
        return this;
    }

    public ExecutePolicyRequest withPolicyName(String str) {
        this.policyName = str;
        return this;
    }
}
