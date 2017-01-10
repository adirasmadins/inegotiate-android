package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.EnableAvailabilityZonesForLoadBalancerRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class EnableAvailabilityZonesForLoadBalancerRequestMarshaller implements Marshaller<Request<EnableAvailabilityZonesForLoadBalancerRequest>, EnableAvailabilityZonesForLoadBalancerRequest> {
    public Request<EnableAvailabilityZonesForLoadBalancerRequest> marshall(EnableAvailabilityZonesForLoadBalancerRequest enableAvailabilityZonesForLoadBalancerRequest) {
        if (enableAvailabilityZonesForLoadBalancerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<EnableAvailabilityZonesForLoadBalancerRequest> defaultRequest = new DefaultRequest(enableAvailabilityZonesForLoadBalancerRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "EnableAvailabilityZonesForLoadBalancer");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (enableAvailabilityZonesForLoadBalancerRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(enableAvailabilityZonesForLoadBalancerRequest.getLoadBalancerName()));
        }
        int i = 1;
        for (String str : enableAvailabilityZonesForLoadBalancerRequest.getAvailabilityZones()) {
            if (str != null) {
                defaultRequest.addParameter("AvailabilityZones.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
