package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreateInstanceExportTaskRequest extends AmazonWebServiceRequest {
    private String description;
    private ExportToS3TaskSpecification exportToS3Task;
    private String instanceId;
    private String targetEnvironment;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateInstanceExportTaskRequest)) {
            return false;
        }
        CreateInstanceExportTaskRequest createInstanceExportTaskRequest = (CreateInstanceExportTaskRequest) obj;
        if (((createInstanceExportTaskRequest.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createInstanceExportTaskRequest.getDescription() != null && !createInstanceExportTaskRequest.getDescription().equals(getDescription())) {
            return false;
        }
        if (((createInstanceExportTaskRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createInstanceExportTaskRequest.getInstanceId() != null && !createInstanceExportTaskRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((createInstanceExportTaskRequest.getTargetEnvironment() == null ? 1 : 0) ^ (getTargetEnvironment() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createInstanceExportTaskRequest.getTargetEnvironment() != null && !createInstanceExportTaskRequest.getTargetEnvironment().equals(getTargetEnvironment())) {
            return false;
        }
        return ((createInstanceExportTaskRequest.getExportToS3Task() == null ? 1 : 0) ^ (getExportToS3Task() == null ? 1 : 0)) == 0 ? createInstanceExportTaskRequest.getExportToS3Task() == null || createInstanceExportTaskRequest.getExportToS3Task().equals(getExportToS3Task()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public ExportToS3TaskSpecification getExportToS3Task() {
        return this.exportToS3Task;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getTargetEnvironment() {
        return this.targetEnvironment;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTargetEnvironment() == null ? 0 : getTargetEnvironment().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getExportToS3Task() != null) {
            i = getExportToS3Task().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExportToS3Task(ExportToS3TaskSpecification exportToS3TaskSpecification) {
        this.exportToS3Task = exportToS3TaskSpecification;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setTargetEnvironment(ExportEnvironment exportEnvironment) {
        this.targetEnvironment = exportEnvironment.toString();
    }

    public void setTargetEnvironment(String str) {
        this.targetEnvironment = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.targetEnvironment != null) {
            stringBuilder.append("TargetEnvironment: " + this.targetEnvironment + ", ");
        }
        if (this.exportToS3Task != null) {
            stringBuilder.append("ExportToS3Task: " + this.exportToS3Task + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateInstanceExportTaskRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public CreateInstanceExportTaskRequest withExportToS3Task(ExportToS3TaskSpecification exportToS3TaskSpecification) {
        this.exportToS3Task = exportToS3TaskSpecification;
        return this;
    }

    public CreateInstanceExportTaskRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public CreateInstanceExportTaskRequest withTargetEnvironment(ExportEnvironment exportEnvironment) {
        this.targetEnvironment = exportEnvironment.toString();
        return this;
    }

    public CreateInstanceExportTaskRequest withTargetEnvironment(String str) {
        this.targetEnvironment = str;
        return this;
    }
}
