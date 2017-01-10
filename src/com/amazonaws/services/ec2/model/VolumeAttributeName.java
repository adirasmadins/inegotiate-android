package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum VolumeAttributeName {
    AutoEnableIO("autoEnableIO"),
    ProductCodes("productCodes");
    
    private String value;

    private VolumeAttributeName(String str) {
        this.value = str;
    }

    public static VolumeAttributeName fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("autoEnableIO".equals(str)) {
            return AutoEnableIO;
        } else {
            if ("productCodes".equals(str)) {
                return ProductCodes;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
