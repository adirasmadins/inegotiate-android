package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerListenersRequest;
import com.amazonaws.services.elasticloadbalancing.model.Listener;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateLoadBalancerListenersRequestMarshaller implements Marshaller<Request<CreateLoadBalancerListenersRequest>, CreateLoadBalancerListenersRequest> {
    public Request<CreateLoadBalancerListenersRequest> marshall(CreateLoadBalancerListenersRequest createLoadBalancerListenersRequest) {
        if (createLoadBalancerListenersRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateLoadBalancerListenersRequest> defaultRequest = new DefaultRequest(createLoadBalancerListenersRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "CreateLoadBalancerListeners");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (createLoadBalancerListenersRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(createLoadBalancerListenersRequest.getLoadBalancerName()));
        }
        int i = 1;
        for (Listener listener : createLoadBalancerListenersRequest.getListeners()) {
            if (listener != null) {
                if (listener.getProtocol() != null) {
                    defaultRequest.addParameter("Listeners.member." + i + ".Protocol", StringUtils.fromString(listener.getProtocol()));
                }
                if (listener.getLoadBalancerPort() != null) {
                    defaultRequest.addParameter("Listeners.member." + i + ".LoadBalancerPort", StringUtils.fromInteger(listener.getLoadBalancerPort()));
                }
                if (listener.getInstanceProtocol() != null) {
                    defaultRequest.addParameter("Listeners.member." + i + ".InstanceProtocol", StringUtils.fromString(listener.getInstanceProtocol()));
                }
                if (listener.getInstancePort() != null) {
                    defaultRequest.addParameter("Listeners.member." + i + ".InstancePort", StringUtils.fromInteger(listener.getInstancePort()));
                }
                if (listener.getSSLCertificateId() != null) {
                    defaultRequest.addParameter("Listeners.member." + i + ".SSLCertificateId", StringUtils.fromString(listener.getSSLCertificateId()));
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
