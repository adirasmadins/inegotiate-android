package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.ConfigureHealthCheckRequest;
import com.amazonaws.services.elasticloadbalancing.model.HealthCheck;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ConfigureHealthCheckRequestMarshaller implements Marshaller<Request<ConfigureHealthCheckRequest>, ConfigureHealthCheckRequest> {
    public Request<ConfigureHealthCheckRequest> marshall(ConfigureHealthCheckRequest configureHealthCheckRequest) {
        if (configureHealthCheckRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ConfigureHealthCheckRequest> defaultRequest = new DefaultRequest(configureHealthCheckRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "ConfigureHealthCheck");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (configureHealthCheckRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(configureHealthCheckRequest.getLoadBalancerName()));
        }
        HealthCheck healthCheck = configureHealthCheckRequest.getHealthCheck();
        if (healthCheck != null) {
            if (healthCheck.getTarget() != null) {
                defaultRequest.addParameter("HealthCheck.Target", StringUtils.fromString(healthCheck.getTarget()));
            }
            if (healthCheck.getInterval() != null) {
                defaultRequest.addParameter("HealthCheck.Interval", StringUtils.fromInteger(healthCheck.getInterval()));
            }
            if (healthCheck.getTimeout() != null) {
                defaultRequest.addParameter("HealthCheck.Timeout", StringUtils.fromInteger(healthCheck.getTimeout()));
            }
            if (healthCheck.getUnhealthyThreshold() != null) {
                defaultRequest.addParameter("HealthCheck.UnhealthyThreshold", StringUtils.fromInteger(healthCheck.getUnhealthyThreshold()));
            }
            if (healthCheck.getHealthyThreshold() != null) {
                defaultRequest.addParameter("HealthCheck.HealthyThreshold", StringUtils.fromInteger(healthCheck.getHealthyThreshold()));
            }
        }
        return defaultRequest;
    }
}
