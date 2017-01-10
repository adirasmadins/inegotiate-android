package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.ResetInstanceAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ResetInstanceAttributeRequestMarshaller implements Marshaller<Request<ResetInstanceAttributeRequest>, ResetInstanceAttributeRequest> {
    public Request<ResetInstanceAttributeRequest> marshall(ResetInstanceAttributeRequest resetInstanceAttributeRequest) {
        if (resetInstanceAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ResetInstanceAttributeRequest> defaultRequest = new DefaultRequest(resetInstanceAttributeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ResetInstanceAttribute");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (resetInstanceAttributeRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(resetInstanceAttributeRequest.getInstanceId()));
        }
        if (resetInstanceAttributeRequest.getAttribute() != null) {
            defaultRequest.addParameter("Attribute", StringUtils.fromString(resetInstanceAttributeRequest.getAttribute()));
        }
        return defaultRequest;
    }
}
