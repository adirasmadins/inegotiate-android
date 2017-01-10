package com.amazonaws.services.simpleemail.model;

import com.amazonaws.AmazonWebServiceRequest;

public class VerifyDomainIdentityRequest extends AmazonWebServiceRequest {
    private String domain;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyDomainIdentityRequest)) {
            return false;
        }
        VerifyDomainIdentityRequest verifyDomainIdentityRequest = (VerifyDomainIdentityRequest) obj;
        return ((verifyDomainIdentityRequest.getDomain() == null ? 1 : 0) ^ (getDomain() == null ? 1 : 0)) == 0 ? verifyDomainIdentityRequest.getDomain() == null || verifyDomainIdentityRequest.getDomain().equals(getDomain()) : false;
    }

    public String getDomain() {
        return this.domain;
    }

    public int hashCode() {
        return (getDomain() == null ? 0 : getDomain().hashCode()) + 31;
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

    public VerifyDomainIdentityRequest withDomain(String str) {
        this.domain = str;
        return this;
    }
}
