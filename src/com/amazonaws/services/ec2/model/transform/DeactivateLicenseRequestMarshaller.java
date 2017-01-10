package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DeactivateLicenseRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeactivateLicenseRequestMarshaller implements Marshaller<Request<DeactivateLicenseRequest>, DeactivateLicenseRequest> {
    public Request<DeactivateLicenseRequest> marshall(DeactivateLicenseRequest deactivateLicenseRequest) {
        if (deactivateLicenseRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeactivateLicenseRequest> defaultRequest = new DefaultRequest(deactivateLicenseRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DeactivateLicense");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (deactivateLicenseRequest.getLicenseId() != null) {
            defaultRequest.addParameter("LicenseId", StringUtils.fromString(deactivateLicenseRequest.getLicenseId()));
        }
        if (deactivateLicenseRequest.getCapacity() != null) {
            defaultRequest.addParameter("Capacity", StringUtils.fromInteger(deactivateLicenseRequest.getCapacity()));
        }
        return defaultRequest;
    }
}
