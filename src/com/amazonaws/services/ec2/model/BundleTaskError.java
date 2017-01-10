package com.amazonaws.services.ec2.model;

public class BundleTaskError {
    private String code;
    private String message;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BundleTaskError)) {
            return false;
        }
        BundleTaskError bundleTaskError = (BundleTaskError) obj;
        if (((bundleTaskError.getCode() == null ? 1 : 0) ^ (getCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (bundleTaskError.getCode() != null && !bundleTaskError.getCode().equals(getCode())) {
            return false;
        }
        return ((bundleTaskError.getMessage() == null ? 1 : 0) ^ (getMessage() == null ? 1 : 0)) == 0 ? bundleTaskError.getMessage() == null || bundleTaskError.getMessage().equals(getMessage()) : false;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCode() == null ? 0 : getCode().hashCode()) + 31) * 31;
        if (getMessage() != null) {
            i = getMessage().hashCode();
        }
        return hashCode + i;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.code != null) {
            stringBuilder.append("Code: " + this.code + ", ");
        }
        if (this.message != null) {
            stringBuilder.append("Message: " + this.message + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BundleTaskError withCode(String str) {
        this.code = str;
        return this;
    }

    public BundleTaskError withMessage(String str) {
        this.message = str;
        return this;
    }
}
