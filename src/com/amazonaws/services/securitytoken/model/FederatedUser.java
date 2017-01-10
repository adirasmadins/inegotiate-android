package com.amazonaws.services.securitytoken.model;

public class FederatedUser {
    private String arn;
    private String federatedUserId;

    public FederatedUser(String str, String str2) {
        this.federatedUserId = str;
        this.arn = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FederatedUser)) {
            return false;
        }
        FederatedUser federatedUser = (FederatedUser) obj;
        if (((federatedUser.getFederatedUserId() == null ? 1 : 0) ^ (getFederatedUserId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (federatedUser.getFederatedUserId() != null && !federatedUser.getFederatedUserId().equals(getFederatedUserId())) {
            return false;
        }
        return ((federatedUser.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) == 0 ? federatedUser.getArn() == null || federatedUser.getArn().equals(getArn()) : false;
    }

    public String getArn() {
        return this.arn;
    }

    public String getFederatedUserId() {
        return this.federatedUserId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getFederatedUserId() == null ? 0 : getFederatedUserId().hashCode()) + 31) * 31;
        if (getArn() != null) {
            i = getArn().hashCode();
        }
        return hashCode + i;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public void setFederatedUserId(String str) {
        this.federatedUserId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.federatedUserId != null) {
            stringBuilder.append("FederatedUserId: " + this.federatedUserId + ", ");
        }
        if (this.arn != null) {
            stringBuilder.append("Arn: " + this.arn + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public FederatedUser withArn(String str) {
        this.arn = str;
        return this;
    }

    public FederatedUser withFederatedUserId(String str) {
        this.federatedUserId = str;
        return this;
    }
}
