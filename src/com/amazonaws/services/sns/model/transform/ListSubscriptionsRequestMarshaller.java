package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.ListSubscriptionsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ListSubscriptionsRequestMarshaller implements Marshaller<Request<ListSubscriptionsRequest>, ListSubscriptionsRequest> {
    public Request<ListSubscriptionsRequest> marshall(ListSubscriptionsRequest listSubscriptionsRequest) {
        if (listSubscriptionsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ListSubscriptionsRequest> defaultRequest = new DefaultRequest(listSubscriptionsRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "ListSubscriptions");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (listSubscriptionsRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(listSubscriptionsRequest.getNextToken()));
        }
        return defaultRequest;
    }
}
