package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SetAlarmStateRequest extends AmazonWebServiceRequest {
    private String alarmName;
    private String stateReason;
    private String stateReasonData;
    private String stateValue;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetAlarmStateRequest)) {
            return false;
        }
        SetAlarmStateRequest setAlarmStateRequest = (SetAlarmStateRequest) obj;
        if (((setAlarmStateRequest.getAlarmName() == null ? 1 : 0) ^ (getAlarmName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setAlarmStateRequest.getAlarmName() != null && !setAlarmStateRequest.getAlarmName().equals(getAlarmName())) {
            return false;
        }
        if (((setAlarmStateRequest.getStateValue() == null ? 1 : 0) ^ (getStateValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setAlarmStateRequest.getStateValue() != null && !setAlarmStateRequest.getStateValue().equals(getStateValue())) {
            return false;
        }
        if (((setAlarmStateRequest.getStateReason() == null ? 1 : 0) ^ (getStateReason() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setAlarmStateRequest.getStateReason() != null && !setAlarmStateRequest.getStateReason().equals(getStateReason())) {
            return false;
        }
        return ((setAlarmStateRequest.getStateReasonData() == null ? 1 : 0) ^ (getStateReasonData() == null ? 1 : 0)) == 0 ? setAlarmStateRequest.getStateReasonData() == null || setAlarmStateRequest.getStateReasonData().equals(getStateReasonData()) : false;
    }

    public String getAlarmName() {
        return this.alarmName;
    }

    public String getStateReason() {
        return this.stateReason;
    }

    public String getStateReasonData() {
        return this.stateReasonData;
    }

    public String getStateValue() {
        return this.stateValue;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getStateReason() == null ? 0 : getStateReason().hashCode()) + (((getStateValue() == null ? 0 : getStateValue().hashCode()) + (((getAlarmName() == null ? 0 : getAlarmName().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getStateReasonData() != null) {
            i = getStateReasonData().hashCode();
        }
        return hashCode + i;
    }

    public void setAlarmName(String str) {
        this.alarmName = str;
    }

    public void setStateReason(String str) {
        this.stateReason = str;
    }

    public void setStateReasonData(String str) {
        this.stateReasonData = str;
    }

    public void setStateValue(StateValue stateValue) {
        this.stateValue = stateValue.toString();
    }

    public void setStateValue(String str) {
        this.stateValue = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.alarmName != null) {
            stringBuilder.append("AlarmName: " + this.alarmName + ", ");
        }
        if (this.stateValue != null) {
            stringBuilder.append("StateValue: " + this.stateValue + ", ");
        }
        if (this.stateReason != null) {
            stringBuilder.append("StateReason: " + this.stateReason + ", ");
        }
        if (this.stateReasonData != null) {
            stringBuilder.append("StateReasonData: " + this.stateReasonData + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SetAlarmStateRequest withAlarmName(String str) {
        this.alarmName = str;
        return this;
    }

    public SetAlarmStateRequest withStateReason(String str) {
        this.stateReason = str;
        return this;
    }

    public SetAlarmStateRequest withStateReasonData(String str) {
        this.stateReasonData = str;
        return this;
    }

    public SetAlarmStateRequest withStateValue(StateValue stateValue) {
        this.stateValue = stateValue.toString();
        return this;
    }

    public SetAlarmStateRequest withStateValue(String str) {
        this.stateValue = str;
        return this;
    }
}
