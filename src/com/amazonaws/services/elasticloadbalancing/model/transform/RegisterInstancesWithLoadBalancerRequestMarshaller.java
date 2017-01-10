package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.Instance;
import com.amazonaws.services.elasticloadbalancing.model.RegisterInstancesWithLoadBalancerRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class RegisterInstancesWithLoadBalancerRequestMarshaller implements Marshaller<Request<RegisterInstancesWithLoadBalancerRequest>, RegisterInstancesWithLoadBalancerRequest> {
    public Request<RegisterInstancesWithLoadBalancerRequest> marshall(RegisterInstancesWithLoadBalancerRequest registerInstancesWithLoadBalancerRequest) {
        if (registerInstancesWithLoadBalancerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<RegisterInstancesWithLoadBalancerRequest> defaultRequest = new DefaultRequest(registerInstancesWithLoadBalancerRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "RegisterInstancesWithLoadBalancer");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (registerInstancesWithLoadBalancerRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(registerInstancesWithLoadBalancerRequest.getLoadBalancerName()));
        }
        int i = 1;
        for (Instance instance : registerInstancesWithLoadBalancerRequest.getInstances()) {
            if (!(instance == null || instance.getInstanceId() == null)) {
                defaultRequest.addParameter("Instances.member." + i + ".InstanceId", StringUtils.fromString(instance.getInstanceId()));
            }
            i++;
        }
        return defaultRequest;
    }
}
