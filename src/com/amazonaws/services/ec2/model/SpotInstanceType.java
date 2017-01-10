package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum SpotInstanceType {
    OneTime("one-time"),
    Persistent("persistent");
    
    private String value;

    private SpotInstanceType(String str) {
        this.value = str;
    }

    public static SpotInstanceType fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("one-time".equals(str)) {
            return OneTime;
        } else {
            if ("persistent".equals(str)) {
                return Persistent;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
