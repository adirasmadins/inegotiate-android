package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum HypervisorType {
    Ovm("ovm"),
    Xen("xen");
    
    private String value;

    private HypervisorType(String str) {
        this.value = str;
    }

    public static HypervisorType fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("ovm".equals(str)) {
            return Ovm;
        } else {
            if ("xen".equals(str)) {
                return Xen;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
