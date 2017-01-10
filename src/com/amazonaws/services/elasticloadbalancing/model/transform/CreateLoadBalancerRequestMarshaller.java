package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.Listener;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateLoadBalancerRequestMarshaller implements Marshaller<Request<CreateLoadBalancerRequest>, CreateLoadBalancerRequest> {
    public Request<CreateLoadBalancerRequest> marshall(CreateLoadBalancerRequest createLoadBalancerRequest) {
        int i = 1;
        if (createLoadBalancerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateLoadBalancerRequest> defaultRequest = new DefaultRequest(createLoadBalancerRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "CreateLoadBalancer");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (createLoadBalancerRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(createLoadBalancerRequest.getLoadBalancerName()));
        }
        int i2 = 1;
        for (Listener listener : createLoadBalancerRequest.getListeners()) {
            if (listener != null) {
                if (listener.getProtocol() != null) {
                    defaultRequest.addParameter("Listeners.member." + i2 + ".Protocol", StringUtils.fromString(listener.getProtocol()));
                }
                if (listener.getLoadBalancerPort() != null) {
                    defaultRequest.addParameter("Listeners.member." + i2 + ".LoadBalancerPort", StringUtils.fromInteger(listener.getLoadBalancerPort()));
                }
                if (listener.getInstanceProtocol() != null) {
                    defaultRequest.addParameter("Listeners.member." + i2 + ".InstanceProtocol", StringUtils.fromString(listener.getInstanceProtocol()));
                }
                if (listener.getInstancePort() != null) {
                    defaultRequest.addParameter("Listeners.member." + i2 + ".InstancePort", StringUtils.fromInteger(listener.getInstancePort()));
                }
                if (listener.getSSLCertificateId() != null) {
                    defaultRequest.addParameter("Listeners.member." + i2 + ".SSLCertificateId", StringUtils.fromString(listener.getSSLCertificateId()));
                }
            }
            i2++;
        }
        i2 = 1;
        for (String str : createLoadBalancerRequest.getAvailabilityZones()) {
            if (str != null) {
                defaultRequest.addParameter("AvailabilityZones.member." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        i2 = 1;
        for (String str2 : createLoadBalancerRequest.getSubnets()) {
            if (str2 != null) {
                defaultRequest.addParameter("Subnets.member." + i2, StringUtils.fromString(str2));
            }
            i2++;
        }
        for (String str22 : createLoadBalancerRequest.getSecurityGroups()) {
            if (str22 != null) {
                defaultRequest.addParameter("SecurityGroups.member." + i, StringUtils.fromString(str22));
            }
            i++;
        }
        if (createLoadBalancerRequest.getScheme() != null) {
            defaultRequest.addParameter("Scheme", StringUtils.fromString(createLoadBalancerRequest.getScheme()));
        }
        return defaultRequest;
    }
}
