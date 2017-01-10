package com.amazonaws.services.ec2.model;

public class InstanceStateChange {
    private InstanceState currentState;
    private String instanceId;
    private InstanceState previousState;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceStateChange)) {
            return false;
        }
        InstanceStateChange instanceStateChange = (InstanceStateChange) obj;
        if (((instanceStateChange.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStateChange.getInstanceId() != null && !instanceStateChange.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((instanceStateChange.getCurrentState() == null ? 1 : 0) ^ (getCurrentState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStateChange.getCurrentState() != null && !instanceStateChange.getCurrentState().equals(getCurrentState())) {
            return false;
        }
        return ((instanceStateChange.getPreviousState() == null ? 1 : 0) ^ (getPreviousState() == null ? 1 : 0)) == 0 ? instanceStateChange.getPreviousState() == null || instanceStateChange.getPreviousState().equals(getPreviousState()) : false;
    }

    public InstanceState getCurrentState() {
        return this.currentState;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public InstanceState getPreviousState() {
        return this.previousState;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCurrentState() == null ? 0 : getCurrentState().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31;
        if (getPreviousState() != null) {
            i = getPreviousState().hashCode();
        }
        return hashCode + i;
    }

    public void setCurrentState(InstanceState instanceState) {
        this.currentState = instanceState;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setPreviousState(InstanceState instanceState) {
        this.previousState = instanceState;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.currentState != null) {
            stringBuilder.append("CurrentState: " + this.currentState + ", ");
        }
        if (this.previousState != null) {
            stringBuilder.append("PreviousState: " + this.previousState + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceStateChange withCurrentState(InstanceState instanceState) {
        this.currentState = instanceState;
        return this;
    }

    public InstanceStateChange withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public InstanceStateChange withPreviousState(InstanceState instanceState) {
        this.previousState = instanceState;
        return this;
    }
}
