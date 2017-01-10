package com.amazonaws.services.ec2.model;

public class InstanceExportDetails {
    private String instanceId;
    private String targetEnvironment;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceExportDetails)) {
            return false;
        }
        InstanceExportDetails instanceExportDetails = (InstanceExportDetails) obj;
        if (((instanceExportDetails.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceExportDetails.getInstanceId() != null && !instanceExportDetails.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        return ((instanceExportDetails.getTargetEnvironment() == null ? 1 : 0) ^ (getTargetEnvironment() == null ? 1 : 0)) == 0 ? instanceExportDetails.getTargetEnvironment() == null || instanceExportDetails.getTargetEnvironment().equals(getTargetEnvironment()) : false;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getTargetEnvironment() {
        return this.targetEnvironment;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31;
        if (getTargetEnvironment() != null) {
            i = getTargetEnvironment().hashCode();
        }
        return hashCode + i;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setTargetEnvironment(ExportEnvironment exportEnvironment) {
        this.targetEnvironment = exportEnvironment.toString();
    }

    public void setTargetEnvironment(String str) {
        this.targetEnvironment = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.targetEnvironment != null) {
            stringBuilder.append("TargetEnvironment: " + this.targetEnvironment + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceExportDetails withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public InstanceExportDetails withTargetEnvironment(ExportEnvironment exportEnvironment) {
        this.targetEnvironment = exportEnvironment.toString();
        return this;
    }

    public InstanceExportDetails withTargetEnvironment(String str) {
        this.targetEnvironment = str;
        return this;
    }
}
