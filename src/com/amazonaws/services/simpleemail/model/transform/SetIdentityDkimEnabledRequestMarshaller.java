package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.SetIdentityDkimEnabledRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SetIdentityDkimEnabledRequestMarshaller implements Marshaller<Request<SetIdentityDkimEnabledRequest>, SetIdentityDkimEnabledRequest> {
    public Request<SetIdentityDkimEnabledRequest> marshall(SetIdentityDkimEnabledRequest setIdentityDkimEnabledRequest) {
        if (setIdentityDkimEnabledRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetIdentityDkimEnabledRequest> defaultRequest = new DefaultRequest(setIdentityDkimEnabledRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "SetIdentityDkimEnabled");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (setIdentityDkimEnabledRequest.getIdentity() != null) {
            defaultRequest.addParameter("Identity", StringUtils.fromString(setIdentityDkimEnabledRequest.getIdentity()));
        }
        if (setIdentityDkimEnabledRequest.isDkimEnabled() != null) {
            defaultRequest.addParameter("DkimEnabled", StringUtils.fromBoolean(setIdentityDkimEnabledRequest.isDkimEnabled()));
        }
        return defaultRequest;
    }
}
