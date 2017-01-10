package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeSecurityGroupsRequestMarshaller implements Marshaller<Request<DescribeSecurityGroupsRequest>, DescribeSecurityGroupsRequest> {
    public Request<DescribeSecurityGroupsRequest> marshall(DescribeSecurityGroupsRequest describeSecurityGroupsRequest) {
        if (describeSecurityGroupsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeSecurityGroupsRequest> defaultRequest = new DefaultRequest(describeSecurityGroupsRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeSecurityGroups");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describeSecurityGroupsRequest.getGroupNames()) {
            if (str != null) {
                defaultRequest.addParameter("GroupName." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (String str2 : describeSecurityGroupsRequest.getGroupIds()) {
            if (str2 != null) {
                defaultRequest.addParameter("GroupId." + i, StringUtils.fromString(str2));
            }
            i++;
        }
        i = 1;
        for (Filter filter : describeSecurityGroupsRequest.getFilters()) {
            if (filter != null) {
                if (filter.getName() != null) {
                    defaultRequest.addParameter("Filter." + i + ".Name", StringUtils.fromString(filter.getName()));
                }
                int i2 = 1;
                for (String str22 : filter.getValues()) {
                    if (str22 != null) {
                        defaultRequest.addParameter("Filter." + i + ".Value." + i2, StringUtils.fromString(str22));
                    }
                    i2++;
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
