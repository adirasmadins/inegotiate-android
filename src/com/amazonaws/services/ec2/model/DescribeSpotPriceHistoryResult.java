package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeSpotPriceHistoryResult {
    private String nextToken;
    private List<SpotPrice> spotPriceHistory;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeSpotPriceHistoryResult)) {
            return false;
        }
        DescribeSpotPriceHistoryResult describeSpotPriceHistoryResult = (DescribeSpotPriceHistoryResult) obj;
        if (((describeSpotPriceHistoryResult.getSpotPriceHistory() == null ? 1 : 0) ^ (getSpotPriceHistory() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSpotPriceHistoryResult.getSpotPriceHistory() != null && !describeSpotPriceHistoryResult.getSpotPriceHistory().equals(getSpotPriceHistory())) {
            return false;
        }
        return ((describeSpotPriceHistoryResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeSpotPriceHistoryResult.getNextToken() == null || describeSpotPriceHistoryResult.getNextToken().equals(getNextToken()) : false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<SpotPrice> getSpotPriceHistory() {
        if (this.spotPriceHistory == null) {
            this.spotPriceHistory = new ArrayList();
        }
        return this.spotPriceHistory;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSpotPriceHistory() == null ? 0 : getSpotPriceHistory().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setSpotPriceHistory(Collection<SpotPrice> collection) {
        if (collection == null) {
            this.spotPriceHistory = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.spotPriceHistory = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.spotPriceHistory != null) {
            stringBuilder.append("SpotPriceHistory: " + this.spotPriceHistory + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeSpotPriceHistoryResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribeSpotPriceHistoryResult withSpotPriceHistory(Collection<SpotPrice> collection) {
        if (collection == null) {
            this.spotPriceHistory = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.spotPriceHistory = arrayList;
        }
        return this;
    }

    public DescribeSpotPriceHistoryResult withSpotPriceHistory(SpotPrice... spotPriceArr) {
        if (getSpotPriceHistory() == null) {
            setSpotPriceHistory(new ArrayList(spotPriceArr.length));
        }
        for (Object add : spotPriceArr) {
            getSpotPriceHistory().add(add);
        }
        return this;
    }
}
