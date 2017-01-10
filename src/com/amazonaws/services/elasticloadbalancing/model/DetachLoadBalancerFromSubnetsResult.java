package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DetachLoadBalancerFromSubnetsResult {
    private List<String> subnets;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DetachLoadBalancerFromSubnetsResult)) {
            return false;
        }
        DetachLoadBalancerFromSubnetsResult detachLoadBalancerFromSubnetsResult = (DetachLoadBalancerFromSubnetsResult) obj;
        return ((detachLoadBalancerFromSubnetsResult.getSubnets() == null ? 1 : 0) ^ (getSubnets() == null ? 1 : 0)) == 0 ? detachLoadBalancerFromSubnetsResult.getSubnets() == null || detachLoadBalancerFromSubnetsResult.getSubnets().equals(getSubnets()) : false;
    }

    public List<String> getSubnets() {
        if (this.subnets == null) {
            this.subnets = new ArrayList();
        }
        return this.subnets;
    }

    public int hashCode() {
        return (getSubnets() == null ? 0 : getSubnets().hashCode()) + 31;
    }

    public void setSubnets(Collection<String> collection) {
        if (collection == null) {
            this.subnets = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.subnets = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.subnets != null) {
            stringBuilder.append("Subnets: " + this.subnets + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DetachLoadBalancerFromSubnetsResult withSubnets(Collection<String> collection) {
        if (collection == null) {
            this.subnets = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.subnets = arrayList;
        }
        return this;
    }

    public DetachLoadBalancerFromSubnetsResult withSubnets(String... strArr) {
        if (getSubnets() == null) {
            setSubnets(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSubnets().add(add);
        }
        return this;
    }
}
