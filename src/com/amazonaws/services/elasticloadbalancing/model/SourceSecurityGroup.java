package com.amazonaws.services.elasticloadbalancing.model;

public class SourceSecurityGroup {
    private String groupName;
    private String ownerAlias;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SourceSecurityGroup)) {
            return false;
        }
        SourceSecurityGroup sourceSecurityGroup = (SourceSecurityGroup) obj;
        if (((sourceSecurityGroup.getOwnerAlias() == null ? 1 : 0) ^ (getOwnerAlias() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sourceSecurityGroup.getOwnerAlias() != null && !sourceSecurityGroup.getOwnerAlias().equals(getOwnerAlias())) {
            return false;
        }
        return ((sourceSecurityGroup.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) == 0 ? sourceSecurityGroup.getGroupName() == null || sourceSecurityGroup.getGroupName().equals(getGroupName()) : false;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getOwnerAlias() {
        return this.ownerAlias;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getOwnerAlias() == null ? 0 : getOwnerAlias().hashCode()) + 31) * 31;
        if (getGroupName() != null) {
            i = getGroupName().hashCode();
        }
        return hashCode + i;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setOwnerAlias(String str) {
        this.ownerAlias = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.ownerAlias != null) {
            stringBuilder.append("OwnerAlias: " + this.ownerAlias + ", ");
        }
        if (this.groupName != null) {
            stringBuilder.append("GroupName: " + this.groupName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SourceSecurityGroup withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public SourceSecurityGroup withOwnerAlias(String str) {
        this.ownerAlias = str;
        return this;
    }
}
