package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ConfigureHealthCheckRequest extends AmazonWebServiceRequest {
    private HealthCheck healthCheck;
    private String loadBalancerName;

    public ConfigureHealthCheckRequest(String str, HealthCheck healthCheck) {
        this.loadBalancerName = str;
        this.healthCheck = healthCheck;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfigureHealthCheckRequest)) {
            return false;
        }
        ConfigureHealthCheckRequest configureHealthCheckRequest = (ConfigureHealthCheckRequest) obj;
        if (((configureHealthCheckRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (configureHealthCheckRequest.getLoadBalancerName() != null && !configureHealthCheckRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        return ((configureHealthCheckRequest.getHealthCheck() == null ? 1 : 0) ^ (getHealthCheck() == null ? 1 : 0)) == 0 ? configureHealthCheckRequest.getHealthCheck() == null || configureHealthCheckRequest.getHealthCheck().equals(getHealthCheck()) : false;
    }

    public HealthCheck getHealthCheck() {
        return this.healthCheck;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31;
        if (getHealthCheck() != null) {
            i = getHealthCheck().hashCode();
        }
        return hashCode + i;
    }

    public void setHealthCheck(HealthCheck healthCheck) {
        this.healthCheck = healthCheck;
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
        if (this.healthCheck != null) {
            stringBuilder.append("HealthCheck: " + this.healthCheck + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ConfigureHealthCheckRequest withHealthCheck(HealthCheck healthCheck) {
        this.healthCheck = healthCheck;
        return this;
    }

    public ConfigureHealthCheckRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }
}
