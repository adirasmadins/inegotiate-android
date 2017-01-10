package com.amazonaws.services.simpleemail.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetSendStatisticsResult {
    private List<SendDataPoint> sendDataPoints;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSendStatisticsResult)) {
            return false;
        }
        GetSendStatisticsResult getSendStatisticsResult = (GetSendStatisticsResult) obj;
        return ((getSendStatisticsResult.getSendDataPoints() == null ? 1 : 0) ^ (getSendDataPoints() == null ? 1 : 0)) == 0 ? getSendStatisticsResult.getSendDataPoints() == null || getSendStatisticsResult.getSendDataPoints().equals(getSendDataPoints()) : false;
    }

    public List<SendDataPoint> getSendDataPoints() {
        if (this.sendDataPoints == null) {
            this.sendDataPoints = new ArrayList();
        }
        return this.sendDataPoints;
    }

    public int hashCode() {
        return (getSendDataPoints() == null ? 0 : getSendDataPoints().hashCode()) + 31;
    }

    public void setSendDataPoints(Collection<SendDataPoint> collection) {
        if (collection == null) {
            this.sendDataPoints = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.sendDataPoints = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.sendDataPoints != null) {
            stringBuilder.append("SendDataPoints: " + this.sendDataPoints + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetSendStatisticsResult withSendDataPoints(Collection<SendDataPoint> collection) {
        if (collection == null) {
            this.sendDataPoints = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.sendDataPoints = arrayList;
        }
        return this;
    }

    public GetSendStatisticsResult withSendDataPoints(SendDataPoint... sendDataPointArr) {
        if (getSendDataPoints() == null) {
            setSendDataPoints(new ArrayList(sendDataPointArr.length));
        }
        for (Object add : sendDataPointArr) {
            getSendDataPoints().add(add);
        }
        return this;
    }
}
