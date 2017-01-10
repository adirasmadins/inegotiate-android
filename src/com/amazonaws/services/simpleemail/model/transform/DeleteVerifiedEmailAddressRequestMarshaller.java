package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.DeleteVerifiedEmailAddressRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteVerifiedEmailAddressRequestMarshaller implements Marshaller<Request<DeleteVerifiedEmailAddressRequest>, DeleteVerifiedEmailAddressRequest> {
    public Request<DeleteVerifiedEmailAddressRequest> marshall(DeleteVerifiedEmailAddressRequest deleteVerifiedEmailAddressRequest) {
        if (deleteVerifiedEmailAddressRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteVerifiedEmailAddressRequest> defaultRequest = new DefaultRequest(deleteVerifiedEmailAddressRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "DeleteVerifiedEmailAddress");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (deleteVerifiedEmailAddressRequest.getEmailAddress() != null) {
            defaultRequest.addParameter("EmailAddress", StringUtils.fromString(deleteVerifiedEmailAddressRequest.getEmailAddress()));
        }
        return defaultRequest;
    }
}
