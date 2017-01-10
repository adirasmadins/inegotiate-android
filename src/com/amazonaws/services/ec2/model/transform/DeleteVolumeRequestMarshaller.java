package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DeleteVolumeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteVolumeRequestMarshaller implements Marshaller<Request<DeleteVolumeRequest>, DeleteVolumeRequest> {
    public Request<DeleteVolumeRequest> marshall(DeleteVolumeRequest deleteVolumeRequest) {
        if (deleteVolumeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteVolumeRequest> defaultRequest = new DefaultRequest(deleteVolumeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DeleteVolume");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (deleteVolumeRequest.getVolumeId() != null) {
            defaultRequest.addParameter("VolumeId", StringUtils.fromString(deleteVolumeRequest.getVolumeId()));
        }
        return defaultRequest;
    }
}
