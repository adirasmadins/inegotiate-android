package com.amazonaws.services.cloudwatch.model;

import com.google.gdata.util.common.base.StringUtil;

public enum ComparisonOperator {
    GreaterThanOrEqualToThreshold("GreaterThanOrEqualToThreshold"),
    GreaterThanThreshold("GreaterThanThreshold"),
    LessThanThreshold("LessThanThreshold"),
    LessThanOrEqualToThreshold("LessThanOrEqualToThreshold");
    
    private String value;

    private ComparisonOperator(String str) {
        this.value = str;
    }

    public static ComparisonOperator fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("GreaterThanOrEqualToThreshold".equals(str)) {
            return GreaterThanOrEqualToThreshold;
        } else {
            if ("GreaterThanThreshold".equals(str)) {
                return GreaterThanThreshold;
            }
            if ("LessThanThreshold".equals(str)) {
                return LessThanThreshold;
            }
            if ("LessThanOrEqualToThreshold".equals(str)) {
                return LessThanOrEqualToThreshold;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
