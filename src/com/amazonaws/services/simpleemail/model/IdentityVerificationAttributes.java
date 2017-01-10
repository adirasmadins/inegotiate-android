package com.amazonaws.services.simpleemail.model;

public class IdentityVerificationAttributes {
    private String verificationStatus;
    private String verificationToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IdentityVerificationAttributes)) {
            return false;
        }
        IdentityVerificationAttributes identityVerificationAttributes = (IdentityVerificationAttributes) obj;
        if (((identityVerificationAttributes.getVerificationStatus() == null ? 1 : 0) ^ (getVerificationStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (identityVerificationAttributes.getVerificationStatus() != null && !identityVerificationAttributes.getVerificationStatus().equals(getVerificationStatus())) {
            return false;
        }
        return ((identityVerificationAttributes.getVerificationToken() == null ? 1 : 0) ^ (getVerificationToken() == null ? 1 : 0)) == 0 ? identityVerificationAttributes.getVerificationToken() == null || identityVerificationAttributes.getVerificationToken().equals(getVerificationToken()) : false;
    }

    public String getVerificationStatus() {
        return this.verificationStatus;
    }

    public String getVerificationToken() {
        return this.verificationToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVerificationStatus() == null ? 0 : getVerificationStatus().hashCode()) + 31) * 31;
        if (getVerificationToken() != null) {
            i = getVerificationToken().hashCode();
        }
        return hashCode + i;
    }

    public void setVerificationStatus(VerificationStatus verificationStatus) {
        this.verificationStatus = verificationStatus.toString();
    }

    public void setVerificationStatus(String str) {
        this.verificationStatus = str;
    }

    public void setVerificationToken(String str) {
        this.verificationToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.verificationStatus != null) {
            stringBuilder.append("VerificationStatus: " + this.verificationStatus + ", ");
        }
        if (this.verificationToken != null) {
            stringBuilder.append("VerificationToken: " + this.verificationToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public IdentityVerificationAttributes withVerificationStatus(VerificationStatus verificationStatus) {
        this.verificationStatus = verificationStatus.toString();
        return this;
    }

    public IdentityVerificationAttributes withVerificationStatus(String str) {
        this.verificationStatus = str;
        return this;
    }

    public IdentityVerificationAttributes withVerificationToken(String str) {
        this.verificationToken = str;
        return this;
    }
}
