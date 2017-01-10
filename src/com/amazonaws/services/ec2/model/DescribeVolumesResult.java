package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeVolumesResult {
    private List<Volume> volumes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeVolumesResult)) {
            return false;
        }
        DescribeVolumesResult describeVolumesResult = (DescribeVolumesResult) obj;
        return ((describeVolumesResult.getVolumes() == null ? 1 : 0) ^ (getVolumes() == null ? 1 : 0)) == 0 ? describeVolumesResult.getVolumes() == null || describeVolumesResult.getVolumes().equals(getVolumes()) : false;
    }

    public List<Volume> getVolumes() {
        if (this.volumes == null) {
            this.volumes = new ArrayList();
        }
        return this.volumes;
    }

    public int hashCode() {
        return (getVolumes() == null ? 0 : getVolumes().hashCode()) + 31;
    }

    public void setVolumes(Collection<Volume> collection) {
        if (collection == null) {
            this.volumes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.volumes = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.volumes != null) {
            stringBuilder.append("Volumes: " + this.volumes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeVolumesResult withVolumes(Collection<Volume> collection) {
        if (collection == null) {
            this.volumes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.volumes = arrayList;
        }
        return this;
    }

    public DescribeVolumesResult withVolumes(Volume... volumeArr) {
        if (getVolumes() == null) {
            setVolumes(new ArrayList(volumeArr.length));
        }
        for (Object add : volumeArr) {
            getVolumes().add(add);
        }
        return this;
    }
}
