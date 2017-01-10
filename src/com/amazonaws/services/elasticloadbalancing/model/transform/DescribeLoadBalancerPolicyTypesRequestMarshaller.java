package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancerPolicyTypesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeLoadBalancerPolicyTypesRequestMarshaller implements Marshaller<Request<DescribeLoadBalancerPolicyTypesRequest>, DescribeLoadBalancerPolicyTypesRequest> {
    public Request<DescribeLoadBalancerPolicyTypesRequest> marshall(DescribeLoadBalancerPolicyTypesRequest describeLoadBalancerPolicyTypesRequest) {
        if (describeLoadBalancerPolicyTypesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeLoadBalancerPolicyTypesRequest> defaultRequest = new DefaultRequest(describeLoadBalancerPolicyTypesRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "DescribeLoadBalancerPolicyTypes");
        defaultRequest.addParameter("Version", "2012-06-01");
        int i = 1;
        for (String str : describeLoadBalancerPolicyTypesRequest.getPolicyTypeNames()) {
            if (str != null) {
                defaultRequest.addParameter("PolicyTypeNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
