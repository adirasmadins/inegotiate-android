package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EnableAvailabilityZonesForLoadBalancerResult {
    private List<String> availabilityZones;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EnableAvailabilityZonesForLoadBalancerResult)) {
            return false;
        }
        EnableAvailabilityZonesForLoadBalancerResult enableAvailabilityZonesForLoadBalancerResult = (EnableAvailabilityZonesForLoadBalancerResult) obj;
        return ((enableAvailabilityZonesForLoadBalancerResult.getAvailabilityZones() == null ? 1 : 0) ^ (getAvailabilityZones() == null ? 1 : 0)) == 0 ? enableAvailabilityZonesForLoadBalancerResult.getAvailabilityZones() == null || enableAvailabilityZonesForLoadBalancerResult.getAvailabilityZones().equals(getAvailabilityZones()) : false;
    }

    public List<String> getAvailabilityZones() {
        if (this.availabilityZones == null) {
            this.availabilityZones = new ArrayList();
        }
        return this.availabilityZones;
    }

    public int hashCode() {
        return (getAvailabilityZones() == null ? 0 : getAvailabilityZones().hashCode()) + 31;
    }

    public void setAvailabilityZones(Collection<String> collection) {
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

    public EnableAvailabilityZonesForLoadBalancerResult withAvailabilityZones(Collection<String> collection) {
        if (collection == null) {
            this.availabilityZones = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.availabilityZones = arrayList;
        }
        return this;
    }

    public EnableAvailabilityZonesForLoadBalancerResult withAvailabilityZones(String... strArr) {
        if (getAvailabilityZones() == null) {
            setAvailabilityZones(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAvailabilityZones().add(add);
        }
        return this;
    }
}
