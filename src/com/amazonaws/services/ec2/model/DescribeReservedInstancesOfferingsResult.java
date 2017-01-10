package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeReservedInstancesOfferingsResult {
    private String nextToken;
    private List<ReservedInstancesOffering> reservedInstancesOfferings;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeReservedInstancesOfferingsResult)) {
            return false;
        }
        DescribeReservedInstancesOfferingsResult describeReservedInstancesOfferingsResult = (DescribeReservedInstancesOfferingsResult) obj;
        if (((describeReservedInstancesOfferingsResult.getReservedInstancesOfferings() == null ? 1 : 0) ^ (getReservedInstancesOfferings() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeReservedInstancesOfferingsResult.getReservedInstancesOfferings() != null && !describeReservedInstancesOfferingsResult.getReservedInstancesOfferings().equals(getReservedInstancesOfferings())) {
            return false;
        }
        return ((describeReservedInstancesOfferingsResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeReservedInstancesOfferingsResult.getNextToken() == null || describeReservedInstancesOfferingsResult.getNextToken().equals(getNextToken()) : false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<ReservedInstancesOffering> getReservedInstancesOfferings() {
        if (this.reservedInstancesOfferings == null) {
            this.reservedInstancesOfferings = new ArrayList();
        }
        return this.reservedInstancesOfferings;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getReservedInstancesOfferings() == null ? 0 : getReservedInstancesOfferings().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setReservedInstancesOfferings(Collection<ReservedInstancesOffering> collection) {
        if (collection == null) {
            this.reservedInstancesOfferings = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.reservedInstancesOfferings = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstancesOfferings != null) {
            stringBuilder.append("ReservedInstancesOfferings: " + this.reservedInstancesOfferings + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeReservedInstancesOfferingsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribeReservedInstancesOfferingsResult withReservedInstancesOfferings(Collection<ReservedInstancesOffering> collection) {
        if (collection == null) {
            this.reservedInstancesOfferings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.reservedInstancesOfferings = arrayList;
        }
        return this;
    }

    public DescribeReservedInstancesOfferingsResult withReservedInstancesOfferings(ReservedInstancesOffering... reservedInstancesOfferingArr) {
        if (getReservedInstancesOfferings() == null) {
            setReservedInstancesOfferings(new ArrayList(reservedInstancesOfferingArr.length));
        }
        for (Object add : reservedInstancesOfferingArr) {
            getReservedInstancesOfferings().add(add);
        }
        return this;
    }
}
