package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeConversionTasksResult {
    private List<ConversionTask> conversionTasks;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeConversionTasksResult)) {
            return false;
        }
        DescribeConversionTasksResult describeConversionTasksResult = (DescribeConversionTasksResult) obj;
        return ((describeConversionTasksResult.getConversionTasks() == null ? 1 : 0) ^ (getConversionTasks() == null ? 1 : 0)) == 0 ? describeConversionTasksResult.getConversionTasks() == null || describeConversionTasksResult.getConversionTasks().equals(getConversionTasks()) : false;
    }

    public List<ConversionTask> getConversionTasks() {
        if (this.conversionTasks == null) {
            this.conversionTasks = new ArrayList();
        }
        return this.conversionTasks;
    }

    public int hashCode() {
        return (getConversionTasks() == null ? 0 : getConversionTasks().hashCode()) + 31;
    }

    public void setConversionTasks(Collection<ConversionTask> collection) {
        if (collection == null) {
            this.conversionTasks = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.conversionTasks = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.conversionTasks != null) {
            stringBuilder.append("ConversionTasks: " + this.conversionTasks + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeConversionTasksResult withConversionTasks(Collection<ConversionTask> collection) {
        if (collection == null) {
            this.conversionTasks = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.conversionTasks = arrayList;
        }
        return this;
    }

    public DescribeConversionTasksResult withConversionTasks(ConversionTask... conversionTaskArr) {
        if (getConversionTasks() == null) {
            setConversionTasks(new ArrayList(conversionTaskArr.length));
        }
        for (Object add : conversionTaskArr) {
            getConversionTasks().add(add);
        }
        return this;
    }
}
