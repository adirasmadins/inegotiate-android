package com.amazonaws.services.elasticloadbalancing.model;

public class LBCookieStickinessPolicy {
    private Long cookieExpirationPeriod;
    private String policyName;

    public LBCookieStickinessPolicy(String str, Long l) {
        this.policyName = str;
        this.cookieExpirationPeriod = l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LBCookieStickinessPolicy)) {
            return false;
        }
        LBCookieStickinessPolicy lBCookieStickinessPolicy = (LBCookieStickinessPolicy) obj;
        if (((lBCookieStickinessPolicy.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (lBCookieStickinessPolicy.getPolicyName() != null && !lBCookieStickinessPolicy.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        return ((lBCookieStickinessPolicy.getCookieExpirationPeriod() == null ? 1 : 0) ^ (getCookieExpirationPeriod() == null ? 1 : 0)) == 0 ? lBCookieStickinessPolicy.getCookieExpirationPeriod() == null || lBCookieStickinessPolicy.getCookieExpirationPeriod().equals(getCookieExpirationPeriod()) : false;
    }

    public Long getCookieExpirationPeriod() {
        return this.cookieExpirationPeriod;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPolicyName() == null ? 0 : getPolicyName().hashCode()) + 31) * 31;
        if (getCookieExpirationPeriod() != null) {
            i = getCookieExpirationPeriod().hashCode();
        }
        return hashCode + i;
    }

    public void setCookieExpirationPeriod(Long l) {
        this.cookieExpirationPeriod = l;
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
        if (this.cookieExpirationPeriod != null) {
            stringBuilder.append("CookieExpirationPeriod: " + this.cookieExpirationPeriod + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public LBCookieStickinessPolicy withCookieExpirationPeriod(Long l) {
        this.cookieExpirationPeriod = l;
        return this;
    }

    public LBCookieStickinessPolicy withPolicyName(String str) {
        this.policyName = str;
        return this;
    }
}
