package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.ResetImageAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ResetImageAttributeRequestMarshaller implements Marshaller<Request<ResetImageAttributeRequest>, ResetImageAttributeRequest> {
    public Request<ResetImageAttributeRequest> marshall(ResetImageAttributeRequest resetImageAttributeRequest) {
        if (resetImageAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ResetImageAttributeRequest> defaultRequest = new DefaultRequest(resetImageAttributeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ResetImageAttribute");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (resetImageAttributeRequest.getImageId() != null) {
            defaultRequest.addParameter("ImageId", StringUtils.fromString(resetImageAttributeRequest.getImageId()));
        }
        if (resetImageAttributeRequest.getAttribute() != null) {
            defaultRequest.addParameter("Attribute", StringUtils.fromString(resetImageAttributeRequest.getAttribute()));
        }
        return defaultRequest;
    }
}
