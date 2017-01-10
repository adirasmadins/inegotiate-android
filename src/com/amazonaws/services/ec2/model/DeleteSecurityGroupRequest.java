package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteSecurityGroupRequest extends AmazonWebServiceRequest {
    private String groupId;
    private String groupName;

    public DeleteSecurityGroupRequest(String str) {
        this.groupName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteSecurityGroupRequest)) {
            return false;
        }
        DeleteSecurityGroupRequest deleteSecurityGroupRequest = (DeleteSecurityGroupRequest) obj;
        if (((deleteSecurityGroupRequest.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteSecurityGroupRequest.getGroupName() != null && !deleteSecurityGroupRequest.getGroupName().equals(getGroupName())) {
            return false;
        }
        return ((deleteSecurityGroupRequest.getGroupId() == null ? 1 : 0) ^ (getGroupId() == null ? 1 : 0)) == 0 ? deleteSecurityGroupRequest.getGroupId() == null || deleteSecurityGroupRequest.getGroupId().equals(getGroupId()) : false;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getGroupName() == null ? 0 : getGroupName().hashCode()) + 31) * 31;
        if (getGroupId() != null) {
            i = getGroupId().hashCode();
        }
        return hashCode + i;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.groupName != null) {
            stringBuilder.append("GroupName: " + this.groupName + ", ");
        }
        if (this.groupId != null) {
            stringBuilder.append("GroupId: " + this.groupId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteSecurityGroupRequest withGroupId(String str) {
        this.groupId = str;
        return this;
    }

    public DeleteSecurityGroupRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }
}
