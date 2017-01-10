package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.SetInstanceHealthRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SetInstanceHealthRequestMarshaller implements Marshaller<Request<SetInstanceHealthRequest>, SetInstanceHealthRequest> {
    public Request<SetInstanceHealthRequest> marshall(SetInstanceHealthRequest setInstanceHealthRequest) {
        if (setInstanceHealthRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetInstanceHealthRequest> defaultRequest = new DefaultRequest(setInstanceHealthRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "SetInstanceHealth");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (setInstanceHealthRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(setInstanceHealthRequest.getInstanceId()));
        }
        if (setInstanceHealthRequest.getHealthStatus() != null) {
            defaultRequest.addParameter("HealthStatus", StringUtils.fromString(setInstanceHealthRequest.getHealthStatus()));
        }
        if (setInstanceHealthRequest.isShouldRespectGracePeriod() != null) {
            defaultRequest.addParameter("ShouldRespectGracePeriod", StringUtils.fromBoolean(setInstanceHealthRequest.isShouldRespectGracePeriod()));
        }
        return defaultRequest;
    }
}
