package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CancelReservedInstancesListingRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CancelReservedInstancesListingRequestMarshaller implements Marshaller<Request<CancelReservedInstancesListingRequest>, CancelReservedInstancesListingRequest> {
    public Request<CancelReservedInstancesListingRequest> marshall(CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest) {
        if (cancelReservedInstancesListingRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CancelReservedInstancesListingRequest> defaultRequest = new DefaultRequest(cancelReservedInstancesListingRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CancelReservedInstancesListing");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (cancelReservedInstancesListingRequest.getReservedInstancesListingId() != null) {
            defaultRequest.addParameter("ReservedInstancesListingId", StringUtils.fromString(cancelReservedInstancesListingRequest.getReservedInstancesListingId()));
        }
        return defaultRequest;
    }
}
