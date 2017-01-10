package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeSpotPriceHistoryRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeSpotPriceHistoryRequestMarshaller implements Marshaller<Request<DescribeSpotPriceHistoryRequest>, DescribeSpotPriceHistoryRequest> {
    public Request<DescribeSpotPriceHistoryRequest> marshall(DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest) {
        if (describeSpotPriceHistoryRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeSpotPriceHistoryRequest> defaultRequest = new DefaultRequest(describeSpotPriceHistoryRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeSpotPriceHistory");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (describeSpotPriceHistoryRequest.getStartTime() != null) {
            defaultRequest.addParameter("StartTime", StringUtils.fromDate(describeSpotPriceHistoryRequest.getStartTime()));
        }
        if (describeSpotPriceHistoryRequest.getEndTime() != null) {
            defaultRequest.addParameter("EndTime", StringUtils.fromDate(describeSpotPriceHistoryRequest.getEndTime()));
        }
        int i = 1;
        for (String str : describeSpotPriceHistoryRequest.getInstanceTypes()) {
            if (str != null) {
                defaultRequest.addParameter("InstanceType." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (String str2 : describeSpotPriceHistoryRequest.getProductDescriptions()) {
            if (str2 != null) {
                defaultRequest.addParameter("ProductDescription." + i, StringUtils.fromString(str2));
            }
            i++;
        }
        i = 1;
        for (Filter filter : describeSpotPriceHistoryRequest.getFilters()) {
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
        if (describeSpotPriceHistoryRequest.getAvailabilityZone() != null) {
            defaultRequest.addParameter("AvailabilityZone", StringUtils.fromString(describeSpotPriceHistoryRequest.getAvailabilityZone()));
        }
        if (describeSpotPriceHistoryRequest.getMaxResults() != null) {
            defaultRequest.addParameter("MaxResults", StringUtils.fromInteger(describeSpotPriceHistoryRequest.getMaxResults()));
        }
        if (describeSpotPriceHistoryRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeSpotPriceHistoryRequest.getNextToken()));
        }
        return defaultRequest;
    }
}
