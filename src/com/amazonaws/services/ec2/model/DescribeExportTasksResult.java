package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeExportTasksResult {
    private List<ExportTask> exportTasks;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeExportTasksResult)) {
            return false;
        }
        DescribeExportTasksResult describeExportTasksResult = (DescribeExportTasksResult) obj;
        return ((describeExportTasksResult.getExportTasks() == null ? 1 : 0) ^ (getExportTasks() == null ? 1 : 0)) == 0 ? describeExportTasksResult.getExportTasks() == null || describeExportTasksResult.getExportTasks().equals(getExportTasks()) : false;
    }

    public List<ExportTask> getExportTasks() {
        if (this.exportTasks == null) {
            this.exportTasks = new ArrayList();
        }
        return this.exportTasks;
    }

    public int hashCode() {
        return (getExportTasks() == null ? 0 : getExportTasks().hashCode()) + 31;
    }

    public void setExportTasks(Collection<ExportTask> collection) {
        if (collection == null) {
            this.exportTasks = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.exportTasks = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.exportTasks != null) {
            stringBuilder.append("ExportTasks: " + this.exportTasks + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeExportTasksResult withExportTasks(Collection<ExportTask> collection) {
        if (collection == null) {
            this.exportTasks = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.exportTasks = arrayList;
        }
        return this;
    }

    public DescribeExportTasksResult withExportTasks(ExportTask... exportTaskArr) {
        if (getExportTasks() == null) {
            setExportTasks(new ArrayList(exportTaskArr.length));
        }
        for (Object add : exportTaskArr) {
            getExportTasks().add(add);
        }
        return this;
    }
}
