package com.amazonaws.services.ec2.model;

import java.util.Date;

public class GetConsoleOutputResult {
    private String instanceId;
    private String output;
    private Date timestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetConsoleOutputResult)) {
            return false;
        }
        GetConsoleOutputResult getConsoleOutputResult = (GetConsoleOutputResult) obj;
        if (((getConsoleOutputResult.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getConsoleOutputResult.getInstanceId() != null && !getConsoleOutputResult.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((getConsoleOutputResult.getTimestamp() == null ? 1 : 0) ^ (getTimestamp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getConsoleOutputResult.getTimestamp() != null && !getConsoleOutputResult.getTimestamp().equals(getTimestamp())) {
            return false;
        }
        return ((getConsoleOutputResult.getOutput() == null ? 1 : 0) ^ (getOutput() == null ? 1 : 0)) == 0 ? getConsoleOutputResult.getOutput() == null || getConsoleOutputResult.getOutput().equals(getOutput()) : false;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getOutput() {
        return this.output;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTimestamp() == null ? 0 : getTimestamp().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31;
        if (getOutput() != null) {
            i = getOutput().hashCode();
        }
        return hashCode + i;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setOutput(String str) {
        this.output = str;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.timestamp != null) {
            stringBuilder.append("Timestamp: " + this.timestamp + ", ");
        }
        if (this.output != null) {
            stringBuilder.append("Output: " + this.output + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetConsoleOutputResult withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public GetConsoleOutputResult withOutput(String str) {
        this.output = str;
        return this;
    }

    public GetConsoleOutputResult withTimestamp(Date date) {
        this.timestamp = date;
        return this;
    }
}
