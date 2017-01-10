package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.ConfirmSubscriptionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ConfirmSubscriptionRequestMarshaller implements Marshaller<Request<ConfirmSubscriptionRequest>, ConfirmSubscriptionRequest> {
    public Request<ConfirmSubscriptionRequest> marshall(ConfirmSubscriptionRequest confirmSubscriptionRequest) {
        if (confirmSubscriptionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ConfirmSubscriptionRequest> defaultRequest = new DefaultRequest(confirmSubscriptionRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "ConfirmSubscription");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (confirmSubscriptionRequest.getTopicArn() != null) {
            defaultRequest.addParameter("TopicArn", StringUtils.fromString(confirmSubscriptionRequest.getTopicArn()));
        }
        if (confirmSubscriptionRequest.getToken() != null) {
            defaultRequest.addParameter("Token", StringUtils.fromString(confirmSubscriptionRequest.getToken()));
        }
        if (confirmSubscriptionRequest.getAuthenticateOnUnsubscribe() != null) {
            defaultRequest.addParameter("AuthenticateOnUnsubscribe", StringUtils.fromString(confirmSubscriptionRequest.getAuthenticateOnUnsubscribe()));
        }
        return defaultRequest;
    }
}
