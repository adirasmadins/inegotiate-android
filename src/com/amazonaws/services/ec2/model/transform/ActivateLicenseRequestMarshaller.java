package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.ActivateLicenseRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ActivateLicenseRequestMarshaller implements Marshaller<Request<ActivateLicenseRequest>, ActivateLicenseRequest> {
    public Request<ActivateLicenseRequest> marshall(ActivateLicenseRequest activateLicenseRequest) {
        if (activateLicenseRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ActivateLicenseRequest> defaultRequest = new DefaultRequest(activateLicenseRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ActivateLicense");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (activateLicenseRequest.getLicenseId() != null) {
            defaultRequest.addParameter("LicenseId", StringUtils.fromString(activateLicenseRequest.getLicenseId()));
        }
        if (activateLicenseRequest.getCapacity() != null) {
            defaultRequest.addParameter("Capacity", StringUtils.fromInteger(activateLicenseRequest.getCapacity()));
        }
        return defaultRequest;
    }
}
