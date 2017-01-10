package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class PutScalingPolicyRequest extends AmazonWebServiceRequest {
    private String adjustmentType;
    private String autoScalingGroupName;
    private Integer cooldown;
    private Integer minAdjustmentStep;
    private String policyName;
    private Integer scalingAdjustment;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutScalingPolicyRequest)) {
            return false;
        }
        PutScalingPolicyRequest putScalingPolicyRequest = (PutScalingPolicyRequest) obj;
        if (((putScalingPolicyRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScalingPolicyRequest.getAutoScalingGroupName() != null && !putScalingPolicyRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((putScalingPolicyRequest.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScalingPolicyRequest.getPolicyName() != null && !putScalingPolicyRequest.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        if (((putScalingPolicyRequest.getScalingAdjustment() == null ? 1 : 0) ^ (getScalingAdjustment() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScalingPolicyRequest.getScalingAdjustment() != null && !putScalingPolicyRequest.getScalingAdjustment().equals(getScalingAdjustment())) {
            return false;
        }
        if (((putScalingPolicyRequest.getAdjustmentType() == null ? 1 : 0) ^ (getAdjustmentType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScalingPolicyRequest.getAdjustmentType() != null && !putScalingPolicyRequest.getAdjustmentType().equals(getAdjustmentType())) {
            return false;
        }
        if (((putScalingPolicyRequest.getCooldown() == null ? 1 : 0) ^ (getCooldown() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScalingPolicyRequest.getCooldown() != null && !putScalingPolicyRequest.getCooldown().equals(getCooldown())) {
            return false;
        }
        return ((putScalingPolicyRequest.getMinAdjustmentStep() == null ? 1 : 0) ^ (getMinAdjustmentStep() == null ? 1 : 0)) == 0 ? putScalingPolicyRequest.getMinAdjustmentStep() == null || putScalingPolicyRequest.getMinAdjustmentStep().equals(getMinAdjustmentStep()) : false;
    }

    public String getAdjustmentType() {
        return this.adjustmentType;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public Integer getCooldown() {
        return this.cooldown;
    }

    public Integer getMinAdjustmentStep() {
        return this.minAdjustmentStep;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public Integer getScalingAdjustment() {
        return this.scalingAdjustment;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCooldown() == null ? 0 : getCooldown().hashCode()) + (((getAdjustmentType() == null ? 0 : getAdjustmentType().hashCode()) + (((getScalingAdjustment() == null ? 0 : getScalingAdjustment().hashCode()) + (((getPolicyName() == null ? 0 : getPolicyName().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getMinAdjustmentStep() != null) {
            i = getMinAdjustmentStep().hashCode();
        }
        return hashCode + i;
    }

    public void setAdjustmentType(String str) {
        this.adjustmentType = str;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setCooldown(Integer num) {
        this.cooldown = num;
    }

    public void setMinAdjustmentStep(Integer num) {
        this.minAdjustmentStep = num;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public void setScalingAdjustment(Integer num) {
        this.scalingAdjustment = num;
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
        if (this.scalingAdjustment != null) {
            stringBuilder.append("ScalingAdjustment: " + this.scalingAdjustment + ", ");
        }
        if (this.adjustmentType != null) {
            stringBuilder.append("AdjustmentType: " + this.adjustmentType + ", ");
        }
        if (this.cooldown != null) {
            stringBuilder.append("Cooldown: " + this.cooldown + ", ");
        }
        if (this.minAdjustmentStep != null) {
            stringBuilder.append("MinAdjustmentStep: " + this.minAdjustmentStep + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PutScalingPolicyRequest withAdjustmentType(String str) {
        this.adjustmentType = str;
        return this;
    }

    public PutScalingPolicyRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public PutScalingPolicyRequest withCooldown(Integer num) {
        this.cooldown = num;
        return this;
    }

    public PutScalingPolicyRequest withMinAdjustmentStep(Integer num) {
        this.minAdjustmentStep = num;
        return this;
    }

    public PutScalingPolicyRequest withPolicyName(String str) {
        this.policyName = str;
        return this;
    }

    public PutScalingPolicyRequest withScalingAdjustment(Integer num) {
        this.scalingAdjustment = num;
        return this;
    }
}
