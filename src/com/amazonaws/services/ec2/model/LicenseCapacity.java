package com.amazonaws.services.ec2.model;

import java.util.Date;

public class LicenseCapacity {
    private Integer capacity;
    private Date earliestAllowedDeactivationTime;
    private Integer instanceCapacity;
    private String state;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LicenseCapacity)) {
            return false;
        }
        LicenseCapacity licenseCapacity = (LicenseCapacity) obj;
        if (((licenseCapacity.getCapacity() == null ? 1 : 0) ^ (getCapacity() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (licenseCapacity.getCapacity() != null && !licenseCapacity.getCapacity().equals(getCapacity())) {
            return false;
        }
        if (((licenseCapacity.getInstanceCapacity() == null ? 1 : 0) ^ (getInstanceCapacity() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (licenseCapacity.getInstanceCapacity() != null && !licenseCapacity.getInstanceCapacity().equals(getInstanceCapacity())) {
            return false;
        }
        if (((licenseCapacity.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (licenseCapacity.getState() != null && !licenseCapacity.getState().equals(getState())) {
            return false;
        }
        return ((licenseCapacity.getEarliestAllowedDeactivationTime() == null ? 1 : 0) ^ (getEarliestAllowedDeactivationTime() == null ? 1 : 0)) == 0 ? licenseCapacity.getEarliestAllowedDeactivationTime() == null || licenseCapacity.getEarliestAllowedDeactivationTime().equals(getEarliestAllowedDeactivationTime()) : false;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    public Date getEarliestAllowedDeactivationTime() {
        return this.earliestAllowedDeactivationTime;
    }

    public Integer getInstanceCapacity() {
        return this.instanceCapacity;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getState() == null ? 0 : getState().hashCode()) + (((getInstanceCapacity() == null ? 0 : getInstanceCapacity().hashCode()) + (((getCapacity() == null ? 0 : getCapacity().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getEarliestAllowedDeactivationTime() != null) {
            i = getEarliestAllowedDeactivationTime().hashCode();
        }
        return hashCode + i;
    }

    public void setCapacity(Integer num) {
        this.capacity = num;
    }

    public void setEarliestAllowedDeactivationTime(Date date) {
        this.earliestAllowedDeactivationTime = date;
    }

    public void setInstanceCapacity(Integer num) {
        this.instanceCapacity = num;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.capacity != null) {
            stringBuilder.append("Capacity: " + this.capacity + ", ");
        }
        if (this.instanceCapacity != null) {
            stringBuilder.append("InstanceCapacity: " + this.instanceCapacity + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.earliestAllowedDeactivationTime != null) {
            stringBuilder.append("EarliestAllowedDeactivationTime: " + this.earliestAllowedDeactivationTime + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public LicenseCapacity withCapacity(Integer num) {
        this.capacity = num;
        return this;
    }

    public LicenseCapacity withEarliestAllowedDeactivationTime(Date date) {
        this.earliestAllowedDeactivationTime = date;
        return this;
    }

    public LicenseCapacity withInstanceCapacity(Integer num) {
        this.instanceCapacity = num;
        return this;
    }

    public LicenseCapacity withState(String str) {
        this.state = str;
        return this;
    }
}
