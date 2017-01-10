package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeLoadBalancerPoliciesResult {
    private List<PolicyDescription> policyDescriptions;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeLoadBalancerPoliciesResult)) {
            return false;
        }
        DescribeLoadBalancerPoliciesResult describeLoadBalancerPoliciesResult = (DescribeLoadBalancerPoliciesResult) obj;
        return ((describeLoadBalancerPoliciesResult.getPolicyDescriptions() == null ? 1 : 0) ^ (getPolicyDescriptions() == null ? 1 : 0)) == 0 ? describeLoadBalancerPoliciesResult.getPolicyDescriptions() == null || describeLoadBalancerPoliciesResult.getPolicyDescriptions().equals(getPolicyDescriptions()) : false;
    }

    public List<PolicyDescription> getPolicyDescriptions() {
        if (this.policyDescriptions == null) {
            this.policyDescriptions = new ArrayList();
        }
        return this.policyDescriptions;
    }

    public int hashCode() {
        return (getPolicyDescriptions() == null ? 0 : getPolicyDescriptions().hashCode()) + 31;
    }

    public void setPolicyDescriptions(Collection<PolicyDescription> collection) {
        if (collection == null) {
            this.policyDescriptions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.policyDescriptions = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.policyDescriptions != null) {
            stringBuilder.append("PolicyDescriptions: " + this.policyDescriptions + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeLoadBalancerPoliciesResult withPolicyDescriptions(Collection<PolicyDescription> collection) {
        if (collection == null) {
            this.policyDescriptions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyDescriptions = arrayList;
        }
        return this;
    }

    public DescribeLoadBalancerPoliciesResult withPolicyDescriptions(PolicyDescription... policyDescriptionArr) {
        if (getPolicyDescriptions() == null) {
            setPolicyDescriptions(new ArrayList(policyDescriptionArr.length));
        }
        for (Object add : policyDescriptionArr) {
            getPolicyDescriptions().add(add);
        }
        return this;
    }
}
