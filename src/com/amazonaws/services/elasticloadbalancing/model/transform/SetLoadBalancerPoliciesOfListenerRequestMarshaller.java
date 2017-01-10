package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerPoliciesOfListenerRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.google.gdata.util.common.base.StringUtil;
import java.util.List;

public class SetLoadBalancerPoliciesOfListenerRequestMarshaller implements Marshaller<Request<SetLoadBalancerPoliciesOfListenerRequest>, SetLoadBalancerPoliciesOfListenerRequest> {
    public Request<SetLoadBalancerPoliciesOfListenerRequest> marshall(SetLoadBalancerPoliciesOfListenerRequest setLoadBalancerPoliciesOfListenerRequest) {
        if (setLoadBalancerPoliciesOfListenerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetLoadBalancerPoliciesOfListenerRequest> defaultRequest = new DefaultRequest(setLoadBalancerPoliciesOfListenerRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "SetLoadBalancerPoliciesOfListener");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (setLoadBalancerPoliciesOfListenerRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(setLoadBalancerPoliciesOfListenerRequest.getLoadBalancerName()));
        }
        if (setLoadBalancerPoliciesOfListenerRequest.getLoadBalancerPort() != null) {
            defaultRequest.addParameter("LoadBalancerPort", StringUtils.fromInteger(setLoadBalancerPoliciesOfListenerRequest.getLoadBalancerPort()));
        }
        List<String> policyNames = setLoadBalancerPoliciesOfListenerRequest.getPolicyNames();
        if (policyNames.isEmpty()) {
            defaultRequest.addParameter("PolicyNames", StringUtil.EMPTY_STRING);
        }
        int i = 1;
        for (String str : policyNames) {
            if (str != null) {
                defaultRequest.addParameter("PolicyNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
