package com.amazonaws.services.simpleemail.model;

import com.google.gdata.util.common.base.StringUtil;

public enum VerificationStatus {
    Pending("Pending"),
    Success("Success"),
    Failed("Failed"),
    TemporaryFailure("TemporaryFailure");
    
    private String value;

    private VerificationStatus(String str) {
        this.value = str;
    }

    public static VerificationStatus fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("Pending".equals(str)) {
            return Pending;
        } else {
            if ("Success".equals(str)) {
                return Success;
            }
            if ("Failed".equals(str)) {
                return Failed;
            }
            if ("TemporaryFailure".equals(str)) {
                return TemporaryFailure;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
