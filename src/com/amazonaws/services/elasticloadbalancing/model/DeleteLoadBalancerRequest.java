package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteLoadBalancerRequest extends AmazonWebServiceRequest {
    private String loadBalancerName;

    public DeleteLoadBalancerRequest(String str) {
        this.loadBalancerName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteLoadBalancerRequest)) {
            return false;
        }
        DeleteLoadBalancerRequest deleteLoadBalancerRequest = (DeleteLoadBalancerRequest) obj;
        return ((deleteLoadBalancerRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) == 0 ? deleteLoadBalancerRequest.getLoadBalancerName() == null || deleteLoadBalancerRequest.getLoadBalancerName().equals(getLoadBalancerName()) : false;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public int hashCode() {
        return (getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteLoadBalancerRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }
}
