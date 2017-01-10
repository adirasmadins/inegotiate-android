package com.amazonaws.services.ec2.model;

public class InstanceNetworkInterfaceAssociation {
    private String ipOwnerId;
    private String publicIp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceNetworkInterfaceAssociation)) {
            return false;
        }
        InstanceNetworkInterfaceAssociation instanceNetworkInterfaceAssociation = (InstanceNetworkInterfaceAssociation) obj;
        if (((instanceNetworkInterfaceAssociation.getPublicIp() == null ? 1 : 0) ^ (getPublicIp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceAssociation.getPublicIp() != null && !instanceNetworkInterfaceAssociation.getPublicIp().equals(getPublicIp())) {
            return false;
        }
        return ((instanceNetworkInterfaceAssociation.getIpOwnerId() == null ? 1 : 0) ^ (getIpOwnerId() == null ? 1 : 0)) == 0 ? instanceNetworkInterfaceAssociation.getIpOwnerId() == null || instanceNetworkInterfaceAssociation.getIpOwnerId().equals(getIpOwnerId()) : false;
    }

    public String getIpOwnerId() {
        return this.ipOwnerId;
    }

    public String getPublicIp() {
        return this.publicIp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPublicIp() == null ? 0 : getPublicIp().hashCode()) + 31) * 31;
        if (getIpOwnerId() != null) {
            i = getIpOwnerId().hashCode();
        }
        return hashCode + i;
    }

    public void setIpOwnerId(String str) {
        this.ipOwnerId = str;
    }

    public void setPublicIp(String str) {
        this.publicIp = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.publicIp != null) {
            stringBuilder.append("PublicIp: " + this.publicIp + ", ");
        }
        if (this.ipOwnerId != null) {
            stringBuilder.append("IpOwnerId: " + this.ipOwnerId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceNetworkInterfaceAssociation withIpOwnerId(String str) {
        this.ipOwnerId = str;
        return this;
    }

    public InstanceNetworkInterfaceAssociation withPublicIp(String str) {
        this.publicIp = str;
        return this;
    }
}
