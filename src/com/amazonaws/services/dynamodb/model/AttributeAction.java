package com.amazonaws.services.dynamodb.model;

import com.google.gdata.util.common.base.StringUtil;

public enum AttributeAction {
    ADD("ADD"),
    PUT("PUT"),
    DELETE("DELETE");
    
    private String value;

    private AttributeAction(String str) {
        this.value = str;
    }

    public static AttributeAction fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("ADD".equals(str)) {
            return ADD;
        } else {
            if ("PUT".equals(str)) {
                return PUT;
            }
            if ("DELETE".equals(str)) {
                return DELETE;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
