package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateLoadBalancerRequest extends AmazonWebServiceRequest {
    private List<String> availabilityZones;
    private List<Listener> listeners;
    private String loadBalancerName;
    private String scheme;
    private List<String> securityGroups;
    private List<String> subnets;

    public CreateLoadBalancerRequest(String str) {
        this.loadBalancerName = str;
    }

    public CreateLoadBalancerRequest(String str, List<Listener> list, List<String> list2) {
        this.loadBalancerName = str;
        this.listeners = list;
        this.availabilityZones = list2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateLoadBalancerRequest)) {
            return false;
        }
        CreateLoadBalancerRequest createLoadBalancerRequest = (CreateLoadBalancerRequest) obj;
        if (((createLoadBalancerRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createLoadBalancerRequest.getLoadBalancerName() != null && !createLoadBalancerRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        if (((createLoadBalancerRequest.getListeners() == null ? 1 : 0) ^ (getListeners() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createLoadBalancerRequest.getListeners() != null && !createLoadBalancerRequest.getListeners().equals(getListeners())) {
            return false;
        }
        if (((createLoadBalancerRequest.getAvailabilityZones() == null ? 1 : 0) ^ (getAvailabilityZones() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createLoadBalancerRequest.getAvailabilityZones() != null && !createLoadBalancerRequest.getAvailabilityZones().equals(getAvailabilityZones())) {
            return false;
        }
        if (((createLoadBalancerRequest.getSubnets() == null ? 1 : 0) ^ (getSubnets() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createLoadBalancerRequest.getSubnets() != null && !createLoadBalancerRequest.getSubnets().equals(getSubnets())) {
            return false;
        }
        if (((createLoadBalancerRequest.getSecurityGroups() == null ? 1 : 0) ^ (getSecurityGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createLoadBalancerRequest.getSecurityGroups() != null && !createLoadBalancerRequest.getSecurityGroups().equals(getSecurityGroups())) {
            return false;
        }
        return ((createLoadBalancerRequest.getScheme() == null ? 1 : 0) ^ (getScheme() == null ? 1 : 0)) == 0 ? createLoadBalancerRequest.getScheme() == null || createLoadBalancerRequest.getScheme().equals(getScheme()) : false;
    }

    public List<String> getAvailabilityZones() {
        if (this.availabilityZones == null) {
            this.availabilityZones = new ArrayList();
        }
        return this.availabilityZones;
    }

    public List<Listener> getListeners() {
        if (this.listeners == null) {
            this.listeners = new ArrayList();
        }
        return this.listeners;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public String getScheme() {
        return this.scheme;
    }

    public List<String> getSecurityGroups() {
        if (this.securityGroups == null) {
            this.securityGroups = new ArrayList();
        }
        return this.securityGroups;
    }

    public List<String> getSubnets() {
        if (this.subnets == null) {
            this.subnets = new ArrayList();
        }
        return this.subnets;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSecurityGroups() == null ? 0 : getSecurityGroups().hashCode()) + (((getSubnets() == null ? 0 : getSubnets().hashCode()) + (((getAvailabilityZones() == null ? 0 : getAvailabilityZones().hashCode()) + (((getListeners() == null ? 0 : getListeners().hashCode()) + (((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getScheme() != null) {
            i = getScheme().hashCode();
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

    public void setListeners(Collection<Listener> collection) {
        if (collection == null) {
            this.listeners = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.listeners = arrayList;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.securityGroups = arrayList;
    }

    public void setSubnets(Collection<String> collection) {
        if (collection == null) {
            this.subnets = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.subnets = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.listeners != null) {
            stringBuilder.append("Listeners: " + this.listeners + ", ");
        }
        if (this.availabilityZones != null) {
            stringBuilder.append("AvailabilityZones: " + this.availabilityZones + ", ");
        }
        if (this.subnets != null) {
            stringBuilder.append("Subnets: " + this.subnets + ", ");
        }
        if (this.securityGroups != null) {
            stringBuilder.append("SecurityGroups: " + this.securityGroups + ", ");
        }
        if (this.scheme != null) {
            stringBuilder.append("Scheme: " + this.scheme + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateLoadBalancerRequest withAvailabilityZones(Collection<String> collection) {
        if (collection == null) {
            this.availabilityZones = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.availabilityZones = arrayList;
        }
        return this;
    }

    public CreateLoadBalancerRequest withAvailabilityZones(String... strArr) {
        if (getAvailabilityZones() == null) {
            setAvailabilityZones(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAvailabilityZones().add(add);
        }
        return this;
    }

    public CreateLoadBalancerRequest withListeners(Collection<Listener> collection) {
        if (collection == null) {
            this.listeners = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.listeners = arrayList;
        }
        return this;
    }

    public CreateLoadBalancerRequest withListeners(Listener... listenerArr) {
        if (getListeners() == null) {
            setListeners(new ArrayList(listenerArr.length));
        }
        for (Object add : listenerArr) {
            getListeners().add(add);
        }
        return this;
    }

    public CreateLoadBalancerRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public CreateLoadBalancerRequest withScheme(String str) {
        this.scheme = str;
        return this;
    }

    public CreateLoadBalancerRequest withSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.securityGroups = arrayList;
        }
        return this;
    }

    public CreateLoadBalancerRequest withSecurityGroups(String... strArr) {
        if (getSecurityGroups() == null) {
            setSecurityGroups(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSecurityGroups().add(add);
        }
        return this;
    }

    public CreateLoadBalancerRequest withSubnets(Collection<String> collection) {
        if (collection == null) {
            this.subnets = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.subnets = arrayList;
        }
        return this;
    }

    public CreateLoadBalancerRequest withSubnets(String... strArr) {
        if (getSubnets() == null) {
            setSubnets(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSubnets().add(add);
        }
        return this;
    }
}
