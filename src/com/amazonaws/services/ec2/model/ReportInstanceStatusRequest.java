package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ReportInstanceStatusRequest extends AmazonWebServiceRequest {
    private String description;
    private Date endTime;
    private List<String> instances;
    private List<String> reasonCodes;
    private Date startTime;
    private String status;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReportInstanceStatusRequest)) {
            return false;
        }
        ReportInstanceStatusRequest reportInstanceStatusRequest = (ReportInstanceStatusRequest) obj;
        if (((reportInstanceStatusRequest.getInstances() == null ? 1 : 0) ^ (getInstances() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reportInstanceStatusRequest.getInstances() != null && !reportInstanceStatusRequest.getInstances().equals(getInstances())) {
            return false;
        }
        if (((reportInstanceStatusRequest.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reportInstanceStatusRequest.getStatus() != null && !reportInstanceStatusRequest.getStatus().equals(getStatus())) {
            return false;
        }
        if (((reportInstanceStatusRequest.getStartTime() == null ? 1 : 0) ^ (getStartTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reportInstanceStatusRequest.getStartTime() != null && !reportInstanceStatusRequest.getStartTime().equals(getStartTime())) {
            return false;
        }
        if (((reportInstanceStatusRequest.getEndTime() == null ? 1 : 0) ^ (getEndTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reportInstanceStatusRequest.getEndTime() != null && !reportInstanceStatusRequest.getEndTime().equals(getEndTime())) {
            return false;
        }
        if (((reportInstanceStatusRequest.getReasonCodes() == null ? 1 : 0) ^ (getReasonCodes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reportInstanceStatusRequest.getReasonCodes() != null && !reportInstanceStatusRequest.getReasonCodes().equals(getReasonCodes())) {
            return false;
        }
        return ((reportInstanceStatusRequest.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) == 0 ? reportInstanceStatusRequest.getDescription() == null || reportInstanceStatusRequest.getDescription().equals(getDescription()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public List<String> getInstances() {
        if (this.instances == null) {
            this.instances = new ArrayList();
        }
        return this.instances;
    }

    public List<String> getReasonCodes() {
        if (this.reasonCodes == null) {
            this.reasonCodes = new ArrayList();
        }
        return this.reasonCodes;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getReasonCodes() == null ? 0 : getReasonCodes().hashCode()) + (((getEndTime() == null ? 0 : getEndTime().hashCode()) + (((getStartTime() == null ? 0 : getStartTime().hashCode()) + (((getStatus() == null ? 0 : getStatus().hashCode()) + (((getInstances() == null ? 0 : getInstances().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getDescription() != null) {
            i = getDescription().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setEndTime(Date date) {
        this.endTime = date;
    }

    public void setInstances(Collection<String> collection) {
        if (collection == null) {
            this.instances = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.instances = arrayList;
    }

    public void setReasonCodes(Collection<String> collection) {
        if (collection == null) {
            this.reasonCodes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.reasonCodes = arrayList;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instances != null) {
            stringBuilder.append("Instances: " + this.instances + ", ");
        }
        if (this.status != null) {
            stringBuilder.append("Status: " + this.status + ", ");
        }
        if (this.startTime != null) {
            stringBuilder.append("StartTime: " + this.startTime + ", ");
        }
        if (this.endTime != null) {
            stringBuilder.append("EndTime: " + this.endTime + ", ");
        }
        if (this.reasonCodes != null) {
            stringBuilder.append("ReasonCodes: " + this.reasonCodes + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ReportInstanceStatusRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public ReportInstanceStatusRequest withEndTime(Date date) {
        this.endTime = date;
        return this;
    }

    public ReportInstanceStatusRequest withInstances(Collection<String> collection) {
        if (collection == null) {
            this.instances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instances = arrayList;
        }
        return this;
    }

    public ReportInstanceStatusRequest withInstances(String... strArr) {
        if (getInstances() == null) {
            setInstances(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getInstances().add(add);
        }
        return this;
    }

    public ReportInstanceStatusRequest withReasonCodes(Collection<String> collection) {
        if (collection == null) {
            this.reasonCodes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.reasonCodes = arrayList;
        }
        return this;
    }

    public ReportInstanceStatusRequest withReasonCodes(String... strArr) {
        if (getReasonCodes() == null) {
            setReasonCodes(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getReasonCodes().add(add);
        }
        return this;
    }

    public ReportInstanceStatusRequest withStartTime(Date date) {
        this.startTime = date;
        return this;
    }

    public ReportInstanceStatusRequest withStatus(String str) {
        this.status = str;
        return this;
    }
}
