package com.amazonaws.services.elasticloadbalancing.model;

public class CreateAppCookieStickinessPolicyResult {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CreateAppCookieStickinessPolicyResult)) {
            return false;
        }
        CreateAppCookieStickinessPolicyResult createAppCookieStickinessPolicyResult = (CreateAppCookieStickinessPolicyResult) obj;
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
