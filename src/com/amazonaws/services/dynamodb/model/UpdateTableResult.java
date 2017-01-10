package com.amazonaws.services.dynamodb.model;

public class UpdateTableResult {
    private TableDescription tableDescription;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateTableResult)) {
            return false;
        }
        UpdateTableResult updateTableResult = (UpdateTableResult) obj;
        return ((updateTableResult.getTableDescription() == null ? 1 : 0) ^ (getTableDescription() == null ? 1 : 0)) == 0 ? updateTableResult.getTableDescription() == null || updateTableResult.getTableDescription().equals(getTableDescription()) : false;
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

    public UpdateTableResult withTableDescription(TableDescription tableDescription) {
        this.tableDescription = tableDescription;
        return this;
    }
}
