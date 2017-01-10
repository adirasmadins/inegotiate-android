package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.EnableMetricsCollectionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class EnableMetricsCollectionRequestMarshaller implements Marshaller<Request<EnableMetricsCollectionRequest>, EnableMetricsCollectionRequest> {
    public Request<EnableMetricsCollectionRequest> marshall(EnableMetricsCollectionRequest enableMetricsCollectionRequest) {
        if (enableMetricsCollectionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<EnableMetricsCollectionRequest> defaultRequest = new DefaultRequest(enableMetricsCollectionRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "EnableMetricsCollection");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (enableMetricsCollectionRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(enableMetricsCollectionRequest.getAutoScalingGroupName()));
        }
        int i = 1;
        for (String str : enableMetricsCollectionRequest.getMetrics()) {
            if (str != null) {
                defaultRequest.addParameter("Metrics.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (enableMetricsCollectionRequest.getGranularity() != null) {
            defaultRequest.addParameter("Granularity", StringUtils.fromString(enableMetricsCollectionRequest.getGranularity()));
        }
        return defaultRequest;
    }
}
