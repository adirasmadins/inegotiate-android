package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum InstanceAttributeName {
    InstanceType("instanceType"),
    Kernel("kernel"),
    Ramdisk("ramdisk"),
    UserData("userData"),
    DisableApiTermination("disableApiTermination"),
    InstanceInitiatedShutdownBehavior("instanceInitiatedShutdownBehavior"),
    RootDeviceName("rootDeviceName"),
    BlockDeviceMapping("blockDeviceMapping"),
    ProductCodes("productCodes"),
    SourceDestCheck("sourceDestCheck"),
    GroupSet("groupSet"),
    EbsOptimized("ebsOptimized");
    
    private String value;

    private InstanceAttributeName(String str) {
        this.value = str;
    }

    public static InstanceAttributeName fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("instanceType".equals(str)) {
            return InstanceType;
        } else {
            if ("kernel".equals(str)) {
                return Kernel;
            }
            if ("ramdisk".equals(str)) {
                return Ramdisk;
            }
            if ("userData".equals(str)) {
                return UserData;
            }
            if ("disableApiTermination".equals(str)) {
                return DisableApiTermination;
            }
            if ("instanceInitiatedShutdownBehavior".equals(str)) {
                return InstanceInitiatedShutdownBehavior;
            }
            if ("rootDeviceName".equals(str)) {
                return RootDeviceName;
            }
            if ("blockDeviceMapping".equals(str)) {
                return BlockDeviceMapping;
            }
            if ("productCodes".equals(str)) {
                return ProductCodes;
            }
            if ("sourceDestCheck".equals(str)) {
                return SourceDestCheck;
            }
            if ("groupSet".equals(str)) {
                return GroupSet;
            }
            if ("ebsOptimized".equals(str)) {
                return EbsOptimized;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
