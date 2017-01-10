package com.amazonaws.services.ec2.model;

public class GroupIdentifier {
    private String groupId;
    private String groupName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GroupIdentifier)) {
            return false;
        }
        GroupIdentifier groupIdentifier = (GroupIdentifier) obj;
        if (((groupIdentifier.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (groupIdentifier.getGroupName() != null && !groupIdentifier.getGroupName().equals(getGroupName())) {
            return false;
        }
        return ((groupIdentifier.getGroupId() == null ? 1 : 0) ^ (getGroupId() == null ? 1 : 0)) == 0 ? groupIdentifier.getGroupId() == null || groupIdentifier.getGroupId().equals(getGroupId()) : false;
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

    public GroupIdentifier withGroupId(String str) {
        this.groupId = str;
        return this;
    }

    public GroupIdentifier withGroupName(String str) {
        this.groupName = str;
        return this;
    }
}
