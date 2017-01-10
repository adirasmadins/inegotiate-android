package com.amazonaws.services.simpledb.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ListDomainsRequest extends AmazonWebServiceRequest {
    private Integer maxNumberOfDomains;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListDomainsRequest)) {
            return false;
        }
        ListDomainsRequest listDomainsRequest = (ListDomainsRequest) obj;
        if (((listDomainsRequest.getMaxNumberOfDomains() == null ? 1 : 0) ^ (getMaxNumberOfDomains() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listDomainsRequest.getMaxNumberOfDomains() != null && !listDomainsRequest.getMaxNumberOfDomains().equals(getMaxNumberOfDomains())) {
            return false;
        }
        return ((listDomainsRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? listDomainsRequest.getNextToken() == null || listDomainsRequest.getNextToken().equals(getNextToken()) : false;
    }

    public Integer getMaxNumberOfDomains() {
        return this.maxNumberOfDomains;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMaxNumberOfDomains() == null ? 0 : getMaxNumberOfDomains().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setMaxNumberOfDomains(Integer num) {
        this.maxNumberOfDomains = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.maxNumberOfDomains != null) {
            stringBuilder.append("MaxNumberOfDomains: " + this.maxNumberOfDomains + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListDomainsRequest withMaxNumberOfDomains(Integer num) {
        this.maxNumberOfDomains = num;
        return this;
    }

    public ListDomainsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
