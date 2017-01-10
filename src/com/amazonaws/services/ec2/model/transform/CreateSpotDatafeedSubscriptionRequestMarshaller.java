package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CreateSpotDatafeedSubscriptionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateSpotDatafeedSubscriptionRequestMarshaller implements Marshaller<Request<CreateSpotDatafeedSubscriptionRequest>, CreateSpotDatafeedSubscriptionRequest> {
    public Request<CreateSpotDatafeedSubscriptionRequest> marshall(CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest) {
        if (createSpotDatafeedSubscriptionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateSpotDatafeedSubscriptionRequest> defaultRequest = new DefaultRequest(createSpotDatafeedSubscriptionRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CreateSpotDatafeedSubscription");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (createSpotDatafeedSubscriptionRequest.getBucket() != null) {
            defaultRequest.addParameter("Bucket", StringUtils.fromString(createSpotDatafeedSubscriptionRequest.getBucket()));
        }
        if (createSpotDatafeedSubscriptionRequest.getPrefix() != null) {
            defaultRequest.addParameter("Prefix", StringUtils.fromString(createSpotDatafeedSubscriptionRequest.getPrefix()));
        }
        return defaultRequest;
    }
}
