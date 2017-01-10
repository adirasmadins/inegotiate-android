package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum SnapshotState {
    Pending("pending"),
    Completed("completed"),
    Error("error");
    
    private String value;

    private SnapshotState(String str) {
        this.value = str;
    }

    public static SnapshotState fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("pending".equals(str)) {
            return Pending;
        } else {
            if ("completed".equals(str)) {
                return Completed;
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
