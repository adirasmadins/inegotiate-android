package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DetachVolumeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DetachVolumeRequestMarshaller implements Marshaller<Request<DetachVolumeRequest>, DetachVolumeRequest> {
    public Request<DetachVolumeRequest> marshall(DetachVolumeRequest detachVolumeRequest) {
        if (detachVolumeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DetachVolumeRequest> defaultRequest = new DefaultRequest(detachVolumeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DetachVolume");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (detachVolumeRequest.getVolumeId() != null) {
            defaultRequest.addParameter("VolumeId", StringUtils.fromString(detachVolumeRequest.getVolumeId()));
        }
        if (detachVolumeRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(detachVolumeRequest.getInstanceId()));
        }
        if (detachVolumeRequest.getDevice() != null) {
            defaultRequest.addParameter("Device", StringUtils.fromString(detachVolumeRequest.getDevice()));
        }
        if (detachVolumeRequest.isForce() != null) {
            defaultRequest.addParameter("Force", StringUtils.fromBoolean(detachVolumeRequest.isForce()));
        }
        return defaultRequest;
    }
}
