package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateDomainRequestMarshaller implements Marshaller<Request<CreateDomainRequest>, CreateDomainRequest> {
    public Request<CreateDomainRequest> marshall(CreateDomainRequest createDomainRequest) {
        if (createDomainRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateDomainRequest> defaultRequest = new DefaultRequest(createDomainRequest, "AmazonSimpleDB");
        defaultRequest.addParameter("Action", "CreateDomain");
        defaultRequest.addParameter("Version", "2009-04-15");
        if (createDomainRequest.getDomainName() != null) {
            defaultRequest.addParameter("DomainName", StringUtils.fromString(createDomainRequest.getDomainName()));
        }
        return defaultRequest;
    }
}
