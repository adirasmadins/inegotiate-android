package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.ResumeProcessesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ResumeProcessesRequestMarshaller implements Marshaller<Request<ResumeProcessesRequest>, ResumeProcessesRequest> {
    public Request<ResumeProcessesRequest> marshall(ResumeProcessesRequest resumeProcessesRequest) {
        if (resumeProcessesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ResumeProcessesRequest> defaultRequest = new DefaultRequest(resumeProcessesRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "ResumeProcesses");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (resumeProcessesRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(resumeProcessesRequest.getAutoScalingGroupName()));
        }
        int i = 1;
        for (String str : resumeProcessesRequest.getScalingProcesses()) {
            if (str != null) {
                defaultRequest.addParameter("ScalingProcesses.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
