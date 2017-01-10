package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.VerifyDomainDkimRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class VerifyDomainDkimRequestMarshaller implements Marshaller<Request<VerifyDomainDkimRequest>, VerifyDomainDkimRequest> {
    public Request<VerifyDomainDkimRequest> marshall(VerifyDomainDkimRequest verifyDomainDkimRequest) {
        if (verifyDomainDkimRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<VerifyDomainDkimRequest> defaultRequest = new DefaultRequest(verifyDomainDkimRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "VerifyDomainDkim");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (verifyDomainDkimRequest.getDomain() != null) {
            defaultRequest.addParameter("Domain", StringUtils.fromString(verifyDomainDkimRequest.getDomain()));
        }
        return defaultRequest;
    }
}
