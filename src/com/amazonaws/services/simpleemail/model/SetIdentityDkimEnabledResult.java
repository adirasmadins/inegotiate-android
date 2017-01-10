package com.amazonaws.services.simpleemail.model;

public class SetIdentityDkimEnabledResult {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SetIdentityDkimEnabledResult)) {
            return false;
        }
        SetIdentityDkimEnabledResult setIdentityDkimEnabledResult = (SetIdentityDkimEnabledResult) obj;
        return true;
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
