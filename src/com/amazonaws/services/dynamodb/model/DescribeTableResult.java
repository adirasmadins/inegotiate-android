package com.amazonaws.services.dynamodb.model;

public class DescribeTableResult {
    private TableDescription table;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeTableResult)) {
            return false;
        }
        DescribeTableResult describeTableResult = (DescribeTableResult) obj;
        return ((describeTableResult.getTable() == null ? 1 : 0) ^ (getTable() == null ? 1 : 0)) == 0 ? describeTableResult.getTable() == null || describeTableResult.getTable().equals(getTable()) : false;
    }

    public TableDescription getTable() {
        return this.table;
    }

    public int hashCode() {
        return (getTable() == null ? 0 : getTable().hashCode()) + 31;
    }

    public void setTable(TableDescription tableDescription) {
        this.table = tableDescription;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.table != null) {
            stringBuilder.append("Table: " + this.table + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeTableResult withTable(TableDescription tableDescription) {
        this.table = tableDescription;
        return this;
    }
}
