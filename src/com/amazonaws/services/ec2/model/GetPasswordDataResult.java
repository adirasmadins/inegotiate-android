package com.amazonaws.services.ec2.model;

import java.util.Date;

public class GetPasswordDataResult {
    private String instanceId;
    private String passwordData;
    private Date timestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetPasswordDataResult)) {
            return false;
        }
        GetPasswordDataResult getPasswordDataResult = (GetPasswordDataResult) obj;
        if (((getPasswordDataResult.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getPasswordDataResult.getInstanceId() != null && !getPasswordDataResult.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((getPasswordDataResult.getTimestamp() == null ? 1 : 0) ^ (getTimestamp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getPasswordDataResult.getTimestamp() != null && !getPasswordDataResult.getTimestamp().equals(getTimestamp())) {
            return false;
        }
        return ((getPasswordDataResult.getPasswordData() == null ? 1 : 0) ^ (getPasswordData() == null ? 1 : 0)) == 0 ? getPasswordDataResult.getPasswordData() == null || getPasswordDataResult.getPasswordData().equals(getPasswordData()) : false;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getPasswordData() {
        return this.passwordData;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTimestamp() == null ? 0 : getTimestamp().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31;
        if (getPasswordData() != null) {
            i = getPasswordData().hashCode();
        }
        return hashCode + i;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setPasswordData(String str) {
        this.passwordData = str;
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
        if (this.passwordData != null) {
            stringBuilder.append("PasswordData: " + this.passwordData + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetPasswordDataResult withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public GetPasswordDataResult withPasswordData(String str) {
        this.passwordData = str;
        return this;
    }

    public GetPasswordDataResult withTimestamp(Date date) {
        this.timestamp = date;
        return this;
    }
}
