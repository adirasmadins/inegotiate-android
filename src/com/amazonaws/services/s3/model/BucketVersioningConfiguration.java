package com.amazonaws.services.s3.model;

public class BucketVersioningConfiguration {
    public static final String ENABLED = "Enabled";
    public static final String OFF = "Off";
    public static final String SUSPENDED = "Suspended";
    private Boolean isMfaDeleteEnabled;
    private String status;

    public BucketVersioningConfiguration() {
        this.isMfaDeleteEnabled = null;
        setStatus(OFF);
    }

    public BucketVersioningConfiguration(String str) {
        this.isMfaDeleteEnabled = null;
        setStatus(str);
    }

    public String getStatus() {
        return this.status;
    }

    public Boolean isMfaDeleteEnabled() {
        return this.isMfaDeleteEnabled;
    }

    public void setMfaDeleteEnabled(Boolean bool) {
        this.isMfaDeleteEnabled = bool;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public BucketVersioningConfiguration withMfaDeleteEnabled(Boolean bool) {
        setMfaDeleteEnabled(bool);
        return this;
    }

    public BucketVersioningConfiguration withStatus(String str) {
        setStatus(str);
        return this;
    }
}
