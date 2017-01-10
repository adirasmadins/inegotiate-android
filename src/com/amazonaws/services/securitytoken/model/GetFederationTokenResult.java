package com.amazonaws.services.securitytoken.model;

public class GetFederationTokenResult {
    private Credentials credentials;
    private FederatedUser federatedUser;
    private Integer packedPolicySize;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetFederationTokenResult)) {
            return false;
        }
        GetFederationTokenResult getFederationTokenResult = (GetFederationTokenResult) obj;
        if (((getFederationTokenResult.getCredentials() == null ? 1 : 0) ^ (getCredentials() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getFederationTokenResult.getCredentials() != null && !getFederationTokenResult.getCredentials().equals(getCredentials())) {
            return false;
        }
        if (((getFederationTokenResult.getFederatedUser() == null ? 1 : 0) ^ (getFederatedUser() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getFederationTokenResult.getFederatedUser() != null && !getFederationTokenResult.getFederatedUser().equals(getFederatedUser())) {
            return false;
        }
        return ((getFederationTokenResult.getPackedPolicySize() == null ? 1 : 0) ^ (getPackedPolicySize() == null ? 1 : 0)) == 0 ? getFederationTokenResult.getPackedPolicySize() == null || getFederationTokenResult.getPackedPolicySize().equals(getPackedPolicySize()) : false;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public FederatedUser getFederatedUser() {
        return this.federatedUser;
    }

    public Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getFederatedUser() == null ? 0 : getFederatedUser().hashCode()) + (((getCredentials() == null ? 0 : getCredentials().hashCode()) + 31) * 31)) * 31;
        if (getPackedPolicySize() != null) {
            i = getPackedPolicySize().hashCode();
        }
        return hashCode + i;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setFederatedUser(FederatedUser federatedUser) {
        this.federatedUser = federatedUser;
    }

    public void setPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.credentials != null) {
            stringBuilder.append("Credentials: " + this.credentials + ", ");
        }
        if (this.federatedUser != null) {
            stringBuilder.append("FederatedUser: " + this.federatedUser + ", ");
        }
        if (this.packedPolicySize != null) {
            stringBuilder.append("PackedPolicySize: " + this.packedPolicySize + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetFederationTokenResult withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    public GetFederationTokenResult withFederatedUser(FederatedUser federatedUser) {
        this.federatedUser = federatedUser;
        return this;
    }

    public GetFederationTokenResult withPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
        return this;
    }
}
