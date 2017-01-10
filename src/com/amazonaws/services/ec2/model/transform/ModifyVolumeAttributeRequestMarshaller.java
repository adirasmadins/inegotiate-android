package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.ModifyVolumeAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ModifyVolumeAttributeRequestMarshaller implements Marshaller<Request<ModifyVolumeAttributeRequest>, ModifyVolumeAttributeRequest> {
    public Request<ModifyVolumeAttributeRequest> marshall(ModifyVolumeAttributeRequest modifyVolumeAttributeRequest) {
        if (modifyVolumeAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ModifyVolumeAttributeRequest> defaultRequest = new DefaultRequest(modifyVolumeAttributeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ModifyVolumeAttribute");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (modifyVolumeAttributeRequest.getVolumeId() != null) {
            defaultRequest.addParameter("VolumeId", StringUtils.fromString(modifyVolumeAttributeRequest.getVolumeId()));
        }
        if (modifyVolumeAttributeRequest.isAutoEnableIO() != null) {
            defaultRequest.addParameter("AutoEnableIO.Value", StringUtils.fromBoolean(modifyVolumeAttributeRequest.isAutoEnableIO()));
        }
        return defaultRequest;
    }
}
