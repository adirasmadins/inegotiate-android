package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeSnapshotAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeSnapshotAttributeRequestMarshaller implements Marshaller<Request<DescribeSnapshotAttributeRequest>, DescribeSnapshotAttributeRequest> {
    public Request<DescribeSnapshotAttributeRequest> marshall(DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest) {
        if (describeSnapshotAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeSnapshotAttributeRequest> defaultRequest = new DefaultRequest(describeSnapshotAttributeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeSnapshotAttribute");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (describeSnapshotAttributeRequest.getSnapshotId() != null) {
            defaultRequest.addParameter("SnapshotId", StringUtils.fromString(describeSnapshotAttributeRequest.getSnapshotId()));
        }
        if (describeSnapshotAttributeRequest.getAttribute() != null) {
            defaultRequest.addParameter("Attribute", StringUtils.fromString(describeSnapshotAttributeRequest.getAttribute()));
        }
        return defaultRequest;
    }
}
