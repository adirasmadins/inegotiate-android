package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ListSubscriptionsByTopicRequestMarshaller implements Marshaller<Request<ListSubscriptionsByTopicRequest>, ListSubscriptionsByTopicRequest> {
    public Request<ListSubscriptionsByTopicRequest> marshall(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) {
        if (listSubscriptionsByTopicRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ListSubscriptionsByTopicRequest> defaultRequest = new DefaultRequest(listSubscriptionsByTopicRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "ListSubscriptionsByTopic");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (listSubscriptionsByTopicRequest.getTopicArn() != null) {
            defaultRequest.addParameter("TopicArn", StringUtils.fromString(listSubscriptionsByTopicRequest.getTopicArn()));
        }
        if (listSubscriptionsByTopicRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(listSubscriptionsByTopicRequest.getNextToken()));
        }
        return defaultRequest;
    }
}
