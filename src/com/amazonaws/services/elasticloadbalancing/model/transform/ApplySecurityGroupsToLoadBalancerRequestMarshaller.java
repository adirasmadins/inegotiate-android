package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.ApplySecurityGroupsToLoadBalancerRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ApplySecurityGroupsToLoadBalancerRequestMarshaller implements Marshaller<Request<ApplySecurityGroupsToLoadBalancerRequest>, ApplySecurityGroupsToLoadBalancerRequest> {
    public Request<ApplySecurityGroupsToLoadBalancerRequest> marshall(ApplySecurityGroupsToLoadBalancerRequest applySecurityGroupsToLoadBalancerRequest) {
        if (applySecurityGroupsToLoadBalancerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ApplySecurityGroupsToLoadBalancerRequest> defaultRequest = new DefaultRequest(applySecurityGroupsToLoadBalancerRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "ApplySecurityGroupsToLoadBalancer");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (applySecurityGroupsToLoadBalancerRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(applySecurityGroupsToLoadBalancerRequest.getLoadBalancerName()));
        }
        int i = 1;
        for (String str : applySecurityGroupsToLoadBalancerRequest.getSecurityGroups()) {
            if (str != null) {
                defaultRequest.addParameter("SecurityGroups.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
