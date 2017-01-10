package com.amazonaws.services.dynamodb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ScanResult {
    private Double consumedCapacityUnits;
    private Integer count;
    private List<Map<String, AttributeValue>> items;
    private Key lastEvaluatedKey;
    private Integer scannedCount;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ScanResult)) {
            return false;
        }
        ScanResult scanResult = (ScanResult) obj;
        if (((scanResult.getItems() == null ? 1 : 0) ^ (getItems() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scanResult.getItems() != null && !scanResult.getItems().equals(getItems())) {
            return false;
        }
        if (((scanResult.getCount() == null ? 1 : 0) ^ (getCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scanResult.getCount() != null && !scanResult.getCount().equals(getCount())) {
            return false;
        }
        if (((scanResult.getScannedCount() == null ? 1 : 0) ^ (getScannedCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scanResult.getScannedCount() != null && !scanResult.getScannedCount().equals(getScannedCount())) {
            return false;
        }
        if (((scanResult.getLastEvaluatedKey() == null ? 1 : 0) ^ (getLastEvaluatedKey() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scanResult.getLastEvaluatedKey() != null && !scanResult.getLastEvaluatedKey().equals(getLastEvaluatedKey())) {
            return false;
        }
        return ((scanResult.getConsumedCapacityUnits() == null ? 1 : 0) ^ (getConsumedCapacityUnits() == null ? 1 : 0)) == 0 ? scanResult.getConsumedCapacityUnits() == null || scanResult.getConsumedCapacityUnits().equals(getConsumedCapacityUnits()) : false;
    }

    public Double getConsumedCapacityUnits() {
        return this.consumedCapacityUnits;
    }

    public Integer getCount() {
        return this.count;
    }

    public List<Map<String, AttributeValue>> getItems() {
        return this.items;
    }

    public Key getLastEvaluatedKey() {
        return this.lastEvaluatedKey;
    }

    public Integer getScannedCount() {
        return this.scannedCount;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLastEvaluatedKey() == null ? 0 : getLastEvaluatedKey().hashCode()) + (((getScannedCount() == null ? 0 : getScannedCount().hashCode()) + (((getCount() == null ? 0 : getCount().hashCode()) + (((getItems() == null ? 0 : getItems().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getConsumedCapacityUnits() != null) {
            i = getConsumedCapacityUnits().hashCode();
        }
        return hashCode + i;
    }

    public void setConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public void setItems(Collection<Map<String, AttributeValue>> collection) {
        if (collection == null) {
            this.items = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.items = arrayList;
    }

    public void setLastEvaluatedKey(Key key) {
        this.lastEvaluatedKey = key;
    }

    public void setScannedCount(Integer num) {
        this.scannedCount = num;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.items != null) {
            stringBuilder.append("Items: " + this.items + ", ");
        }
        if (this.count != null) {
            stringBuilder.append("Count: " + this.count + ", ");
        }
        if (this.scannedCount != null) {
            stringBuilder.append("ScannedCount: " + this.scannedCount + ", ");
        }
        if (this.lastEvaluatedKey != null) {
            stringBuilder.append("LastEvaluatedKey: " + this.lastEvaluatedKey + ", ");
        }
        if (this.consumedCapacityUnits != null) {
            stringBuilder.append("ConsumedCapacityUnits: " + this.consumedCapacityUnits + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ScanResult withConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
        return this;
    }

    public ScanResult withCount(Integer num) {
        this.count = num;
        return this;
    }

    public ScanResult withItems(Collection<Map<String, AttributeValue>> collection) {
        if (collection == null) {
            this.items = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.items = arrayList;
        }
        return this;
    }

    public ScanResult withItems(Map<String, AttributeValue>... mapArr) {
        if (getItems() == null) {
            setItems(new ArrayList(mapArr.length));
        }
        for (Object add : mapArr) {
            getItems().add(add);
        }
        return this;
    }

    public ScanResult withLastEvaluatedKey(Key key) {
        this.lastEvaluatedKey = key;
        return this;
    }

    public ScanResult withScannedCount(Integer num) {
        this.scannedCount = num;
        return this;
    }
}
