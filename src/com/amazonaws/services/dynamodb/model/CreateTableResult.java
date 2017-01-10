package com.amazonaws.services.dynamodb.model;

public class CreateTableResult {
    private TableDescription tableDescription;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateTableResult)) {
            return false;
        }
        CreateTableResult createTableResult = (CreateTableResult) obj;
        return ((createTableResult.getTableDescription() == null ? 1 : 0) ^ (getTableDescription() == null ? 1 : 0)) == 0 ? createTableResult.getTableDescription() == null || createTableResult.getTableDescription().equals(getTableDescription()) : false;
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

    public CreateTableResult withTableDescription(TableDescription tableDescription) {
        this.tableDescription = tableDescription;
        return this;
    }
}
