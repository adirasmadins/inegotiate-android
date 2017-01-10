package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeletePolicyRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private String policyName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeletePolicyRequest)) {
            return false;
        }
        DeletePolicyRequest deletePolicyRequest = (DeletePolicyRequest) obj;
        if (((deletePolicyRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deletePolicyRequest.getAutoScalingGroupName() != null && !deletePolicyRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        return ((deletePolicyRequest.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) == 0 ? deletePolicyRequest.getPolicyName() == null || deletePolicyRequest.getPolicyName().equals(getPolicyName()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31;
        if (getPolicyName() != null) {
            i = getPolicyName().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeletePolicyRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public DeletePolicyRequest withPolicyName(String str) {
        this.policyName = str;
        return this;
    }
}
