package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum ContainerFormat {
    Ova("ova");
    
    private String value;

    private ContainerFormat(String str) {
        this.value = str;
    }

    public static ContainerFormat fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("ova".equals(str)) {
            return Ova;
        } else {
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
