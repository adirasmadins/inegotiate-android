package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeregisterInstancesFromLoadBalancerResult {
    private List<Instance> instances;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeregisterInstancesFromLoadBalancerResult)) {
            return false;
        }
        DeregisterInstancesFromLoadBalancerResult deregisterInstancesFromLoadBalancerResult = (DeregisterInstancesFromLoadBalancerResult) obj;
        return ((deregisterInstancesFromLoadBalancerResult.getInstances() == null ? 1 : 0) ^ (getInstances() == null ? 1 : 0)) == 0 ? deregisterInstancesFromLoadBalancerResult.getInstances() == null || deregisterInstancesFromLoadBalancerResult.getInstances().equals(getInstances()) : false;
    }

    public List<Instance> getInstances() {
        if (this.instances == null) {
            this.instances = new ArrayList();
        }
        return this.instances;
    }

    public int hashCode() {
        return (getInstances() == null ? 0 : getInstances().hashCode()) + 31;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instances != null) {
            stringBuilder.append("Instances: " + this.instances + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeregisterInstancesFromLoadBalancerResult withInstances(Collection<Instance> collection) {
        if (collection == null) {
            this.instances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instances = arrayList;
        }
        return this;
    }

    public DeregisterInstancesFromLoadBalancerResult withInstances(Instance... instanceArr) {
        if (getInstances() == null) {
            setInstances(new ArrayList(instanceArr.length));
        }
        for (Object add : instanceArr) {
            getInstances().add(add);
        }
        return this;
    }
}
