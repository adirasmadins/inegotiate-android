package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.PutScalingPolicyRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class PutScalingPolicyRequestMarshaller implements Marshaller<Request<PutScalingPolicyRequest>, PutScalingPolicyRequest> {
    public Request<PutScalingPolicyRequest> marshall(PutScalingPolicyRequest putScalingPolicyRequest) {
        if (putScalingPolicyRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<PutScalingPolicyRequest> defaultRequest = new DefaultRequest(putScalingPolicyRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "PutScalingPolicy");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (putScalingPolicyRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(putScalingPolicyRequest.getAutoScalingGroupName()));
        }
        if (putScalingPolicyRequest.getPolicyName() != null) {
            defaultRequest.addParameter("PolicyName", StringUtils.fromString(putScalingPolicyRequest.getPolicyName()));
        }
        if (putScalingPolicyRequest.getScalingAdjustment() != null) {
            defaultRequest.addParameter("ScalingAdjustment", StringUtils.fromInteger(putScalingPolicyRequest.getScalingAdjustment()));
        }
        if (putScalingPolicyRequest.getAdjustmentType() != null) {
            defaultRequest.addParameter("AdjustmentType", StringUtils.fromString(putScalingPolicyRequest.getAdjustmentType()));
        }
        if (putScalingPolicyRequest.getCooldown() != null) {
            defaultRequest.addParameter("Cooldown", StringUtils.fromInteger(putScalingPolicyRequest.getCooldown()));
        }
        if (putScalingPolicyRequest.getMinAdjustmentStep() != null) {
            defaultRequest.addParameter("MinAdjustmentStep", StringUtils.fromInteger(putScalingPolicyRequest.getMinAdjustmentStep()));
        }
        return defaultRequest;
    }
}
