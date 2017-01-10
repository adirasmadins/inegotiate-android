package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CancelExportTaskRequest extends AmazonWebServiceRequest {
    private String exportTaskId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CancelExportTaskRequest)) {
            return false;
        }
        CancelExportTaskRequest cancelExportTaskRequest = (CancelExportTaskRequest) obj;
        return ((cancelExportTaskRequest.getExportTaskId() == null ? 1 : 0) ^ (getExportTaskId() == null ? 1 : 0)) == 0 ? cancelExportTaskRequest.getExportTaskId() == null || cancelExportTaskRequest.getExportTaskId().equals(getExportTaskId()) : false;
    }

    public String getExportTaskId() {
        return this.exportTaskId;
    }

    public int hashCode() {
        return (getExportTaskId() == null ? 0 : getExportTaskId().hashCode()) + 31;
    }

    public void setExportTaskId(String str) {
        this.exportTaskId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.exportTaskId != null) {
            stringBuilder.append("ExportTaskId: " + this.exportTaskId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CancelExportTaskRequest withExportTaskId(String str) {
        this.exportTaskId = str;
        return this;
    }
}
