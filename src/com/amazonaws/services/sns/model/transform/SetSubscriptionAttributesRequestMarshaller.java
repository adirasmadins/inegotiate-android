package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.SetSubscriptionAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SetSubscriptionAttributesRequestMarshaller implements Marshaller<Request<SetSubscriptionAttributesRequest>, SetSubscriptionAttributesRequest> {
    public Request<SetSubscriptionAttributesRequest> marshall(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) {
        if (setSubscriptionAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetSubscriptionAttributesRequest> defaultRequest = new DefaultRequest(setSubscriptionAttributesRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "SetSubscriptionAttributes");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (setSubscriptionAttributesRequest.getSubscriptionArn() != null) {
            defaultRequest.addParameter("SubscriptionArn", StringUtils.fromString(setSubscriptionAttributesRequest.getSubscriptionArn()));
        }
        if (setSubscriptionAttributesRequest.getAttributeName() != null) {
            defaultRequest.addParameter("AttributeName", StringUtils.fromString(setSubscriptionAttributesRequest.getAttributeName()));
        }
        if (setSubscriptionAttributesRequest.getAttributeValue() != null) {
            defaultRequest.addParameter("AttributeValue", StringUtils.fromString(setSubscriptionAttributesRequest.getAttributeValue()));
        }
        return defaultRequest;
    }
}
