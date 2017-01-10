package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum VolumeType {
    Standard("standard"),
    Io1("io1");
    
    private String value;

    private VolumeType(String str) {
        this.value = str;
    }

    public static VolumeType fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("standard".equals(str)) {
            return Standard;
        } else {
            if ("io1".equals(str)) {
                return Io1;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
