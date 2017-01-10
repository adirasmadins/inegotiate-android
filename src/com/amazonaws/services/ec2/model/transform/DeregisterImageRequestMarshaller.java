package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DeregisterImageRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeregisterImageRequestMarshaller implements Marshaller<Request<DeregisterImageRequest>, DeregisterImageRequest> {
    public Request<DeregisterImageRequest> marshall(DeregisterImageRequest deregisterImageRequest) {
        if (deregisterImageRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeregisterImageRequest> defaultRequest = new DefaultRequest(deregisterImageRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DeregisterImage");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (deregisterImageRequest.getImageId() != null) {
            defaultRequest.addParameter("ImageId", StringUtils.fromString(deregisterImageRequest.getImageId()));
        }
        return defaultRequest;
    }
}
