package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeImageAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeImageAttributeRequestMarshaller implements Marshaller<Request<DescribeImageAttributeRequest>, DescribeImageAttributeRequest> {
    public Request<DescribeImageAttributeRequest> marshall(DescribeImageAttributeRequest describeImageAttributeRequest) {
        if (describeImageAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeImageAttributeRequest> defaultRequest = new DefaultRequest(describeImageAttributeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeImageAttribute");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (describeImageAttributeRequest.getImageId() != null) {
            defaultRequest.addParameter("ImageId", StringUtils.fromString(describeImageAttributeRequest.getImageId()));
        }
        if (describeImageAttributeRequest.getAttribute() != null) {
            defaultRequest.addParameter("Attribute", StringUtils.fromString(describeImageAttributeRequest.getAttribute()));
        }
        return defaultRequest;
    }
}
