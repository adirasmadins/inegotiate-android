package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.SetTopicAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SetTopicAttributesRequestMarshaller implements Marshaller<Request<SetTopicAttributesRequest>, SetTopicAttributesRequest> {
    public Request<SetTopicAttributesRequest> marshall(SetTopicAttributesRequest setTopicAttributesRequest) {
        if (setTopicAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetTopicAttributesRequest> defaultRequest = new DefaultRequest(setTopicAttributesRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "SetTopicAttributes");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (setTopicAttributesRequest.getTopicArn() != null) {
            defaultRequest.addParameter("TopicArn", StringUtils.fromString(setTopicAttributesRequest.getTopicArn()));
        }
        if (setTopicAttributesRequest.getAttributeName() != null) {
            defaultRequest.addParameter("AttributeName", StringUtils.fromString(setTopicAttributesRequest.getAttributeName()));
        }
        if (setTopicAttributesRequest.getAttributeValue() != null) {
            defaultRequest.addParameter("AttributeValue", StringUtils.fromString(setTopicAttributesRequest.getAttributeValue()));
        }
        return defaultRequest;
    }
}
