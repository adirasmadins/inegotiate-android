package com.amazonaws.services.simpleemail.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ListIdentitiesRequest extends AmazonWebServiceRequest {
    private String identityType;
    private Integer maxItems;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListIdentitiesRequest)) {
            return false;
        }
        ListIdentitiesRequest listIdentitiesRequest = (ListIdentitiesRequest) obj;
        if (((listIdentitiesRequest.getIdentityType() == null ? 1 : 0) ^ (getIdentityType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listIdentitiesRequest.getIdentityType() != null && !listIdentitiesRequest.getIdentityType().equals(getIdentityType())) {
            return false;
        }
        if (((listIdentitiesRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listIdentitiesRequest.getNextToken() != null && !listIdentitiesRequest.getNextToken().equals(getNextToken())) {
            return false;
        }
        return ((listIdentitiesRequest.getMaxItems() == null ? 1 : 0) ^ (getMaxItems() == null ? 1 : 0)) == 0 ? listIdentitiesRequest.getMaxItems() == null || listIdentitiesRequest.getMaxItems().equals(getMaxItems()) : false;
    }

    public String getIdentityType() {
        return this.identityType;
    }

    public Integer getMaxItems() {
        return this.maxItems;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNextToken() == null ? 0 : getNextToken().hashCode()) + (((getIdentityType() == null ? 0 : getIdentityType().hashCode()) + 31) * 31)) * 31;
        if (getMaxItems() != null) {
            i = getMaxItems().hashCode();
        }
        return hashCode + i;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType.toString();
    }

    public void setIdentityType(String str) {
        this.identityType = str;
    }

    public void setMaxItems(Integer num) {
        this.maxItems = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.identityType != null) {
            stringBuilder.append("IdentityType: " + this.identityType + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        if (this.maxItems != null) {
            stringBuilder.append("MaxItems: " + this.maxItems + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListIdentitiesRequest withIdentityType(IdentityType identityType) {
        this.identityType = identityType.toString();
        return this;
    }

    public ListIdentitiesRequest withIdentityType(String str) {
        this.identityType = str;
        return this;
    }

    public ListIdentitiesRequest withMaxItems(Integer num) {
        this.maxItems = num;
        return this;
    }

    public ListIdentitiesRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
