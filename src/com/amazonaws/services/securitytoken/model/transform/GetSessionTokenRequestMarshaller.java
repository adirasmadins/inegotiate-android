package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetSessionTokenRequestMarshaller implements Marshaller<Request<GetSessionTokenRequest>, GetSessionTokenRequest> {
    public Request<GetSessionTokenRequest> marshall(GetSessionTokenRequest getSessionTokenRequest) {
        if (getSessionTokenRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetSessionTokenRequest> defaultRequest = new DefaultRequest(getSessionTokenRequest, "AWSSecurityTokenService");
        defaultRequest.addParameter("Action", "GetSessionToken");
        defaultRequest.addParameter("Version", "2011-06-15");
        if (getSessionTokenRequest.getDurationSeconds() != null) {
            defaultRequest.addParameter("DurationSeconds", StringUtils.fromInteger(getSessionTokenRequest.getDurationSeconds()));
        }
        if (getSessionTokenRequest.getSerialNumber() != null) {
            defaultRequest.addParameter("SerialNumber", StringUtils.fromString(getSessionTokenRequest.getSerialNumber()));
        }
        if (getSessionTokenRequest.getTokenCode() != null) {
            defaultRequest.addParameter("TokenCode", StringUtils.fromString(getSessionTokenRequest.getTokenCode()));
        }
        return defaultRequest;
    }
}
