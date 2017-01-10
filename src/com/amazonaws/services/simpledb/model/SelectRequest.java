package com.amazonaws.services.simpledb.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SelectRequest extends AmazonWebServiceRequest {
    private Boolean consistentRead;
    private String nextToken;
    private String selectExpression;

    public SelectRequest(String str) {
        this.selectExpression = str;
    }

    public SelectRequest(String str, Boolean bool) {
        this.selectExpression = str;
        this.consistentRead = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SelectRequest)) {
            return false;
        }
        SelectRequest selectRequest = (SelectRequest) obj;
        if (((selectRequest.getSelectExpression() == null ? 1 : 0) ^ (getSelectExpression() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (selectRequest.getSelectExpression() != null && !selectRequest.getSelectExpression().equals(getSelectExpression())) {
            return false;
        }
        if (((selectRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (selectRequest.getNextToken() != null && !selectRequest.getNextToken().equals(getNextToken())) {
            return false;
        }
        return ((selectRequest.isConsistentRead() == null ? 1 : 0) ^ (isConsistentRead() == null ? 1 : 0)) == 0 ? selectRequest.isConsistentRead() == null || selectRequest.isConsistentRead().equals(isConsistentRead()) : false;
    }

    public Boolean getConsistentRead() {
        return this.consistentRead;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public String getSelectExpression() {
        return this.selectExpression;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNextToken() == null ? 0 : getNextToken().hashCode()) + (((getSelectExpression() == null ? 0 : getSelectExpression().hashCode()) + 31) * 31)) * 31;
        if (isConsistentRead() != null) {
            i = isConsistentRead().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isConsistentRead() {
        return this.consistentRead;
    }

    public void setConsistentRead(Boolean bool) {
        this.consistentRead = bool;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setSelectExpression(String str) {
        this.selectExpression = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.selectExpression != null) {
            stringBuilder.append("SelectExpression: " + this.selectExpression + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        if (this.consistentRead != null) {
            stringBuilder.append("ConsistentRead: " + this.consistentRead + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SelectRequest withConsistentRead(Boolean bool) {
        this.consistentRead = bool;
        return this;
    }

    public SelectRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public SelectRequest withSelectExpression(String str) {
        this.selectExpression = str;
        return this;
    }
}
