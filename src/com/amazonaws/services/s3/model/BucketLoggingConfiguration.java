package com.amazonaws.services.s3.model;

import com.google.gdata.util.common.base.StringUtil;

public class BucketLoggingConfiguration {
    private String destinationBucketName;
    private String logFilePrefix;

    public BucketLoggingConfiguration() {
        this.destinationBucketName = null;
        this.logFilePrefix = null;
    }

    public BucketLoggingConfiguration(String str, String str2) {
        this.destinationBucketName = null;
        this.logFilePrefix = null;
        setLogFilePrefix(str2);
        setDestinationBucketName(str);
    }

    public String getDestinationBucketName() {
        return this.destinationBucketName;
    }

    public String getLogFilePrefix() {
        return this.logFilePrefix;
    }

    public boolean isLoggingEnabled() {
        return (this.destinationBucketName == null || this.logFilePrefix == null) ? false : true;
    }

    public void setDestinationBucketName(String str) {
        this.destinationBucketName = str;
    }

    public void setLogFilePrefix(String str) {
        if (str == null) {
            str = StringUtil.EMPTY_STRING;
        }
        this.logFilePrefix = str;
    }

    public String toString() {
        String str = "LoggingConfiguration enabled=" + isLoggingEnabled();
        return isLoggingEnabled() ? str + ", destinationBucketName=" + getDestinationBucketName() + ", logFilePrefix=" + getLogFilePrefix() : str;
    }
}
