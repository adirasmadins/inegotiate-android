package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeVolumeAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeVolumeAttributeRequestMarshaller implements Marshaller<Request<DescribeVolumeAttributeRequest>, DescribeVolumeAttributeRequest> {
    public Request<DescribeVolumeAttributeRequest> marshall(DescribeVolumeAttributeRequest describeVolumeAttributeRequest) {
        if (describeVolumeAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeVolumeAttributeRequest> defaultRequest = new DefaultRequest(describeVolumeAttributeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeVolumeAttribute");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (describeVolumeAttributeRequest.getVolumeId() != null) {
            defaultRequest.addParameter("VolumeId", StringUtils.fromString(describeVolumeAttributeRequest.getVolumeId()));
        }
        if (describeVolumeAttributeRequest.getAttribute() != null) {
            defaultRequest.addParameter("Attribute", StringUtils.fromString(describeVolumeAttributeRequest.getAttribute()));
        }
        return defaultRequest;
    }
}
