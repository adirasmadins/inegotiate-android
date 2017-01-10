package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum DomainType {
    Vpc("vpc"),
    Standard("standard");
    
    private String value;

    private DomainType(String str) {
        this.value = str;
    }

    public static DomainType fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("vpc".equals(str)) {
            return Vpc;
        } else {
            if ("standard".equals(str)) {
                return Standard;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
