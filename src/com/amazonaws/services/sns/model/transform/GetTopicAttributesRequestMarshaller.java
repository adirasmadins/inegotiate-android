package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.GetTopicAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetTopicAttributesRequestMarshaller implements Marshaller<Request<GetTopicAttributesRequest>, GetTopicAttributesRequest> {
    public Request<GetTopicAttributesRequest> marshall(GetTopicAttributesRequest getTopicAttributesRequest) {
        if (getTopicAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetTopicAttributesRequest> defaultRequest = new DefaultRequest(getTopicAttributesRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "GetTopicAttributes");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (getTopicAttributesRequest.getTopicArn() != null) {
            defaultRequest.addParameter("TopicArn", StringUtils.fromString(getTopicAttributesRequest.getTopicArn()));
        }
        return defaultRequest;
    }
}
