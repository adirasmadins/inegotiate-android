package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteLoadBalancerPolicyRequest extends AmazonWebServiceRequest {
    private String loadBalancerName;
    private String policyName;

    public DeleteLoadBalancerPolicyRequest(String str, String str2) {
        this.loadBalancerName = str;
        this.policyName = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteLoadBalancerPolicyRequest)) {
            return false;
        }
        DeleteLoadBalancerPolicyRequest deleteLoadBalancerPolicyRequest = (DeleteLoadBalancerPolicyRequest) obj;
        if (((deleteLoadBalancerPolicyRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteLoadBalancerPolicyRequest.getLoadBalancerName() != null && !deleteLoadBalancerPolicyRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        return ((deleteLoadBalancerPolicyRequest.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) == 0 ? deleteLoadBalancerPolicyRequest.getPolicyName() == null || deleteLoadBalancerPolicyRequest.getPolicyName().equals(getPolicyName()) : false;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31;
        if (getPolicyName() != null) {
            i = getPolicyName().hashCode();
        }
        return hashCode + i;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.policyName != null) {
            stringBuilder.append("PolicyName: " + this.policyName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteLoadBalancerPolicyRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public DeleteLoadBalancerPolicyRequest withPolicyName(String str) {
        this.policyName = str;
        return this;
    }
}
