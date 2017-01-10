package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeScalingProcessTypesResult {
    private List<ProcessType> processes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeScalingProcessTypesResult)) {
            return false;
        }
        DescribeScalingProcessTypesResult describeScalingProcessTypesResult = (DescribeScalingProcessTypesResult) obj;
        return ((describeScalingProcessTypesResult.getProcesses() == null ? 1 : 0) ^ (getProcesses() == null ? 1 : 0)) == 0 ? describeScalingProcessTypesResult.getProcesses() == null || describeScalingProcessTypesResult.getProcesses().equals(getProcesses()) : false;
    }

    public List<ProcessType> getProcesses() {
        if (this.processes == null) {
            this.processes = new ArrayList();
        }
        return this.processes;
    }

    public int hashCode() {
        return (getProcesses() == null ? 0 : getProcesses().hashCode()) + 31;
    }

    public void setProcesses(Collection<ProcessType> collection) {
        if (collection == null) {
            this.processes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.processes = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.processes != null) {
            stringBuilder.append("Processes: " + this.processes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeScalingProcessTypesResult withProcesses(Collection<ProcessType> collection) {
        if (collection == null) {
            this.processes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.processes = arrayList;
        }
        return this;
    }

    public DescribeScalingProcessTypesResult withProcesses(ProcessType... processTypeArr) {
        if (getProcesses() == null) {
            setProcesses(new ArrayList(processTypeArr.length));
        }
        for (Object add : processTypeArr) {
            getProcesses().add(add);
        }
        return this;
    }
}
