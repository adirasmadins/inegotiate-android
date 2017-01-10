package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.CreateAppCookieStickinessPolicyRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateAppCookieStickinessPolicyRequestMarshaller implements Marshaller<Request<CreateAppCookieStickinessPolicyRequest>, CreateAppCookieStickinessPolicyRequest> {
    public Request<CreateAppCookieStickinessPolicyRequest> marshall(CreateAppCookieStickinessPolicyRequest createAppCookieStickinessPolicyRequest) {
        if (createAppCookieStickinessPolicyRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateAppCookieStickinessPolicyRequest> defaultRequest = new DefaultRequest(createAppCookieStickinessPolicyRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "CreateAppCookieStickinessPolicy");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (createAppCookieStickinessPolicyRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(createAppCookieStickinessPolicyRequest.getLoadBalancerName()));
        }
        if (createAppCookieStickinessPolicyRequest.getPolicyName() != null) {
            defaultRequest.addParameter("PolicyName", StringUtils.fromString(createAppCookieStickinessPolicyRequest.getPolicyName()));
        }
        if (createAppCookieStickinessPolicyRequest.getCookieName() != null) {
            defaultRequest.addParameter("CookieName", StringUtils.fromString(createAppCookieStickinessPolicyRequest.getCookieName()));
        }
        return defaultRequest;
    }
}
