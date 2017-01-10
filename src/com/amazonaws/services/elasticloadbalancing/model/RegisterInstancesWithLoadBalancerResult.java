package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegisterInstancesWithLoadBalancerResult {
    private List<Instance> instances;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RegisterInstancesWithLoadBalancerResult)) {
            return false;
        }
        RegisterInstancesWithLoadBalancerResult registerInstancesWithLoadBalancerResult = (RegisterInstancesWithLoadBalancerResult) obj;
        return ((registerInstancesWithLoadBalancerResult.getInstances() == null ? 1 : 0) ^ (getInstances() == null ? 1 : 0)) == 0 ? registerInstancesWithLoadBalancerResult.getInstances() == null || registerInstancesWithLoadBalancerResult.getInstances().equals(getInstances()) : false;
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

    public RegisterInstancesWithLoadBalancerResult withInstances(Collection<Instance> collection) {
        if (collection == null) {
            this.instances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instances = arrayList;
        }
        return this;
    }

    public RegisterInstancesWithLoadBalancerResult withInstances(Instance... instanceArr) {
        if (getInstances() == null) {
            setInstances(new ArrayList(instanceArr.length));
        }
        for (Object add : instanceArr) {
            getInstances().add(add);
        }
        return this;
    }
}
