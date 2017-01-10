package com.amazonaws.services.elasticloadbalancing.model;

public class AppCookieStickinessPolicy {
    private String cookieName;
    private String policyName;

    public AppCookieStickinessPolicy(String str, String str2) {
        this.policyName = str;
        this.cookieName = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AppCookieStickinessPolicy)) {
            return false;
        }
        AppCookieStickinessPolicy appCookieStickinessPolicy = (AppCookieStickinessPolicy) obj;
        if (((appCookieStickinessPolicy.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (appCookieStickinessPolicy.getPolicyName() != null && !appCookieStickinessPolicy.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        return ((appCookieStickinessPolicy.getCookieName() == null ? 1 : 0) ^ (getCookieName() == null ? 1 : 0)) == 0 ? appCookieStickinessPolicy.getCookieName() == null || appCookieStickinessPolicy.getCookieName().equals(getCookieName()) : false;
    }

    public String getCookieName() {
        return this.cookieName;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPolicyName() == null ? 0 : getPolicyName().hashCode()) + 31) * 31;
        if (getCookieName() != null) {
            i = getCookieName().hashCode();
        }
        return hashCode + i;
    }

    public void setCookieName(String str) {
        this.cookieName = str;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.policyName != null) {
            stringBuilder.append("PolicyName: " + this.policyName + ", ");
        }
        if (this.cookieName != null) {
            stringBuilder.append("CookieName: " + this.cookieName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AppCookieStickinessPolicy withCookieName(String str) {
        this.cookieName = str;
        return this;
    }

    public AppCookieStickinessPolicy withPolicyName(String str) {
        this.policyName = str;
        return this;
    }
}
