package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class AllocateAddressRequest extends AmazonWebServiceRequest {
    private String domain;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AllocateAddressRequest)) {
            return false;
        }
        AllocateAddressRequest allocateAddressRequest = (AllocateAddressRequest) obj;
        return ((allocateAddressRequest.getDomain() == null ? 1 : 0) ^ (getDomain() == null ? 1 : 0)) == 0 ? allocateAddressRequest.getDomain() == null || allocateAddressRequest.getDomain().equals(getDomain()) : false;
    }

    public String getDomain() {
        return this.domain;
    }

    public int hashCode() {
        return (getDomain() == null ? 0 : getDomain().hashCode()) + 31;
    }

    public void setDomain(DomainType domainType) {
        this.domain = domainType.toString();
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.domain != null) {
            stringBuilder.append("Domain: " + this.domain + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AllocateAddressRequest withDomain(DomainType domainType) {
        this.domain = domainType.toString();
        return this;
    }

    public AllocateAddressRequest withDomain(String str) {
        this.domain = str;
        return this;
    }
}
