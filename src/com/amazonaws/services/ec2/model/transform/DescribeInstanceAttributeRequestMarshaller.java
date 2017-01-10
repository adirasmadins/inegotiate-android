package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeInstanceAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeInstanceAttributeRequestMarshaller implements Marshaller<Request<DescribeInstanceAttributeRequest>, DescribeInstanceAttributeRequest> {
    public Request<DescribeInstanceAttributeRequest> marshall(DescribeInstanceAttributeRequest describeInstanceAttributeRequest) {
        if (describeInstanceAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeInstanceAttributeRequest> defaultRequest = new DefaultRequest(describeInstanceAttributeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeInstanceAttribute");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (describeInstanceAttributeRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(describeInstanceAttributeRequest.getInstanceId()));
        }
        if (describeInstanceAttributeRequest.getAttribute() != null) {
            defaultRequest.addParameter("Attribute", StringUtils.fromString(describeInstanceAttributeRequest.getAttribute()));
        }
        return defaultRequest;
    }
}
