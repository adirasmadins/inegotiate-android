package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeBundleTasksRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeBundleTasksRequestMarshaller implements Marshaller<Request<DescribeBundleTasksRequest>, DescribeBundleTasksRequest> {
    public Request<DescribeBundleTasksRequest> marshall(DescribeBundleTasksRequest describeBundleTasksRequest) {
        if (describeBundleTasksRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeBundleTasksRequest> defaultRequest = new DefaultRequest(describeBundleTasksRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeBundleTasks");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describeBundleTasksRequest.getBundleIds()) {
            if (str != null) {
                defaultRequest.addParameter("BundleId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (Filter filter : describeBundleTasksRequest.getFilters()) {
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
