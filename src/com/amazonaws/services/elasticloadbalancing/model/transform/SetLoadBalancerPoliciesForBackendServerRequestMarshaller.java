package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerPoliciesForBackendServerRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.google.gdata.util.common.base.StringUtil;
import java.util.List;

public class SetLoadBalancerPoliciesForBackendServerRequestMarshaller implements Marshaller<Request<SetLoadBalancerPoliciesForBackendServerRequest>, SetLoadBalancerPoliciesForBackendServerRequest> {
    public Request<SetLoadBalancerPoliciesForBackendServerRequest> marshall(SetLoadBalancerPoliciesForBackendServerRequest setLoadBalancerPoliciesForBackendServerRequest) {
        if (setLoadBalancerPoliciesForBackendServerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetLoadBalancerPoliciesForBackendServerRequest> defaultRequest = new DefaultRequest(setLoadBalancerPoliciesForBackendServerRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "SetLoadBalancerPoliciesForBackendServer");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (setLoadBalancerPoliciesForBackendServerRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(setLoadBalancerPoliciesForBackendServerRequest.getLoadBalancerName()));
        }
        if (setLoadBalancerPoliciesForBackendServerRequest.getInstancePort() != null) {
            defaultRequest.addParameter("InstancePort", StringUtils.fromInteger(setLoadBalancerPoliciesForBackendServerRequest.getInstancePort()));
        }
        List<String> policyNames = setLoadBalancerPoliciesForBackendServerRequest.getPolicyNames();
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
