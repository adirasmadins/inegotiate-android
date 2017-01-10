package com.amazonaws.services.elasticloadbalancing.model;

public class Listener {
    private Integer instancePort;
    private String instanceProtocol;
    private Integer loadBalancerPort;
    private String protocol;
    private String sSLCertificateId;

    public Listener(String str, Integer num, Integer num2) {
        this.protocol = str;
        this.loadBalancerPort = num;
        this.instancePort = num2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Listener)) {
            return false;
        }
        Listener listener = (Listener) obj;
        if (((listener.getProtocol() == null ? 1 : 0) ^ (getProtocol() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listener.getProtocol() != null && !listener.getProtocol().equals(getProtocol())) {
            return false;
        }
        if (((listener.getLoadBalancerPort() == null ? 1 : 0) ^ (getLoadBalancerPort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listener.getLoadBalancerPort() != null && !listener.getLoadBalancerPort().equals(getLoadBalancerPort())) {
            return false;
        }
        if (((listener.getInstanceProtocol() == null ? 1 : 0) ^ (getInstanceProtocol() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listener.getInstanceProtocol() != null && !listener.getInstanceProtocol().equals(getInstanceProtocol())) {
            return false;
        }
        if (((listener.getInstancePort() == null ? 1 : 0) ^ (getInstancePort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listener.getInstancePort() != null && !listener.getInstancePort().equals(getInstancePort())) {
            return false;
        }
        return ((listener.getSSLCertificateId() == null ? 1 : 0) ^ (getSSLCertificateId() == null ? 1 : 0)) == 0 ? listener.getSSLCertificateId() == null || listener.getSSLCertificateId().equals(getSSLCertificateId()) : false;
    }

    public Integer getInstancePort() {
        return this.instancePort;
    }

    public String getInstanceProtocol() {
        return this.instanceProtocol;
    }

    public Integer getLoadBalancerPort() {
        return this.loadBalancerPort;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getSSLCertificateId() {
        return this.sSLCertificateId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstancePort() == null ? 0 : getInstancePort().hashCode()) + (((getInstanceProtocol() == null ? 0 : getInstanceProtocol().hashCode()) + (((getLoadBalancerPort() == null ? 0 : getLoadBalancerPort().hashCode()) + (((getProtocol() == null ? 0 : getProtocol().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getSSLCertificateId() != null) {
            i = getSSLCertificateId().hashCode();
        }
        return hashCode + i;
    }

    public void setInstancePort(Integer num) {
        this.instancePort = num;
    }

    public void setInstanceProtocol(String str) {
        this.instanceProtocol = str;
    }

    public void setLoadBalancerPort(Integer num) {
        this.loadBalancerPort = num;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setSSLCertificateId(String str) {
        this.sSLCertificateId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.protocol != null) {
            stringBuilder.append("Protocol: " + this.protocol + ", ");
        }
        if (this.loadBalancerPort != null) {
            stringBuilder.append("LoadBalancerPort: " + this.loadBalancerPort + ", ");
        }
        if (this.instanceProtocol != null) {
            stringBuilder.append("InstanceProtocol: " + this.instanceProtocol + ", ");
        }
        if (this.instancePort != null) {
            stringBuilder.append("InstancePort: " + this.instancePort + ", ");
        }
        if (this.sSLCertificateId != null) {
            stringBuilder.append("SSLCertificateId: " + this.sSLCertificateId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Listener withInstancePort(Integer num) {
        this.instancePort = num;
        return this;
    }

    public Listener withInstanceProtocol(String str) {
        this.instanceProtocol = str;
        return this;
    }

    public Listener withLoadBalancerPort(Integer num) {
        this.loadBalancerPort = num;
        return this;
    }

    public Listener withProtocol(String str) {
        this.protocol = str;
        return this;
    }

    public Listener withSSLCertificateId(String str) {
        this.sSLCertificateId = str;
        return this;
    }
}
