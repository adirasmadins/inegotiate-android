package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateTopicRequestMarshaller implements Marshaller<Request<CreateTopicRequest>, CreateTopicRequest> {
    public Request<CreateTopicRequest> marshall(CreateTopicRequest createTopicRequest) {
        if (createTopicRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateTopicRequest> defaultRequest = new DefaultRequest(createTopicRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "CreateTopic");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (createTopicRequest.getName() != null) {
            defaultRequest.addParameter("Name", StringUtils.fromString(createTopicRequest.getName()));
        }
        return defaultRequest;
    }
}
