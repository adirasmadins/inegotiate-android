package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.DetachLoadBalancerFromSubnetsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DetachLoadBalancerFromSubnetsRequestMarshaller implements Marshaller<Request<DetachLoadBalancerFromSubnetsRequest>, DetachLoadBalancerFromSubnetsRequest> {
    public Request<DetachLoadBalancerFromSubnetsRequest> marshall(DetachLoadBalancerFromSubnetsRequest detachLoadBalancerFromSubnetsRequest) {
        if (detachLoadBalancerFromSubnetsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DetachLoadBalancerFromSubnetsRequest> defaultRequest = new DefaultRequest(detachLoadBalancerFromSubnetsRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "DetachLoadBalancerFromSubnets");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (detachLoadBalancerFromSubnetsRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(detachLoadBalancerFromSubnetsRequest.getLoadBalancerName()));
        }
        int i = 1;
        for (String str : detachLoadBalancerFromSubnetsRequest.getSubnets()) {
            if (str != null) {
                defaultRequest.addParameter("Subnets.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
