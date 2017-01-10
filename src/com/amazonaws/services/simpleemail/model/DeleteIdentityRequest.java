package com.amazonaws.services.simpleemail.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteIdentityRequest extends AmazonWebServiceRequest {
    private String identity;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteIdentityRequest)) {
            return false;
        }
        DeleteIdentityRequest deleteIdentityRequest = (DeleteIdentityRequest) obj;
        return ((deleteIdentityRequest.getIdentity() == null ? 1 : 0) ^ (getIdentity() == null ? 1 : 0)) == 0 ? deleteIdentityRequest.getIdentity() == null || deleteIdentityRequest.getIdentity().equals(getIdentity()) : false;
    }

    public String getIdentity() {
        return this.identity;
    }

    public int hashCode() {
        return (getIdentity() == null ? 0 : getIdentity().hashCode()) + 31;
    }

    public void setIdentity(String str) {
        this.identity = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.identity != null) {
            stringBuilder.append("Identity: " + this.identity + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteIdentityRequest withIdentity(String str) {
        this.identity = str;
        return this;
    }
}
