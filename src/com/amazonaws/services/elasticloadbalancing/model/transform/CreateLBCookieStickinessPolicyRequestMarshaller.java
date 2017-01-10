package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.CreateLBCookieStickinessPolicyRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateLBCookieStickinessPolicyRequestMarshaller implements Marshaller<Request<CreateLBCookieStickinessPolicyRequest>, CreateLBCookieStickinessPolicyRequest> {
    public Request<CreateLBCookieStickinessPolicyRequest> marshall(CreateLBCookieStickinessPolicyRequest createLBCookieStickinessPolicyRequest) {
        if (createLBCookieStickinessPolicyRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateLBCookieStickinessPolicyRequest> defaultRequest = new DefaultRequest(createLBCookieStickinessPolicyRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "CreateLBCookieStickinessPolicy");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (createLBCookieStickinessPolicyRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(createLBCookieStickinessPolicyRequest.getLoadBalancerName()));
        }
        if (createLBCookieStickinessPolicyRequest.getPolicyName() != null) {
            defaultRequest.addParameter("PolicyName", StringUtils.fromString(createLBCookieStickinessPolicyRequest.getPolicyName()));
        }
        if (createLBCookieStickinessPolicyRequest.getCookieExpirationPeriod() != null) {
            defaultRequest.addParameter("CookieExpirationPeriod", StringUtils.fromLong(createLBCookieStickinessPolicyRequest.getCookieExpirationPeriod()));
        }
        return defaultRequest;
    }
}
