package com.amazonaws.services.simpleemail.model;

public class VerifyDomainIdentityResult {
    private String verificationToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyDomainIdentityResult)) {
            return false;
        }
        VerifyDomainIdentityResult verifyDomainIdentityResult = (VerifyDomainIdentityResult) obj;
        return ((verifyDomainIdentityResult.getVerificationToken() == null ? 1 : 0) ^ (getVerificationToken() == null ? 1 : 0)) == 0 ? verifyDomainIdentityResult.getVerificationToken() == null || verifyDomainIdentityResult.getVerificationToken().equals(getVerificationToken()) : false;
    }

    public String getVerificationToken() {
        return this.verificationToken;
    }

    public int hashCode() {
        return (getVerificationToken() == null ? 0 : getVerificationToken().hashCode()) + 31;
    }

    public void setVerificationToken(String str) {
        this.verificationToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.verificationToken != null) {
            stringBuilder.append("VerificationToken: " + this.verificationToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public VerifyDomainIdentityResult withVerificationToken(String str) {
        this.verificationToken = str;
        return this;
    }
}
