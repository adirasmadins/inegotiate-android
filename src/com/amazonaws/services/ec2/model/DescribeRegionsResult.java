package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeRegionsResult {
    private List<Region> regions;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeRegionsResult)) {
            return false;
        }
        DescribeRegionsResult describeRegionsResult = (DescribeRegionsResult) obj;
        return ((describeRegionsResult.getRegions() == null ? 1 : 0) ^ (getRegions() == null ? 1 : 0)) == 0 ? describeRegionsResult.getRegions() == null || describeRegionsResult.getRegions().equals(getRegions()) : false;
    }

    public List<Region> getRegions() {
        if (this.regions == null) {
            this.regions = new ArrayList();
        }
        return this.regions;
    }

    public int hashCode() {
        return (getRegions() == null ? 0 : getRegions().hashCode()) + 31;
    }

    public void setRegions(Collection<Region> collection) {
        if (collection == null) {
            this.regions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.regions = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.regions != null) {
            stringBuilder.append("Regions: " + this.regions + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeRegionsResult withRegions(Collection<Region> collection) {
        if (collection == null) {
            this.regions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.regions = arrayList;
        }
        return this;
    }

    public DescribeRegionsResult withRegions(Region... regionArr) {
        if (getRegions() == null) {
            setRegions(new ArrayList(regionArr.length));
        }
        for (Object add : regionArr) {
            getRegions().add(add);
        }
        return this;
    }
}
