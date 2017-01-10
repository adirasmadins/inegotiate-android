package com.amazonaws.services.ec2.model;

public class Placement {
    private String availabilityZone;
    private String groupName;
    private String tenancy;

    public Placement(String str) {
        this.availabilityZone = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Placement)) {
            return false;
        }
        Placement placement = (Placement) obj;
        if (((placement.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (placement.getAvailabilityZone() != null && !placement.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((placement.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (placement.getGroupName() != null && !placement.getGroupName().equals(getGroupName())) {
            return false;
        }
        return ((placement.getTenancy() == null ? 1 : 0) ^ (getTenancy() == null ? 1 : 0)) == 0 ? placement.getTenancy() == null || placement.getTenancy().equals(getTenancy()) : false;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getTenancy() {
        return this.tenancy;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getGroupName() == null ? 0 : getGroupName().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + 31) * 31)) * 31;
        if (getTenancy() != null) {
            i = getTenancy().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setTenancy(String str) {
        this.tenancy = str;
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
        if (this.tenancy != null) {
            stringBuilder.append("Tenancy: " + this.tenancy + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Placement withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public Placement withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public Placement withTenancy(String str) {
        this.tenancy = str;
        return this;
    }
}
