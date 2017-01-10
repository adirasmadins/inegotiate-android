package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DisableAvailabilityZonesForLoadBalancerRequest extends AmazonWebServiceRequest {
    private List<String> availabilityZones;
    private String loadBalancerName;

    public DisableAvailabilityZonesForLoadBalancerRequest(String str, List<String> list) {
        this.loadBalancerName = str;
        this.availabilityZones = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DisableAvailabilityZonesForLoadBalancerRequest)) {
            return false;
        }
        DisableAvailabilityZonesForLoadBalancerRequest disableAvailabilityZonesForLoadBalancerRequest = (DisableAvailabilityZonesForLoadBalancerRequest) obj;
        if (((disableAvailabilityZonesForLoadBalancerRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (disableAvailabilityZonesForLoadBalancerRequest.getLoadBalancerName() != null && !disableAvailabilityZonesForLoadBalancerRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        return ((disableAvailabilityZonesForLoadBalancerRequest.getAvailabilityZones() == null ? 1 : 0) ^ (getAvailabilityZones() == null ? 1 : 0)) == 0 ? disableAvailabilityZonesForLoadBalancerRequest.getAvailabilityZones() == null || disableAvailabilityZonesForLoadBalancerRequest.getAvailabilityZones().equals(getAvailabilityZones()) : false;
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

    public DisableAvailabilityZonesForLoadBalancerRequest withAvailabilityZones(Collection<String> collection) {
        if (collection == null) {
            this.availabilityZones = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.availabilityZones = arrayList;
        }
        return this;
    }

    public DisableAvailabilityZonesForLoadBalancerRequest withAvailabilityZones(String... strArr) {
        if (getAvailabilityZones() == null) {
            setAvailabilityZones(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAvailabilityZones().add(add);
        }
        return this;
    }

    public DisableAvailabilityZonesForLoadBalancerRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }
}
