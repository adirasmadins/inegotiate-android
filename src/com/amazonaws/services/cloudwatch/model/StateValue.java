package com.amazonaws.services.cloudwatch.model;

import com.google.gdata.util.common.base.StringUtil;

public enum StateValue {
    OK("OK"),
    ALARM("ALARM"),
    INSUFFICIENT_DATA("INSUFFICIENT_DATA");
    
    private String value;

    private StateValue(String str) {
        this.value = str;
    }

    public static StateValue fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("OK".equals(str)) {
            return OK;
        } else {
            if ("ALARM".equals(str)) {
                return ALARM;
            }
            if ("INSUFFICIENT_DATA".equals(str)) {
                return INSUFFICIENT_DATA;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
