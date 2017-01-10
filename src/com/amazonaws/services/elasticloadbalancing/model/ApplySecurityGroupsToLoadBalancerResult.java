package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApplySecurityGroupsToLoadBalancerResult {
    private List<String> securityGroups;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ApplySecurityGroupsToLoadBalancerResult)) {
            return false;
        }
        ApplySecurityGroupsToLoadBalancerResult applySecurityGroupsToLoadBalancerResult = (ApplySecurityGroupsToLoadBalancerResult) obj;
        return ((applySecurityGroupsToLoadBalancerResult.getSecurityGroups() == null ? 1 : 0) ^ (getSecurityGroups() == null ? 1 : 0)) == 0 ? applySecurityGroupsToLoadBalancerResult.getSecurityGroups() == null || applySecurityGroupsToLoadBalancerResult.getSecurityGroups().equals(getSecurityGroups()) : false;
    }

    public List<String> getSecurityGroups() {
        if (this.securityGroups == null) {
            this.securityGroups = new ArrayList();
        }
        return this.securityGroups;
    }

    public int hashCode() {
        return (getSecurityGroups() == null ? 0 : getSecurityGroups().hashCode()) + 31;
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
        if (this.securityGroups != null) {
            stringBuilder.append("SecurityGroups: " + this.securityGroups + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ApplySecurityGroupsToLoadBalancerResult withSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.securityGroups = arrayList;
        }
        return this;
    }

    public ApplySecurityGroupsToLoadBalancerResult withSecurityGroups(String... strArr) {
        if (getSecurityGroups() == null) {
            setSecurityGroups(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSecurityGroups().add(add);
        }
        return this;
    }
}
