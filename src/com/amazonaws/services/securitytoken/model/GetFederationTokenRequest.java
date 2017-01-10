package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;

public class GetFederationTokenRequest extends AmazonWebServiceRequest {
    private Integer durationSeconds;
    private String name;
    private String policy;

    public GetFederationTokenRequest(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetFederationTokenRequest)) {
            return false;
        }
        GetFederationTokenRequest getFederationTokenRequest = (GetFederationTokenRequest) obj;
        if (((getFederationTokenRequest.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getFederationTokenRequest.getName() != null && !getFederationTokenRequest.getName().equals(getName())) {
            return false;
        }
        if (((getFederationTokenRequest.getPolicy() == null ? 1 : 0) ^ (getPolicy() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getFederationTokenRequest.getPolicy() != null && !getFederationTokenRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        return ((getFederationTokenRequest.getDurationSeconds() == null ? 1 : 0) ^ (getDurationSeconds() == null ? 1 : 0)) == 0 ? getFederationTokenRequest.getDurationSeconds() == null || getFederationTokenRequest.getDurationSeconds().equals(getDurationSeconds()) : false;
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getName() {
        return this.name;
    }

    public String getPolicy() {
        return this.policy;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPolicy() == null ? 0 : getPolicy().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + 31) * 31)) * 31;
        if (getDurationSeconds() != null) {
            i = getDurationSeconds().hashCode();
        }
        return hashCode + i;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.name != null) {
            stringBuilder.append("Name: " + this.name + ", ");
        }
        if (this.policy != null) {
            stringBuilder.append("Policy: " + this.policy + ", ");
        }
        if (this.durationSeconds != null) {
            stringBuilder.append("DurationSeconds: " + this.durationSeconds + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetFederationTokenRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public GetFederationTokenRequest withName(String str) {
        this.name = str;
        return this;
    }

    public GetFederationTokenRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }
}
