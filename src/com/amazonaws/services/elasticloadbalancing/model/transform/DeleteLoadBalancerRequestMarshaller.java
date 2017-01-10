package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.DeleteLoadBalancerRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteLoadBalancerRequestMarshaller implements Marshaller<Request<DeleteLoadBalancerRequest>, DeleteLoadBalancerRequest> {
    public Request<DeleteLoadBalancerRequest> marshall(DeleteLoadBalancerRequest deleteLoadBalancerRequest) {
        if (deleteLoadBalancerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteLoadBalancerRequest> defaultRequest = new DefaultRequest(deleteLoadBalancerRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "DeleteLoadBalancer");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (deleteLoadBalancerRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(deleteLoadBalancerRequest.getLoadBalancerName()));
        }
        return defaultRequest;
    }
}
