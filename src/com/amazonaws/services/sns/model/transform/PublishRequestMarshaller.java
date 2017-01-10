package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class PublishRequestMarshaller implements Marshaller<Request<PublishRequest>, PublishRequest> {
    public Request<PublishRequest> marshall(PublishRequest publishRequest) {
        if (publishRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<PublishRequest> defaultRequest = new DefaultRequest(publishRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "Publish");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (publishRequest.getTopicArn() != null) {
            defaultRequest.addParameter("TopicArn", StringUtils.fromString(publishRequest.getTopicArn()));
        }
        if (publishRequest.getMessage() != null) {
            defaultRequest.addParameter("Message", StringUtils.fromString(publishRequest.getMessage()));
        }
        if (publishRequest.getSubject() != null) {
            defaultRequest.addParameter("Subject", StringUtils.fromString(publishRequest.getSubject()));
        }
        if (publishRequest.getMessageStructure() != null) {
            defaultRequest.addParameter("MessageStructure", StringUtils.fromString(publishRequest.getMessageStructure()));
        }
        return defaultRequest;
    }
}
