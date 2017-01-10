package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CreateVolumeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateVolumeRequestMarshaller implements Marshaller<Request<CreateVolumeRequest>, CreateVolumeRequest> {
    public Request<CreateVolumeRequest> marshall(CreateVolumeRequest createVolumeRequest) {
        if (createVolumeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateVolumeRequest> defaultRequest = new DefaultRequest(createVolumeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CreateVolume");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (createVolumeRequest.getSize() != null) {
            defaultRequest.addParameter("Size", StringUtils.fromInteger(createVolumeRequest.getSize()));
        }
        if (createVolumeRequest.getSnapshotId() != null) {
            defaultRequest.addParameter("SnapshotId", StringUtils.fromString(createVolumeRequest.getSnapshotId()));
        }
        if (createVolumeRequest.getAvailabilityZone() != null) {
            defaultRequest.addParameter("AvailabilityZone", StringUtils.fromString(createVolumeRequest.getAvailabilityZone()));
        }
        if (createVolumeRequest.getVolumeType() != null) {
            defaultRequest.addParameter("VolumeType", StringUtils.fromString(createVolumeRequest.getVolumeType()));
        }
        if (createVolumeRequest.getIops() != null) {
            defaultRequest.addParameter("Iops", StringUtils.fromInteger(createVolumeRequest.getIops()));
        }
        return defaultRequest;
    }
}
