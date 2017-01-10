package com.amazonaws.services.ec2.model;

public class SpotPlacement {
    private String availabilityZone;
    private String groupName;

    public SpotPlacement(String str) {
        this.availabilityZone = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SpotPlacement)) {
            return false;
        }
        SpotPlacement spotPlacement = (SpotPlacement) obj;
        if (((spotPlacement.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotPlacement.getAvailabilityZone() != null && !spotPlacement.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        return ((spotPlacement.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) == 0 ? spotPlacement.getGroupName() == null || spotPlacement.getGroupName().equals(getGroupName()) : false;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + 31) * 31;
        if (getGroupName() != null) {
            i = getGroupName().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
        if (this.groupName != null) {
            stringBuilder.append("GroupName: " + this.groupName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SpotPlacement withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public SpotPlacement withGroupName(String str) {
        this.groupName = str;
        return this;
    }
}
