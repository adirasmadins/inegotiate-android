package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SetLoadBalancerPoliciesOfListenerRequest extends AmazonWebServiceRequest {
    private String loadBalancerName;
    private Integer loadBalancerPort;
    private List<String> policyNames;

    public SetLoadBalancerPoliciesOfListenerRequest(String str, Integer num, List<String> list) {
        this.loadBalancerName = str;
        this.loadBalancerPort = num;
        this.policyNames = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetLoadBalancerPoliciesOfListenerRequest)) {
            return false;
        }
        SetLoadBalancerPoliciesOfListenerRequest setLoadBalancerPoliciesOfListenerRequest = (SetLoadBalancerPoliciesOfListenerRequest) obj;
        if (((setLoadBalancerPoliciesOfListenerRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setLoadBalancerPoliciesOfListenerRequest.getLoadBalancerName() != null && !setLoadBalancerPoliciesOfListenerRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        if (((setLoadBalancerPoliciesOfListenerRequest.getLoadBalancerPort() == null ? 1 : 0) ^ (getLoadBalancerPort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setLoadBalancerPoliciesOfListenerRequest.getLoadBalancerPort() != null && !setLoadBalancerPoliciesOfListenerRequest.getLoadBalancerPort().equals(getLoadBalancerPort())) {
            return false;
        }
        return ((setLoadBalancerPoliciesOfListenerRequest.getPolicyNames() == null ? 1 : 0) ^ (getPolicyNames() == null ? 1 : 0)) == 0 ? setLoadBalancerPoliciesOfListenerRequest.getPolicyNames() == null || setLoadBalancerPoliciesOfListenerRequest.getPolicyNames().equals(getPolicyNames()) : false;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public Integer getLoadBalancerPort() {
        return this.loadBalancerPort;
    }

    public List<String> getPolicyNames() {
        if (this.policyNames == null) {
            this.policyNames = new ArrayList();
        }
        return this.policyNames;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerPort() == null ? 0 : getLoadBalancerPort().hashCode()) + (((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31)) * 31;
        if (getPolicyNames() != null) {
            i = getPolicyNames().hashCode();
        }
        return hashCode + i;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public void setLoadBalancerPort(Integer num) {
        this.loadBalancerPort = num;
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
        if (this.loadBalancerPort != null) {
            stringBuilder.append("LoadBalancerPort: " + this.loadBalancerPort + ", ");
        }
        if (this.policyNames != null) {
            stringBuilder.append("PolicyNames: " + this.policyNames + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SetLoadBalancerPoliciesOfListenerRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public SetLoadBalancerPoliciesOfListenerRequest withLoadBalancerPort(Integer num) {
        this.loadBalancerPort = num;
        return this;
    }

    public SetLoadBalancerPoliciesOfListenerRequest withPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyNames = arrayList;
        }
        return this;
    }

    public SetLoadBalancerPoliciesOfListenerRequest withPolicyNames(String... strArr) {
        if (getPolicyNames() == null) {
            setPolicyNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getPolicyNames().add(add);
        }
        return this;
    }
}
