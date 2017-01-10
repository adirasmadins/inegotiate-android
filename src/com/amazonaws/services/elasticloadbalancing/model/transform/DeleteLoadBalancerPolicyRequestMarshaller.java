package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.DeleteLoadBalancerPolicyRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteLoadBalancerPolicyRequestMarshaller implements Marshaller<Request<DeleteLoadBalancerPolicyRequest>, DeleteLoadBalancerPolicyRequest> {
    public Request<DeleteLoadBalancerPolicyRequest> marshall(DeleteLoadBalancerPolicyRequest deleteLoadBalancerPolicyRequest) {
        if (deleteLoadBalancerPolicyRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteLoadBalancerPolicyRequest> defaultRequest = new DefaultRequest(deleteLoadBalancerPolicyRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "DeleteLoadBalancerPolicy");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (deleteLoadBalancerPolicyRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(deleteLoadBalancerPolicyRequest.getLoadBalancerName()));
        }
        if (deleteLoadBalancerPolicyRequest.getPolicyName() != null) {
            defaultRequest.addParameter("PolicyName", StringUtils.fromString(deleteLoadBalancerPolicyRequest.getPolicyName()));
        }
        return defaultRequest;
    }
}
