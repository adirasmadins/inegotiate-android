package com.amazonaws.services.ec2.model;

public class InstanceBlockDeviceMappingSpecification {
    private String deviceName;
    private EbsInstanceBlockDeviceSpecification ebs;
    private String noDevice;
    private String virtualName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceBlockDeviceMappingSpecification)) {
            return false;
        }
        InstanceBlockDeviceMappingSpecification instanceBlockDeviceMappingSpecification = (InstanceBlockDeviceMappingSpecification) obj;
        if (((instanceBlockDeviceMappingSpecification.getDeviceName() == null ? 1 : 0) ^ (getDeviceName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceBlockDeviceMappingSpecification.getDeviceName() != null && !instanceBlockDeviceMappingSpecification.getDeviceName().equals(getDeviceName())) {
            return false;
        }
        if (((instanceBlockDeviceMappingSpecification.getEbs() == null ? 1 : 0) ^ (getEbs() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceBlockDeviceMappingSpecification.getEbs() != null && !instanceBlockDeviceMappingSpecification.getEbs().equals(getEbs())) {
            return false;
        }
        if (((instanceBlockDeviceMappingSpecification.getVirtualName() == null ? 1 : 0) ^ (getVirtualName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceBlockDeviceMappingSpecification.getVirtualName() != null && !instanceBlockDeviceMappingSpecification.getVirtualName().equals(getVirtualName())) {
            return false;
        }
        return ((instanceBlockDeviceMappingSpecification.getNoDevice() == null ? 1 : 0) ^ (getNoDevice() == null ? 1 : 0)) == 0 ? instanceBlockDeviceMappingSpecification.getNoDevice() == null || instanceBlockDeviceMappingSpecification.getNoDevice().equals(getNoDevice()) : false;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public EbsInstanceBlockDeviceSpecification getEbs() {
        return this.ebs;
    }

    public String getNoDevice() {
        return this.noDevice;
    }

    public String getVirtualName() {
        return this.virtualName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVirtualName() == null ? 0 : getVirtualName().hashCode()) + (((getEbs() == null ? 0 : getEbs().hashCode()) + (((getDeviceName() == null ? 0 : getDeviceName().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getNoDevice() != null) {
            i = getNoDevice().hashCode();
        }
        return hashCode + i;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setEbs(EbsInstanceBlockDeviceSpecification ebsInstanceBlockDeviceSpecification) {
        this.ebs = ebsInstanceBlockDeviceSpecification;
    }

    public void setNoDevice(String str) {
        this.noDevice = str;
    }

    public void setVirtualName(String str) {
        this.virtualName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.deviceName != null) {
            stringBuilder.append("DeviceName: " + this.deviceName + ", ");
        }
        if (this.ebs != null) {
            stringBuilder.append("Ebs: " + this.ebs + ", ");
        }
        if (this.virtualName != null) {
            stringBuilder.append("VirtualName: " + this.virtualName + ", ");
        }
        if (this.noDevice != null) {
            stringBuilder.append("NoDevice: " + this.noDevice + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceBlockDeviceMappingSpecification withDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public InstanceBlockDeviceMappingSpecification withEbs(EbsInstanceBlockDeviceSpecification ebsInstanceBlockDeviceSpecification) {
        this.ebs = ebsInstanceBlockDeviceSpecification;
        return this;
    }

    public InstanceBlockDeviceMappingSpecification withNoDevice(String str) {
        this.noDevice = str;
        return this;
    }

    public InstanceBlockDeviceMappingSpecification withVirtualName(String str) {
        this.virtualName = str;
        return this;
    }
}
