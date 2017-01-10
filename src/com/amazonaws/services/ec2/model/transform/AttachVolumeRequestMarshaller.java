package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.AttachVolumeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class AttachVolumeRequestMarshaller implements Marshaller<Request<AttachVolumeRequest>, AttachVolumeRequest> {
    public Request<AttachVolumeRequest> marshall(AttachVolumeRequest attachVolumeRequest) {
        if (attachVolumeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<AttachVolumeRequest> defaultRequest = new DefaultRequest(attachVolumeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "AttachVolume");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (attachVolumeRequest.getVolumeId() != null) {
            defaultRequest.addParameter("VolumeId", StringUtils.fromString(attachVolumeRequest.getVolumeId()));
        }
        if (attachVolumeRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(attachVolumeRequest.getInstanceId()));
        }
        if (attachVolumeRequest.getDevice() != null) {
            defaultRequest.addParameter("Device", StringUtils.fromString(attachVolumeRequest.getDevice()));
        }
        return defaultRequest;
    }
}
