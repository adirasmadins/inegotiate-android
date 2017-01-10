package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import java.util.Map.Entry;

public class CreateQueueRequestMarshaller implements Marshaller<Request<CreateQueueRequest>, CreateQueueRequest> {
    public Request<CreateQueueRequest> marshall(CreateQueueRequest createQueueRequest) {
        if (createQueueRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateQueueRequest> defaultRequest = new DefaultRequest(createQueueRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "CreateQueue");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (createQueueRequest.getQueueName() != null) {
            defaultRequest.addParameter("QueueName", StringUtils.fromString(createQueueRequest.getQueueName()));
        }
        if (!(createQueueRequest == null || createQueueRequest.getAttributes() == null)) {
            int i = 1;
            for (Entry entry : createQueueRequest.getAttributes().entrySet()) {
                if (entry.getKey() != null) {
                    defaultRequest.addParameter("Attribute." + i + ".Name", StringUtils.fromString((String) entry.getKey()));
                }
                if (entry.getValue() != null) {
                    defaultRequest.addParameter("Attribute." + i + ".Value", StringUtils.fromString((String) entry.getValue()));
                }
                i++;
            }
        }
        return defaultRequest;
    }
}
