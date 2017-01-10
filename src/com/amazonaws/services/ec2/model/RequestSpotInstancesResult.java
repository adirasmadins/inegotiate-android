package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RequestSpotInstancesResult {
    private List<SpotInstanceRequest> spotInstanceRequests;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RequestSpotInstancesResult)) {
            return false;
        }
        RequestSpotInstancesResult requestSpotInstancesResult = (RequestSpotInstancesResult) obj;
        return ((requestSpotInstancesResult.getSpotInstanceRequests() == null ? 1 : 0) ^ (getSpotInstanceRequests() == null ? 1 : 0)) == 0 ? requestSpotInstancesResult.getSpotInstanceRequests() == null || requestSpotInstancesResult.getSpotInstanceRequests().equals(getSpotInstanceRequests()) : false;
    }

    public List<SpotInstanceRequest> getSpotInstanceRequests() {
        if (this.spotInstanceRequests == null) {
            this.spotInstanceRequests = new ArrayList();
        }
        return this.spotInstanceRequests;
    }

    public int hashCode() {
        return (getSpotInstanceRequests() == null ? 0 : getSpotInstanceRequests().hashCode()) + 31;
    }

    public void setSpotInstanceRequests(Collection<SpotInstanceRequest> collection) {
        if (collection == null) {
            this.spotInstanceRequests = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.spotInstanceRequests = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.spotInstanceRequests != null) {
            stringBuilder.append("SpotInstanceRequests: " + this.spotInstanceRequests + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public RequestSpotInstancesResult withSpotInstanceRequests(Collection<SpotInstanceRequest> collection) {
        if (collection == null) {
            this.spotInstanceRequests = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.spotInstanceRequests = arrayList;
        }
        return this;
    }

    public RequestSpotInstancesResult withSpotInstanceRequests(SpotInstanceRequest... spotInstanceRequestArr) {
        if (getSpotInstanceRequests() == null) {
            setSpotInstanceRequests(new ArrayList(spotInstanceRequestArr.length));
        }
        for (Object add : spotInstanceRequestArr) {
            getSpotInstanceRequests().add(add);
        }
        return this;
    }
}
