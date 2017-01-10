package com.amazonaws.services.cloudwatch.model;

import com.google.gdata.util.common.base.StringUtil;

public enum Statistic {
    SampleCount("SampleCount"),
    Average("Average"),
    Sum("Sum"),
    Minimum("Minimum"),
    Maximum("Maximum");
    
    private String value;

    private Statistic(String str) {
        this.value = str;
    }

    public static Statistic fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("SampleCount".equals(str)) {
            return SampleCount;
        } else {
            if ("Average".equals(str)) {
                return Average;
            }
            if ("Sum".equals(str)) {
                return Sum;
            }
            if ("Minimum".equals(str)) {
                return Minimum;
            }
            if ("Maximum".equals(str)) {
                return Maximum;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
