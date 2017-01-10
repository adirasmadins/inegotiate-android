package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.DeleteTopicRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteTopicRequestMarshaller implements Marshaller<Request<DeleteTopicRequest>, DeleteTopicRequest> {
    public Request<DeleteTopicRequest> marshall(DeleteTopicRequest deleteTopicRequest) {
        if (deleteTopicRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteTopicRequest> defaultRequest = new DefaultRequest(deleteTopicRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "DeleteTopic");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (deleteTopicRequest.getTopicArn() != null) {
            defaultRequest.addParameter("TopicArn", StringUtils.fromString(deleteTopicRequest.getTopicArn()));
        }
        return defaultRequest;
    }
}
