package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CancelSpotInstanceRequestsResult {
    private List<CancelledSpotInstanceRequest> cancelledSpotInstanceRequests;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CancelSpotInstanceRequestsResult)) {
            return false;
        }
        CancelSpotInstanceRequestsResult cancelSpotInstanceRequestsResult = (CancelSpotInstanceRequestsResult) obj;
        return ((cancelSpotInstanceRequestsResult.getCancelledSpotInstanceRequests() == null ? 1 : 0) ^ (getCancelledSpotInstanceRequests() == null ? 1 : 0)) == 0 ? cancelSpotInstanceRequestsResult.getCancelledSpotInstanceRequests() == null || cancelSpotInstanceRequestsResult.getCancelledSpotInstanceRequests().equals(getCancelledSpotInstanceRequests()) : false;
    }

    public List<CancelledSpotInstanceRequest> getCancelledSpotInstanceRequests() {
        if (this.cancelledSpotInstanceRequests == null) {
            this.cancelledSpotInstanceRequests = new ArrayList();
        }
        return this.cancelledSpotInstanceRequests;
    }

    public int hashCode() {
        return (getCancelledSpotInstanceRequests() == null ? 0 : getCancelledSpotInstanceRequests().hashCode()) + 31;
    }

    public void setCancelledSpotInstanceRequests(Collection<CancelledSpotInstanceRequest> collection) {
        if (collection == null) {
            this.cancelledSpotInstanceRequests = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.cancelledSpotInstanceRequests = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.cancelledSpotInstanceRequests != null) {
            stringBuilder.append("CancelledSpotInstanceRequests: " + this.cancelledSpotInstanceRequests + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CancelSpotInstanceRequestsResult withCancelledSpotInstanceRequests(Collection<CancelledSpotInstanceRequest> collection) {
        if (collection == null) {
            this.cancelledSpotInstanceRequests = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.cancelledSpotInstanceRequests = arrayList;
        }
        return this;
    }

    public CancelSpotInstanceRequestsResult withCancelledSpotInstanceRequests(CancelledSpotInstanceRequest... cancelledSpotInstanceRequestArr) {
        if (getCancelledSpotInstanceRequests() == null) {
            setCancelledSpotInstanceRequests(new ArrayList(cancelledSpotInstanceRequestArr.length));
        }
        for (Object add : cancelledSpotInstanceRequestArr) {
            getCancelledSpotInstanceRequests().add(add);
        }
        return this;
    }
}
