package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum VirtualizationType {
    Hvm("hvm"),
    Paravirtual("paravirtual");
    
    private String value;

    private VirtualizationType(String str) {
        this.value = str;
    }

    public static VirtualizationType fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("hvm".equals(str)) {
            return Hvm;
        } else {
            if ("paravirtual".equals(str)) {
                return Paravirtual;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
