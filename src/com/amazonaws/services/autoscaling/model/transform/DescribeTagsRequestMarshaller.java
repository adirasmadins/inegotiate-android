package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeTagsRequest;
import com.amazonaws.services.autoscaling.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeTagsRequestMarshaller implements Marshaller<Request<DescribeTagsRequest>, DescribeTagsRequest> {
    public Request<DescribeTagsRequest> marshall(DescribeTagsRequest describeTagsRequest) {
        if (describeTagsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeTagsRequest> defaultRequest = new DefaultRequest(describeTagsRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeTags");
        defaultRequest.addParameter("Version", "2011-01-01");
        int i = 1;
        for (Filter filter : describeTagsRequest.getFilters()) {
            if (filter != null) {
                if (filter.getName() != null) {
                    defaultRequest.addParameter("Filters.member." + i + ".Name", StringUtils.fromString(filter.getName()));
                }
                int i2 = 1;
                for (String str : filter.getValues()) {
                    if (str != null) {
                        defaultRequest.addParameter("Filters.member." + i + ".Values.member." + i2, StringUtils.fromString(str));
                    }
                    i2++;
                }
            }
            i++;
        }
        if (describeTagsRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeTagsRequest.getNextToken()));
        }
        if (describeTagsRequest.getMaxRecords() != null) {
            defaultRequest.addParameter("MaxRecords", StringUtils.fromInteger(describeTagsRequest.getMaxRecords()));
        }
        return defaultRequest;
    }
}
