package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CancelSpotInstanceRequestsRequest extends AmazonWebServiceRequest {
    private List<String> spotInstanceRequestIds;

    public CancelSpotInstanceRequestsRequest(List<String> list) {
        this.spotInstanceRequestIds = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CancelSpotInstanceRequestsRequest)) {
            return false;
        }
        CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest = (CancelSpotInstanceRequestsRequest) obj;
        return ((cancelSpotInstanceRequestsRequest.getSpotInstanceRequestIds() == null ? 1 : 0) ^ (getSpotInstanceRequestIds() == null ? 1 : 0)) == 0 ? cancelSpotInstanceRequestsRequest.getSpotInstanceRequestIds() == null || cancelSpotInstanceRequestsRequest.getSpotInstanceRequestIds().equals(getSpotInstanceRequestIds()) : false;
    }

    public List<String> getSpotInstanceRequestIds() {
        if (this.spotInstanceRequestIds == null) {
            this.spotInstanceRequestIds = new ArrayList();
        }
        return this.spotInstanceRequestIds;
    }

    public int hashCode() {
        return (getSpotInstanceRequestIds() == null ? 0 : getSpotInstanceRequestIds().hashCode()) + 31;
    }

    public void setSpotInstanceRequestIds(Collection<String> collection) {
        if (collection == null) {
            this.spotInstanceRequestIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.spotInstanceRequestIds = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.spotInstanceRequestIds != null) {
            stringBuilder.append("SpotInstanceRequestIds: " + this.spotInstanceRequestIds + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CancelSpotInstanceRequestsRequest withSpotInstanceRequestIds(Collection<String> collection) {
        if (collection == null) {
            this.spotInstanceRequestIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.spotInstanceRequestIds = arrayList;
        }
        return this;
    }

    public CancelSpotInstanceRequestsRequest withSpotInstanceRequestIds(String... strArr) {
        if (getSpotInstanceRequestIds() == null) {
            setSpotInstanceRequestIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSpotInstanceRequestIds().add(add);
        }
        return this;
    }
}
