package com.amazonaws.services.ec2.model;

public class UserIdGroupPair {
    private String groupId;
    private String groupName;
    private String userId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserIdGroupPair)) {
            return false;
        }
        UserIdGroupPair userIdGroupPair = (UserIdGroupPair) obj;
        if (((userIdGroupPair.getUserId() == null ? 1 : 0) ^ (getUserId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (userIdGroupPair.getUserId() != null && !userIdGroupPair.getUserId().equals(getUserId())) {
            return false;
        }
        if (((userIdGroupPair.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (userIdGroupPair.getGroupName() != null && !userIdGroupPair.getGroupName().equals(getGroupName())) {
            return false;
        }
        return ((userIdGroupPair.getGroupId() == null ? 1 : 0) ^ (getGroupId() == null ? 1 : 0)) == 0 ? userIdGroupPair.getGroupId() == null || userIdGroupPair.getGroupId().equals(getGroupId()) : false;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getGroupName() == null ? 0 : getGroupName().hashCode()) + (((getUserId() == null ? 0 : getUserId().hashCode()) + 31) * 31)) * 31;
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

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.userId != null) {
            stringBuilder.append("UserId: " + this.userId + ", ");
        }
        if (this.groupName != null) {
            stringBuilder.append("GroupName: " + this.groupName + ", ");
        }
        if (this.groupId != null) {
            stringBuilder.append("GroupId: " + this.groupId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public UserIdGroupPair withGroupId(String str) {
        this.groupId = str;
        return this;
    }

    public UserIdGroupPair withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public UserIdGroupPair withUserId(String str) {
        this.userId = str;
        return this;
    }
}
