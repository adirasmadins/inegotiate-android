package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.SetIdentityFeedbackForwardingEnabledRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SetIdentityFeedbackForwardingEnabledRequestMarshaller implements Marshaller<Request<SetIdentityFeedbackForwardingEnabledRequest>, SetIdentityFeedbackForwardingEnabledRequest> {
    public Request<SetIdentityFeedbackForwardingEnabledRequest> marshall(SetIdentityFeedbackForwardingEnabledRequest setIdentityFeedbackForwardingEnabledRequest) {
        if (setIdentityFeedbackForwardingEnabledRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetIdentityFeedbackForwardingEnabledRequest> defaultRequest = new DefaultRequest(setIdentityFeedbackForwardingEnabledRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "SetIdentityFeedbackForwardingEnabled");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (setIdentityFeedbackForwardingEnabledRequest.getIdentity() != null) {
            defaultRequest.addParameter("Identity", StringUtils.fromString(setIdentityFeedbackForwardingEnabledRequest.getIdentity()));
        }
        if (setIdentityFeedbackForwardingEnabledRequest.isForwardingEnabled() != null) {
            defaultRequest.addParameter("ForwardingEnabled", StringUtils.fromBoolean(setIdentityFeedbackForwardingEnabledRequest.isForwardingEnabled()));
        }
        return defaultRequest;
    }
}
