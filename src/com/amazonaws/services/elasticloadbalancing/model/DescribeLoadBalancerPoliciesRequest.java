package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeLoadBalancerPoliciesRequest extends AmazonWebServiceRequest {
    private String loadBalancerName;
    private List<String> policyNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeLoadBalancerPoliciesRequest)) {
            return false;
        }
        DescribeLoadBalancerPoliciesRequest describeLoadBalancerPoliciesRequest = (DescribeLoadBalancerPoliciesRequest) obj;
        if (((describeLoadBalancerPoliciesRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeLoadBalancerPoliciesRequest.getLoadBalancerName() != null && !describeLoadBalancerPoliciesRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        return ((describeLoadBalancerPoliciesRequest.getPolicyNames() == null ? 1 : 0) ^ (getPolicyNames() == null ? 1 : 0)) == 0 ? describeLoadBalancerPoliciesRequest.getPolicyNames() == null || describeLoadBalancerPoliciesRequest.getPolicyNames().equals(getPolicyNames()) : false;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public List<String> getPolicyNames() {
        if (this.policyNames == null) {
            this.policyNames = new ArrayList();
        }
        return this.policyNames;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31;
        if (getPolicyNames() != null) {
            i = getPolicyNames().hashCode();
        }
        return hashCode + i;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public void setPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.policyNames = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.policyNames != null) {
            stringBuilder.append("PolicyNames: " + this.policyNames + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeLoadBalancerPoliciesRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public DescribeLoadBalancerPoliciesRequest withPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyNames = arrayList;
        }
        return this;
    }

    public DescribeLoadBalancerPoliciesRequest withPolicyNames(String... strArr) {
        if (getPolicyNames() == null) {
            setPolicyNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getPolicyNames().add(add);
        }
        return this;
    }
}
