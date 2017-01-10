package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeLoadBalancerPolicyTypesResult {
    private List<PolicyTypeDescription> policyTypeDescriptions;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeLoadBalancerPolicyTypesResult)) {
            return false;
        }
        DescribeLoadBalancerPolicyTypesResult describeLoadBalancerPolicyTypesResult = (DescribeLoadBalancerPolicyTypesResult) obj;
        return ((describeLoadBalancerPolicyTypesResult.getPolicyTypeDescriptions() == null ? 1 : 0) ^ (getPolicyTypeDescriptions() == null ? 1 : 0)) == 0 ? describeLoadBalancerPolicyTypesResult.getPolicyTypeDescriptions() == null || describeLoadBalancerPolicyTypesResult.getPolicyTypeDescriptions().equals(getPolicyTypeDescriptions()) : false;
    }

    public List<PolicyTypeDescription> getPolicyTypeDescriptions() {
        if (this.policyTypeDescriptions == null) {
            this.policyTypeDescriptions = new ArrayList();
        }
        return this.policyTypeDescriptions;
    }

    public int hashCode() {
        return (getPolicyTypeDescriptions() == null ? 0 : getPolicyTypeDescriptions().hashCode()) + 31;
    }

    public void setPolicyTypeDescriptions(Collection<PolicyTypeDescription> collection) {
        if (collection == null) {
            this.policyTypeDescriptions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.policyTypeDescriptions = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.policyTypeDescriptions != null) {
            stringBuilder.append("PolicyTypeDescriptions: " + this.policyTypeDescriptions + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeLoadBalancerPolicyTypesResult withPolicyTypeDescriptions(Collection<PolicyTypeDescription> collection) {
        if (collection == null) {
            this.policyTypeDescriptions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyTypeDescriptions = arrayList;
        }
        return this;
    }

    public DescribeLoadBalancerPolicyTypesResult withPolicyTypeDescriptions(PolicyTypeDescription... policyTypeDescriptionArr) {
        if (getPolicyTypeDescriptions() == null) {
            setPolicyTypeDescriptions(new ArrayList(policyTypeDescriptionArr.length));
        }
        for (Object add : policyTypeDescriptionArr) {
            getPolicyTypeDescriptions().add(add);
        }
        return this;
    }
}
