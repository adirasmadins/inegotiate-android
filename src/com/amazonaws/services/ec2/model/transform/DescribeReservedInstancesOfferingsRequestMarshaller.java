package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesOfferingsRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeReservedInstancesOfferingsRequestMarshaller implements Marshaller<Request<DescribeReservedInstancesOfferingsRequest>, DescribeReservedInstancesOfferingsRequest> {
    public Request<DescribeReservedInstancesOfferingsRequest> marshall(DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest) {
        if (describeReservedInstancesOfferingsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeReservedInstancesOfferingsRequest> defaultRequest = new DefaultRequest(describeReservedInstancesOfferingsRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeReservedInstancesOfferings");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describeReservedInstancesOfferingsRequest.getReservedInstancesOfferingIds()) {
            if (str != null) {
                defaultRequest.addParameter("ReservedInstancesOfferingId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (describeReservedInstancesOfferingsRequest.getInstanceType() != null) {
            defaultRequest.addParameter("InstanceType", StringUtils.fromString(describeReservedInstancesOfferingsRequest.getInstanceType()));
        }
        if (describeReservedInstancesOfferingsRequest.getAvailabilityZone() != null) {
            defaultRequest.addParameter("AvailabilityZone", StringUtils.fromString(describeReservedInstancesOfferingsRequest.getAvailabilityZone()));
        }
        if (describeReservedInstancesOfferingsRequest.getProductDescription() != null) {
            defaultRequest.addParameter("ProductDescription", StringUtils.fromString(describeReservedInstancesOfferingsRequest.getProductDescription()));
        }
        i = 1;
        for (Filter filter : describeReservedInstancesOfferingsRequest.getFilters()) {
            if (filter != null) {
                if (filter.getName() != null) {
                    defaultRequest.addParameter("Filter." + i + ".Name", StringUtils.fromString(filter.getName()));
                }
                int i2 = 1;
                for (String str2 : filter.getValues()) {
                    if (str2 != null) {
                        defaultRequest.addParameter("Filter." + i + ".Value." + i2, StringUtils.fromString(str2));
                    }
                    i2++;
                }
            }
            i++;
        }
        if (describeReservedInstancesOfferingsRequest.getInstanceTenancy() != null) {
            defaultRequest.addParameter("InstanceTenancy", StringUtils.fromString(describeReservedInstancesOfferingsRequest.getInstanceTenancy()));
        }
        if (describeReservedInstancesOfferingsRequest.getOfferingType() != null) {
            defaultRequest.addParameter("OfferingType", StringUtils.fromString(describeReservedInstancesOfferingsRequest.getOfferingType()));
        }
        return defaultRequest;
    }
}
