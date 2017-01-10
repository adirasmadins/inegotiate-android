package com.amazonaws.services.simpleemail.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SetIdentityDkimEnabledRequest extends AmazonWebServiceRequest {
    private Boolean dkimEnabled;
    private String identity;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetIdentityDkimEnabledRequest)) {
            return false;
        }
        SetIdentityDkimEnabledRequest setIdentityDkimEnabledRequest = (SetIdentityDkimEnabledRequest) obj;
        if (((setIdentityDkimEnabledRequest.getIdentity() == null ? 1 : 0) ^ (getIdentity() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setIdentityDkimEnabledRequest.getIdentity() != null && !setIdentityDkimEnabledRequest.getIdentity().equals(getIdentity())) {
            return false;
        }
        return ((setIdentityDkimEnabledRequest.isDkimEnabled() == null ? 1 : 0) ^ (isDkimEnabled() == null ? 1 : 0)) == 0 ? setIdentityDkimEnabledRequest.isDkimEnabled() == null || setIdentityDkimEnabledRequest.isDkimEnabled().equals(isDkimEnabled()) : false;
    }

    public Boolean getDkimEnabled() {
        return this.dkimEnabled;
    }

    public String getIdentity() {
        return this.identity;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getIdentity() == null ? 0 : getIdentity().hashCode()) + 31) * 31;
        if (isDkimEnabled() != null) {
            i = isDkimEnabled().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isDkimEnabled() {
        return this.dkimEnabled;
    }

    public void setDkimEnabled(Boolean bool) {
        this.dkimEnabled = bool;
    }

    public void setIdentity(String str) {
        this.identity = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.identity != null) {
            stringBuilder.append("Identity: " + this.identity + ", ");
        }
        if (this.dkimEnabled != null) {
            stringBuilder.append("DkimEnabled: " + this.dkimEnabled + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SetIdentityDkimEnabledRequest withDkimEnabled(Boolean bool) {
        this.dkimEnabled = bool;
        return this;
    }

    public SetIdentityDkimEnabledRequest withIdentity(String str) {
        this.identity = str;
        return this;
    }
}
