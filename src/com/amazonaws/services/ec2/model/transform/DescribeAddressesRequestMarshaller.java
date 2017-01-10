package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeAddressesRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeAddressesRequestMarshaller implements Marshaller<Request<DescribeAddressesRequest>, DescribeAddressesRequest> {
    public Request<DescribeAddressesRequest> marshall(DescribeAddressesRequest describeAddressesRequest) {
        int i = 1;
        if (describeAddressesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeAddressesRequest> defaultRequest = new DefaultRequest(describeAddressesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeAddresses");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i2 = 1;
        for (String str : describeAddressesRequest.getPublicIps()) {
            if (str != null) {
                defaultRequest.addParameter("PublicIp." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        i2 = 1;
        for (Filter filter : describeAddressesRequest.getFilters()) {
            if (filter != null) {
                if (filter.getName() != null) {
                    defaultRequest.addParameter("Filter." + i2 + ".Name", StringUtils.fromString(filter.getName()));
                }
                int i3 = 1;
                for (String str2 : filter.getValues()) {
                    if (str2 != null) {
                        defaultRequest.addParameter("Filter." + i2 + ".Value." + i3, StringUtils.fromString(str2));
                    }
                    i3++;
                }
            }
            i2++;
        }
        for (String str22 : describeAddressesRequest.getAllocationIds()) {
            if (str22 != null) {
                defaultRequest.addParameter("AllocationId." + i, StringUtils.fromString(str22));
            }
            i++;
        }
        return defaultRequest;
    }
}
