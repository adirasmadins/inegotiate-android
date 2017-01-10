package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum PlacementStrategy {
    Cluster("cluster");
    
    private String value;

    private PlacementStrategy(String str) {
        this.value = str;
    }

    public static PlacementStrategy fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("cluster".equals(str)) {
            return Cluster;
        } else {
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
