package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StartInstancesResult {
    private List<InstanceStateChange> startingInstances;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StartInstancesResult)) {
            return false;
        }
        StartInstancesResult startInstancesResult = (StartInstancesResult) obj;
        return ((startInstancesResult.getStartingInstances() == null ? 1 : 0) ^ (getStartingInstances() == null ? 1 : 0)) == 0 ? startInstancesResult.getStartingInstances() == null || startInstancesResult.getStartingInstances().equals(getStartingInstances()) : false;
    }

    public List<InstanceStateChange> getStartingInstances() {
        if (this.startingInstances == null) {
            this.startingInstances = new ArrayList();
        }
        return this.startingInstances;
    }

    public int hashCode() {
        return (getStartingInstances() == null ? 0 : getStartingInstances().hashCode()) + 31;
    }

    public void setStartingInstances(Collection<InstanceStateChange> collection) {
        if (collection == null) {
            this.startingInstances = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.startingInstances = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.startingInstances != null) {
            stringBuilder.append("StartingInstances: " + this.startingInstances + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public StartInstancesResult withStartingInstances(Collection<InstanceStateChange> collection) {
        if (collection == null) {
            this.startingInstances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.startingInstances = arrayList;
        }
        return this;
    }

    public StartInstancesResult withStartingInstances(InstanceStateChange... instanceStateChangeArr) {
        if (getStartingInstances() == null) {
            setStartingInstances(new ArrayList(instanceStateChangeArr.length));
        }
        for (Object add : instanceStateChangeArr) {
            getStartingInstances().add(add);
        }
        return this;
    }
}
