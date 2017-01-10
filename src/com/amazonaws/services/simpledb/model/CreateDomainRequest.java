package com.amazonaws.services.simpledb.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreateDomainRequest extends AmazonWebServiceRequest {
    private String domainName;

    public CreateDomainRequest(String str) {
        this.domainName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateDomainRequest)) {
            return false;
        }
        CreateDomainRequest createDomainRequest = (CreateDomainRequest) obj;
        return ((createDomainRequest.getDomainName() == null ? 1 : 0) ^ (getDomainName() == null ? 1 : 0)) == 0 ? createDomainRequest.getDomainName() == null || createDomainRequest.getDomainName().equals(getDomainName()) : false;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public int hashCode() {
        return (getDomainName() == null ? 0 : getDomainName().hashCode()) + 31;
    }

    public void setDomainName(String str) {
        this.domainName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.domainName != null) {
            stringBuilder.append("DomainName: " + this.domainName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateDomainRequest withDomainName(String str) {
        this.domainName = str;
        return this;
    }
}
