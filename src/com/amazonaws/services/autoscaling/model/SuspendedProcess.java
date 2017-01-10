package com.amazonaws.services.autoscaling.model;

public class SuspendedProcess {
    private String processName;
    private String suspensionReason;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SuspendedProcess)) {
            return false;
        }
        SuspendedProcess suspendedProcess = (SuspendedProcess) obj;
        if (((suspendedProcess.getProcessName() == null ? 1 : 0) ^ (getProcessName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (suspendedProcess.getProcessName() != null && !suspendedProcess.getProcessName().equals(getProcessName())) {
            return false;
        }
        return ((suspendedProcess.getSuspensionReason() == null ? 1 : 0) ^ (getSuspensionReason() == null ? 1 : 0)) == 0 ? suspendedProcess.getSuspensionReason() == null || suspendedProcess.getSuspensionReason().equals(getSuspensionReason()) : false;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getSuspensionReason() {
        return this.suspensionReason;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getProcessName() == null ? 0 : getProcessName().hashCode()) + 31) * 31;
        if (getSuspensionReason() != null) {
            i = getSuspensionReason().hashCode();
        }
        return hashCode + i;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }

    public void setSuspensionReason(String str) {
        this.suspensionReason = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.processName != null) {
            stringBuilder.append("ProcessName: " + this.processName + ", ");
        }
        if (this.suspensionReason != null) {
            stringBuilder.append("SuspensionReason: " + this.suspensionReason + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SuspendedProcess withProcessName(String str) {
        this.processName = str;
        return this;
    }

    public SuspendedProcess withSuspensionReason(String str) {
        this.suspensionReason = str;
        return this;
    }
}
