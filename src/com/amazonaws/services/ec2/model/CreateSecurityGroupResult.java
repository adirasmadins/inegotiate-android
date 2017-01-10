package com.amazonaws.services.ec2.model;

public class CreateSecurityGroupResult {
    private String groupId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateSecurityGroupResult)) {
            return false;
        }
        CreateSecurityGroupResult createSecurityGroupResult = (CreateSecurityGroupResult) obj;
        return ((createSecurityGroupResult.getGroupId() == null ? 1 : 0) ^ (getGroupId() == null ? 1 : 0)) == 0 ? createSecurityGroupResult.getGroupId() == null || createSecurityGroupResult.getGroupId().equals(getGroupId()) : false;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int hashCode() {
        return (getGroupId() == null ? 0 : getGroupId().hashCode()) + 31;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.groupId != null) {
            stringBuilder.append("GroupId: " + this.groupId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateSecurityGroupResult withGroupId(String str) {
        this.groupId = str;
        return this;
    }
}
