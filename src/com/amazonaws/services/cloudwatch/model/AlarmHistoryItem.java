package com.amazonaws.services.cloudwatch.model;

import java.util.Date;

public class AlarmHistoryItem {
    private String alarmName;
    private String historyData;
    private String historyItemType;
    private String historySummary;
    private Date timestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AlarmHistoryItem)) {
            return false;
        }
        AlarmHistoryItem alarmHistoryItem = (AlarmHistoryItem) obj;
        if (((alarmHistoryItem.getAlarmName() == null ? 1 : 0) ^ (getAlarmName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (alarmHistoryItem.getAlarmName() != null && !alarmHistoryItem.getAlarmName().equals(getAlarmName())) {
            return false;
        }
        if (((alarmHistoryItem.getTimestamp() == null ? 1 : 0) ^ (getTimestamp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (alarmHistoryItem.getTimestamp() != null && !alarmHistoryItem.getTimestamp().equals(getTimestamp())) {
            return false;
        }
        if (((alarmHistoryItem.getHistoryItemType() == null ? 1 : 0) ^ (getHistoryItemType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (alarmHistoryItem.getHistoryItemType() != null && !alarmHistoryItem.getHistoryItemType().equals(getHistoryItemType())) {
            return false;
        }
        if (((alarmHistoryItem.getHistorySummary() == null ? 1 : 0) ^ (getHistorySummary() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (alarmHistoryItem.getHistorySummary() != null && !alarmHistoryItem.getHistorySummary().equals(getHistorySummary())) {
            return false;
        }
        return ((alarmHistoryItem.getHistoryData() == null ? 1 : 0) ^ (getHistoryData() == null ? 1 : 0)) == 0 ? alarmHistoryItem.getHistoryData() == null || alarmHistoryItem.getHistoryData().equals(getHistoryData()) : false;
    }

    public String getAlarmName() {
        return this.alarmName;
    }

    public String getHistoryData() {
        return this.historyData;
    }

    public String getHistoryItemType() {
        return this.historyItemType;
    }

    public String getHistorySummary() {
        return this.historySummary;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getHistorySummary() == null ? 0 : getHistorySummary().hashCode()) + (((getHistoryItemType() == null ? 0 : getHistoryItemType().hashCode()) + (((getTimestamp() == null ? 0 : getTimestamp().hashCode()) + (((getAlarmName() == null ? 0 : getAlarmName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getHistoryData() != null) {
            i = getHistoryData().hashCode();
        }
        return hashCode + i;
    }

    public void setAlarmName(String str) {
        this.alarmName = str;
    }

    public void setHistoryData(String str) {
        this.historyData = str;
    }

    public void setHistoryItemType(HistoryItemType historyItemType) {
        this.historyItemType = historyItemType.toString();
    }

    public void setHistoryItemType(String str) {
        this.historyItemType = str;
    }

    public void setHistorySummary(String str) {
        this.historySummary = str;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.alarmName != null) {
            stringBuilder.append("AlarmName: " + this.alarmName + ", ");
        }
        if (this.timestamp != null) {
            stringBuilder.append("Timestamp: " + this.timestamp + ", ");
        }
        if (this.historyItemType != null) {
            stringBuilder.append("HistoryItemType: " + this.historyItemType + ", ");
        }
        if (this.historySummary != null) {
            stringBuilder.append("HistorySummary: " + this.historySummary + ", ");
        }
        if (this.historyData != null) {
            stringBuilder.append("HistoryData: " + this.historyData + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AlarmHistoryItem withAlarmName(String str) {
        this.alarmName = str;
        return this;
    }

    public AlarmHistoryItem withHistoryData(String str) {
        this.historyData = str;
        return this;
    }

    public AlarmHistoryItem withHistoryItemType(HistoryItemType historyItemType) {
        this.historyItemType = historyItemType.toString();
        return this;
    }

    public AlarmHistoryItem withHistoryItemType(String str) {
        this.historyItemType = str;
        return this;
    }

    public AlarmHistoryItem withHistorySummary(String str) {
        this.historySummary = str;
        return this;
    }

    public AlarmHistoryItem withTimestamp(Date date) {
        this.timestamp = date;
        return this;
    }
}
