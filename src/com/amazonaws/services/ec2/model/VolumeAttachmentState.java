package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum VolumeAttachmentState {
    Attaching("attaching"),
    Attached("attached"),
    Detaching("detaching"),
    Detached("detached");
    
    private String value;

    private VolumeAttachmentState(String str) {
        this.value = str;
    }

    public static VolumeAttachmentState fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("attaching".equals(str)) {
            return Attaching;
        } else {
            if ("attached".equals(str)) {
                return Attached;
            }
            if ("detaching".equals(str)) {
                return Detaching;
            }
            if ("detached".equals(str)) {
                return Detached;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
