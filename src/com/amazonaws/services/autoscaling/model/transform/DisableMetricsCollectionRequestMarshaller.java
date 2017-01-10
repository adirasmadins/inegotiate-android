package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DisableMetricsCollectionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DisableMetricsCollectionRequestMarshaller implements Marshaller<Request<DisableMetricsCollectionRequest>, DisableMetricsCollectionRequest> {
    public Request<DisableMetricsCollectionRequest> marshall(DisableMetricsCollectionRequest disableMetricsCollectionRequest) {
        if (disableMetricsCollectionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DisableMetricsCollectionRequest> defaultRequest = new DefaultRequest(disableMetricsCollectionRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DisableMetricsCollection");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (disableMetricsCollectionRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(disableMetricsCollectionRequest.getAutoScalingGroupName()));
        }
        int i = 1;
        for (String str : disableMetricsCollectionRequest.getMetrics()) {
            if (str != null) {
                defaultRequest.addParameter("Metrics.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
