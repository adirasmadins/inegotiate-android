package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.VerifyDomainIdentityRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class VerifyDomainIdentityRequestMarshaller implements Marshaller<Request<VerifyDomainIdentityRequest>, VerifyDomainIdentityRequest> {
    public Request<VerifyDomainIdentityRequest> marshall(VerifyDomainIdentityRequest verifyDomainIdentityRequest) {
        if (verifyDomainIdentityRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<VerifyDomainIdentityRequest> defaultRequest = new DefaultRequest(verifyDomainIdentityRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "VerifyDomainIdentity");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (verifyDomainIdentityRequest.getDomain() != null) {
            defaultRequest.addParameter("Domain", StringUtils.fromString(verifyDomainIdentityRequest.getDomain()));
        }
        return defaultRequest;
    }
}
