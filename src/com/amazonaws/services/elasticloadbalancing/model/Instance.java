package com.amazonaws.services.elasticloadbalancing.model;

public class Instance {
    private String instanceId;

    public Instance(String str) {
        this.instanceId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Instance)) {
            return false;
        }
        Instance instance = (Instance) obj;
        return ((instance.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) == 0 ? instance.getInstanceId() == null || instance.getInstanceId().equals(getInstanceId()) : false;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public int hashCode() {
        return (getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Instance withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }
}
