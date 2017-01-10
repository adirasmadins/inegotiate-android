package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.GetPasswordDataRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetPasswordDataRequestMarshaller implements Marshaller<Request<GetPasswordDataRequest>, GetPasswordDataRequest> {
    public Request<GetPasswordDataRequest> marshall(GetPasswordDataRequest getPasswordDataRequest) {
        if (getPasswordDataRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetPasswordDataRequest> defaultRequest = new DefaultRequest(getPasswordDataRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "GetPasswordData");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (getPasswordDataRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(getPasswordDataRequest.getInstanceId()));
        }
        return defaultRequest;
    }
}
