package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TerminateInstancesResult {
    private List<InstanceStateChange> terminatingInstances;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TerminateInstancesResult)) {
            return false;
        }
        TerminateInstancesResult terminateInstancesResult = (TerminateInstancesResult) obj;
        return ((terminateInstancesResult.getTerminatingInstances() == null ? 1 : 0) ^ (getTerminatingInstances() == null ? 1 : 0)) == 0 ? terminateInstancesResult.getTerminatingInstances() == null || terminateInstancesResult.getTerminatingInstances().equals(getTerminatingInstances()) : false;
    }

    public List<InstanceStateChange> getTerminatingInstances() {
        if (this.terminatingInstances == null) {
            this.terminatingInstances = new ArrayList();
        }
        return this.terminatingInstances;
    }

    public int hashCode() {
        return (getTerminatingInstances() == null ? 0 : getTerminatingInstances().hashCode()) + 31;
    }

    public void setTerminatingInstances(Collection<InstanceStateChange> collection) {
        if (collection == null) {
            this.terminatingInstances = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.terminatingInstances = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.terminatingInstances != null) {
            stringBuilder.append("TerminatingInstances: " + this.terminatingInstances + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public TerminateInstancesResult withTerminatingInstances(Collection<InstanceStateChange> collection) {
        if (collection == null) {
            this.terminatingInstances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.terminatingInstances = arrayList;
        }
        return this;
    }

    public TerminateInstancesResult withTerminatingInstances(InstanceStateChange... instanceStateChangeArr) {
        if (getTerminatingInstances() == null) {
            setTerminatingInstances(new ArrayList(instanceStateChangeArr.length));
        }
        for (Object add : instanceStateChangeArr) {
            getTerminatingInstances().add(add);
        }
        return this;
    }
}
