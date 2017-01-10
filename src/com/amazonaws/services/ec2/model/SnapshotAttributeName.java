package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum SnapshotAttributeName {
    ProductCodes("productCodes"),
    CreateVolumePermission("createVolumePermission");
    
    private String value;

    private SnapshotAttributeName(String str) {
        this.value = str;
    }

    public static SnapshotAttributeName fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("productCodes".equals(str)) {
            return ProductCodes;
        } else {
            if ("createVolumePermission".equals(str)) {
                return CreateVolumePermission;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
