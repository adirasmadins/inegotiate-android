package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum DiskImageFormat {
    Vmdk("vmdk"),
    Vhd("vhd");
    
    private String value;

    private DiskImageFormat(String str) {
        this.value = str;
    }

    public static DiskImageFormat fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("vmdk".equals(str)) {
            return Vmdk;
        } else {
            if ("vhd".equals(str)) {
                return Vhd;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
