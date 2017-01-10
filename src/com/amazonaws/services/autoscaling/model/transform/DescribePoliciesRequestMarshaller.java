package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribePoliciesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribePoliciesRequestMarshaller implements Marshaller<Request<DescribePoliciesRequest>, DescribePoliciesRequest> {
    public Request<DescribePoliciesRequest> marshall(DescribePoliciesRequest describePoliciesRequest) {
        if (describePoliciesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribePoliciesRequest> defaultRequest = new DefaultRequest(describePoliciesRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribePolicies");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (describePoliciesRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(describePoliciesRequest.getAutoScalingGroupName()));
        }
        int i = 1;
        for (String str : describePoliciesRequest.getPolicyNames()) {
            if (str != null) {
                defaultRequest.addParameter("PolicyNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (describePoliciesRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describePoliciesRequest.getNextToken()));
        }
        if (describePoliciesRequest.getMaxRecords() != null) {
            defaultRequest.addParameter("MaxRecords", StringUtils.fromInteger(describePoliciesRequest.getMaxRecords()));
        }
        return defaultRequest;
    }
}
