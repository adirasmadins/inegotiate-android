package com.amazonaws.services.ec2.model;

public class ExportTask {
    private String description;
    private String exportTaskId;
    private ExportToS3Task exportToS3Task;
    private InstanceExportDetails instanceExportDetails;
    private String state;
    private String statusMessage;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ExportTask)) {
            return false;
        }
        ExportTask exportTask = (ExportTask) obj;
        if (((exportTask.getExportTaskId() == null ? 1 : 0) ^ (getExportTaskId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (exportTask.getExportTaskId() != null && !exportTask.getExportTaskId().equals(getExportTaskId())) {
            return false;
        }
        if (((exportTask.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (exportTask.getDescription() != null && !exportTask.getDescription().equals(getDescription())) {
            return false;
        }
        if (((exportTask.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (exportTask.getState() != null && !exportTask.getState().equals(getState())) {
            return false;
        }
        if (((exportTask.getStatusMessage() == null ? 1 : 0) ^ (getStatusMessage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (exportTask.getStatusMessage() != null && !exportTask.getStatusMessage().equals(getStatusMessage())) {
            return false;
        }
        if (((exportTask.getInstanceExportDetails() == null ? 1 : 0) ^ (getInstanceExportDetails() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (exportTask.getInstanceExportDetails() != null && !exportTask.getInstanceExportDetails().equals(getInstanceExportDetails())) {
            return false;
        }
        return ((exportTask.getExportToS3Task() == null ? 1 : 0) ^ (getExportToS3Task() == null ? 1 : 0)) == 0 ? exportTask.getExportToS3Task() == null || exportTask.getExportToS3Task().equals(getExportToS3Task()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getExportTaskId() {
        return this.exportTaskId;
    }

    public ExportToS3Task getExportToS3Task() {
        return this.exportToS3Task;
    }

    public InstanceExportDetails getInstanceExportDetails() {
        return this.instanceExportDetails;
    }

    public String getState() {
        return this.state;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstanceExportDetails() == null ? 0 : getInstanceExportDetails().hashCode()) + (((getStatusMessage() == null ? 0 : getStatusMessage().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getExportTaskId() == null ? 0 : getExportTaskId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getExportToS3Task() != null) {
            i = getExportToS3Task().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExportTaskId(String str) {
        this.exportTaskId = str;
    }

    public void setExportToS3Task(ExportToS3Task exportToS3Task) {
        this.exportToS3Task = exportToS3Task;
    }

    public void setInstanceExportDetails(InstanceExportDetails instanceExportDetails) {
        this.instanceExportDetails = instanceExportDetails;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.exportTaskId != null) {
            stringBuilder.append("ExportTaskId: " + this.exportTaskId + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.statusMessage != null) {
            stringBuilder.append("StatusMessage: " + this.statusMessage + ", ");
        }
        if (this.instanceExportDetails != null) {
            stringBuilder.append("InstanceExportDetails: " + this.instanceExportDetails + ", ");
        }
        if (this.exportToS3Task != null) {
            stringBuilder.append("ExportToS3Task: " + this.exportToS3Task + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ExportTask withDescription(String str) {
        this.description = str;
        return this;
    }

    public ExportTask withExportTaskId(String str) {
        this.exportTaskId = str;
        return this;
    }

    public ExportTask withExportToS3Task(ExportToS3Task exportToS3Task) {
        this.exportToS3Task = exportToS3Task;
        return this;
    }

    public ExportTask withInstanceExportDetails(InstanceExportDetails instanceExportDetails) {
        this.instanceExportDetails = instanceExportDetails;
        return this;
    }

    public ExportTask withState(String str) {
        this.state = str;
        return this;
    }

    public ExportTask withStatusMessage(String str) {
        this.statusMessage = str;
        return this;
    }
}
