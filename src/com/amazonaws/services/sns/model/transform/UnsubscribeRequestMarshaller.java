package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.UnsubscribeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class UnsubscribeRequestMarshaller implements Marshaller<Request<UnsubscribeRequest>, UnsubscribeRequest> {
    public Request<UnsubscribeRequest> marshall(UnsubscribeRequest unsubscribeRequest) {
        if (unsubscribeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<UnsubscribeRequest> defaultRequest = new DefaultRequest(unsubscribeRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "Unsubscribe");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (unsubscribeRequest.getSubscriptionArn() != null) {
            defaultRequest.addParameter("SubscriptionArn", StringUtils.fromString(unsubscribeRequest.getSubscriptionArn()));
        }
        return defaultRequest;
    }
}
