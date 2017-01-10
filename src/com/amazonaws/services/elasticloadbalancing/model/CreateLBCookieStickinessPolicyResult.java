package com.amazonaws.services.elasticloadbalancing.model;

public class CreateLBCookieStickinessPolicyResult {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CreateLBCookieStickinessPolicyResult)) {
            return false;
        }
        CreateLBCookieStickinessPolicyResult createLBCookieStickinessPolicyResult = (CreateLBCookieStickinessPolicyResult) obj;
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
