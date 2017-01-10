package com.amazonaws.services.ec2.model;

public class InstanceBlockDeviceMapping {
    private String deviceName;
    private EbsInstanceBlockDevice ebs;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceBlockDeviceMapping)) {
            return false;
        }
        InstanceBlockDeviceMapping instanceBlockDeviceMapping = (InstanceBlockDeviceMapping) obj;
        if (((instanceBlockDeviceMapping.getDeviceName() == null ? 1 : 0) ^ (getDeviceName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceBlockDeviceMapping.getDeviceName() != null && !instanceBlockDeviceMapping.getDeviceName().equals(getDeviceName())) {
            return false;
        }
        return ((instanceBlockDeviceMapping.getEbs() == null ? 1 : 0) ^ (getEbs() == null ? 1 : 0)) == 0 ? instanceBlockDeviceMapping.getEbs() == null || instanceBlockDeviceMapping.getEbs().equals(getEbs()) : false;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public EbsInstanceBlockDevice getEbs() {
        return this.ebs;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDeviceName() == null ? 0 : getDeviceName().hashCode()) + 31) * 31;
        if (getEbs() != null) {
            i = getEbs().hashCode();
        }
        return hashCode + i;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setEbs(EbsInstanceBlockDevice ebsInstanceBlockDevice) {
        this.ebs = ebsInstanceBlockDevice;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceBlockDeviceMapping withDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public InstanceBlockDeviceMapping withEbs(EbsInstanceBlockDevice ebsInstanceBlockDevice) {
        this.ebs = ebsInstanceBlockDevice;
        return this;
    }
}
