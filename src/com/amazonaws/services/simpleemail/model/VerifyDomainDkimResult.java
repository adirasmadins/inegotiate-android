package com.amazonaws.services.simpleemail.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VerifyDomainDkimResult {
    private List<String> dkimTokens;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyDomainDkimResult)) {
            return false;
        }
        VerifyDomainDkimResult verifyDomainDkimResult = (VerifyDomainDkimResult) obj;
        return ((verifyDomainDkimResult.getDkimTokens() == null ? 1 : 0) ^ (getDkimTokens() == null ? 1 : 0)) == 0 ? verifyDomainDkimResult.getDkimTokens() == null || verifyDomainDkimResult.getDkimTokens().equals(getDkimTokens()) : false;
    }

    public List<String> getDkimTokens() {
        if (this.dkimTokens == null) {
            this.dkimTokens = new ArrayList();
        }
        return this.dkimTokens;
    }

    public int hashCode() {
        return (getDkimTokens() == null ? 0 : getDkimTokens().hashCode()) + 31;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.dkimTokens != null) {
            stringBuilder.append("DkimTokens: " + this.dkimTokens + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public VerifyDomainDkimResult withDkimTokens(Collection<String> collection) {
        if (collection == null) {
            this.dkimTokens = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.dkimTokens = arrayList;
        }
        return this;
    }

    public VerifyDomainDkimResult withDkimTokens(String... strArr) {
        if (getDkimTokens() == null) {
            setDkimTokens(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getDkimTokens().add(add);
        }
        return this;
    }
}
