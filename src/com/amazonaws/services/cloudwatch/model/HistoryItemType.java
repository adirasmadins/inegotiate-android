package com.amazonaws.services.cloudwatch.model;

import com.google.gdata.util.common.base.StringUtil;

public enum HistoryItemType {
    ConfigurationUpdate("ConfigurationUpdate"),
    StateUpdate("StateUpdate"),
    Action("Action");
    
    private String value;

    private HistoryItemType(String str) {
        this.value = str;
    }

    public static HistoryItemType fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("ConfigurationUpdate".equals(str)) {
            return ConfigurationUpdate;
        } else {
            if ("StateUpdate".equals(str)) {
                return StateUpdate;
            }
            if ("Action".equals(str)) {
                return Action;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
