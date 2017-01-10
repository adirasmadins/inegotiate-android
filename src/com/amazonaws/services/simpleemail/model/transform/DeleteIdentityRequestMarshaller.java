package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.DeleteIdentityRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteIdentityRequestMarshaller implements Marshaller<Request<DeleteIdentityRequest>, DeleteIdentityRequest> {
    public Request<DeleteIdentityRequest> marshall(DeleteIdentityRequest deleteIdentityRequest) {
        if (deleteIdentityRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteIdentityRequest> defaultRequest = new DefaultRequest(deleteIdentityRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "DeleteIdentity");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (deleteIdentityRequest.getIdentity() != null) {
            defaultRequest.addParameter("Identity", StringUtils.fromString(deleteIdentityRequest.getIdentity()));
        }
        return defaultRequest;
    }
}
