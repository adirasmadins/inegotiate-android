package com.amazonaws.services.simpleemail.model;

import java.util.HashMap;
import java.util.Map;

public class GetIdentityNotificationAttributesResult {
    private Map<String, IdentityNotificationAttributes> notificationAttributes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdentityNotificationAttributesResult)) {
            return false;
        }
        GetIdentityNotificationAttributesResult getIdentityNotificationAttributesResult = (GetIdentityNotificationAttributesResult) obj;
        return ((getIdentityNotificationAttributesResult.getNotificationAttributes() == null ? 1 : 0) ^ (getNotificationAttributes() == null ? 1 : 0)) == 0 ? getIdentityNotificationAttributesResult.getNotificationAttributes() == null || getIdentityNotificationAttributesResult.getNotificationAttributes().equals(getNotificationAttributes()) : false;
    }

    public Map<String, IdentityNotificationAttributes> getNotificationAttributes() {
        if (this.notificationAttributes == null) {
            this.notificationAttributes = new HashMap();
        }
        return this.notificationAttributes;
    }

    public int hashCode() {
        return (getNotificationAttributes() == null ? 0 : getNotificationAttributes().hashCode()) + 31;
    }

    public void setNotificationAttributes(Map<String, IdentityNotificationAttributes> map) {
        this.notificationAttributes = map;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.notificationAttributes != null) {
            stringBuilder.append("NotificationAttributes: " + this.notificationAttributes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetIdentityNotificationAttributesResult withNotificationAttributes(Map<String, IdentityNotificationAttributes> map) {
        setNotificationAttributes(map);
        return this;
    }
}
