package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeImagesRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeImagesRequestMarshaller implements Marshaller<Request<DescribeImagesRequest>, DescribeImagesRequest> {
    public Request<DescribeImagesRequest> marshall(DescribeImagesRequest describeImagesRequest) {
        if (describeImagesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeImagesRequest> defaultRequest = new DefaultRequest(describeImagesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeImages");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describeImagesRequest.getImageIds()) {
            if (str != null) {
                defaultRequest.addParameter("ImageId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (String str2 : describeImagesRequest.getOwners()) {
            if (str2 != null) {
                defaultRequest.addParameter("Owner." + i, StringUtils.fromString(str2));
            }
            i++;
        }
        i = 1;
        for (String str22 : describeImagesRequest.getExecutableUsers()) {
            if (str22 != null) {
                defaultRequest.addParameter("ExecutableBy." + i, StringUtils.fromString(str22));
            }
            i++;
        }
        i = 1;
        for (Filter filter : describeImagesRequest.getFilters()) {
            if (filter != null) {
                if (filter.getName() != null) {
                    defaultRequest.addParameter("Filter." + i + ".Name", StringUtils.fromString(filter.getName()));
                }
                int i2 = 1;
                for (String str222 : filter.getValues()) {
                    if (str222 != null) {
                        defaultRequest.addParameter("Filter." + i + ".Value." + i2, StringUtils.fromString(str222));
                    }
                    i2++;
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
