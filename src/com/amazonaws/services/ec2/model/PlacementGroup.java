package com.amazonaws.services.ec2.model;

public class PlacementGroup {
    private String groupName;
    private String state;
    private String strategy;

    public PlacementGroup(String str) {
        this.groupName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PlacementGroup)) {
            return false;
        }
        PlacementGroup placementGroup = (PlacementGroup) obj;
        if (((placementGroup.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (placementGroup.getGroupName() != null && !placementGroup.getGroupName().equals(getGroupName())) {
            return false;
        }
        if (((placementGroup.getStrategy() == null ? 1 : 0) ^ (getStrategy() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (placementGroup.getStrategy() != null && !placementGroup.getStrategy().equals(getStrategy())) {
            return false;
        }
        return ((placementGroup.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) == 0 ? placementGroup.getState() == null || placementGroup.getState().equals(getState()) : false;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getState() {
        return this.state;
    }

    public String getStrategy() {
        return this.strategy;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getStrategy() == null ? 0 : getStrategy().hashCode()) + (((getGroupName() == null ? 0 : getGroupName().hashCode()) + 31) * 31)) * 31;
        if (getState() != null) {
            i = getState().hashCode();
        }
        return hashCode + i;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setState(PlacementGroupState placementGroupState) {
        this.state = placementGroupState.toString();
    }

    public void setState(String str) {
        this.state = str;
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
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PlacementGroup withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public PlacementGroup withState(PlacementGroupState placementGroupState) {
        this.state = placementGroupState.toString();
        return this;
    }

    public PlacementGroup withState(String str) {
        this.state = str;
        return this;
    }

    public PlacementGroup withStrategy(PlacementStrategy placementStrategy) {
        this.strategy = placementStrategy.toString();
        return this;
    }

    public PlacementGroup withStrategy(String str) {
        this.strategy = str;
        return this;
    }
}
