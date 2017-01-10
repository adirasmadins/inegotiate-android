package com.amazonaws.services.dynamodb.model;

import com.google.gdata.util.common.base.StringUtil;

public enum ComparisonOperator {
    EQ("EQ"),
    NE("NE"),
    IN("IN"),
    LE("LE"),
    LT("LT"),
    GE("GE"),
    GT("GT"),
    BETWEEN("BETWEEN"),
    NOT_NULL("NOT_NULL"),
    NULL("NULL"),
    CONTAINS("CONTAINS"),
    NOT_CONTAINS("NOT_CONTAINS"),
    BEGINS_WITH("BEGINS_WITH");
    
    private String value;

    private ComparisonOperator(String str) {
        this.value = str;
    }

    public static ComparisonOperator fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("EQ".equals(str)) {
            return EQ;
        } else {
            if ("NE".equals(str)) {
                return NE;
            }
            if ("IN".equals(str)) {
                return IN;
            }
            if ("LE".equals(str)) {
                return LE;
            }
            if ("LT".equals(str)) {
                return LT;
            }
            if ("GE".equals(str)) {
                return GE;
            }
            if ("GT".equals(str)) {
                return GT;
            }
            if ("BETWEEN".equals(str)) {
                return BETWEEN;
            }
            if ("NOT_NULL".equals(str)) {
                return NOT_NULL;
            }
            if ("NULL".equals(str)) {
                return NULL;
            }
            if ("CONTAINS".equals(str)) {
                return CONTAINS;
            }
            if ("NOT_CONTAINS".equals(str)) {
                return NOT_CONTAINS;
            }
            if ("BEGINS_WITH".equals(str)) {
                return BEGINS_WITH;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
