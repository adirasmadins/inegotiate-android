package com.amazonaws.services.ec2.model;

public class LaunchPermission {
    private String group;
    private String userId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LaunchPermission)) {
            return false;
        }
        LaunchPermission launchPermission = (LaunchPermission) obj;
        if (((launchPermission.getUserId() == null ? 1 : 0) ^ (getUserId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchPermission.getUserId() != null && !launchPermission.getUserId().equals(getUserId())) {
            return false;
        }
        return ((launchPermission.getGroup() == null ? 1 : 0) ^ (getGroup() == null ? 1 : 0)) == 0 ? launchPermission.getGroup() == null || launchPermission.getGroup().equals(getGroup()) : false;
    }

    public String getGroup() {
        return this.group;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getUserId() == null ? 0 : getUserId().hashCode()) + 31) * 31;
        if (getGroup() != null) {
            i = getGroup().hashCode();
        }
        return hashCode + i;
    }

    public void setGroup(String str) {
        this.group = str;
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
        if (this.group != null) {
            stringBuilder.append("Group: " + this.group + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public LaunchPermission withGroup(String str) {
        this.group = str;
        return this;
    }

    public LaunchPermission withUserId(String str) {
        this.userId = str;
        return this;
    }
}
