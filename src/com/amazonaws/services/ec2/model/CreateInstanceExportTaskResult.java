package com.amazonaws.services.ec2.model;

public class CreateInstanceExportTaskResult {
    private ExportTask exportTask;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateInstanceExportTaskResult)) {
            return false;
        }
        CreateInstanceExportTaskResult createInstanceExportTaskResult = (CreateInstanceExportTaskResult) obj;
        return ((createInstanceExportTaskResult.getExportTask() == null ? 1 : 0) ^ (getExportTask() == null ? 1 : 0)) == 0 ? createInstanceExportTaskResult.getExportTask() == null || createInstanceExportTaskResult.getExportTask().equals(getExportTask()) : false;
    }

    public ExportTask getExportTask() {
        return this.exportTask;
    }

    public int hashCode() {
        return (getExportTask() == null ? 0 : getExportTask().hashCode()) + 31;
    }

    public void setExportTask(ExportTask exportTask) {
        this.exportTask = exportTask;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.exportTask != null) {
            stringBuilder.append("ExportTask: " + this.exportTask + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateInstanceExportTaskResult withExportTask(ExportTask exportTask) {
        this.exportTask = exportTask;
        return this;
    }
}
