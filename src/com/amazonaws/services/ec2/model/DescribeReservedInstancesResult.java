package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeReservedInstancesResult {
    private List<ReservedInstances> reservedInstances;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeReservedInstancesResult)) {
            return false;
        }
        DescribeReservedInstancesResult describeReservedInstancesResult = (DescribeReservedInstancesResult) obj;
        return ((describeReservedInstancesResult.getReservedInstances() == null ? 1 : 0) ^ (getReservedInstances() == null ? 1 : 0)) == 0 ? describeReservedInstancesResult.getReservedInstances() == null || describeReservedInstancesResult.getReservedInstances().equals(getReservedInstances()) : false;
    }

    public List<ReservedInstances> getReservedInstances() {
        if (this.reservedInstances == null) {
            this.reservedInstances = new ArrayList();
        }
        return this.reservedInstances;
    }

    public int hashCode() {
        return (getReservedInstances() == null ? 0 : getReservedInstances().hashCode()) + 31;
    }

    public void setReservedInstances(Collection<ReservedInstances> collection) {
        if (collection == null) {
            this.reservedInstances = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.reservedInstances = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstances != null) {
            stringBuilder.append("ReservedInstances: " + this.reservedInstances + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeReservedInstancesResult withReservedInstances(Collection<ReservedInstances> collection) {
        if (collection == null) {
            this.reservedInstances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.reservedInstances = arrayList;
        }
        return this;
    }

    public DescribeReservedInstancesResult withReservedInstances(ReservedInstances... reservedInstancesArr) {
        if (getReservedInstances() == null) {
            setReservedInstances(new ArrayList(reservedInstancesArr.length));
        }
        for (Object add : reservedInstancesArr) {
            getReservedInstances().add(add);
        }
        return this;
    }
}
