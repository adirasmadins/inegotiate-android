package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum ImageState {
    Available("available"),
    Deregistered("deregistered");
    
    private String value;

    private ImageState(String str) {
        this.value = str;
    }

    public static ImageState fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("available".equals(str)) {
            return Available;
        } else {
            if ("deregistered".equals(str)) {
                return Deregistered;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
