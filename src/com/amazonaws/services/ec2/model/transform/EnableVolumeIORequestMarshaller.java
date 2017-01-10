package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.EnableVolumeIORequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class EnableVolumeIORequestMarshaller implements Marshaller<Request<EnableVolumeIORequest>, EnableVolumeIORequest> {
    public Request<EnableVolumeIORequest> marshall(EnableVolumeIORequest enableVolumeIORequest) {
        if (enableVolumeIORequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<EnableVolumeIORequest> defaultRequest = new DefaultRequest(enableVolumeIORequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "EnableVolumeIO");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (enableVolumeIORequest.getVolumeId() != null) {
            defaultRequest.addParameter("VolumeId", StringUtils.fromString(enableVolumeIORequest.getVolumeId()));
        }
        return defaultRequest;
    }
}
