package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CancelConversionTaskRequest extends AmazonWebServiceRequest {
    private String conversionTaskId;
    private String reasonMessage;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CancelConversionTaskRequest)) {
            return false;
        }
        CancelConversionTaskRequest cancelConversionTaskRequest = (CancelConversionTaskRequest) obj;
        if (((cancelConversionTaskRequest.getConversionTaskId() == null ? 1 : 0) ^ (getConversionTaskId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (cancelConversionTaskRequest.getConversionTaskId() != null && !cancelConversionTaskRequest.getConversionTaskId().equals(getConversionTaskId())) {
            return false;
        }
        return ((cancelConversionTaskRequest.getReasonMessage() == null ? 1 : 0) ^ (getReasonMessage() == null ? 1 : 0)) == 0 ? cancelConversionTaskRequest.getReasonMessage() == null || cancelConversionTaskRequest.getReasonMessage().equals(getReasonMessage()) : false;
    }

    public String getConversionTaskId() {
        return this.conversionTaskId;
    }

    public String getReasonMessage() {
        return this.reasonMessage;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getConversionTaskId() == null ? 0 : getConversionTaskId().hashCode()) + 31) * 31;
        if (getReasonMessage() != null) {
            i = getReasonMessage().hashCode();
        }
        return hashCode + i;
    }

    public void setConversionTaskId(String str) {
        this.conversionTaskId = str;
    }

    public void setReasonMessage(String str) {
        this.reasonMessage = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.conversionTaskId != null) {
            stringBuilder.append("ConversionTaskId: " + this.conversionTaskId + ", ");
        }
        if (this.reasonMessage != null) {
            stringBuilder.append("ReasonMessage: " + this.reasonMessage + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CancelConversionTaskRequest withConversionTaskId(String str) {
        this.conversionTaskId = str;
        return this;
    }

    public CancelConversionTaskRequest withReasonMessage(String str) {
        this.reasonMessage = str;
        return this;
    }
}
