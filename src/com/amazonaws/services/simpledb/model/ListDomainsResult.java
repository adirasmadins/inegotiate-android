package com.amazonaws.services.simpledb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListDomainsResult {
    private List<String> domainNames;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListDomainsResult)) {
            return false;
        }
        ListDomainsResult listDomainsResult = (ListDomainsResult) obj;
        if (((listDomainsResult.getDomainNames() == null ? 1 : 0) ^ (getDomainNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listDomainsResult.getDomainNames() != null && !listDomainsResult.getDomainNames().equals(getDomainNames())) {
            return false;
        }
        return ((listDomainsResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? listDomainsResult.getNextToken() == null || listDomainsResult.getNextToken().equals(getNextToken()) : false;
    }

    public List<String> getDomainNames() {
        if (this.domainNames == null) {
            this.domainNames = new ArrayList();
        }
        return this.domainNames;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDomainNames() == null ? 0 : getDomainNames().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setDomainNames(Collection<String> collection) {
        if (collection == null) {
            this.domainNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.domainNames = arrayList;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.domainNames != null) {
            stringBuilder.append("DomainNames: " + this.domainNames + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListDomainsResult withDomainNames(Collection<String> collection) {
        if (collection == null) {
            this.domainNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.domainNames = arrayList;
        }
        return this;
    }

    public ListDomainsResult withDomainNames(String... strArr) {
        if (getDomainNames() == null) {
            setDomainNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getDomainNames().add(add);
        }
        return this;
    }

    public ListDomainsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
