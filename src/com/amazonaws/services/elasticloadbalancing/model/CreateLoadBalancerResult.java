package com.amazonaws.services.elasticloadbalancing.model;

public class CreateLoadBalancerResult {
    private String dNSName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateLoadBalancerResult)) {
            return false;
        }
        CreateLoadBalancerResult createLoadBalancerResult = (CreateLoadBalancerResult) obj;
        return ((createLoadBalancerResult.getDNSName() == null ? 1 : 0) ^ (getDNSName() == null ? 1 : 0)) == 0 ? createLoadBalancerResult.getDNSName() == null || createLoadBalancerResult.getDNSName().equals(getDNSName()) : false;
    }

    public String getDNSName() {
        return this.dNSName;
    }

    public int hashCode() {
        return (getDNSName() == null ? 0 : getDNSName().hashCode()) + 31;
    }

    public void setDNSName(String str) {
        this.dNSName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.dNSName != null) {
            stringBuilder.append("DNSName: " + this.dNSName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateLoadBalancerResult withDNSName(String str) {
        this.dNSName = str;
        return this;
    }
}
