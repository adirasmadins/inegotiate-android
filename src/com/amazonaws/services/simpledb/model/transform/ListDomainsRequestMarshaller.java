package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpledb.model.ListDomainsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ListDomainsRequestMarshaller implements Marshaller<Request<ListDomainsRequest>, ListDomainsRequest> {
    public Request<ListDomainsRequest> marshall(ListDomainsRequest listDomainsRequest) {
        if (listDomainsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ListDomainsRequest> defaultRequest = new DefaultRequest(listDomainsRequest, "AmazonSimpleDB");
        defaultRequest.addParameter("Action", "ListDomains");
        defaultRequest.addParameter("Version", "2009-04-15");
        if (listDomainsRequest.getMaxNumberOfDomains() != null) {
            defaultRequest.addParameter("MaxNumberOfDomains", StringUtils.fromInteger(listDomainsRequest.getMaxNumberOfDomains()));
        }
        if (listDomainsRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(listDomainsRequest.getNextToken()));
        }
        return defaultRequest;
    }
}
