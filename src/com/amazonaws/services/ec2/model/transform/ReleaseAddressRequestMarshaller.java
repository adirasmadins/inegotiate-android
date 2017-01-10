package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.ReleaseAddressRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ReleaseAddressRequestMarshaller implements Marshaller<Request<ReleaseAddressRequest>, ReleaseAddressRequest> {
    public Request<ReleaseAddressRequest> marshall(ReleaseAddressRequest releaseAddressRequest) {
        if (releaseAddressRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ReleaseAddressRequest> defaultRequest = new DefaultRequest(releaseAddressRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ReleaseAddress");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (releaseAddressRequest.getPublicIp() != null) {
            defaultRequest.addParameter("PublicIp", StringUtils.fromString(releaseAddressRequest.getPublicIp()));
        }
        if (releaseAddressRequest.getAllocationId() != null) {
            defaultRequest.addParameter("AllocationId", StringUtils.fromString(releaseAddressRequest.getAllocationId()));
        }
        return defaultRequest;
    }
}
