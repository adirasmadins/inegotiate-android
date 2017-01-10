package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum InstanceStateName {
    Pending("pending"),
    Running("running"),
    ShuttingDown("shutting-down"),
    Terminated("terminated"),
    Stopping("stopping"),
    Stopped("stopped");
    
    private String value;

    private InstanceStateName(String str) {
        this.value = str;
    }

    public static InstanceStateName fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("pending".equals(str)) {
            return Pending;
        } else {
            if ("running".equals(str)) {
                return Running;
            }
            if ("shutting-down".equals(str)) {
                return ShuttingDown;
            }
            if ("terminated".equals(str)) {
                return Terminated;
            }
            if ("stopping".equals(str)) {
                return Stopping;
            }
            if ("stopped".equals(str)) {
                return Stopped;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
