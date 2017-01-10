package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeConversionTasksRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeConversionTasksRequestMarshaller implements Marshaller<Request<DescribeConversionTasksRequest>, DescribeConversionTasksRequest> {
    public Request<DescribeConversionTasksRequest> marshall(DescribeConversionTasksRequest describeConversionTasksRequest) {
        int i = 1;
        if (describeConversionTasksRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeConversionTasksRequest> defaultRequest = new DefaultRequest(describeConversionTasksRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeConversionTasks");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i2 = 1;
        for (Filter filter : describeConversionTasksRequest.getFilters()) {
            if (filter != null) {
                if (filter.getName() != null) {
                    defaultRequest.addParameter("Filter." + i2 + ".Name", StringUtils.fromString(filter.getName()));
                }
                int i3 = 1;
                for (String str : filter.getValues()) {
                    if (str != null) {
                        defaultRequest.addParameter("Filter." + i2 + ".Value." + i3, StringUtils.fromString(str));
                    }
                    i3++;
                }
            }
            i2++;
        }
        for (String str2 : describeConversionTasksRequest.getConversionTaskIds()) {
            if (str2 != null) {
                defaultRequest.addParameter("ConversionTaskId." + i, StringUtils.fromString(str2));
            }
            i++;
        }
        return defaultRequest;
    }
}
