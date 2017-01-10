package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeSpotDatafeedSubscriptionRequest;
import com.amazonaws.transform.Marshaller;

public class DescribeSpotDatafeedSubscriptionRequestMarshaller implements Marshaller<Request<DescribeSpotDatafeedSubscriptionRequest>, DescribeSpotDatafeedSubscriptionRequest> {
    public Request<DescribeSpotDatafeedSubscriptionRequest> marshall(DescribeSpotDatafeedSubscriptionRequest describeSpotDatafeedSubscriptionRequest) {
        if (describeSpotDatafeedSubscriptionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeSpotDatafeedSubscriptionRequest> defaultRequest = new DefaultRequest(describeSpotDatafeedSubscriptionRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeSpotDatafeedSubscription");
        defaultRequest.addParameter("Version", "2012-08-15");
        return defaultRequest;
    }
}
