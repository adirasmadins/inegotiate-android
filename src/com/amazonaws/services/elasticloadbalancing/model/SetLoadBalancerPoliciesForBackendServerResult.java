package com.amazonaws.services.elasticloadbalancing.model;

public class SetLoadBalancerPoliciesForBackendServerResult {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SetLoadBalancerPoliciesForBackendServerResult)) {
            return false;
        }
        SetLoadBalancerPoliciesForBackendServerResult setLoadBalancerPoliciesForBackendServerResult = (SetLoadBalancerPoliciesForBackendServerResult) obj;
        return true;
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
