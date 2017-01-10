package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeLoadBalancerPolicyTypesRequest extends AmazonWebServiceRequest {
    private List<String> policyTypeNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeLoadBalancerPolicyTypesRequest)) {
            return false;
        }
        DescribeLoadBalancerPolicyTypesRequest describeLoadBalancerPolicyTypesRequest = (DescribeLoadBalancerPolicyTypesRequest) obj;
        return ((describeLoadBalancerPolicyTypesRequest.getPolicyTypeNames() == null ? 1 : 0) ^ (getPolicyTypeNames() == null ? 1 : 0)) == 0 ? describeLoadBalancerPolicyTypesRequest.getPolicyTypeNames() == null || describeLoadBalancerPolicyTypesRequest.getPolicyTypeNames().equals(getPolicyTypeNames()) : false;
    }

    public List<String> getPolicyTypeNames() {
        if (this.policyTypeNames == null) {
            this.policyTypeNames = new ArrayList();
        }
        return this.policyTypeNames;
    }

    public int hashCode() {
        return (getPolicyTypeNames() == null ? 0 : getPolicyTypeNames().hashCode()) + 31;
    }

    public void setPolicyTypeNames(Collection<String> collection) {
        if (collection == null) {
            this.policyTypeNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.policyTypeNames = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.policyTypeNames != null) {
            stringBuilder.append("PolicyTypeNames: " + this.policyTypeNames + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeLoadBalancerPolicyTypesRequest withPolicyTypeNames(Collection<String> collection) {
        if (collection == null) {
            this.policyTypeNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyTypeNames = arrayList;
        }
        return this;
    }

    public DescribeLoadBalancerPolicyTypesRequest withPolicyTypeNames(String... strArr) {
        if (getPolicyTypeNames() == null) {
            setPolicyTypeNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getPolicyTypeNames().add(add);
        }
        return this;
    }
}
