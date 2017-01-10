package com.amazonaws.services.ec2.model;

public class InstanceLicenseSpecification {
    private String pool;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceLicenseSpecification)) {
            return false;
        }
        InstanceLicenseSpecification instanceLicenseSpecification = (InstanceLicenseSpecification) obj;
        return ((instanceLicenseSpecification.getPool() == null ? 1 : 0) ^ (getPool() == null ? 1 : 0)) == 0 ? instanceLicenseSpecification.getPool() == null || instanceLicenseSpecification.getPool().equals(getPool()) : false;
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

    public InstanceLicenseSpecification withPool(String str) {
        this.pool = str;
        return this;
    }
}
