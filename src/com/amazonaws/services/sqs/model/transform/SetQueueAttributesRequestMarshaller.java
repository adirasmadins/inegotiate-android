package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import java.util.Map.Entry;

public class SetQueueAttributesRequestMarshaller implements Marshaller<Request<SetQueueAttributesRequest>, SetQueueAttributesRequest> {
    public Request<SetQueueAttributesRequest> marshall(SetQueueAttributesRequest setQueueAttributesRequest) {
        if (setQueueAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetQueueAttributesRequest> defaultRequest = new DefaultRequest(setQueueAttributesRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "SetQueueAttributes");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (setQueueAttributesRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(setQueueAttributesRequest.getQueueUrl()));
        }
        if (!(setQueueAttributesRequest == null || setQueueAttributesRequest.getAttributes() == null)) {
            int i = 1;
            for (Entry entry : setQueueAttributesRequest.getAttributes().entrySet()) {
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
