package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpledb.model.DeleteDomainRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteDomainRequestMarshaller implements Marshaller<Request<DeleteDomainRequest>, DeleteDomainRequest> {
    public Request<DeleteDomainRequest> marshall(DeleteDomainRequest deleteDomainRequest) {
        if (deleteDomainRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteDomainRequest> defaultRequest = new DefaultRequest(deleteDomainRequest, "AmazonSimpleDB");
        defaultRequest.addParameter("Action", "DeleteDomain");
        defaultRequest.addParameter("Version", "2009-04-15");
        if (deleteDomainRequest.getDomainName() != null) {
            defaultRequest.addParameter("DomainName", StringUtils.fromString(deleteDomainRequest.getDomainName()));
        }
        return defaultRequest;
    }
}
