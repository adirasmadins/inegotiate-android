package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribePlacementGroupsRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribePlacementGroupsRequestMarshaller implements Marshaller<Request<DescribePlacementGroupsRequest>, DescribePlacementGroupsRequest> {
    public Request<DescribePlacementGroupsRequest> marshall(DescribePlacementGroupsRequest describePlacementGroupsRequest) {
        if (describePlacementGroupsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribePlacementGroupsRequest> defaultRequest = new DefaultRequest(describePlacementGroupsRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribePlacementGroups");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describePlacementGroupsRequest.getGroupNames()) {
            if (str != null) {
                defaultRequest.addParameter("GroupName." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (Filter filter : describePlacementGroupsRequest.getFilters()) {
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
