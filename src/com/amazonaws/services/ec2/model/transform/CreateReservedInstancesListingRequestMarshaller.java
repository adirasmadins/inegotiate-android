package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CreateReservedInstancesListingRequest;
import com.amazonaws.services.ec2.model.PriceScheduleSpecification;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateReservedInstancesListingRequestMarshaller implements Marshaller<Request<CreateReservedInstancesListingRequest>, CreateReservedInstancesListingRequest> {
    public Request<CreateReservedInstancesListingRequest> marshall(CreateReservedInstancesListingRequest createReservedInstancesListingRequest) {
        if (createReservedInstancesListingRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateReservedInstancesListingRequest> defaultRequest = new DefaultRequest(createReservedInstancesListingRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CreateReservedInstancesListing");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (createReservedInstancesListingRequest.getReservedInstancesId() != null) {
            defaultRequest.addParameter("ReservedInstancesId", StringUtils.fromString(createReservedInstancesListingRequest.getReservedInstancesId()));
        }
        if (createReservedInstancesListingRequest.getInstanceCount() != null) {
            defaultRequest.addParameter("InstanceCount", StringUtils.fromInteger(createReservedInstancesListingRequest.getInstanceCount()));
        }
        int i = 1;
        for (PriceScheduleSpecification priceScheduleSpecification : createReservedInstancesListingRequest.getPriceSchedules()) {
            if (priceScheduleSpecification != null) {
                if (priceScheduleSpecification.getTerm() != null) {
                    defaultRequest.addParameter("PriceSchedules." + i + ".Term", StringUtils.fromLong(priceScheduleSpecification.getTerm()));
                }
                if (priceScheduleSpecification.getPrice() != null) {
                    defaultRequest.addParameter("PriceSchedules." + i + ".Price", StringUtils.fromDouble(priceScheduleSpecification.getPrice()));
                }
                if (priceScheduleSpecification.getCurrencyCode() != null) {
                    defaultRequest.addParameter("PriceSchedules." + i + ".CurrencyCode", StringUtils.fromString(priceScheduleSpecification.getCurrencyCode()));
                }
            }
            i++;
        }
        if (createReservedInstancesListingRequest.getClientToken() != null) {
            defaultRequest.addParameter("ClientToken", StringUtils.fromString(createReservedInstancesListingRequest.getClientToken()));
        }
        return defaultRequest;
    }
}
