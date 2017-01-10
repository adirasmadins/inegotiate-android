package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpledb.model.DomainMetadataRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DomainMetadataRequestMarshaller implements Marshaller<Request<DomainMetadataRequest>, DomainMetadataRequest> {
    public Request<DomainMetadataRequest> marshall(DomainMetadataRequest domainMetadataRequest) {
        if (domainMetadataRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DomainMetadataRequest> defaultRequest = new DefaultRequest(domainMetadataRequest, "AmazonSimpleDB");
        defaultRequest.addParameter("Action", "DomainMetadata");
        defaultRequest.addParameter("Version", "2009-04-15");
        if (domainMetadataRequest.getDomainName() != null) {
            defaultRequest.addParameter("DomainName", StringUtils.fromString(domainMetadataRequest.getDomainName()));
        }
        return defaultRequest;
    }
}
