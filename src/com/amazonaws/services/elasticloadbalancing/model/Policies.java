package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Policies {
    private List<AppCookieStickinessPolicy> appCookieStickinessPolicies;
    private List<LBCookieStickinessPolicy> lBCookieStickinessPolicies;
    private List<String> otherPolicies;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Policies)) {
            return false;
        }
        Policies policies = (Policies) obj;
        if (((policies.getAppCookieStickinessPolicies() == null ? 1 : 0) ^ (getAppCookieStickinessPolicies() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policies.getAppCookieStickinessPolicies() != null && !policies.getAppCookieStickinessPolicies().equals(getAppCookieStickinessPolicies())) {
            return false;
        }
        if (((policies.getLBCookieStickinessPolicies() == null ? 1 : 0) ^ (getLBCookieStickinessPolicies() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policies.getLBCookieStickinessPolicies() != null && !policies.getLBCookieStickinessPolicies().equals(getLBCookieStickinessPolicies())) {
            return false;
        }
        return ((policies.getOtherPolicies() == null ? 1 : 0) ^ (getOtherPolicies() == null ? 1 : 0)) == 0 ? policies.getOtherPolicies() == null || policies.getOtherPolicies().equals(getOtherPolicies()) : false;
    }

    public List<AppCookieStickinessPolicy> getAppCookieStickinessPolicies() {
        if (this.appCookieStickinessPolicies == null) {
            this.appCookieStickinessPolicies = new ArrayList();
        }
        return this.appCookieStickinessPolicies;
    }

    public List<LBCookieStickinessPolicy> getLBCookieStickinessPolicies() {
        if (this.lBCookieStickinessPolicies == null) {
            this.lBCookieStickinessPolicies = new ArrayList();
        }
        return this.lBCookieStickinessPolicies;
    }

    public List<String> getOtherPolicies() {
        if (this.otherPolicies == null) {
            this.otherPolicies = new ArrayList();
        }
        return this.otherPolicies;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLBCookieStickinessPolicies() == null ? 0 : getLBCookieStickinessPolicies().hashCode()) + (((getAppCookieStickinessPolicies() == null ? 0 : getAppCookieStickinessPolicies().hashCode()) + 31) * 31)) * 31;
        if (getOtherPolicies() != null) {
            i = getOtherPolicies().hashCode();
        }
        return hashCode + i;
    }

    public void setAppCookieStickinessPolicies(Collection<AppCookieStickinessPolicy> collection) {
        if (collection == null) {
            this.appCookieStickinessPolicies = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.appCookieStickinessPolicies = arrayList;
    }

    public void setLBCookieStickinessPolicies(Collection<LBCookieStickinessPolicy> collection) {
        if (collection == null) {
            this.lBCookieStickinessPolicies = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.lBCookieStickinessPolicies = arrayList;
    }

    public void setOtherPolicies(Collection<String> collection) {
        if (collection == null) {
            this.otherPolicies = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.otherPolicies = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.appCookieStickinessPolicies != null) {
            stringBuilder.append("AppCookieStickinessPolicies: " + this.appCookieStickinessPolicies + ", ");
        }
        if (this.lBCookieStickinessPolicies != null) {
            stringBuilder.append("LBCookieStickinessPolicies: " + this.lBCookieStickinessPolicies + ", ");
        }
        if (this.otherPolicies != null) {
            stringBuilder.append("OtherPolicies: " + this.otherPolicies + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Policies withAppCookieStickinessPolicies(Collection<AppCookieStickinessPolicy> collection) {
        if (collection == null) {
            this.appCookieStickinessPolicies = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.appCookieStickinessPolicies = arrayList;
        }
        return this;
    }

    public Policies withAppCookieStickinessPolicies(AppCookieStickinessPolicy... appCookieStickinessPolicyArr) {
        if (getAppCookieStickinessPolicies() == null) {
            setAppCookieStickinessPolicies(new ArrayList(appCookieStickinessPolicyArr.length));
        }
        for (Object add : appCookieStickinessPolicyArr) {
            getAppCookieStickinessPolicies().add(add);
        }
        return this;
    }

    public Policies withLBCookieStickinessPolicies(Collection<LBCookieStickinessPolicy> collection) {
        if (collection == null) {
            this.lBCookieStickinessPolicies = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.lBCookieStickinessPolicies = arrayList;
        }
        return this;
    }

    public Policies withLBCookieStickinessPolicies(LBCookieStickinessPolicy... lBCookieStickinessPolicyArr) {
        if (getLBCookieStickinessPolicies() == null) {
            setLBCookieStickinessPolicies(new ArrayList(lBCookieStickinessPolicyArr.length));
        }
        for (Object add : lBCookieStickinessPolicyArr) {
            getLBCookieStickinessPolicies().add(add);
        }
        return this;
    }

    public Policies withOtherPolicies(Collection<String> collection) {
        if (collection == null) {
            this.otherPolicies = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.otherPolicies = arrayList;
        }
        return this;
    }

    public Policies withOtherPolicies(String... strArr) {
        if (getOtherPolicies() == null) {
            setOtherPolicies(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getOtherPolicies().add(add);
        }
        return this;
    }
}
