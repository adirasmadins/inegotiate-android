package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeReservedInstancesRequestMarshaller implements Marshaller<Request<DescribeReservedInstancesRequest>, DescribeReservedInstancesRequest> {
    public Request<DescribeReservedInstancesRequest> marshall(DescribeReservedInstancesRequest describeReservedInstancesRequest) {
        if (describeReservedInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeReservedInstancesRequest> defaultRequest = new DefaultRequest(describeReservedInstancesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeReservedInstances");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describeReservedInstancesRequest.getReservedInstancesIds()) {
            if (str != null) {
                defaultRequest.addParameter("ReservedInstancesId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (Filter filter : describeReservedInstancesRequest.getFilters()) {
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
        if (describeReservedInstancesRequest.getOfferingType() != null) {
            defaultRequest.addParameter("OfferingType", StringUtils.fromString(describeReservedInstancesRequest.getOfferingType()));
        }
        return defaultRequest;
    }
}
