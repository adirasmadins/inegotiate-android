package com.amazonaws.services.ec2.model;

public class StateReason {
    private String code;
    private String message;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StateReason)) {
            return false;
        }
        StateReason stateReason = (StateReason) obj;
        if (((stateReason.getCode() == null ? 1 : 0) ^ (getCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (stateReason.getCode() != null && !stateReason.getCode().equals(getCode())) {
            return false;
        }
        return ((stateReason.getMessage() == null ? 1 : 0) ^ (getMessage() == null ? 1 : 0)) == 0 ? stateReason.getMessage() == null || stateReason.getMessage().equals(getMessage()) : false;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCode() == null ? 0 : getCode().hashCode()) + 31) * 31;
        if (getMessage() != null) {
            i = getMessage().hashCode();
        }
        return hashCode + i;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.code != null) {
            stringBuilder.append("Code: " + this.code + ", ");
        }
        if (this.message != null) {
            stringBuilder.append("Message: " + this.message + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public StateReason withCode(String str) {
        this.code = str;
        return this;
    }

    public StateReason withMessage(String str) {
        this.message = str;
        return this;
    }
}
