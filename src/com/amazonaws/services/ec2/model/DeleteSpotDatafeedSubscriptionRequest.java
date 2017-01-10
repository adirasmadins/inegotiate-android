package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteSpotDatafeedSubscriptionRequest extends AmazonWebServiceRequest {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DeleteSpotDatafeedSubscriptionRequest)) {
            return false;
        }
        DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest = (DeleteSpotDatafeedSubscriptionRequest) obj;
        return true;
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
