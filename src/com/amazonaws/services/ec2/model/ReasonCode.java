package com.amazonaws.services.ec2.model;

public class ReasonCode {
    private String reasonCode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReasonCode)) {
            return false;
        }
        ReasonCode reasonCode = (ReasonCode) obj;
        return ((reasonCode.getReasonCode() == null ? 1 : 0) ^ (getReasonCode() == null ? 1 : 0)) == 0 ? reasonCode.getReasonCode() == null || reasonCode.getReasonCode().equals(getReasonCode()) : false;
    }

    public String getReasonCode() {
        return this.reasonCode;
    }

    public int hashCode() {
        return (getReasonCode() == null ? 0 : getReasonCode().hashCode()) + 31;
    }

    public void setReasonCode(String str) {
        this.reasonCode = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reasonCode != null) {
            stringBuilder.append("ReasonCode: " + this.reasonCode + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ReasonCode withReasonCode(String str) {
        this.reasonCode = str;
        return this;
    }
}
