package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EnableAvailabilityZonesForLoadBalancerRequest extends AmazonWebServiceRequest {
    private List<String> availabilityZones;
    private String loadBalancerName;

    public EnableAvailabilityZonesForLoadBalancerRequest(String str, List<String> list) {
        this.loadBalancerName = str;
        this.availabilityZones = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EnableAvailabilityZonesForLoadBalancerRequest)) {
            return false;
        }
        EnableAvailabilityZonesForLoadBalancerRequest enableAvailabilityZonesForLoadBalancerRequest = (EnableAvailabilityZonesForLoadBalancerRequest) obj;
        if (((enableAvailabilityZonesForLoadBalancerRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (enableAvailabilityZonesForLoadBalancerRequest.getLoadBalancerName() != null && !enableAvailabilityZonesForLoadBalancerRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        return ((enableAvailabilityZonesForLoadBalancerRequest.getAvailabilityZones() == null ? 1 : 0) ^ (getAvailabilityZones() == null ? 1 : 0)) == 0 ? enableAvailabilityZonesForLoadBalancerRequest.getAvailabilityZones() == null || enableAvailabilityZonesForLoadBalancerRequest.getAvailabilityZones().equals(getAvailabilityZones()) : false;
    }

    public List<String> getAvailabilityZones() {
        if (this.availabilityZones == null) {
            this.availabilityZones = new ArrayList();
        }
        return this.availabilityZones;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31;
        if (getAvailabilityZones() != null) {
            i = getAvailabilityZones().hashCode();
        }
        return hashCode + i;
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

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.availabilityZones != null) {
            stringBuilder.append("AvailabilityZones: " + this.availabilityZones + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public EnableAvailabilityZonesForLoadBalancerRequest withAvailabilityZones(Collection<String> collection) {
        if (collection == null) {
            this.availabilityZones = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.availabilityZones = arrayList;
        }
        return this;
    }

    public EnableAvailabilityZonesForLoadBalancerRequest withAvailabilityZones(String... strArr) {
        if (getAvailabilityZones() == null) {
            setAvailabilityZones(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAvailabilityZones().add(add);
        }
        return this;
    }

    public EnableAvailabilityZonesForLoadBalancerRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }
}
