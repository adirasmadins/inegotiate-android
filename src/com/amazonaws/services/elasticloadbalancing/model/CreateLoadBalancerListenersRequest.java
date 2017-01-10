package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateLoadBalancerListenersRequest extends AmazonWebServiceRequest {
    private List<Listener> listeners;
    private String loadBalancerName;

    public CreateLoadBalancerListenersRequest(String str, List<Listener> list) {
        this.loadBalancerName = str;
        this.listeners = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateLoadBalancerListenersRequest)) {
            return false;
        }
        CreateLoadBalancerListenersRequest createLoadBalancerListenersRequest = (CreateLoadBalancerListenersRequest) obj;
        if (((createLoadBalancerListenersRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createLoadBalancerListenersRequest.getLoadBalancerName() != null && !createLoadBalancerListenersRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        return ((createLoadBalancerListenersRequest.getListeners() == null ? 1 : 0) ^ (getListeners() == null ? 1 : 0)) == 0 ? createLoadBalancerListenersRequest.getListeners() == null || createLoadBalancerListenersRequest.getListeners().equals(getListeners()) : false;
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

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31;
        if (getListeners() != null) {
            i = getListeners().hashCode();
        }
        return hashCode + i;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.listeners != null) {
            stringBuilder.append("Listeners: " + this.listeners + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateLoadBalancerListenersRequest withListeners(Collection<Listener> collection) {
        if (collection == null) {
            this.listeners = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.listeners = arrayList;
        }
        return this;
    }

    public CreateLoadBalancerListenersRequest withListeners(Listener... listenerArr) {
        if (getListeners() == null) {
            setListeners(new ArrayList(listenerArr.length));
        }
        for (Object add : listenerArr) {
            getListeners().add(add);
        }
        return this;
    }

    public CreateLoadBalancerListenersRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }
}
