package com.amazonaws.services.dynamodb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Condition {
    private List<AttributeValue> attributeValueList;
    private String comparisonOperator;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Condition)) {
            return false;
        }
        Condition condition = (Condition) obj;
        if (((condition.getAttributeValueList() == null ? 1 : 0) ^ (getAttributeValueList() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (condition.getAttributeValueList() != null && !condition.getAttributeValueList().equals(getAttributeValueList())) {
            return false;
        }
        return ((condition.getComparisonOperator() == null ? 1 : 0) ^ (getComparisonOperator() == null ? 1 : 0)) == 0 ? condition.getComparisonOperator() == null || condition.getComparisonOperator().equals(getComparisonOperator()) : false;
    }

    public List<AttributeValue> getAttributeValueList() {
        return this.attributeValueList;
    }

    public String getComparisonOperator() {
        return this.comparisonOperator;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributeValueList() == null ? 0 : getAttributeValueList().hashCode()) + 31) * 31;
        if (getComparisonOperator() != null) {
            i = getComparisonOperator().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributeValueList(Collection<AttributeValue> collection) {
        if (collection == null) {
            this.attributeValueList = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.attributeValueList = arrayList;
    }

    public void setComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator.toString();
    }

    public void setComparisonOperator(String str) {
        this.comparisonOperator = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.attributeValueList != null) {
            stringBuilder.append("AttributeValueList: " + this.attributeValueList + ", ");
        }
        if (this.comparisonOperator != null) {
            stringBuilder.append("ComparisonOperator: " + this.comparisonOperator + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Condition withAttributeValueList(Collection<AttributeValue> collection) {
        if (collection == null) {
            this.attributeValueList = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributeValueList = arrayList;
        }
        return this;
    }

    public Condition withAttributeValueList(AttributeValue... attributeValueArr) {
        if (getAttributeValueList() == null) {
            setAttributeValueList(new ArrayList(attributeValueArr.length));
        }
        for (Object add : attributeValueArr) {
            getAttributeValueList().add(add);
        }
        return this;
    }

    public Condition withComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator.toString();
        return this;
    }

    public Condition withComparisonOperator(String str) {
        this.comparisonOperator = str;
        return this;
    }
}
