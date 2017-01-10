package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeInstanceHealthResult {
    private List<InstanceState> instanceStates;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeInstanceHealthResult)) {
            return false;
        }
        DescribeInstanceHealthResult describeInstanceHealthResult = (DescribeInstanceHealthResult) obj;
        return ((describeInstanceHealthResult.getInstanceStates() == null ? 1 : 0) ^ (getInstanceStates() == null ? 1 : 0)) == 0 ? describeInstanceHealthResult.getInstanceStates() == null || describeInstanceHealthResult.getInstanceStates().equals(getInstanceStates()) : false;
    }

    public List<InstanceState> getInstanceStates() {
        if (this.instanceStates == null) {
            this.instanceStates = new ArrayList();
        }
        return this.instanceStates;
    }

    public int hashCode() {
        return (getInstanceStates() == null ? 0 : getInstanceStates().hashCode()) + 31;
    }

    public void setInstanceStates(Collection<InstanceState> collection) {
        if (collection == null) {
            this.instanceStates = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.instanceStates = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceStates != null) {
            stringBuilder.append("InstanceStates: " + this.instanceStates + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeInstanceHealthResult withInstanceStates(Collection<InstanceState> collection) {
        if (collection == null) {
            this.instanceStates = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instanceStates = arrayList;
        }
        return this;
    }

    public DescribeInstanceHealthResult withInstanceStates(InstanceState... instanceStateArr) {
        if (getInstanceStates() == null) {
            setInstanceStates(new ArrayList(instanceStateArr.length));
        }
        for (Object add : instanceStateArr) {
            getInstanceStates().add(add);
        }
        return this;
    }
}
