package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAdjustmentTypesResult {
    private List<AdjustmentType> adjustmentTypes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAdjustmentTypesResult)) {
            return false;
        }
        DescribeAdjustmentTypesResult describeAdjustmentTypesResult = (DescribeAdjustmentTypesResult) obj;
        return ((describeAdjustmentTypesResult.getAdjustmentTypes() == null ? 1 : 0) ^ (getAdjustmentTypes() == null ? 1 : 0)) == 0 ? describeAdjustmentTypesResult.getAdjustmentTypes() == null || describeAdjustmentTypesResult.getAdjustmentTypes().equals(getAdjustmentTypes()) : false;
    }

    public List<AdjustmentType> getAdjustmentTypes() {
        if (this.adjustmentTypes == null) {
            this.adjustmentTypes = new ArrayList();
        }
        return this.adjustmentTypes;
    }

    public int hashCode() {
        return (getAdjustmentTypes() == null ? 0 : getAdjustmentTypes().hashCode()) + 31;
    }

    public void setAdjustmentTypes(Collection<AdjustmentType> collection) {
        if (collection == null) {
            this.adjustmentTypes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.adjustmentTypes = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.adjustmentTypes != null) {
            stringBuilder.append("AdjustmentTypes: " + this.adjustmentTypes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAdjustmentTypesResult withAdjustmentTypes(Collection<AdjustmentType> collection) {
        if (collection == null) {
            this.adjustmentTypes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.adjustmentTypes = arrayList;
        }
        return this;
    }

    public DescribeAdjustmentTypesResult withAdjustmentTypes(AdjustmentType... adjustmentTypeArr) {
        if (getAdjustmentTypes() == null) {
            setAdjustmentTypes(new ArrayList(adjustmentTypeArr.length));
        }
        for (Object add : adjustmentTypeArr) {
            getAdjustmentTypes().add(add);
        }
        return this;
    }
}
