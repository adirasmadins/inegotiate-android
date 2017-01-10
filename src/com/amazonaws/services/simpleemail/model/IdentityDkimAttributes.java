package com.amazonaws.services.simpleemail.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IdentityDkimAttributes {
    private Boolean dkimEnabled;
    private List<String> dkimTokens;
    private String dkimVerificationStatus;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IdentityDkimAttributes)) {
            return false;
        }
        IdentityDkimAttributes identityDkimAttributes = (IdentityDkimAttributes) obj;
        if (((identityDkimAttributes.isDkimEnabled() == null ? 1 : 0) ^ (isDkimEnabled() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (identityDkimAttributes.isDkimEnabled() != null && !identityDkimAttributes.isDkimEnabled().equals(isDkimEnabled())) {
            return false;
        }
        if (((identityDkimAttributes.getDkimVerificationStatus() == null ? 1 : 0) ^ (getDkimVerificationStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (identityDkimAttributes.getDkimVerificationStatus() != null && !identityDkimAttributes.getDkimVerificationStatus().equals(getDkimVerificationStatus())) {
            return false;
        }
        return ((identityDkimAttributes.getDkimTokens() == null ? 1 : 0) ^ (getDkimTokens() == null ? 1 : 0)) == 0 ? identityDkimAttributes.getDkimTokens() == null || identityDkimAttributes.getDkimTokens().equals(getDkimTokens()) : false;
    }

    public Boolean getDkimEnabled() {
        return this.dkimEnabled;
    }

    public List<String> getDkimTokens() {
        if (this.dkimTokens == null) {
            this.dkimTokens = new ArrayList();
        }
        return this.dkimTokens;
    }

    public String getDkimVerificationStatus() {
        return this.dkimVerificationStatus;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDkimVerificationStatus() == null ? 0 : getDkimVerificationStatus().hashCode()) + (((isDkimEnabled() == null ? 0 : isDkimEnabled().hashCode()) + 31) * 31)) * 31;
        if (getDkimTokens() != null) {
            i = getDkimTokens().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isDkimEnabled() {
        return this.dkimEnabled;
    }

    public void setDkimEnabled(Boolean bool) {
        this.dkimEnabled = bool;
    }

    public void setDkimTokens(Collection<String> collection) {
        if (collection == null) {
            this.dkimTokens = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.dkimTokens = arrayList;
    }

    public void setDkimVerificationStatus(VerificationStatus verificationStatus) {
        this.dkimVerificationStatus = verificationStatus.toString();
    }

    public void setDkimVerificationStatus(String str) {
        this.dkimVerificationStatus = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.dkimEnabled != null) {
            stringBuilder.append("DkimEnabled: " + this.dkimEnabled + ", ");
        }
        if (this.dkimVerificationStatus != null) {
            stringBuilder.append("DkimVerificationStatus: " + this.dkimVerificationStatus + ", ");
        }
        if (this.dkimTokens != null) {
            stringBuilder.append("DkimTokens: " + this.dkimTokens + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public IdentityDkimAttributes withDkimEnabled(Boolean bool) {
        this.dkimEnabled = bool;
        return this;
    }

    public IdentityDkimAttributes withDkimTokens(Collection<String> collection) {
        if (collection == null) {
            this.dkimTokens = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.dkimTokens = arrayList;
        }
        return this;
    }

    public IdentityDkimAttributes withDkimTokens(String... strArr) {
        if (getDkimTokens() == null) {
            setDkimTokens(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getDkimTokens().add(add);
        }
        return this;
    }

    public IdentityDkimAttributes withDkimVerificationStatus(VerificationStatus verificationStatus) {
        this.dkimVerificationStatus = verificationStatus.toString();
        return this;
    }

    public IdentityDkimAttributes withDkimVerificationStatus(String str) {
        this.dkimVerificationStatus = str;
        return this;
    }
}
