package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesListingsRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeReservedInstancesListingsRequestMarshaller implements Marshaller<Request<DescribeReservedInstancesListingsRequest>, DescribeReservedInstancesListingsRequest> {
    public Request<DescribeReservedInstancesListingsRequest> marshall(DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest) {
        if (describeReservedInstancesListingsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeReservedInstancesListingsRequest> defaultRequest = new DefaultRequest(describeReservedInstancesListingsRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeReservedInstancesListings");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (describeReservedInstancesListingsRequest.getReservedInstancesId() != null) {
            defaultRequest.addParameter("ReservedInstancesId", StringUtils.fromString(describeReservedInstancesListingsRequest.getReservedInstancesId()));
        }
        if (describeReservedInstancesListingsRequest.getReservedInstancesListingId() != null) {
            defaultRequest.addParameter("ReservedInstancesListingId", StringUtils.fromString(describeReservedInstancesListingsRequest.getReservedInstancesListingId()));
        }
        int i = 1;
        for (Filter filter : describeReservedInstancesListingsRequest.getFilters()) {
            if (filter != null) {
                if (filter.getName() != null) {
                    defaultRequest.addParameter("Filters." + i + ".Name", StringUtils.fromString(filter.getName()));
                }
                int i2 = 1;
                for (String str : filter.getValues()) {
                    if (str != null) {
                        defaultRequest.addParameter("Filters." + i + ".Value." + i2, StringUtils.fromString(str));
                    }
                    i2++;
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
