package com.amazonaws.services.ec2.model;

import java.util.Date;

public class InstanceStatusDetails {
    private Date impairedSince;
    private String name;
    private String status;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceStatusDetails)) {
            return false;
        }
        InstanceStatusDetails instanceStatusDetails = (InstanceStatusDetails) obj;
        if (((instanceStatusDetails.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStatusDetails.getName() != null && !instanceStatusDetails.getName().equals(getName())) {
            return false;
        }
        if (((instanceStatusDetails.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStatusDetails.getStatus() != null && !instanceStatusDetails.getStatus().equals(getStatus())) {
            return false;
        }
        return ((instanceStatusDetails.getImpairedSince() == null ? 1 : 0) ^ (getImpairedSince() == null ? 1 : 0)) == 0 ? instanceStatusDetails.getImpairedSince() == null || instanceStatusDetails.getImpairedSince().equals(getImpairedSince()) : false;
    }

    public Date getImpairedSince() {
        return this.impairedSince;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getStatus() == null ? 0 : getStatus().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + 31) * 31)) * 31;
        if (getImpairedSince() != null) {
            i = getImpairedSince().hashCode();
        }
        return hashCode + i;
    }

    public void setImpairedSince(Date date) {
        this.impairedSince = date;
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
        if (this.impairedSince != null) {
            stringBuilder.append("ImpairedSince: " + this.impairedSince + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceStatusDetails withImpairedSince(Date date) {
        this.impairedSince = date;
        return this;
    }

    public InstanceStatusDetails withName(String str) {
        this.name = str;
        return this;
    }

    public InstanceStatusDetails withStatus(String str) {
        this.status = str;
        return this;
    }
}
