package com.amazonaws.services.simpleemail.model;

public class SetIdentityNotificationTopicResult {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SetIdentityNotificationTopicResult)) {
            return false;
        }
        SetIdentityNotificationTopicResult setIdentityNotificationTopicResult = (SetIdentityNotificationTopicResult) obj;
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
