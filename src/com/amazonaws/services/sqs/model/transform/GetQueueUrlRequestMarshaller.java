package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetQueueUrlRequestMarshaller implements Marshaller<Request<GetQueueUrlRequest>, GetQueueUrlRequest> {
    public Request<GetQueueUrlRequest> marshall(GetQueueUrlRequest getQueueUrlRequest) {
        if (getQueueUrlRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetQueueUrlRequest> defaultRequest = new DefaultRequest(getQueueUrlRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "GetQueueUrl");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (getQueueUrlRequest.getQueueName() != null) {
            defaultRequest.addParameter("QueueName", StringUtils.fromString(getQueueUrlRequest.getQueueName()));
        }
        if (getQueueUrlRequest.getQueueOwnerAWSAccountId() != null) {
            defaultRequest.addParameter("QueueOwnerAWSAccountId", StringUtils.fromString(getQueueUrlRequest.getQueueOwnerAWSAccountId()));
        }
        return defaultRequest;
    }
}
