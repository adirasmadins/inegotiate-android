package com.amazonaws.services.dynamodb.model;

import com.google.gdata.util.common.base.StringUtil;

public enum TableStatus {
    CREATING("CREATING"),
    UPDATING("UPDATING"),
    DELETING("DELETING"),
    ACTIVE("ACTIVE");
    
    private String value;

    private TableStatus(String str) {
        this.value = str;
    }

    public static TableStatus fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("CREATING".equals(str)) {
            return CREATING;
        } else {
            if ("UPDATING".equals(str)) {
                return UPDATING;
            }
            if ("DELETING".equals(str)) {
                return DELETING;
            }
            if ("ACTIVE".equals(str)) {
                return ACTIVE;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
