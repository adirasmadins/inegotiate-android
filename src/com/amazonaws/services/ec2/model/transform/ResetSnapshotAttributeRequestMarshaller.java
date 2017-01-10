package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.ResetSnapshotAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ResetSnapshotAttributeRequestMarshaller implements Marshaller<Request<ResetSnapshotAttributeRequest>, ResetSnapshotAttributeRequest> {
    public Request<ResetSnapshotAttributeRequest> marshall(ResetSnapshotAttributeRequest resetSnapshotAttributeRequest) {
        if (resetSnapshotAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ResetSnapshotAttributeRequest> defaultRequest = new DefaultRequest(resetSnapshotAttributeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ResetSnapshotAttribute");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (resetSnapshotAttributeRequest.getSnapshotId() != null) {
            defaultRequest.addParameter("SnapshotId", StringUtils.fromString(resetSnapshotAttributeRequest.getSnapshotId()));
        }
        if (resetSnapshotAttributeRequest.getAttribute() != null) {
            defaultRequest.addParameter("Attribute", StringUtils.fromString(resetSnapshotAttributeRequest.getAttribute()));
        }
        return defaultRequest;
    }
}
