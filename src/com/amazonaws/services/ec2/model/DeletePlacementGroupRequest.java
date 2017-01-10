package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeletePlacementGroupRequest extends AmazonWebServiceRequest {
    private String groupName;

    public DeletePlacementGroupRequest(String str) {
        this.groupName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeletePlacementGroupRequest)) {
            return false;
        }
        DeletePlacementGroupRequest deletePlacementGroupRequest = (DeletePlacementGroupRequest) obj;
        return ((deletePlacementGroupRequest.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) == 0 ? deletePlacementGroupRequest.getGroupName() == null || deletePlacementGroupRequest.getGroupName().equals(getGroupName()) : false;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int hashCode() {
        return (getGroupName() == null ? 0 : getGroupName().hashCode()) + 31;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeletePlacementGroupRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }
}
