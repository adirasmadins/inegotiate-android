package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.GetIdentityNotificationAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetIdentityNotificationAttributesRequestMarshaller implements Marshaller<Request<GetIdentityNotificationAttributesRequest>, GetIdentityNotificationAttributesRequest> {
    public Request<GetIdentityNotificationAttributesRequest> marshall(GetIdentityNotificationAttributesRequest getIdentityNotificationAttributesRequest) {
        if (getIdentityNotificationAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetIdentityNotificationAttributesRequest> defaultRequest = new DefaultRequest(getIdentityNotificationAttributesRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "GetIdentityNotificationAttributes");
        defaultRequest.addParameter("Version", "2010-12-01");
        int i = 1;
        for (String str : getIdentityNotificationAttributesRequest.getIdentities()) {
            if (str != null) {
                defaultRequest.addParameter("Identities.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
