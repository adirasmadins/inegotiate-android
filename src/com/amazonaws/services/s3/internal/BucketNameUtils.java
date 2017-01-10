package com.amazonaws.services.s3.internal;

public class BucketNameUtils {
    public boolean isDNSBucketName(String str) {
        return (str == null || str.length() < 3 || str.length() > 63 || str.endsWith("-") || str.contains("_") || str.contains(".") || str.contains("-.") || str.contains(".-") || !str.toLowerCase().equals(str)) ? false : true;
    }

    public boolean isValidV2BucketName(String str) {
        if (str == null) {
            return false;
        }
        try {
            validateBucketName(str);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void validateBucketName(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("Bucket name cannot be null");
        } else if (!str.toLowerCase().equals(str)) {
            throw new IllegalArgumentException("Bucket name should not contain uppercase characters");
        } else if (str.contains("_")) {
            throw new IllegalArgumentException("Bucket name should not contain '_'");
        } else if (str.contains("!") || str.contains("@") || str.contains("#")) {
            throw new IllegalArgumentException("Bucket name contains illegal characters");
        } else if (str.length() < 3 || str.length() > 63) {
            throw new IllegalArgumentException("Bucket name should be between 3 and 63 characters long");
        } else if (str.endsWith("-") || str.endsWith(".")) {
            throw new IllegalArgumentException("Bucket name should not end with '-' or '.'");
        } else if (str.contains("..")) {
            throw new IllegalArgumentException("Bucket name should not contain two adjacent periods");
        } else if (str.contains("-.") || str.contains(".-")) {
            throw new IllegalArgumentException("Bucket name should not contain dashes next to periods");
        }
    }
}
