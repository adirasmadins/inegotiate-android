package com.amazonaws.services.ec2.model;

public class VolumeStatusDetails {
    private String name;
    private String status;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VolumeStatusDetails)) {
            return false;
        }
        VolumeStatusDetails volumeStatusDetails = (VolumeStatusDetails) obj;
        if (((volumeStatusDetails.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusDetails.getName() != null && !volumeStatusDetails.getName().equals(getName())) {
            return false;
        }
        return ((volumeStatusDetails.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) == 0 ? volumeStatusDetails.getStatus() == null || volumeStatusDetails.getStatus().equals(getStatus()) : false;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getName() == null ? 0 : getName().hashCode()) + 31) * 31;
        if (getStatus() != null) {
            i = getStatus().hashCode();
        }
        return hashCode + i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.name != null) {
            stringBuilder.append("Name: " + this.name + ", ");
        }
        if (this.status != null) {
            stringBuilder.append("Status: " + this.status + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public VolumeStatusDetails withName(String str) {
        this.name = str;
        return this;
    }

    public VolumeStatusDetails withStatus(String str) {
        this.status = str;
        return this;
    }
}
