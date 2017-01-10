package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.GetIdentityDkimAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetIdentityDkimAttributesRequestMarshaller implements Marshaller<Request<GetIdentityDkimAttributesRequest>, GetIdentityDkimAttributesRequest> {
    public Request<GetIdentityDkimAttributesRequest> marshall(GetIdentityDkimAttributesRequest getIdentityDkimAttributesRequest) {
        if (getIdentityDkimAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetIdentityDkimAttributesRequest> defaultRequest = new DefaultRequest(getIdentityDkimAttributesRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "GetIdentityDkimAttributes");
        defaultRequest.addParameter("Version", "2010-12-01");
        int i = 1;
        for (String str : getIdentityDkimAttributesRequest.getIdentities()) {
            if (str != null) {
                defaultRequest.addParameter("Identities.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
