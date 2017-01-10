package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SetLoadBalancerPoliciesForBackendServerRequest extends AmazonWebServiceRequest {
    private Integer instancePort;
    private String loadBalancerName;
    private List<String> policyNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetLoadBalancerPoliciesForBackendServerRequest)) {
            return false;
        }
        SetLoadBalancerPoliciesForBackendServerRequest setLoadBalancerPoliciesForBackendServerRequest = (SetLoadBalancerPoliciesForBackendServerRequest) obj;
        if (((setLoadBalancerPoliciesForBackendServerRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setLoadBalancerPoliciesForBackendServerRequest.getLoadBalancerName() != null && !setLoadBalancerPoliciesForBackendServerRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        if (((setLoadBalancerPoliciesForBackendServerRequest.getInstancePort() == null ? 1 : 0) ^ (getInstancePort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setLoadBalancerPoliciesForBackendServerRequest.getInstancePort() != null && !setLoadBalancerPoliciesForBackendServerRequest.getInstancePort().equals(getInstancePort())) {
            return false;
        }
        return ((setLoadBalancerPoliciesForBackendServerRequest.getPolicyNames() == null ? 1 : 0) ^ (getPolicyNames() == null ? 1 : 0)) == 0 ? setLoadBalancerPoliciesForBackendServerRequest.getPolicyNames() == null || setLoadBalancerPoliciesForBackendServerRequest.getPolicyNames().equals(getPolicyNames()) : false;
    }

    public Integer getInstancePort() {
        return this.instancePort;
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
        int hashCode = ((getInstancePort() == null ? 0 : getInstancePort().hashCode()) + (((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31)) * 31;
        if (getPolicyNames() != null) {
            i = getPolicyNames().hashCode();
        }
        return hashCode + i;
    }

    public void setInstancePort(Integer num) {
        this.instancePort = num;
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
        if (this.instancePort != null) {
            stringBuilder.append("InstancePort: " + this.instancePort + ", ");
        }
        if (this.policyNames != null) {
            stringBuilder.append("PolicyNames: " + this.policyNames + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SetLoadBalancerPoliciesForBackendServerRequest withInstancePort(Integer num) {
        this.instancePort = num;
        return this;
    }

    public SetLoadBalancerPoliciesForBackendServerRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public SetLoadBalancerPoliciesForBackendServerRequest withPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyNames = arrayList;
        }
        return this;
    }

    public SetLoadBalancerPoliciesForBackendServerRequest withPolicyNames(String... strArr) {
        if (getPolicyNames() == null) {
            setPolicyNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getPolicyNames().add(add);
        }
        return this;
    }
}
