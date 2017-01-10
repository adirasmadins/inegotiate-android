package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DetachLoadBalancerFromSubnetsRequest extends AmazonWebServiceRequest {
    private String loadBalancerName;
    private List<String> subnets;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DetachLoadBalancerFromSubnetsRequest)) {
            return false;
        }
        DetachLoadBalancerFromSubnetsRequest detachLoadBalancerFromSubnetsRequest = (DetachLoadBalancerFromSubnetsRequest) obj;
        if (((detachLoadBalancerFromSubnetsRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (detachLoadBalancerFromSubnetsRequest.getLoadBalancerName() != null && !detachLoadBalancerFromSubnetsRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        return ((detachLoadBalancerFromSubnetsRequest.getSubnets() == null ? 1 : 0) ^ (getSubnets() == null ? 1 : 0)) == 0 ? detachLoadBalancerFromSubnetsRequest.getSubnets() == null || detachLoadBalancerFromSubnetsRequest.getSubnets().equals(getSubnets()) : false;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public List<String> getSubnets() {
        if (this.subnets == null) {
            this.subnets = new ArrayList();
        }
        return this.subnets;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31;
        if (getSubnets() != null) {
            i = getSubnets().hashCode();
        }
        return hashCode + i;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
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
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.subnets != null) {
            stringBuilder.append("Subnets: " + this.subnets + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DetachLoadBalancerFromSubnetsRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public DetachLoadBalancerFromSubnetsRequest withSubnets(Collection<String> collection) {
        if (collection == null) {
            this.subnets = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.subnets = arrayList;
        }
        return this;
    }

    public DetachLoadBalancerFromSubnetsRequest withSubnets(String... strArr) {
        if (getSubnets() == null) {
            setSubnets(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSubnets().add(add);
        }
        return this;
    }
}
