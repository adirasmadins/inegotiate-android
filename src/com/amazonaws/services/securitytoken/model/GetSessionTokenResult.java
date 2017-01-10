package com.amazonaws.services.securitytoken.model;

public class GetSessionTokenResult {
    private Credentials credentials;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSessionTokenResult)) {
            return false;
        }
        GetSessionTokenResult getSessionTokenResult = (GetSessionTokenResult) obj;
        return ((getSessionTokenResult.getCredentials() == null ? 1 : 0) ^ (getCredentials() == null ? 1 : 0)) == 0 ? getSessionTokenResult.getCredentials() == null || getSessionTokenResult.getCredentials().equals(getCredentials()) : false;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public int hashCode() {
        return (getCredentials() == null ? 0 : getCredentials().hashCode()) + 31;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.credentials != null) {
            stringBuilder.append("Credentials: " + this.credentials + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetSessionTokenResult withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }
}
