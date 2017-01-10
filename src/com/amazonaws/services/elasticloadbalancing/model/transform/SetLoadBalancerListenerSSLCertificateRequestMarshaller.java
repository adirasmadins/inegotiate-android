package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerListenerSSLCertificateRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SetLoadBalancerListenerSSLCertificateRequestMarshaller implements Marshaller<Request<SetLoadBalancerListenerSSLCertificateRequest>, SetLoadBalancerListenerSSLCertificateRequest> {
    public Request<SetLoadBalancerListenerSSLCertificateRequest> marshall(SetLoadBalancerListenerSSLCertificateRequest setLoadBalancerListenerSSLCertificateRequest) {
        if (setLoadBalancerListenerSSLCertificateRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetLoadBalancerListenerSSLCertificateRequest> defaultRequest = new DefaultRequest(setLoadBalancerListenerSSLCertificateRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "SetLoadBalancerListenerSSLCertificate");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (setLoadBalancerListenerSSLCertificateRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(setLoadBalancerListenerSSLCertificateRequest.getLoadBalancerName()));
        }
        if (setLoadBalancerListenerSSLCertificateRequest.getLoadBalancerPort() != null) {
            defaultRequest.addParameter("LoadBalancerPort", StringUtils.fromInteger(setLoadBalancerListenerSSLCertificateRequest.getLoadBalancerPort()));
        }
        if (setLoadBalancerListenerSSLCertificateRequest.getSSLCertificateId() != null) {
            defaultRequest.addParameter("SSLCertificateId", StringUtils.fromString(setLoadBalancerListenerSSLCertificateRequest.getSSLCertificateId()));
        }
        return defaultRequest;
    }
}
