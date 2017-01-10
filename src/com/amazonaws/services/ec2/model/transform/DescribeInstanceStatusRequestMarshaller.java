package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeInstanceStatusRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeInstanceStatusRequestMarshaller implements Marshaller<Request<DescribeInstanceStatusRequest>, DescribeInstanceStatusRequest> {
    public Request<DescribeInstanceStatusRequest> marshall(DescribeInstanceStatusRequest describeInstanceStatusRequest) {
        if (describeInstanceStatusRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeInstanceStatusRequest> defaultRequest = new DefaultRequest(describeInstanceStatusRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeInstanceStatus");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describeInstanceStatusRequest.getInstanceIds()) {
            if (str != null) {
                defaultRequest.addParameter("InstanceId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (Filter filter : describeInstanceStatusRequest.getFilters()) {
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
        if (describeInstanceStatusRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeInstanceStatusRequest.getNextToken()));
        }
        if (describeInstanceStatusRequest.getMaxResults() != null) {
            defaultRequest.addParameter("MaxResults", StringUtils.fromInteger(describeInstanceStatusRequest.getMaxResults()));
        }
        if (describeInstanceStatusRequest.isIncludeAllInstances() != null) {
            defaultRequest.addParameter("IncludeAllInstances", StringUtils.fromBoolean(describeInstanceStatusRequest.isIncludeAllInstances()));
        }
        return defaultRequest;
    }
}
