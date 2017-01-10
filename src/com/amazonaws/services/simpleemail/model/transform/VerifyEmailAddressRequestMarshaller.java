package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.VerifyEmailAddressRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class VerifyEmailAddressRequestMarshaller implements Marshaller<Request<VerifyEmailAddressRequest>, VerifyEmailAddressRequest> {
    public Request<VerifyEmailAddressRequest> marshall(VerifyEmailAddressRequest verifyEmailAddressRequest) {
        if (verifyEmailAddressRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<VerifyEmailAddressRequest> defaultRequest = new DefaultRequest(verifyEmailAddressRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "VerifyEmailAddress");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (verifyEmailAddressRequest.getEmailAddress() != null) {
            defaultRequest.addParameter("EmailAddress", StringUtils.fromString(verifyEmailAddressRequest.getEmailAddress()));
        }
        return defaultRequest;
    }
}
