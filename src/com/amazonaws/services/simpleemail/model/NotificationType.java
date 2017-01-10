package com.amazonaws.services.simpleemail.model;

import com.google.gdata.util.common.base.StringUtil;

public enum NotificationType {
    Bounce("Bounce"),
    Complaint("Complaint");
    
    private String value;

    private NotificationType(String str) {
        this.value = str;
    }

    public static NotificationType fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("Bounce".equals(str)) {
            return Bounce;
        } else {
            if ("Complaint".equals(str)) {
                return Complaint;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
