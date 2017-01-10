package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.DeleteLoadBalancerListenersRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteLoadBalancerListenersRequestMarshaller implements Marshaller<Request<DeleteLoadBalancerListenersRequest>, DeleteLoadBalancerListenersRequest> {
    public Request<DeleteLoadBalancerListenersRequest> marshall(DeleteLoadBalancerListenersRequest deleteLoadBalancerListenersRequest) {
        if (deleteLoadBalancerListenersRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteLoadBalancerListenersRequest> defaultRequest = new DefaultRequest(deleteLoadBalancerListenersRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "DeleteLoadBalancerListeners");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (deleteLoadBalancerListenersRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(deleteLoadBalancerListenersRequest.getLoadBalancerName()));
        }
        int i = 1;
        for (Integer num : deleteLoadBalancerListenersRequest.getLoadBalancerPorts()) {
            if (num != null) {
                defaultRequest.addParameter("LoadBalancerPorts.member." + i, StringUtils.fromInteger(num));
            }
            i++;
        }
        return defaultRequest;
    }
}
