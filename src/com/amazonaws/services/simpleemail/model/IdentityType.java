package com.amazonaws.services.simpleemail.model;

import com.google.gdata.util.common.base.StringUtil;

public enum IdentityType {
    EmailAddress("EmailAddress"),
    Domain("Domain");
    
    private String value;

    private IdentityType(String str) {
        this.value = str;
    }

    public static IdentityType fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("EmailAddress".equals(str)) {
            return EmailAddress;
        } else {
            if ("Domain".equals(str)) {
                return Domain;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
