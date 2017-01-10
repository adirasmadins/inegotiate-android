package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.Date;

public class DescribeAlarmHistoryRequest extends AmazonWebServiceRequest {
    private String alarmName;
    private Date endDate;
    private String historyItemType;
    private Integer maxRecords;
    private String nextToken;
    private Date startDate;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAlarmHistoryRequest)) {
            return false;
        }
        DescribeAlarmHistoryRequest describeAlarmHistoryRequest = (DescribeAlarmHistoryRequest) obj;
        if (((describeAlarmHistoryRequest.getAlarmName() == null ? 1 : 0) ^ (getAlarmName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmHistoryRequest.getAlarmName() != null && !describeAlarmHistoryRequest.getAlarmName().equals(getAlarmName())) {
            return false;
        }
        if (((describeAlarmHistoryRequest.getHistoryItemType() == null ? 1 : 0) ^ (getHistoryItemType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmHistoryRequest.getHistoryItemType() != null && !describeAlarmHistoryRequest.getHistoryItemType().equals(getHistoryItemType())) {
            return false;
        }
        if (((describeAlarmHistoryRequest.getStartDate() == null ? 1 : 0) ^ (getStartDate() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmHistoryRequest.getStartDate() != null && !describeAlarmHistoryRequest.getStartDate().equals(getStartDate())) {
            return false;
        }
        if (((describeAlarmHistoryRequest.getEndDate() == null ? 1 : 0) ^ (getEndDate() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmHistoryRequest.getEndDate() != null && !describeAlarmHistoryRequest.getEndDate().equals(getEndDate())) {
            return false;
        }
        if (((describeAlarmHistoryRequest.getMaxRecords() == null ? 1 : 0) ^ (getMaxRecords() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmHistoryRequest.getMaxRecords() != null && !describeAlarmHistoryRequest.getMaxRecords().equals(getMaxRecords())) {
            return false;
        }
        return ((describeAlarmHistoryRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeAlarmHistoryRequest.getNextToken() == null || describeAlarmHistoryRequest.getNextToken().equals(getNextToken()) : false;
    }

    public String getAlarmName() {
        return this.alarmName;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public String getHistoryItemType() {
        return this.historyItemType;
    }

    public Integer getMaxRecords() {
        return this.maxRecords;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMaxRecords() == null ? 0 : getMaxRecords().hashCode()) + (((getEndDate() == null ? 0 : getEndDate().hashCode()) + (((getStartDate() == null ? 0 : getStartDate().hashCode()) + (((getHistoryItemType() == null ? 0 : getHistoryItemType().hashCode()) + (((getAlarmName() == null ? 0 : getAlarmName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setAlarmName(String str) {
        this.alarmName = str;
    }

    public void setEndDate(Date date) {
        this.endDate = date;
    }

    public void setHistoryItemType(HistoryItemType historyItemType) {
        this.historyItemType = historyItemType.toString();
    }

    public void setHistoryItemType(String str) {
        this.historyItemType = str;
    }

    public void setMaxRecords(Integer num) {
        this.maxRecords = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.alarmName != null) {
            stringBuilder.append("AlarmName: " + this.alarmName + ", ");
        }
        if (this.historyItemType != null) {
            stringBuilder.append("HistoryItemType: " + this.historyItemType + ", ");
        }
        if (this.startDate != null) {
            stringBuilder.append("StartDate: " + this.startDate + ", ");
        }
        if (this.endDate != null) {
            stringBuilder.append("EndDate: " + this.endDate + ", ");
        }
        if (this.maxRecords != null) {
            stringBuilder.append("MaxRecords: " + this.maxRecords + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAlarmHistoryRequest withAlarmName(String str) {
        this.alarmName = str;
        return this;
    }

    public DescribeAlarmHistoryRequest withEndDate(Date date) {
        this.endDate = date;
        return this;
    }

    public DescribeAlarmHistoryRequest withHistoryItemType(HistoryItemType historyItemType) {
        this.historyItemType = historyItemType.toString();
        return this;
    }

    public DescribeAlarmHistoryRequest withHistoryItemType(String str) {
        this.historyItemType = str;
        return this;
    }

    public DescribeAlarmHistoryRequest withMaxRecords(Integer num) {
        this.maxRecords = num;
        return this;
    }

    public DescribeAlarmHistoryRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribeAlarmHistoryRequest withStartDate(Date date) {
        this.startDate = date;
        return this;
    }
}
