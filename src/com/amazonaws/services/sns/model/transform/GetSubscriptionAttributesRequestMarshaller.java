package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetSubscriptionAttributesRequestMarshaller implements Marshaller<Request<GetSubscriptionAttributesRequest>, GetSubscriptionAttributesRequest> {
    public Request<GetSubscriptionAttributesRequest> marshall(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) {
        if (getSubscriptionAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetSubscriptionAttributesRequest> defaultRequest = new DefaultRequest(getSubscriptionAttributesRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "GetSubscriptionAttributes");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (getSubscriptionAttributesRequest.getSubscriptionArn() != null) {
            defaultRequest.addParameter("SubscriptionArn", StringUtils.fromString(getSubscriptionAttributesRequest.getSubscriptionArn()));
        }
        return defaultRequest;
    }
}
