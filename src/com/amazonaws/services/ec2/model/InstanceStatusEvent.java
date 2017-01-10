package com.amazonaws.services.ec2.model;

import java.util.Date;

public class InstanceStatusEvent {
    private String code;
    private String description;
    private Date notAfter;
    private Date notBefore;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceStatusEvent)) {
            return false;
        }
        InstanceStatusEvent instanceStatusEvent = (InstanceStatusEvent) obj;
        if (((instanceStatusEvent.getCode() == null ? 1 : 0) ^ (getCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStatusEvent.getCode() != null && !instanceStatusEvent.getCode().equals(getCode())) {
            return false;
        }
        if (((instanceStatusEvent.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStatusEvent.getDescription() != null && !instanceStatusEvent.getDescription().equals(getDescription())) {
            return false;
        }
        if (((instanceStatusEvent.getNotBefore() == null ? 1 : 0) ^ (getNotBefore() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStatusEvent.getNotBefore() != null && !instanceStatusEvent.getNotBefore().equals(getNotBefore())) {
            return false;
        }
        return ((instanceStatusEvent.getNotAfter() == null ? 1 : 0) ^ (getNotAfter() == null ? 1 : 0)) == 0 ? instanceStatusEvent.getNotAfter() == null || instanceStatusEvent.getNotAfter().equals(getNotAfter()) : false;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getNotAfter() {
        return this.notAfter;
    }

    public Date getNotBefore() {
        return this.notBefore;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNotBefore() == null ? 0 : getNotBefore().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getCode() == null ? 0 : getCode().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getNotAfter() != null) {
            i = getNotAfter().hashCode();
        }
        return hashCode + i;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setNotAfter(Date date) {
        this.notAfter = date;
    }

    public void setNotBefore(Date date) {
        this.notBefore = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.code != null) {
            stringBuilder.append("Code: " + this.code + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.notBefore != null) {
            stringBuilder.append("NotBefore: " + this.notBefore + ", ");
        }
        if (this.notAfter != null) {
            stringBuilder.append("NotAfter: " + this.notAfter + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceStatusEvent withCode(String str) {
        this.code = str;
        return this;
    }

    public InstanceStatusEvent withDescription(String str) {
        this.description = str;
        return this;
    }

    public InstanceStatusEvent withNotAfter(Date date) {
        this.notAfter = date;
        return this;
    }

    public InstanceStatusEvent withNotBefore(Date date) {
        this.notBefore = date;
        return this;
    }
}
