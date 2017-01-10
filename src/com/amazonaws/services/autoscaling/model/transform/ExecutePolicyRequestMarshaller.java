package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.ExecutePolicyRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ExecutePolicyRequestMarshaller implements Marshaller<Request<ExecutePolicyRequest>, ExecutePolicyRequest> {
    public Request<ExecutePolicyRequest> marshall(ExecutePolicyRequest executePolicyRequest) {
        if (executePolicyRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ExecutePolicyRequest> defaultRequest = new DefaultRequest(executePolicyRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "ExecutePolicy");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (executePolicyRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(executePolicyRequest.getAutoScalingGroupName()));
        }
        if (executePolicyRequest.getPolicyName() != null) {
            defaultRequest.addParameter("PolicyName", StringUtils.fromString(executePolicyRequest.getPolicyName()));
        }
        if (executePolicyRequest.isHonorCooldown() != null) {
            defaultRequest.addParameter("HonorCooldown", StringUtils.fromBoolean(executePolicyRequest.isHonorCooldown()));
        }
        return defaultRequest;
    }
}
