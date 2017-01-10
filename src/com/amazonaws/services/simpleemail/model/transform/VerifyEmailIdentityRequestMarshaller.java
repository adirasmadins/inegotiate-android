package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.VerifyEmailIdentityRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class VerifyEmailIdentityRequestMarshaller implements Marshaller<Request<VerifyEmailIdentityRequest>, VerifyEmailIdentityRequest> {
    public Request<VerifyEmailIdentityRequest> marshall(VerifyEmailIdentityRequest verifyEmailIdentityRequest) {
        if (verifyEmailIdentityRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<VerifyEmailIdentityRequest> defaultRequest = new DefaultRequest(verifyEmailIdentityRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "VerifyEmailIdentity");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (verifyEmailIdentityRequest.getEmailAddress() != null) {
            defaultRequest.addParameter("EmailAddress", StringUtils.fromString(verifyEmailIdentityRequest.getEmailAddress()));
        }
        return defaultRequest;
    }
}
