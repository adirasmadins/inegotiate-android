package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeExportTasksRequest extends AmazonWebServiceRequest {
    private List<String> exportTaskIds;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeExportTasksRequest)) {
            return false;
        }
        DescribeExportTasksRequest describeExportTasksRequest = (DescribeExportTasksRequest) obj;
        return ((describeExportTasksRequest.getExportTaskIds() == null ? 1 : 0) ^ (getExportTaskIds() == null ? 1 : 0)) == 0 ? describeExportTasksRequest.getExportTaskIds() == null || describeExportTasksRequest.getExportTaskIds().equals(getExportTaskIds()) : false;
    }

    public List<String> getExportTaskIds() {
        if (this.exportTaskIds == null) {
            this.exportTaskIds = new ArrayList();
        }
        return this.exportTaskIds;
    }

    public int hashCode() {
        return (getExportTaskIds() == null ? 0 : getExportTaskIds().hashCode()) + 31;
    }

    public void setExportTaskIds(Collection<String> collection) {
        if (collection == null) {
            this.exportTaskIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.exportTaskIds = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.exportTaskIds != null) {
            stringBuilder.append("ExportTaskIds: " + this.exportTaskIds + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeExportTasksRequest withExportTaskIds(Collection<String> collection) {
        if (collection == null) {
            this.exportTaskIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.exportTaskIds = arrayList;
        }
        return this;
    }

    public DescribeExportTasksRequest withExportTaskIds(String... strArr) {
        if (getExportTaskIds() == null) {
            setExportTaskIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getExportTaskIds().add(add);
        }
        return this;
    }
}
