package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DeleteSnapshotRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteSnapshotRequestMarshaller implements Marshaller<Request<DeleteSnapshotRequest>, DeleteSnapshotRequest> {
    public Request<DeleteSnapshotRequest> marshall(DeleteSnapshotRequest deleteSnapshotRequest) {
        if (deleteSnapshotRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteSnapshotRequest> defaultRequest = new DefaultRequest(deleteSnapshotRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DeleteSnapshot");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (deleteSnapshotRequest.getSnapshotId() != null) {
            defaultRequest.addParameter("SnapshotId", StringUtils.fromString(deleteSnapshotRequest.getSnapshotId()));
        }
        return defaultRequest;
    }
}
