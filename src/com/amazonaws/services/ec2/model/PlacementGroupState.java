package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum PlacementGroupState {
    Pending("pending"),
    Available("available"),
    Deleting("deleting"),
    Deleted("deleted");
    
    private String value;

    private PlacementGroupState(String str) {
        this.value = str;
    }

    public static PlacementGroupState fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("pending".equals(str)) {
            return Pending;
        } else {
            if ("available".equals(str)) {
                return Available;
            }
            if ("deleting".equals(str)) {
                return Deleting;
            }
            if ("deleted".equals(str)) {
                return Deleted;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
