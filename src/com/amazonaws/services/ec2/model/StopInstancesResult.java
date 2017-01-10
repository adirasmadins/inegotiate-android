package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StopInstancesResult {
    private List<InstanceStateChange> stoppingInstances;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StopInstancesResult)) {
            return false;
        }
        StopInstancesResult stopInstancesResult = (StopInstancesResult) obj;
        return ((stopInstancesResult.getStoppingInstances() == null ? 1 : 0) ^ (getStoppingInstances() == null ? 1 : 0)) == 0 ? stopInstancesResult.getStoppingInstances() == null || stopInstancesResult.getStoppingInstances().equals(getStoppingInstances()) : false;
    }

    public List<InstanceStateChange> getStoppingInstances() {
        if (this.stoppingInstances == null) {
            this.stoppingInstances = new ArrayList();
        }
        return this.stoppingInstances;
    }

    public int hashCode() {
        return (getStoppingInstances() == null ? 0 : getStoppingInstances().hashCode()) + 31;
    }

    public void setStoppingInstances(Collection<InstanceStateChange> collection) {
        if (collection == null) {
            this.stoppingInstances = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.stoppingInstances = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.stoppingInstances != null) {
            stringBuilder.append("StoppingInstances: " + this.stoppingInstances + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public StopInstancesResult withStoppingInstances(Collection<InstanceStateChange> collection) {
        if (collection == null) {
            this.stoppingInstances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.stoppingInstances = arrayList;
        }
        return this;
    }

    public StopInstancesResult withStoppingInstances(InstanceStateChange... instanceStateChangeArr) {
        if (getStoppingInstances() == null) {
            setStoppingInstances(new ArrayList(instanceStateChangeArr.length));
        }
        for (Object add : instanceStateChangeArr) {
            getStoppingInstances().add(add);
        }
        return this;
    }
}
