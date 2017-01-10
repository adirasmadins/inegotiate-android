package com.amazonaws.services.ec2.model;

public class InstanceState {
    private Integer code;
    private String name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceState)) {
            return false;
        }
        InstanceState instanceState = (InstanceState) obj;
        if (((instanceState.getCode() == null ? 1 : 0) ^ (getCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceState.getCode() != null && !instanceState.getCode().equals(getCode())) {
            return false;
        }
        return ((instanceState.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) == 0 ? instanceState.getName() == null || instanceState.getName().equals(getName()) : false;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCode() == null ? 0 : getCode().hashCode()) + 31) * 31;
        if (getName() != null) {
            i = getName().hashCode();
        }
        return hashCode + i;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setName(InstanceStateName instanceStateName) {
        this.name = instanceStateName.toString();
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.code != null) {
            stringBuilder.append("Code: " + this.code + ", ");
        }
        if (this.name != null) {
            stringBuilder.append("Name: " + this.name + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceState withCode(Integer num) {
        this.code = num;
        return this;
    }

    public InstanceState withName(InstanceStateName instanceStateName) {
        this.name = instanceStateName.toString();
        return this;
    }

    public InstanceState withName(String str) {
        this.name = str;
        return this;
    }
}
