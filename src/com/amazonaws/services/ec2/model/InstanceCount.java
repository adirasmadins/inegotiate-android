package com.amazonaws.services.ec2.model;

public class InstanceCount {
    private Integer instanceCount;
    private String state;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceCount)) {
            return false;
        }
        InstanceCount instanceCount = (InstanceCount) obj;
        if (((instanceCount.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceCount.getState() != null && !instanceCount.getState().equals(getState())) {
            return false;
        }
        return ((instanceCount.getInstanceCount() == null ? 1 : 0) ^ (getInstanceCount() == null ? 1 : 0)) == 0 ? instanceCount.getInstanceCount() == null || instanceCount.getInstanceCount().equals(getInstanceCount()) : false;
    }

    public Integer getInstanceCount() {
        return this.instanceCount;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getState() == null ? 0 : getState().hashCode()) + 31) * 31;
        if (getInstanceCount() != null) {
            i = getInstanceCount().hashCode();
        }
        return hashCode + i;
    }

    public void setInstanceCount(Integer num) {
        this.instanceCount = num;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.instanceCount != null) {
            stringBuilder.append("InstanceCount: " + this.instanceCount + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceCount withInstanceCount(Integer num) {
        this.instanceCount = num;
        return this;
    }

    public InstanceCount withState(String str) {
        this.state = str;
        return this;
    }
}
