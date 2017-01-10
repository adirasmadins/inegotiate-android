package com.amazonaws.services.cloudwatch.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAlarmHistoryResult {
    private List<AlarmHistoryItem> alarmHistoryItems;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAlarmHistoryResult)) {
            return false;
        }
        DescribeAlarmHistoryResult describeAlarmHistoryResult = (DescribeAlarmHistoryResult) obj;
        if (((describeAlarmHistoryResult.getAlarmHistoryItems() == null ? 1 : 0) ^ (getAlarmHistoryItems() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmHistoryResult.getAlarmHistoryItems() != null && !describeAlarmHistoryResult.getAlarmHistoryItems().equals(getAlarmHistoryItems())) {
            return false;
        }
        return ((describeAlarmHistoryResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeAlarmHistoryResult.getNextToken() == null || describeAlarmHistoryResult.getNextToken().equals(getNextToken()) : false;
    }

    public List<AlarmHistoryItem> getAlarmHistoryItems() {
        if (this.alarmHistoryItems == null) {
            this.alarmHistoryItems = new ArrayList();
        }
        return this.alarmHistoryItems;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAlarmHistoryItems() == null ? 0 : getAlarmHistoryItems().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setAlarmHistoryItems(Collection<AlarmHistoryItem> collection) {
        if (collection == null) {
            this.alarmHistoryItems = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.alarmHistoryItems = arrayList;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.alarmHistoryItems != null) {
            stringBuilder.append("AlarmHistoryItems: " + this.alarmHistoryItems + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAlarmHistoryResult withAlarmHistoryItems(Collection<AlarmHistoryItem> collection) {
        if (collection == null) {
            this.alarmHistoryItems = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.alarmHistoryItems = arrayList;
        }
        return this;
    }

    public DescribeAlarmHistoryResult withAlarmHistoryItems(AlarmHistoryItem... alarmHistoryItemArr) {
        if (getAlarmHistoryItems() == null) {
            setAlarmHistoryItems(new ArrayList(alarmHistoryItemArr.length));
        }
        for (Object add : alarmHistoryItemArr) {
            getAlarmHistoryItems().add(add);
        }
        return this;
    }

    public DescribeAlarmHistoryResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
