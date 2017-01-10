package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApplySecurityGroupsToLoadBalancerRequest extends AmazonWebServiceRequest {
    private String loadBalancerName;
    private List<String> securityGroups;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ApplySecurityGroupsToLoadBalancerRequest)) {
            return false;
        }
        ApplySecurityGroupsToLoadBalancerRequest applySecurityGroupsToLoadBalancerRequest = (ApplySecurityGroupsToLoadBalancerRequest) obj;
        if (((applySecurityGroupsToLoadBalancerRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (applySecurityGroupsToLoadBalancerRequest.getLoadBalancerName() != null && !applySecurityGroupsToLoadBalancerRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        return ((applySecurityGroupsToLoadBalancerRequest.getSecurityGroups() == null ? 1 : 0) ^ (getSecurityGroups() == null ? 1 : 0)) == 0 ? applySecurityGroupsToLoadBalancerRequest.getSecurityGroups() == null || applySecurityGroupsToLoadBalancerRequest.getSecurityGroups().equals(getSecurityGroups()) : false;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public List<String> getSecurityGroups() {
        if (this.securityGroups == null) {
            this.securityGroups = new ArrayList();
        }
        return this.securityGroups;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31;
        if (getSecurityGroups() != null) {
            i = getSecurityGroups().hashCode();
        }
        return hashCode + i;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public void setSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.securityGroups = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.securityGroups != null) {
            stringBuilder.append("SecurityGroups: " + this.securityGroups + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ApplySecurityGroupsToLoadBalancerRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public ApplySecurityGroupsToLoadBalancerRequest withSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.securityGroups = arrayList;
        }
        return this;
    }

    public ApplySecurityGroupsToLoadBalancerRequest withSecurityGroups(String... strArr) {
        if (getSecurityGroups() == null) {
            setSecurityGroups(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSecurityGroups().add(add);
        }
        return this;
    }
}
