package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CreateSnapshotRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateSnapshotRequestMarshaller implements Marshaller<Request<CreateSnapshotRequest>, CreateSnapshotRequest> {
    public Request<CreateSnapshotRequest> marshall(CreateSnapshotRequest createSnapshotRequest) {
        if (createSnapshotRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateSnapshotRequest> defaultRequest = new DefaultRequest(createSnapshotRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CreateSnapshot");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (createSnapshotRequest.getVolumeId() != null) {
            defaultRequest.addParameter("VolumeId", StringUtils.fromString(createSnapshotRequest.getVolumeId()));
        }
        if (createSnapshotRequest.getDescription() != null) {
            defaultRequest.addParameter("Description", StringUtils.fromString(createSnapshotRequest.getDescription()));
        }
        return defaultRequest;
    }
}
