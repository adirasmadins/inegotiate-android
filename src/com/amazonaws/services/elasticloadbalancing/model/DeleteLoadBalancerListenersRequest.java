package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeleteLoadBalancerListenersRequest extends AmazonWebServiceRequest {
    private String loadBalancerName;
    private List<Integer> loadBalancerPorts;

    public DeleteLoadBalancerListenersRequest(String str, List<Integer> list) {
        this.loadBalancerName = str;
        this.loadBalancerPorts = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteLoadBalancerListenersRequest)) {
            return false;
        }
        DeleteLoadBalancerListenersRequest deleteLoadBalancerListenersRequest = (DeleteLoadBalancerListenersRequest) obj;
        if (((deleteLoadBalancerListenersRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteLoadBalancerListenersRequest.getLoadBalancerName() != null && !deleteLoadBalancerListenersRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        return ((deleteLoadBalancerListenersRequest.getLoadBalancerPorts() == null ? 1 : 0) ^ (getLoadBalancerPorts() == null ? 1 : 0)) == 0 ? deleteLoadBalancerListenersRequest.getLoadBalancerPorts() == null || deleteLoadBalancerListenersRequest.getLoadBalancerPorts().equals(getLoadBalancerPorts()) : false;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public List<Integer> getLoadBalancerPorts() {
        if (this.loadBalancerPorts == null) {
            this.loadBalancerPorts = new ArrayList();
        }
        return this.loadBalancerPorts;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31;
        if (getLoadBalancerPorts() != null) {
            i = getLoadBalancerPorts().hashCode();
        }
        return hashCode + i;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public void setLoadBalancerPorts(Collection<Integer> collection) {
        if (collection == null) {
            this.loadBalancerPorts = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.loadBalancerPorts = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.loadBalancerPorts != null) {
            stringBuilder.append("LoadBalancerPorts: " + this.loadBalancerPorts + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteLoadBalancerListenersRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public DeleteLoadBalancerListenersRequest withLoadBalancerPorts(Collection<Integer> collection) {
        if (collection == null) {
            this.loadBalancerPorts = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.loadBalancerPorts = arrayList;
        }
        return this;
    }

    public DeleteLoadBalancerListenersRequest withLoadBalancerPorts(Integer... numArr) {
        if (getLoadBalancerPorts() == null) {
            setLoadBalancerPorts(new ArrayList(numArr.length));
        }
        for (Object add : numArr) {
            getLoadBalancerPorts().add(add);
        }
        return this;
    }
}
