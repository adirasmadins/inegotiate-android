package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeTagsRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeTagsRequestMarshaller implements Marshaller<Request<DescribeTagsRequest>, DescribeTagsRequest> {
    public Request<DescribeTagsRequest> marshall(DescribeTagsRequest describeTagsRequest) {
        if (describeTagsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeTagsRequest> defaultRequest = new DefaultRequest(describeTagsRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeTags");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (Filter filter : describeTagsRequest.getFilters()) {
            if (filter != null) {
                if (filter.getName() != null) {
                    defaultRequest.addParameter("Filter." + i + ".Name", StringUtils.fromString(filter.getName()));
                }
                int i2 = 1;
                for (String str : filter.getValues()) {
                    if (str != null) {
                        defaultRequest.addParameter("Filter." + i + ".Value." + i2, StringUtils.fromString(str));
                    }
                    i2++;
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
