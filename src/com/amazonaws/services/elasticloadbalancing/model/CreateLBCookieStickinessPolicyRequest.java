package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreateLBCookieStickinessPolicyRequest extends AmazonWebServiceRequest {
    private Long cookieExpirationPeriod;
    private String loadBalancerName;
    private String policyName;

    public CreateLBCookieStickinessPolicyRequest(String str, String str2) {
        this.loadBalancerName = str;
        this.policyName = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateLBCookieStickinessPolicyRequest)) {
            return false;
        }
        CreateLBCookieStickinessPolicyRequest createLBCookieStickinessPolicyRequest = (CreateLBCookieStickinessPolicyRequest) obj;
        if (((createLBCookieStickinessPolicyRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createLBCookieStickinessPolicyRequest.getLoadBalancerName() != null && !createLBCookieStickinessPolicyRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        if (((createLBCookieStickinessPolicyRequest.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createLBCookieStickinessPolicyRequest.getPolicyName() != null && !createLBCookieStickinessPolicyRequest.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        return ((createLBCookieStickinessPolicyRequest.getCookieExpirationPeriod() == null ? 1 : 0) ^ (getCookieExpirationPeriod() == null ? 1 : 0)) == 0 ? createLBCookieStickinessPolicyRequest.getCookieExpirationPeriod() == null || createLBCookieStickinessPolicyRequest.getCookieExpirationPeriod().equals(getCookieExpirationPeriod()) : false;
    }

    public Long getCookieExpirationPeriod() {
        return this.cookieExpirationPeriod;
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
        if (getCookieExpirationPeriod() != null) {
            i = getCookieExpirationPeriod().hashCode();
        }
        return hashCode + i;
    }

    public void setCookieExpirationPeriod(Long l) {
        this.cookieExpirationPeriod = l;
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
        if (this.cookieExpirationPeriod != null) {
            stringBuilder.append("CookieExpirationPeriod: " + this.cookieExpirationPeriod + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateLBCookieStickinessPolicyRequest withCookieExpirationPeriod(Long l) {
        this.cookieExpirationPeriod = l;
        return this;
    }

    public CreateLBCookieStickinessPolicyRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public CreateLBCookieStickinessPolicyRequest withPolicyName(String str) {
        this.policyName = str;
        return this;
    }
}
