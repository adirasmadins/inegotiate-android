package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum InstanceType {
    T1Micro("t1.micro"),
    M1Small("m1.small"),
    M1Medium("m1.medium"),
    M1Large("m1.large"),
    M1Xlarge("m1.xlarge"),
    M2Xlarge("m2.xlarge"),
    M22xlarge("m2.2xlarge"),
    M24xlarge("m2.4xlarge"),
    C1Medium("c1.medium"),
    C1Xlarge("c1.xlarge"),
    Hi14xlarge("hi1.4xlarge"),
    Cc14xlarge("cc1.4xlarge"),
    Cc28xlarge("cc2.8xlarge"),
    Cg14xlarge("cg1.4xlarge");
    
    private String value;

    private InstanceType(String str) {
        this.value = str;
    }

    public static InstanceType fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("t1.micro".equals(str)) {
            return T1Micro;
        } else {
            if ("m1.small".equals(str)) {
                return M1Small;
            }
            if ("m1.medium".equals(str)) {
                return M1Medium;
            }
            if ("m1.large".equals(str)) {
                return M1Large;
            }
            if ("m1.xlarge".equals(str)) {
                return M1Xlarge;
            }
            if ("m2.xlarge".equals(str)) {
                return M2Xlarge;
            }
            if ("m2.2xlarge".equals(str)) {
                return M22xlarge;
            }
            if ("m2.4xlarge".equals(str)) {
                return M24xlarge;
            }
            if ("c1.medium".equals(str)) {
                return C1Medium;
            }
            if ("c1.xlarge".equals(str)) {
                return C1Xlarge;
            }
            if ("hi1.4xlarge".equals(str)) {
                return Hi14xlarge;
            }
            if ("cc1.4xlarge".equals(str)) {
                return Cc14xlarge;
            }
            if ("cc2.8xlarge".equals(str)) {
                return Cc28xlarge;
            }
            if ("cg1.4xlarge".equals(str)) {
                return Cg14xlarge;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
