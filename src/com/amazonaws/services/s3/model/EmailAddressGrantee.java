package com.amazonaws.services.s3.model;

public class EmailAddressGrantee implements Grantee {
    private String emailAddress;

    public EmailAddressGrantee(String str) {
        this.emailAddress = null;
        setIdentifier(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EmailAddressGrantee emailAddressGrantee = (EmailAddressGrantee) obj;
        return this.emailAddress == null ? emailAddressGrantee.emailAddress == null : this.emailAddress.equals(emailAddressGrantee.emailAddress);
    }

    public String getIdentifier() {
        return this.emailAddress;
    }

    public String getTypeIdentifier() {
        return "emailAddress";
    }

    public int hashCode() {
        return (this.emailAddress == null ? 0 : this.emailAddress.hashCode()) + 31;
    }

    public void setIdentifier(String str) {
        this.emailAddress = str;
    }

    public String toString() {
        return this.emailAddress;
    }
}
