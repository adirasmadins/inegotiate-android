package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.SuspendProcessesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SuspendProcessesRequestMarshaller implements Marshaller<Request<SuspendProcessesRequest>, SuspendProcessesRequest> {
    public Request<SuspendProcessesRequest> marshall(SuspendProcessesRequest suspendProcessesRequest) {
        if (suspendProcessesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SuspendProcessesRequest> defaultRequest = new DefaultRequest(suspendProcessesRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "SuspendProcesses");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (suspendProcessesRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(suspendProcessesRequest.getAutoScalingGroupName()));
        }
        int i = 1;
        for (String str : suspendProcessesRequest.getScalingProcesses()) {
            if (str != null) {
                defaultRequest.addParameter("ScalingProcesses.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
