package com.amazonaws.services.ec2.model;

public class InstanceLicense {
    private String pool;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceLicense)) {
            return false;
        }
        InstanceLicense instanceLicense = (InstanceLicense) obj;
        return ((instanceLicense.getPool() == null ? 1 : 0) ^ (getPool() == null ? 1 : 0)) == 0 ? instanceLicense.getPool() == null || instanceLicense.getPool().equals(getPool()) : false;
    }

    public String getPool() {
        return this.pool;
    }

    public int hashCode() {
        return (getPool() == null ? 0 : getPool().hashCode()) + 31;
    }

    public void setPool(String str) {
        this.pool = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.pool != null) {
            stringBuilder.append("Pool: " + this.pool + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceLicense withPool(String str) {
        this.pool = str;
        return this;
    }
}
