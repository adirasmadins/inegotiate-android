package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerPolicyRequest;
import com.amazonaws.services.elasticloadbalancing.model.PolicyAttribute;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateLoadBalancerPolicyRequestMarshaller implements Marshaller<Request<CreateLoadBalancerPolicyRequest>, CreateLoadBalancerPolicyRequest> {
    public Request<CreateLoadBalancerPolicyRequest> marshall(CreateLoadBalancerPolicyRequest createLoadBalancerPolicyRequest) {
        if (createLoadBalancerPolicyRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateLoadBalancerPolicyRequest> defaultRequest = new DefaultRequest(createLoadBalancerPolicyRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "CreateLoadBalancerPolicy");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (createLoadBalancerPolicyRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(createLoadBalancerPolicyRequest.getLoadBalancerName()));
        }
        if (createLoadBalancerPolicyRequest.getPolicyName() != null) {
            defaultRequest.addParameter("PolicyName", StringUtils.fromString(createLoadBalancerPolicyRequest.getPolicyName()));
        }
        if (createLoadBalancerPolicyRequest.getPolicyTypeName() != null) {
            defaultRequest.addParameter("PolicyTypeName", StringUtils.fromString(createLoadBalancerPolicyRequest.getPolicyTypeName()));
        }
        int i = 1;
        for (PolicyAttribute policyAttribute : createLoadBalancerPolicyRequest.getPolicyAttributes()) {
            if (policyAttribute != null) {
                if (policyAttribute.getAttributeName() != null) {
                    defaultRequest.addParameter("PolicyAttributes.member." + i + ".AttributeName", StringUtils.fromString(policyAttribute.getAttributeName()));
                }
                if (policyAttribute.getAttributeValue() != null) {
                    defaultRequest.addParameter("PolicyAttributes.member." + i + ".AttributeValue", StringUtils.fromString(policyAttribute.getAttributeValue()));
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
