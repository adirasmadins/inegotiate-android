package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum RuleAction {
    Allow("allow"),
    Deny("deny");
    
    private String value;

    private RuleAction(String str) {
        this.value = str;
    }

    public static RuleAction fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("allow".equals(str)) {
            return Allow;
        } else {
            if ("deny".equals(str)) {
                return Deny;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
