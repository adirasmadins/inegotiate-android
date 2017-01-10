package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.ListTopicsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ListTopicsRequestMarshaller implements Marshaller<Request<ListTopicsRequest>, ListTopicsRequest> {
    public Request<ListTopicsRequest> marshall(ListTopicsRequest listTopicsRequest) {
        if (listTopicsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ListTopicsRequest> defaultRequest = new DefaultRequest(listTopicsRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "ListTopics");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (listTopicsRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(listTopicsRequest.getNextToken()));
        }
        return defaultRequest;
    }
}
