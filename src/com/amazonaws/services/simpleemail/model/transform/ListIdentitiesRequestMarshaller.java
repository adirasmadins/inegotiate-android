package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.ListIdentitiesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ListIdentitiesRequestMarshaller implements Marshaller<Request<ListIdentitiesRequest>, ListIdentitiesRequest> {
    public Request<ListIdentitiesRequest> marshall(ListIdentitiesRequest listIdentitiesRequest) {
        if (listIdentitiesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ListIdentitiesRequest> defaultRequest = new DefaultRequest(listIdentitiesRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "ListIdentities");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (listIdentitiesRequest.getIdentityType() != null) {
            defaultRequest.addParameter("IdentityType", StringUtils.fromString(listIdentitiesRequest.getIdentityType()));
        }
        if (listIdentitiesRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(listIdentitiesRequest.getNextToken()));
        }
        if (listIdentitiesRequest.getMaxItems() != null) {
            defaultRequest.addParameter("MaxItems", StringUtils.fromInteger(listIdentitiesRequest.getMaxItems()));
        }
        return defaultRequest;
    }
}
