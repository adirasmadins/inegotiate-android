package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetQueueAttributesRequestMarshaller implements Marshaller<Request<GetQueueAttributesRequest>, GetQueueAttributesRequest> {
    public Request<GetQueueAttributesRequest> marshall(GetQueueAttributesRequest getQueueAttributesRequest) {
        if (getQueueAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetQueueAttributesRequest> defaultRequest = new DefaultRequest(getQueueAttributesRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "GetQueueAttributes");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (getQueueAttributesRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(getQueueAttributesRequest.getQueueUrl()));
        }
        int i = 1;
        for (String str : getQueueAttributesRequest.getAttributeNames()) {
            if (str != null) {
                defaultRequest.addParameter("AttributeName." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
