package com.amazonaws.services.simpledb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SelectResult {
    private List<Item> items;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SelectResult)) {
            return false;
        }
        SelectResult selectResult = (SelectResult) obj;
        if (((selectResult.getItems() == null ? 1 : 0) ^ (getItems() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (selectResult.getItems() != null && !selectResult.getItems().equals(getItems())) {
            return false;
        }
        return ((selectResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? selectResult.getNextToken() == null || selectResult.getNextToken().equals(getNextToken()) : false;
    }

    public List<Item> getItems() {
        if (this.items == null) {
            this.items = new ArrayList();
        }
        return this.items;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getItems() == null ? 0 : getItems().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setItems(Collection<Item> collection) {
        if (collection == null) {
            this.items = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.items = arrayList;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.items != null) {
            stringBuilder.append("Items: " + this.items + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SelectResult withItems(Collection<Item> collection) {
        if (collection == null) {
            this.items = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.items = arrayList;
        }
        return this;
    }

    public SelectResult withItems(Item... itemArr) {
        if (getItems() == null) {
            setItems(new ArrayList(itemArr.length));
        }
        for (Object add : itemArr) {
            getItems().add(add);
        }
        return this;
    }

    public SelectResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
