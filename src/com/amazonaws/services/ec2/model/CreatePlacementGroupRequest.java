package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreatePlacementGroupRequest extends AmazonWebServiceRequest {
    private String groupName;
    private String strategy;

    public CreatePlacementGroupRequest(String str, PlacementStrategy placementStrategy) {
        this.groupName = str;
        this.strategy = placementStrategy.toString();
    }

    public CreatePlacementGroupRequest(String str, String str2) {
        this.groupName = str;
        this.strategy = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreatePlacementGroupRequest)) {
            return false;
        }
        CreatePlacementGroupRequest createPlacementGroupRequest = (CreatePlacementGroupRequest) obj;
        if (((createPlacementGroupRequest.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createPlacementGroupRequest.getGroupName() != null && !createPlacementGroupRequest.getGroupName().equals(getGroupName())) {
            return false;
        }
        return ((createPlacementGroupRequest.getStrategy() == null ? 1 : 0) ^ (getStrategy() == null ? 1 : 0)) == 0 ? createPlacementGroupRequest.getStrategy() == null || createPlacementGroupRequest.getStrategy().equals(getStrategy()) : false;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getStrategy() {
        return this.strategy;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getGroupName() == null ? 0 : getGroupName().hashCode()) + 31) * 31;
        if (getStrategy() != null) {
            i = getStrategy().hashCode();
        }
        return hashCode + i;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setStrategy(PlacementStrategy placementStrategy) {
        this.strategy = placementStrategy.toString();
    }

    public void setStrategy(String str) {
        this.strategy = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.groupName != null) {
            stringBuilder.append("GroupName: " + this.groupName + ", ");
        }
        if (this.strategy != null) {
            stringBuilder.append("Strategy: " + this.strategy + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreatePlacementGroupRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public CreatePlacementGroupRequest withStrategy(PlacementStrategy placementStrategy) {
        this.strategy = placementStrategy.toString();
        return this;
    }

    public CreatePlacementGroupRequest withStrategy(String str) {
        this.strategy = str;
        return this;
    }
}
