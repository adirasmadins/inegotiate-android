package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ListQueuesRequestMarshaller implements Marshaller<Request<ListQueuesRequest>, ListQueuesRequest> {
    public Request<ListQueuesRequest> marshall(ListQueuesRequest listQueuesRequest) {
        if (listQueuesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ListQueuesRequest> defaultRequest = new DefaultRequest(listQueuesRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "ListQueues");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (listQueuesRequest.getQueueNamePrefix() != null) {
            defaultRequest.addParameter("QueueNamePrefix", StringUtils.fromString(listQueuesRequest.getQueueNamePrefix()));
        }
        return defaultRequest;
    }
}
