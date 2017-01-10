package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeLoadBalancersRequest extends AmazonWebServiceRequest {
    private List<String> loadBalancerNames;
    private String marker;

    public DescribeLoadBalancersRequest(List<String> list) {
        this.loadBalancerNames = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeLoadBalancersRequest)) {
            return false;
        }
        DescribeLoadBalancersRequest describeLoadBalancersRequest = (DescribeLoadBalancersRequest) obj;
        if (((describeLoadBalancersRequest.getLoadBalancerNames() == null ? 1 : 0) ^ (getLoadBalancerNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeLoadBalancersRequest.getLoadBalancerNames() != null && !describeLoadBalancersRequest.getLoadBalancerNames().equals(getLoadBalancerNames())) {
            return false;
        }
        return ((describeLoadBalancersRequest.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) == 0 ? describeLoadBalancersRequest.getMarker() == null || describeLoadBalancersRequest.getMarker().equals(getMarker()) : false;
    }

    public List<String> getLoadBalancerNames() {
        if (this.loadBalancerNames == null) {
            this.loadBalancerNames = new ArrayList();
        }
        return this.loadBalancerNames;
    }

    public String getMarker() {
        return this.marker;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerNames() == null ? 0 : getLoadBalancerNames().hashCode()) + 31) * 31;
        if (getMarker() != null) {
            i = getMarker().hashCode();
        }
        return hashCode + i;
    }

    public void setLoadBalancerNames(Collection<String> collection) {
        if (collection == null) {
            this.loadBalancerNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.loadBalancerNames = arrayList;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerNames != null) {
            stringBuilder.append("LoadBalancerNames: " + this.loadBalancerNames + ", ");
        }
        if (this.marker != null) {
            stringBuilder.append("Marker: " + this.marker + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeLoadBalancersRequest withLoadBalancerNames(Collection<String> collection) {
        if (collection == null) {
            this.loadBalancerNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.loadBalancerNames = arrayList;
        }
        return this;
    }

    public DescribeLoadBalancersRequest withLoadBalancerNames(String... strArr) {
        if (getLoadBalancerNames() == null) {
            setLoadBalancerNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getLoadBalancerNames().add(add);
        }
        return this;
    }

    public DescribeLoadBalancersRequest withMarker(String str) {
        this.marker = str;
        return this;
    }
}
