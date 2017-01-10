package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreateAppCookieStickinessPolicyRequest extends AmazonWebServiceRequest {
    private String cookieName;
    private String loadBalancerName;
    private String policyName;

    public CreateAppCookieStickinessPolicyRequest(String str, String str2, String str3) {
        this.loadBalancerName = str;
        this.policyName = str2;
        this.cookieName = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateAppCookieStickinessPolicyRequest)) {
            return false;
        }
        CreateAppCookieStickinessPolicyRequest createAppCookieStickinessPolicyRequest = (CreateAppCookieStickinessPolicyRequest) obj;
        if (((createAppCookieStickinessPolicyRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAppCookieStickinessPolicyRequest.getLoadBalancerName() != null && !createAppCookieStickinessPolicyRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        if (((createAppCookieStickinessPolicyRequest.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAppCookieStickinessPolicyRequest.getPolicyName() != null && !createAppCookieStickinessPolicyRequest.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        return ((createAppCookieStickinessPolicyRequest.getCookieName() == null ? 1 : 0) ^ (getCookieName() == null ? 1 : 0)) == 0 ? createAppCookieStickinessPolicyRequest.getCookieName() == null || createAppCookieStickinessPolicyRequest.getCookieName().equals(getCookieName()) : false;
    }

    public String getCookieName() {
        return this.cookieName;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPolicyName() == null ? 0 : getPolicyName().hashCode()) + (((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31)) * 31;
        if (getCookieName() != null) {
            i = getCookieName().hashCode();
        }
        return hashCode + i;
    }

    public void setCookieName(String str) {
        this.cookieName = str;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.policyName != null) {
            stringBuilder.append("PolicyName: " + this.policyName + ", ");
        }
        if (this.cookieName != null) {
            stringBuilder.append("CookieName: " + this.cookieName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateAppCookieStickinessPolicyRequest withCookieName(String str) {
        this.cookieName = str;
        return this;
    }

    public CreateAppCookieStickinessPolicyRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public CreateAppCookieStickinessPolicyRequest withPolicyName(String str) {
        this.policyName = str;
        return this;
    }
}
