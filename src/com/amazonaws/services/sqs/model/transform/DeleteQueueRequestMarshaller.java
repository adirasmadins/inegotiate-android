package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteQueueRequestMarshaller implements Marshaller<Request<DeleteQueueRequest>, DeleteQueueRequest> {
    public Request<DeleteQueueRequest> marshall(DeleteQueueRequest deleteQueueRequest) {
        if (deleteQueueRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteQueueRequest> defaultRequest = new DefaultRequest(deleteQueueRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "DeleteQueue");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (deleteQueueRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(deleteQueueRequest.getQueueUrl()));
        }
        return defaultRequest;
    }
}
