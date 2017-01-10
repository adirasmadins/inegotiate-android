package com.amazonaws.services.autoscaling.model;

import com.google.gdata.util.common.base.StringUtil;

public enum LifecycleState {
    Pending("Pending"),
    Quarantined("Quarantined"),
    InService("InService"),
    Terminating("Terminating"),
    Terminated("Terminated");
    
    private String value;

    private LifecycleState(String str) {
        this.value = str;
    }

    public static LifecycleState fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("Pending".equals(str)) {
            return Pending;
        } else {
            if ("Quarantined".equals(str)) {
                return Quarantined;
            }
            if ("InService".equals(str)) {
                return InService;
            }
            if ("Terminating".equals(str)) {
                return Terminating;
            }
            if ("Terminated".equals(str)) {
                return Terminated;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
