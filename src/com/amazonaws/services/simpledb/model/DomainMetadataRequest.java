package com.amazonaws.services.simpledb.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DomainMetadataRequest extends AmazonWebServiceRequest {
    private String domainName;

    public DomainMetadataRequest(String str) {
        this.domainName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DomainMetadataRequest)) {
            return false;
        }
        DomainMetadataRequest domainMetadataRequest = (DomainMetadataRequest) obj;
        return ((domainMetadataRequest.getDomainName() == null ? 1 : 0) ^ (getDomainName() == null ? 1 : 0)) == 0 ? domainMetadataRequest.getDomainName() == null || domainMetadataRequest.getDomainName().equals(getDomainName()) : false;
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

    public DomainMetadataRequest withDomainName(String str) {
        this.domainName = str;
        return this;
    }
}
