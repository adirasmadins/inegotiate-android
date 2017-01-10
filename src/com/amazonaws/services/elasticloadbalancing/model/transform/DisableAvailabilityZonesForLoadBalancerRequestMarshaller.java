package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.DisableAvailabilityZonesForLoadBalancerRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DisableAvailabilityZonesForLoadBalancerRequestMarshaller implements Marshaller<Request<DisableAvailabilityZonesForLoadBalancerRequest>, DisableAvailabilityZonesForLoadBalancerRequest> {
    public Request<DisableAvailabilityZonesForLoadBalancerRequest> marshall(DisableAvailabilityZonesForLoadBalancerRequest disableAvailabilityZonesForLoadBalancerRequest) {
        if (disableAvailabilityZonesForLoadBalancerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DisableAvailabilityZonesForLoadBalancerRequest> defaultRequest = new DefaultRequest(disableAvailabilityZonesForLoadBalancerRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "DisableAvailabilityZonesForLoadBalancer");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (disableAvailabilityZonesForLoadBalancerRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(disableAvailabilityZonesForLoadBalancerRequest.getLoadBalancerName()));
        }
        int i = 1;
        for (String str : disableAvailabilityZonesForLoadBalancerRequest.getAvailabilityZones()) {
            if (str != null) {
                defaultRequest.addParameter("AvailabilityZones.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
