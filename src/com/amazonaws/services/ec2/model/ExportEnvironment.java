package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum ExportEnvironment {
    Citrix("citrix"),
    Vmware("vmware");
    
    private String value;

    private ExportEnvironment(String str) {
        this.value = str;
    }

    public static ExportEnvironment fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("citrix".equals(str)) {
            return Citrix;
        } else {
            if ("vmware".equals(str)) {
                return Vmware;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
