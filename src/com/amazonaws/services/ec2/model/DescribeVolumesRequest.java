package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeVolumesRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private List<String> volumeIds;

    public DescribeVolumesRequest(List<String> list) {
        this.volumeIds = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeVolumesRequest)) {
            return false;
        }
        DescribeVolumesRequest describeVolumesRequest = (DescribeVolumesRequest) obj;
        if (((describeVolumesRequest.getVolumeIds() == null ? 1 : 0) ^ (getVolumeIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeVolumesRequest.getVolumeIds() != null && !describeVolumesRequest.getVolumeIds().equals(getVolumeIds())) {
            return false;
        }
        return ((describeVolumesRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeVolumesRequest.getFilters() == null || describeVolumesRequest.getFilters().equals(getFilters()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getVolumeIds() {
        if (this.volumeIds == null) {
            this.volumeIds = new ArrayList();
        }
        return this.volumeIds;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVolumeIds() == null ? 0 : getVolumeIds().hashCode()) + 31) * 31;
        if (getFilters() != null) {
            i = getFilters().hashCode();
        }
        return hashCode + i;
    }

    public void setFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.filters = arrayList;
    }

    public void setVolumeIds(Collection<String> collection) {
        if (collection == null) {
            this.volumeIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.volumeIds = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.volumeIds != null) {
            stringBuilder.append("VolumeIds: " + this.volumeIds + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeVolumesRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeVolumesRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeVolumesRequest withVolumeIds(Collection<String> collection) {
        if (collection == null) {
            this.volumeIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.volumeIds = arrayList;
        }
        return this;
    }

    public DescribeVolumesRequest withVolumeIds(String... strArr) {
        if (getVolumeIds() == null) {
            setVolumeIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getVolumeIds().add(add);
        }
        return this;
    }
}
