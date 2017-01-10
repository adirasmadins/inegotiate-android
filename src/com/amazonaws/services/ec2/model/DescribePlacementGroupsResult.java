package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribePlacementGroupsResult {
    private List<PlacementGroup> placementGroups;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribePlacementGroupsResult)) {
            return false;
        }
        DescribePlacementGroupsResult describePlacementGroupsResult = (DescribePlacementGroupsResult) obj;
        return ((describePlacementGroupsResult.getPlacementGroups() == null ? 1 : 0) ^ (getPlacementGroups() == null ? 1 : 0)) == 0 ? describePlacementGroupsResult.getPlacementGroups() == null || describePlacementGroupsResult.getPlacementGroups().equals(getPlacementGroups()) : false;
    }

    public List<PlacementGroup> getPlacementGroups() {
        if (this.placementGroups == null) {
            this.placementGroups = new ArrayList();
        }
        return this.placementGroups;
    }

    public int hashCode() {
        return (getPlacementGroups() == null ? 0 : getPlacementGroups().hashCode()) + 31;
    }

    public void setPlacementGroups(Collection<PlacementGroup> collection) {
        if (collection == null) {
            this.placementGroups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.placementGroups = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.placementGroups != null) {
            stringBuilder.append("PlacementGroups: " + this.placementGroups + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribePlacementGroupsResult withPlacementGroups(Collection<PlacementGroup> collection) {
        if (collection == null) {
            this.placementGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.placementGroups = arrayList;
        }
        return this;
    }

    public DescribePlacementGroupsResult withPlacementGroups(PlacementGroup... placementGroupArr) {
        if (getPlacementGroups() == null) {
            setPlacementGroups(new ArrayList(placementGroupArr.length));
        }
        for (Object add : placementGroupArr) {
            getPlacementGroups().add(add);
        }
        return this;
    }
}
