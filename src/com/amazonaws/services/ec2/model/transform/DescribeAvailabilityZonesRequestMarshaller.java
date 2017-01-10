package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeAvailabilityZonesRequestMarshaller implements Marshaller<Request<DescribeAvailabilityZonesRequest>, DescribeAvailabilityZonesRequest> {
    public Request<DescribeAvailabilityZonesRequest> marshall(DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest) {
        if (describeAvailabilityZonesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeAvailabilityZonesRequest> defaultRequest = new DefaultRequest(describeAvailabilityZonesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeAvailabilityZones");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describeAvailabilityZonesRequest.getZoneNames()) {
            if (str != null) {
                defaultRequest.addParameter("ZoneName." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (Filter filter : describeAvailabilityZonesRequest.getFilters()) {
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
        return defaultRequest;
    }
}
