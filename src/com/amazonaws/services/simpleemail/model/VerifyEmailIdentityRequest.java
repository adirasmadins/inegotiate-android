package com.amazonaws.services.simpleemail.model;

import com.amazonaws.AmazonWebServiceRequest;

public class VerifyEmailIdentityRequest extends AmazonWebServiceRequest {
    private String emailAddress;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyEmailIdentityRequest)) {
            return false;
        }
        VerifyEmailIdentityRequest verifyEmailIdentityRequest = (VerifyEmailIdentityRequest) obj;
        return ((verifyEmailIdentityRequest.getEmailAddress() == null ? 1 : 0) ^ (getEmailAddress() == null ? 1 : 0)) == 0 ? verifyEmailIdentityRequest.getEmailAddress() == null || verifyEmailIdentityRequest.getEmailAddress().equals(getEmailAddress()) : false;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public int hashCode() {
        return (getEmailAddress() == null ? 0 : getEmailAddress().hashCode()) + 31;
    }

    public void setEmailAddress(String str) {
        this.emailAddress = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.emailAddress != null) {
            stringBuilder.append("EmailAddress: " + this.emailAddress + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public VerifyEmailIdentityRequest withEmailAddress(String str) {
        this.emailAddress = str;
        return this;
    }
}
