package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeVolumesRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeVolumesRequestMarshaller implements Marshaller<Request<DescribeVolumesRequest>, DescribeVolumesRequest> {
    public Request<DescribeVolumesRequest> marshall(DescribeVolumesRequest describeVolumesRequest) {
        if (describeVolumesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeVolumesRequest> defaultRequest = new DefaultRequest(describeVolumesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeVolumes");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describeVolumesRequest.getVolumeIds()) {
            if (str != null) {
                defaultRequest.addParameter("VolumeId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (Filter filter : describeVolumesRequest.getFilters()) {
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
