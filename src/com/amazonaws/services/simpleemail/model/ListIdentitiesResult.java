package com.amazonaws.services.simpleemail.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListIdentitiesResult {
    private List<String> identities;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListIdentitiesResult)) {
            return false;
        }
        ListIdentitiesResult listIdentitiesResult = (ListIdentitiesResult) obj;
        if (((listIdentitiesResult.getIdentities() == null ? 1 : 0) ^ (getIdentities() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listIdentitiesResult.getIdentities() != null && !listIdentitiesResult.getIdentities().equals(getIdentities())) {
            return false;
        }
        return ((listIdentitiesResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? listIdentitiesResult.getNextToken() == null || listIdentitiesResult.getNextToken().equals(getNextToken()) : false;
    }

    public List<String> getIdentities() {
        if (this.identities == null) {
            this.identities = new ArrayList();
        }
        return this.identities;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getIdentities() == null ? 0 : getIdentities().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setIdentities(Collection<String> collection) {
        if (collection == null) {
            this.identities = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.identities = arrayList;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.identities != null) {
            stringBuilder.append("Identities: " + this.identities + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListIdentitiesResult withIdentities(Collection<String> collection) {
        if (collection == null) {
            this.identities = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.identities = arrayList;
        }
        return this;
    }

    public ListIdentitiesResult withIdentities(String... strArr) {
        if (getIdentities() == null) {
            setIdentities(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getIdentities().add(add);
        }
        return this;
    }

    public ListIdentitiesResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
