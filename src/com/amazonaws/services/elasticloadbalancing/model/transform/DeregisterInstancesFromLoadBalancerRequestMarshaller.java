package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.DeregisterInstancesFromLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.Instance;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeregisterInstancesFromLoadBalancerRequestMarshaller implements Marshaller<Request<DeregisterInstancesFromLoadBalancerRequest>, DeregisterInstancesFromLoadBalancerRequest> {
    public Request<DeregisterInstancesFromLoadBalancerRequest> marshall(DeregisterInstancesFromLoadBalancerRequest deregisterInstancesFromLoadBalancerRequest) {
        if (deregisterInstancesFromLoadBalancerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeregisterInstancesFromLoadBalancerRequest> defaultRequest = new DefaultRequest(deregisterInstancesFromLoadBalancerRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "DeregisterInstancesFromLoadBalancer");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (deregisterInstancesFromLoadBalancerRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(deregisterInstancesFromLoadBalancerRequest.getLoadBalancerName()));
        }
        int i = 1;
        for (Instance instance : deregisterInstancesFromLoadBalancerRequest.getInstances()) {
            if (!(instance == null || instance.getInstanceId() == null)) {
                defaultRequest.addParameter("Instances.member." + i + ".InstanceId", StringUtils.fromString(instance.getInstanceId()));
            }
            i++;
        }
        return defaultRequest;
    }
}
