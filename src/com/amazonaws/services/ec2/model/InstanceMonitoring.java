package com.amazonaws.services.ec2.model;

public class InstanceMonitoring {
    private String instanceId;
    private Monitoring monitoring;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceMonitoring)) {
            return false;
        }
        InstanceMonitoring instanceMonitoring = (InstanceMonitoring) obj;
        if (((instanceMonitoring.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceMonitoring.getInstanceId() != null && !instanceMonitoring.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        return ((instanceMonitoring.getMonitoring() == null ? 1 : 0) ^ (getMonitoring() == null ? 1 : 0)) == 0 ? instanceMonitoring.getMonitoring() == null || instanceMonitoring.getMonitoring().equals(getMonitoring()) : false;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public Monitoring getMonitoring() {
        return this.monitoring;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31;
        if (getMonitoring() != null) {
            i = getMonitoring().hashCode();
        }
        return hashCode + i;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setMonitoring(Monitoring monitoring) {
        this.monitoring = monitoring;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.monitoring != null) {
            stringBuilder.append("Monitoring: " + this.monitoring + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceMonitoring withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public InstanceMonitoring withMonitoring(Monitoring monitoring) {
        this.monitoring = monitoring;
        return this;
    }
}
