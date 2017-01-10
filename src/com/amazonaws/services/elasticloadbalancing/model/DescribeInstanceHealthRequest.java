package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeInstanceHealthRequest extends AmazonWebServiceRequest {
    private List<Instance> instances;
    private String loadBalancerName;

    public DescribeInstanceHealthRequest(String str) {
        this.loadBalancerName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeInstanceHealthRequest)) {
            return false;
        }
        DescribeInstanceHealthRequest describeInstanceHealthRequest = (DescribeInstanceHealthRequest) obj;
        if (((describeInstanceHealthRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeInstanceHealthRequest.getLoadBalancerName() != null && !describeInstanceHealthRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        return ((describeInstanceHealthRequest.getInstances() == null ? 1 : 0) ^ (getInstances() == null ? 1 : 0)) == 0 ? describeInstanceHealthRequest.getInstances() == null || describeInstanceHealthRequest.getInstances().equals(getInstances()) : false;
    }

    public List<Instance> getInstances() {
        if (this.instances == null) {
            this.instances = new ArrayList();
        }
        return this.instances;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31;
        if (getInstances() != null) {
            i = getInstances().hashCode();
        }
        return hashCode + i;
    }

    public void setInstances(Collection<Instance> collection) {
        if (collection == null) {
            this.instances = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.instances = arrayList;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.instances != null) {
            stringBuilder.append("Instances: " + this.instances + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeInstanceHealthRequest withInstances(Collection<Instance> collection) {
        if (collection == null) {
            this.instances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instances = arrayList;
        }
        return this;
    }

    public DescribeInstanceHealthRequest withInstances(Instance... instanceArr) {
        if (getInstances() == null) {
            setInstances(new ArrayList(instanceArr.length));
        }
        for (Object add : instanceArr) {
            getInstances().add(add);
        }
        return this;
    }

    public DescribeInstanceHealthRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }
}
