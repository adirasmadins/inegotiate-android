package com.amazonaws.services.cloudwatch.model;

import com.google.gdata.util.common.base.StringUtil;

public enum StandardUnit {
    Seconds("Seconds"),
    Microseconds("Microseconds"),
    Milliseconds("Milliseconds"),
    Bytes("Bytes"),
    Kilobytes("Kilobytes"),
    Megabytes("Megabytes"),
    Gigabytes("Gigabytes"),
    Terabytes("Terabytes"),
    Bits("Bits"),
    Kilobits("Kilobits"),
    Megabits("Megabits"),
    Gigabits("Gigabits"),
    Terabits("Terabits"),
    Percent("Percent"),
    Count("Count"),
    BytesSecond("Bytes/Second"),
    KilobytesSecond("Kilobytes/Second"),
    MegabytesSecond("Megabytes/Second"),
    GigabytesSecond("Gigabytes/Second"),
    TerabytesSecond("Terabytes/Second"),
    BitsSecond("Bits/Second"),
    KilobitsSecond("Kilobits/Second"),
    MegabitsSecond("Megabits/Second"),
    GigabitsSecond("Gigabits/Second"),
    TerabitsSecond("Terabits/Second"),
    CountSecond("Count/Second"),
    None("None");
    
    private String value;

    private StandardUnit(String str) {
        this.value = str;
    }

    public static StandardUnit fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("Seconds".equals(str)) {
            return Seconds;
        } else {
            if ("Microseconds".equals(str)) {
                return Microseconds;
            }
            if ("Milliseconds".equals(str)) {
                return Milliseconds;
            }
            if ("Bytes".equals(str)) {
                return Bytes;
            }
            if ("Kilobytes".equals(str)) {
                return Kilobytes;
            }
            if ("Megabytes".equals(str)) {
                return Megabytes;
            }
            if ("Gigabytes".equals(str)) {
                return Gigabytes;
            }
            if ("Terabytes".equals(str)) {
                return Terabytes;
            }
            if ("Bits".equals(str)) {
                return Bits;
            }
            if ("Kilobits".equals(str)) {
                return Kilobits;
            }
            if ("Megabits".equals(str)) {
                return Megabits;
            }
            if ("Gigabits".equals(str)) {
                return Gigabits;
            }
            if ("Terabits".equals(str)) {
                return Terabits;
            }
            if ("Percent".equals(str)) {
                return Percent;
            }
            if ("Count".equals(str)) {
                return Count;
            }
            if ("Bytes/Second".equals(str)) {
                return BytesSecond;
            }
            if ("Kilobytes/Second".equals(str)) {
                return KilobytesSecond;
            }
            if ("Megabytes/Second".equals(str)) {
                return MegabytesSecond;
            }
            if ("Gigabytes/Second".equals(str)) {
                return GigabytesSecond;
            }
            if ("Terabytes/Second".equals(str)) {
                return TerabytesSecond;
            }
            if ("Bits/Second".equals(str)) {
                return BitsSecond;
            }
            if ("Kilobits/Second".equals(str)) {
                return KilobitsSecond;
            }
            if ("Megabits/Second".equals(str)) {
                return MegabitsSecond;
            }
            if ("Gigabits/Second".equals(str)) {
                return GigabitsSecond;
            }
            if ("Terabits/Second".equals(str)) {
                return TerabitsSecond;
            }
            if ("Count/Second".equals(str)) {
                return CountSecond;
            }
            if ("None".equals(str)) {
                return None;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
