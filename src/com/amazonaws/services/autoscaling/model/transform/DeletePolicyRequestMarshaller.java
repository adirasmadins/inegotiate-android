package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DeletePolicyRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeletePolicyRequestMarshaller implements Marshaller<Request<DeletePolicyRequest>, DeletePolicyRequest> {
    public Request<DeletePolicyRequest> marshall(DeletePolicyRequest deletePolicyRequest) {
        if (deletePolicyRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeletePolicyRequest> defaultRequest = new DefaultRequest(deletePolicyRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DeletePolicy");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (deletePolicyRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(deletePolicyRequest.getAutoScalingGroupName()));
        }
        if (deletePolicyRequest.getPolicyName() != null) {
            defaultRequest.addParameter("PolicyName", StringUtils.fromString(deletePolicyRequest.getPolicyName()));
        }
        return defaultRequest;
    }
}
