package com.amazonaws.services.elasticloadbalancing.model;

public class InstanceState {
    private String description;
    private String instanceId;
    private String reasonCode;
    private String state;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceState)) {
            return false;
        }
        InstanceState instanceState = (InstanceState) obj;
        if (((instanceState.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceState.getInstanceId() != null && !instanceState.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((instanceState.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceState.getState() != null && !instanceState.getState().equals(getState())) {
            return false;
        }
        if (((instanceState.getReasonCode() == null ? 1 : 0) ^ (getReasonCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceState.getReasonCode() != null && !instanceState.getReasonCode().equals(getReasonCode())) {
            return false;
        }
        return ((instanceState.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) == 0 ? instanceState.getDescription() == null || instanceState.getDescription().equals(getDescription()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getReasonCode() {
        return this.reasonCode;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getReasonCode() == null ? 0 : getReasonCode().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getDescription() != null) {
            i = getDescription().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setReasonCode(String str) {
        this.reasonCode = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.reasonCode != null) {
            stringBuilder.append("ReasonCode: " + this.reasonCode + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceState withDescription(String str) {
        this.description = str;
        return this;
    }

    public InstanceState withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public InstanceState withReasonCode(String str) {
        this.reasonCode = str;
        return this;
    }

    public InstanceState withState(String str) {
        this.state = str;
        return this;
    }
}
