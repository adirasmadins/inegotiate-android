package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;

public class GetSessionTokenRequest extends AmazonWebServiceRequest {
    private Integer durationSeconds;
    private String serialNumber;
    private String tokenCode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSessionTokenRequest)) {
            return false;
        }
        GetSessionTokenRequest getSessionTokenRequest = (GetSessionTokenRequest) obj;
        if (((getSessionTokenRequest.getDurationSeconds() == null ? 1 : 0) ^ (getDurationSeconds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getSessionTokenRequest.getDurationSeconds() != null && !getSessionTokenRequest.getDurationSeconds().equals(getDurationSeconds())) {
            return false;
        }
        if (((getSessionTokenRequest.getSerialNumber() == null ? 1 : 0) ^ (getSerialNumber() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getSessionTokenRequest.getSerialNumber() != null && !getSessionTokenRequest.getSerialNumber().equals(getSerialNumber())) {
            return false;
        }
        return ((getSessionTokenRequest.getTokenCode() == null ? 1 : 0) ^ (getTokenCode() == null ? 1 : 0)) == 0 ? getSessionTokenRequest.getTokenCode() == null || getSessionTokenRequest.getTokenCode().equals(getTokenCode()) : false;
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getTokenCode() {
        return this.tokenCode;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSerialNumber() == null ? 0 : getSerialNumber().hashCode()) + (((getDurationSeconds() == null ? 0 : getDurationSeconds().hashCode()) + 31) * 31)) * 31;
        if (getTokenCode() != null) {
            i = getTokenCode().hashCode();
        }
        return hashCode + i;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public void setTokenCode(String str) {
        this.tokenCode = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.durationSeconds != null) {
            stringBuilder.append("DurationSeconds: " + this.durationSeconds + ", ");
        }
        if (this.serialNumber != null) {
            stringBuilder.append("SerialNumber: " + this.serialNumber + ", ");
        }
        if (this.tokenCode != null) {
            stringBuilder.append("TokenCode: " + this.tokenCode + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetSessionTokenRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public GetSessionTokenRequest withSerialNumber(String str) {
        this.serialNumber = str;
        return this;
    }

    public GetSessionTokenRequest withTokenCode(String str) {
        this.tokenCode = str;
        return this;
    }
}
