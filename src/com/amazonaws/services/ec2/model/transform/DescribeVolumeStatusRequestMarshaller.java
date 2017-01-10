package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeVolumeStatusRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeVolumeStatusRequestMarshaller implements Marshaller<Request<DescribeVolumeStatusRequest>, DescribeVolumeStatusRequest> {
    public Request<DescribeVolumeStatusRequest> marshall(DescribeVolumeStatusRequest describeVolumeStatusRequest) {
        if (describeVolumeStatusRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeVolumeStatusRequest> defaultRequest = new DefaultRequest(describeVolumeStatusRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeVolumeStatus");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describeVolumeStatusRequest.getVolumeIds()) {
            if (str != null) {
                defaultRequest.addParameter("VolumeId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (Filter filter : describeVolumeStatusRequest.getFilters()) {
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
        if (describeVolumeStatusRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeVolumeStatusRequest.getNextToken()));
        }
        if (describeVolumeStatusRequest.getMaxResults() != null) {
            defaultRequest.addParameter("MaxResults", StringUtils.fromInteger(describeVolumeStatusRequest.getMaxResults()));
        }
        return defaultRequest;
    }
}
