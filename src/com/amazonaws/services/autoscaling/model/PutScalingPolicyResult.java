package com.amazonaws.services.autoscaling.model;

public class PutScalingPolicyResult {
    private String policyARN;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutScalingPolicyResult)) {
            return false;
        }
        PutScalingPolicyResult putScalingPolicyResult = (PutScalingPolicyResult) obj;
        return ((putScalingPolicyResult.getPolicyARN() == null ? 1 : 0) ^ (getPolicyARN() == null ? 1 : 0)) == 0 ? putScalingPolicyResult.getPolicyARN() == null || putScalingPolicyResult.getPolicyARN().equals(getPolicyARN()) : false;
    }

    public String getPolicyARN() {
        return this.policyARN;
    }

    public int hashCode() {
        return (getPolicyARN() == null ? 0 : getPolicyARN().hashCode()) + 31;
    }

    public void setPolicyARN(String str) {
        this.policyARN = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.policyARN != null) {
            stringBuilder.append("PolicyARN: " + this.policyARN + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PutScalingPolicyResult withPolicyARN(String str) {
        this.policyARN = str;
        return this;
    }
}
