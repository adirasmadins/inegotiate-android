package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeLoadBalancersResult {
    private List<LoadBalancerDescription> loadBalancerDescriptions;
    private String nextMarker;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeLoadBalancersResult)) {
            return false;
        }
        DescribeLoadBalancersResult describeLoadBalancersResult = (DescribeLoadBalancersResult) obj;
        if (((describeLoadBalancersResult.getLoadBalancerDescriptions() == null ? 1 : 0) ^ (getLoadBalancerDescriptions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeLoadBalancersResult.getLoadBalancerDescriptions() != null && !describeLoadBalancersResult.getLoadBalancerDescriptions().equals(getLoadBalancerDescriptions())) {
            return false;
        }
        return ((describeLoadBalancersResult.getNextMarker() == null ? 1 : 0) ^ (getNextMarker() == null ? 1 : 0)) == 0 ? describeLoadBalancersResult.getNextMarker() == null || describeLoadBalancersResult.getNextMarker().equals(getNextMarker()) : false;
    }

    public List<LoadBalancerDescription> getLoadBalancerDescriptions() {
        if (this.loadBalancerDescriptions == null) {
            this.loadBalancerDescriptions = new ArrayList();
        }
        return this.loadBalancerDescriptions;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerDescriptions() == null ? 0 : getLoadBalancerDescriptions().hashCode()) + 31) * 31;
        if (getNextMarker() != null) {
            i = getNextMarker().hashCode();
        }
        return hashCode + i;
    }

    public void setLoadBalancerDescriptions(Collection<LoadBalancerDescription> collection) {
        if (collection == null) {
            this.loadBalancerDescriptions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.loadBalancerDescriptions = arrayList;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerDescriptions != null) {
            stringBuilder.append("LoadBalancerDescriptions: " + this.loadBalancerDescriptions + ", ");
        }
        if (this.nextMarker != null) {
            stringBuilder.append("NextMarker: " + this.nextMarker + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeLoadBalancersResult withLoadBalancerDescriptions(Collection<LoadBalancerDescription> collection) {
        if (collection == null) {
            this.loadBalancerDescriptions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.loadBalancerDescriptions = arrayList;
        }
        return this;
    }

    public DescribeLoadBalancersResult withLoadBalancerDescriptions(LoadBalancerDescription... loadBalancerDescriptionArr) {
        if (getLoadBalancerDescriptions() == null) {
            setLoadBalancerDescriptions(new ArrayList(loadBalancerDescriptionArr.length));
        }
        for (Object add : loadBalancerDescriptionArr) {
            getLoadBalancerDescriptions().add(add);
        }
        return this;
    }

    public DescribeLoadBalancersResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }
}
