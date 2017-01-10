package com.amazonaws.services.simpleemail.model;

public class GetSendQuotaResult {
    private Double max24HourSend;
    private Double maxSendRate;
    private Double sentLast24Hours;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSendQuotaResult)) {
            return false;
        }
        GetSendQuotaResult getSendQuotaResult = (GetSendQuotaResult) obj;
        if (((getSendQuotaResult.getMax24HourSend() == null ? 1 : 0) ^ (getMax24HourSend() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getSendQuotaResult.getMax24HourSend() != null && !getSendQuotaResult.getMax24HourSend().equals(getMax24HourSend())) {
            return false;
        }
        if (((getSendQuotaResult.getMaxSendRate() == null ? 1 : 0) ^ (getMaxSendRate() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getSendQuotaResult.getMaxSendRate() != null && !getSendQuotaResult.getMaxSendRate().equals(getMaxSendRate())) {
            return false;
        }
        return ((getSendQuotaResult.getSentLast24Hours() == null ? 1 : 0) ^ (getSentLast24Hours() == null ? 1 : 0)) == 0 ? getSendQuotaResult.getSentLast24Hours() == null || getSendQuotaResult.getSentLast24Hours().equals(getSentLast24Hours()) : false;
    }

    public Double getMax24HourSend() {
        return this.max24HourSend;
    }

    public Double getMaxSendRate() {
        return this.maxSendRate;
    }

    public Double getSentLast24Hours() {
        return this.sentLast24Hours;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMaxSendRate() == null ? 0 : getMaxSendRate().hashCode()) + (((getMax24HourSend() == null ? 0 : getMax24HourSend().hashCode()) + 31) * 31)) * 31;
        if (getSentLast24Hours() != null) {
            i = getSentLast24Hours().hashCode();
        }
        return hashCode + i;
    }

    public void setMax24HourSend(Double d) {
        this.max24HourSend = d;
    }

    public void setMaxSendRate(Double d) {
        this.maxSendRate = d;
    }

    public void setSentLast24Hours(Double d) {
        this.sentLast24Hours = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.max24HourSend != null) {
            stringBuilder.append("Max24HourSend: " + this.max24HourSend + ", ");
        }
        if (this.maxSendRate != null) {
            stringBuilder.append("MaxSendRate: " + this.maxSendRate + ", ");
        }
        if (this.sentLast24Hours != null) {
            stringBuilder.append("SentLast24Hours: " + this.sentLast24Hours + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetSendQuotaResult withMax24HourSend(Double d) {
        this.max24HourSend = d;
        return this;
    }

    public GetSendQuotaResult withMaxSendRate(Double d) {
        this.maxSendRate = d;
        return this;
    }

    public GetSendQuotaResult withSentLast24Hours(Double d) {
        this.sentLast24Hours = d;
        return this;
    }
}
