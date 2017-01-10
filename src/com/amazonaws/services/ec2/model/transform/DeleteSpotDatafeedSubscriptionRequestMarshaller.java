package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DeleteSpotDatafeedSubscriptionRequest;
import com.amazonaws.transform.Marshaller;

public class DeleteSpotDatafeedSubscriptionRequestMarshaller implements Marshaller<Request<DeleteSpotDatafeedSubscriptionRequest>, DeleteSpotDatafeedSubscriptionRequest> {
    public Request<DeleteSpotDatafeedSubscriptionRequest> marshall(DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest) {
        if (deleteSpotDatafeedSubscriptionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteSpotDatafeedSubscriptionRequest> defaultRequest = new DefaultRequest(deleteSpotDatafeedSubscriptionRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DeleteSpotDatafeedSubscription");
        defaultRequest.addParameter("Version", "2012-08-15");
        return defaultRequest;
    }
}
