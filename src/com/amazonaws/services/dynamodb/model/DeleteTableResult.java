package com.amazonaws.services.dynamodb.model;

public class DeleteTableResult {
    private TableDescription tableDescription;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteTableResult)) {
            return false;
        }
        DeleteTableResult deleteTableResult = (DeleteTableResult) obj;
        return ((deleteTableResult.getTableDescription() == null ? 1 : 0) ^ (getTableDescription() == null ? 1 : 0)) == 0 ? deleteTableResult.getTableDescription() == null || deleteTableResult.getTableDescription().equals(getTableDescription()) : false;
    }

    public TableDescription getTableDescription() {
        return this.tableDescription;
    }

    public int hashCode() {
        return (getTableDescription() == null ? 0 : getTableDescription().hashCode()) + 31;
    }

    public void setTableDescription(TableDescription tableDescription) {
        this.tableDescription = tableDescription;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.tableDescription != null) {
            stringBuilder.append("TableDescription: " + this.tableDescription + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteTableResult withTableDescription(TableDescription tableDescription) {
        this.tableDescription = tableDescription;
        return this;
    }
}
