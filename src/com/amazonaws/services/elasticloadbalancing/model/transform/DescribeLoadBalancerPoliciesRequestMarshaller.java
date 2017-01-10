package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancerPoliciesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeLoadBalancerPoliciesRequestMarshaller implements Marshaller<Request<DescribeLoadBalancerPoliciesRequest>, DescribeLoadBalancerPoliciesRequest> {
    public Request<DescribeLoadBalancerPoliciesRequest> marshall(DescribeLoadBalancerPoliciesRequest describeLoadBalancerPoliciesRequest) {
        if (describeLoadBalancerPoliciesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeLoadBalancerPoliciesRequest> defaultRequest = new DefaultRequest(describeLoadBalancerPoliciesRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "DescribeLoadBalancerPolicies");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (describeLoadBalancerPoliciesRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(describeLoadBalancerPoliciesRequest.getLoadBalancerName()));
        }
        int i = 1;
        for (String str : describeLoadBalancerPoliciesRequest.getPolicyNames()) {
            if (str != null) {
                defaultRequest.addParameter("PolicyNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
