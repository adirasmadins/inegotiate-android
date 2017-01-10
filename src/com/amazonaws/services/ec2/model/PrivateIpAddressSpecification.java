package com.amazonaws.services.ec2.model;

public class PrivateIpAddressSpecification {
    private Boolean primary;
    private String privateIpAddress;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PrivateIpAddressSpecification)) {
            return false;
        }
        PrivateIpAddressSpecification privateIpAddressSpecification = (PrivateIpAddressSpecification) obj;
        if (((privateIpAddressSpecification.getPrivateIpAddress() == null ? 1 : 0) ^ (getPrivateIpAddress() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (privateIpAddressSpecification.getPrivateIpAddress() != null && !privateIpAddressSpecification.getPrivateIpAddress().equals(getPrivateIpAddress())) {
            return false;
        }
        return ((privateIpAddressSpecification.isPrimary() == null ? 1 : 0) ^ (isPrimary() == null ? 1 : 0)) == 0 ? privateIpAddressSpecification.isPrimary() == null || privateIpAddressSpecification.isPrimary().equals(isPrimary()) : false;
    }

    public Boolean getPrimary() {
        return this.primary;
    }

    public String getPrivateIpAddress() {
        return this.privateIpAddress;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPrivateIpAddress() == null ? 0 : getPrivateIpAddress().hashCode()) + 31) * 31;
        if (isPrimary() != null) {
            i = isPrimary().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isPrimary() {
        return this.primary;
    }

    public void setPrimary(Boolean bool) {
        this.primary = bool;
    }

    public void setPrivateIpAddress(String str) {
        this.privateIpAddress = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.privateIpAddress != null) {
            stringBuilder.append("PrivateIpAddress: " + this.privateIpAddress + ", ");
        }
        if (this.primary != null) {
            stringBuilder.append("Primary: " + this.primary + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PrivateIpAddressSpecification withPrimary(Boolean bool) {
        this.primary = bool;
        return this;
    }

    public PrivateIpAddressSpecification withPrivateIpAddress(String str) {
        this.privateIpAddress = str;
        return this;
    }
}
