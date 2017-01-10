package com.amazonaws.services.simpleemail.model;

import com.amazonaws.AmazonWebServiceRequest;

public class VerifyDomainDkimRequest extends AmazonWebServiceRequest {
    private String domain;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyDomainDkimRequest)) {
            return false;
        }
        VerifyDomainDkimRequest verifyDomainDkimRequest = (VerifyDomainDkimRequest) obj;
        return ((verifyDomainDkimRequest.getDomain() == null ? 1 : 0) ^ (getDomain() == null ? 1 : 0)) == 0 ? verifyDomainDkimRequest.getDomain() == null || verifyDomainDkimRequest.getDomain().equals(getDomain()) : false;
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

    public VerifyDomainDkimRequest withDomain(String str) {
        this.domain = str;
        return this;
    }
}
