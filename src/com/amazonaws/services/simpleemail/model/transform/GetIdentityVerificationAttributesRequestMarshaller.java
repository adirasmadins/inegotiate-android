package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.GetIdentityVerificationAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetIdentityVerificationAttributesRequestMarshaller implements Marshaller<Request<GetIdentityVerificationAttributesRequest>, GetIdentityVerificationAttributesRequest> {
    public Request<GetIdentityVerificationAttributesRequest> marshall(GetIdentityVerificationAttributesRequest getIdentityVerificationAttributesRequest) {
        if (getIdentityVerificationAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetIdentityVerificationAttributesRequest> defaultRequest = new DefaultRequest(getIdentityVerificationAttributesRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "GetIdentityVerificationAttributes");
        defaultRequest.addParameter("Version", "2010-12-01");
        int i = 1;
        for (String str : getIdentityVerificationAttributesRequest.getIdentities()) {
            if (str != null) {
                defaultRequest.addParameter("Identities.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
