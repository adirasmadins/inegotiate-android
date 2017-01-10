package com.amazonaws.services.dynamodb.model;

import com.google.gdata.util.common.base.StringUtil;

public enum ScalarAttributeType {
    S("S"),
    N("N"),
    B("B");
    
    private String value;

    private ScalarAttributeType(String str) {
        this.value = str;
    }

    public static ScalarAttributeType fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("S".equals(str)) {
            return S;
        } else {
            if ("N".equals(str)) {
                return N;
            }
            if ("B".equals(str)) {
                return B;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
