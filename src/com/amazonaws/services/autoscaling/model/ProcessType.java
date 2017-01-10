package com.amazonaws.services.autoscaling.model;

public class ProcessType {
    private String processName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ProcessType)) {
            return false;
        }
        ProcessType processType = (ProcessType) obj;
        return ((processType.getProcessName() == null ? 1 : 0) ^ (getProcessName() == null ? 1 : 0)) == 0 ? processType.getProcessName() == null || processType.getProcessName().equals(getProcessName()) : false;
    }

    public String getProcessName() {
        return this.processName;
    }

    public int hashCode() {
        return (getProcessName() == null ? 0 : getProcessName().hashCode()) + 31;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.processName != null) {
            stringBuilder.append("ProcessName: " + this.processName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ProcessType withProcessName(String str) {
        this.processName = str;
        return this;
    }
}
