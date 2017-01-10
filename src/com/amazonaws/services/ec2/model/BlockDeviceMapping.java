package com.amazonaws.services.ec2.model;

public class BlockDeviceMapping {
    private String deviceName;
    private EbsBlockDevice ebs;
    private String noDevice;
    private String virtualName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BlockDeviceMapping)) {
            return false;
        }
        BlockDeviceMapping blockDeviceMapping = (BlockDeviceMapping) obj;
        if (((blockDeviceMapping.getVirtualName() == null ? 1 : 0) ^ (getVirtualName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (blockDeviceMapping.getVirtualName() != null && !blockDeviceMapping.getVirtualName().equals(getVirtualName())) {
            return false;
        }
        if (((blockDeviceMapping.getDeviceName() == null ? 1 : 0) ^ (getDeviceName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (blockDeviceMapping.getDeviceName() != null && !blockDeviceMapping.getDeviceName().equals(getDeviceName())) {
            return false;
        }
        if (((blockDeviceMapping.getEbs() == null ? 1 : 0) ^ (getEbs() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (blockDeviceMapping.getEbs() != null && !blockDeviceMapping.getEbs().equals(getEbs())) {
            return false;
        }
        return ((blockDeviceMapping.getNoDevice() == null ? 1 : 0) ^ (getNoDevice() == null ? 1 : 0)) == 0 ? blockDeviceMapping.getNoDevice() == null || blockDeviceMapping.getNoDevice().equals(getNoDevice()) : false;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public EbsBlockDevice getEbs() {
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
        int hashCode = ((getEbs() == null ? 0 : getEbs().hashCode()) + (((getDeviceName() == null ? 0 : getDeviceName().hashCode()) + (((getVirtualName() == null ? 0 : getVirtualName().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getNoDevice() != null) {
            i = getNoDevice().hashCode();
        }
        return hashCode + i;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setEbs(EbsBlockDevice ebsBlockDevice) {
        this.ebs = ebsBlockDevice;
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
        if (this.virtualName != null) {
            stringBuilder.append("VirtualName: " + this.virtualName + ", ");
        }
        if (this.deviceName != null) {
            stringBuilder.append("DeviceName: " + this.deviceName + ", ");
        }
        if (this.ebs != null) {
            stringBuilder.append("Ebs: " + this.ebs + ", ");
        }
        if (this.noDevice != null) {
            stringBuilder.append("NoDevice: " + this.noDevice + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BlockDeviceMapping withDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public BlockDeviceMapping withEbs(EbsBlockDevice ebsBlockDevice) {
        this.ebs = ebsBlockDevice;
        return this;
    }

    public BlockDeviceMapping withNoDevice(String str) {
        this.noDevice = str;
        return this;
    }

    public BlockDeviceMapping withVirtualName(String str) {
        this.virtualName = str;
        return this;
    }
}
