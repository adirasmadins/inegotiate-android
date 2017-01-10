package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SubscribeRequestMarshaller implements Marshaller<Request<SubscribeRequest>, SubscribeRequest> {
    public Request<SubscribeRequest> marshall(SubscribeRequest subscribeRequest) {
        if (subscribeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SubscribeRequest> defaultRequest = new DefaultRequest(subscribeRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "Subscribe");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (subscribeRequest.getTopicArn() != null) {
            defaultRequest.addParameter("TopicArn", StringUtils.fromString(subscribeRequest.getTopicArn()));
        }
        if (subscribeRequest.getProtocol() != null) {
            defaultRequest.addParameter("Protocol", StringUtils.fromString(subscribeRequest.getProtocol()));
        }
        if (subscribeRequest.getEndpoint() != null) {
            defaultRequest.addParameter("Endpoint", StringUtils.fromString(subscribeRequest.getEndpoint()));
        }
        return defaultRequest;
    }
}
