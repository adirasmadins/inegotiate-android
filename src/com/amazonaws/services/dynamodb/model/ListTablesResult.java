package com.amazonaws.services.dynamodb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListTablesResult {
    private String lastEvaluatedTableName;
    private List<String> tableNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListTablesResult)) {
            return false;
        }
        ListTablesResult listTablesResult = (ListTablesResult) obj;
        if (((listTablesResult.getTableNames() == null ? 1 : 0) ^ (getTableNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listTablesResult.getTableNames() != null && !listTablesResult.getTableNames().equals(getTableNames())) {
            return false;
        }
        return ((listTablesResult.getLastEvaluatedTableName() == null ? 1 : 0) ^ (getLastEvaluatedTableName() == null ? 1 : 0)) == 0 ? listTablesResult.getLastEvaluatedTableName() == null || listTablesResult.getLastEvaluatedTableName().equals(getLastEvaluatedTableName()) : false;
    }

    public String getLastEvaluatedTableName() {
        return this.lastEvaluatedTableName;
    }

    public List<String> getTableNames() {
        return this.tableNames;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTableNames() == null ? 0 : getTableNames().hashCode()) + 31) * 31;
        if (getLastEvaluatedTableName() != null) {
            i = getLastEvaluatedTableName().hashCode();
        }
        return hashCode + i;
    }

    public void setLastEvaluatedTableName(String str) {
        this.lastEvaluatedTableName = str;
    }

    public void setTableNames(Collection<String> collection) {
        if (collection == null) {
            this.tableNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.tableNames = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.tableNames != null) {
            stringBuilder.append("TableNames: " + this.tableNames + ", ");
        }
        if (this.lastEvaluatedTableName != null) {
            stringBuilder.append("LastEvaluatedTableName: " + this.lastEvaluatedTableName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListTablesResult withLastEvaluatedTableName(String str) {
        this.lastEvaluatedTableName = str;
        return this;
    }

    public ListTablesResult withTableNames(Collection<String> collection) {
        if (collection == null) {
            this.tableNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tableNames = arrayList;
        }
        return this;
    }

    public ListTablesResult withTableNames(String... strArr) {
        if (getTableNames() == null) {
            setTableNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getTableNames().add(add);
        }
        return this;
    }
}
