package com.amazonaws.services.autoscaling.model;

public class InstanceMonitoring {
    private Boolean enabled;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceMonitoring)) {
            return false;
        }
        InstanceMonitoring instanceMonitoring = (InstanceMonitoring) obj;
        return ((instanceMonitoring.isEnabled() == null ? 1 : 0) ^ (isEnabled() == null ? 1 : 0)) == 0 ? instanceMonitoring.isEnabled() == null || instanceMonitoring.isEnabled().equals(isEnabled()) : false;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public int hashCode() {
        return (isEnabled() == null ? 0 : isEnabled().hashCode()) + 31;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.enabled != null) {
            stringBuilder.append("Enabled: " + this.enabled + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceMonitoring withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }
}
