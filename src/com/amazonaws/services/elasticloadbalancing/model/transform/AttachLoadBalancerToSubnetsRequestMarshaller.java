package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.AttachLoadBalancerToSubnetsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class AttachLoadBalancerToSubnetsRequestMarshaller implements Marshaller<Request<AttachLoadBalancerToSubnetsRequest>, AttachLoadBalancerToSubnetsRequest> {
    public Request<AttachLoadBalancerToSubnetsRequest> marshall(AttachLoadBalancerToSubnetsRequest attachLoadBalancerToSubnetsRequest) {
        if (attachLoadBalancerToSubnetsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<AttachLoadBalancerToSubnetsRequest> defaultRequest = new DefaultRequest(attachLoadBalancerToSubnetsRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "AttachLoadBalancerToSubnets");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (attachLoadBalancerToSubnetsRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(attachLoadBalancerToSubnetsRequest.getLoadBalancerName()));
        }
        int i = 1;
        for (String str : attachLoadBalancerToSubnetsRequest.getSubnets()) {
            if (str != null) {
                defaultRequest.addParameter("Subnets.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
