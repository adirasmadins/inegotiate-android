package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAvailabilityZonesResult {
    private List<AvailabilityZone> availabilityZones;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAvailabilityZonesResult)) {
            return false;
        }
        DescribeAvailabilityZonesResult describeAvailabilityZonesResult = (DescribeAvailabilityZonesResult) obj;
        return ((describeAvailabilityZonesResult.getAvailabilityZones() == null ? 1 : 0) ^ (getAvailabilityZones() == null ? 1 : 0)) == 0 ? describeAvailabilityZonesResult.getAvailabilityZones() == null || describeAvailabilityZonesResult.getAvailabilityZones().equals(getAvailabilityZones()) : false;
    }

    public List<AvailabilityZone> getAvailabilityZones() {
        if (this.availabilityZones == null) {
            this.availabilityZones = new ArrayList();
        }
        return this.availabilityZones;
    }

    public int hashCode() {
        return (getAvailabilityZones() == null ? 0 : getAvailabilityZones().hashCode()) + 31;
    }

    public void setAvailabilityZones(Collection<AvailabilityZone> collection) {
        if (collection == null) {
            this.availabilityZones = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.availabilityZones = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.availabilityZones != null) {
            stringBuilder.append("AvailabilityZones: " + this.availabilityZones + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAvailabilityZonesResult withAvailabilityZones(Collection<AvailabilityZone> collection) {
        if (collection == null) {
            this.availabilityZones = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.availabilityZones = arrayList;
        }
        return this;
    }

    public DescribeAvailabilityZonesResult withAvailabilityZones(AvailabilityZone... availabilityZoneArr) {
        if (getAvailabilityZones() == null) {
            setAvailabilityZones(new ArrayList(availabilityZoneArr.length));
        }
        for (Object add : availabilityZoneArr) {
            getAvailabilityZones().add(add);
        }
        return this;
    }
}
