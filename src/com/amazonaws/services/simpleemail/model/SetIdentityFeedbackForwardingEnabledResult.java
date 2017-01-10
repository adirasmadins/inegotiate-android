package com.amazonaws.services.simpleemail.model;

public class SetIdentityFeedbackForwardingEnabledResult {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SetIdentityFeedbackForwardingEnabledResult)) {
            return false;
        }
        SetIdentityFeedbackForwardingEnabledResult setIdentityFeedbackForwardingEnabledResult = (SetIdentityFeedbackForwardingEnabledResult) obj;
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
