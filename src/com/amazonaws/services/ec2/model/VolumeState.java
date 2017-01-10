package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum VolumeState {
    Creating("creating"),
    Available("available"),
    InUse("in-use"),
    Deleting("deleting"),
    Error("error");
    
    private String value;

    private VolumeState(String str) {
        this.value = str;
    }

    public static VolumeState fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("creating".equals(str)) {
            return Creating;
        } else {
            if ("available".equals(str)) {
                return Available;
            }
            if ("in-use".equals(str)) {
                return InUse;
            }
            if ("deleting".equals(str)) {
                return Deleting;
            }
            if ("error".equals(str)) {
                return Error;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
