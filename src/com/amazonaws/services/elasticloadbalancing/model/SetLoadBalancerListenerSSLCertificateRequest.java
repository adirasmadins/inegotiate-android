package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SetLoadBalancerListenerSSLCertificateRequest extends AmazonWebServiceRequest {
    private String loadBalancerName;
    private Integer loadBalancerPort;
    private String sSLCertificateId;

    public SetLoadBalancerListenerSSLCertificateRequest(String str, Integer num, String str2) {
        this.loadBalancerName = str;
        this.loadBalancerPort = num;
        this.sSLCertificateId = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetLoadBalancerListenerSSLCertificateRequest)) {
            return false;
        }
        SetLoadBalancerListenerSSLCertificateRequest setLoadBalancerListenerSSLCertificateRequest = (SetLoadBalancerListenerSSLCertificateRequest) obj;
        if (((setLoadBalancerListenerSSLCertificateRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setLoadBalancerListenerSSLCertificateRequest.getLoadBalancerName() != null && !setLoadBalancerListenerSSLCertificateRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        if (((setLoadBalancerListenerSSLCertificateRequest.getLoadBalancerPort() == null ? 1 : 0) ^ (getLoadBalancerPort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setLoadBalancerListenerSSLCertificateRequest.getLoadBalancerPort() != null && !setLoadBalancerListenerSSLCertificateRequest.getLoadBalancerPort().equals(getLoadBalancerPort())) {
            return false;
        }
        return ((setLoadBalancerListenerSSLCertificateRequest.getSSLCertificateId() == null ? 1 : 0) ^ (getSSLCertificateId() == null ? 1 : 0)) == 0 ? setLoadBalancerListenerSSLCertificateRequest.getSSLCertificateId() == null || setLoadBalancerListenerSSLCertificateRequest.getSSLCertificateId().equals(getSSLCertificateId()) : false;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public Integer getLoadBalancerPort() {
        return this.loadBalancerPort;
    }

    public String getSSLCertificateId() {
        return this.sSLCertificateId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLoadBalancerPort() == null ? 0 : getLoadBalancerPort().hashCode()) + (((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31)) * 31;
        if (getSSLCertificateId() != null) {
            i = getSSLCertificateId().hashCode();
        }
        return hashCode + i;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public void setLoadBalancerPort(Integer num) {
        this.loadBalancerPort = num;
    }

    public void setSSLCertificateId(String str) {
        this.sSLCertificateId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.loadBalancerPort != null) {
            stringBuilder.append("LoadBalancerPort: " + this.loadBalancerPort + ", ");
        }
        if (this.sSLCertificateId != null) {
            stringBuilder.append("SSLCertificateId: " + this.sSLCertificateId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SetLoadBalancerListenerSSLCertificateRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public SetLoadBalancerListenerSSLCertificateRequest withLoadBalancerPort(Integer num) {
        this.loadBalancerPort = num;
        return this;
    }

    public SetLoadBalancerListenerSSLCertificateRequest withSSLCertificateId(String str) {
        this.sSLCertificateId = str;
        return this;
    }
}
