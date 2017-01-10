package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.SetDesiredCapacityRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SetDesiredCapacityRequestMarshaller implements Marshaller<Request<SetDesiredCapacityRequest>, SetDesiredCapacityRequest> {
    public Request<SetDesiredCapacityRequest> marshall(SetDesiredCapacityRequest setDesiredCapacityRequest) {
        if (setDesiredCapacityRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetDesiredCapacityRequest> defaultRequest = new DefaultRequest(setDesiredCapacityRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "SetDesiredCapacity");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (setDesiredCapacityRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(setDesiredCapacityRequest.getAutoScalingGroupName()));
        }
        if (setDesiredCapacityRequest.getDesiredCapacity() != null) {
            defaultRequest.addParameter("DesiredCapacity", StringUtils.fromInteger(setDesiredCapacityRequest.getDesiredCapacity()));
        }
        if (setDesiredCapacityRequest.isHonorCooldown() != null) {
            defaultRequest.addParameter("HonorCooldown", StringUtils.fromBoolean(setDesiredCapacityRequest.isHonorCooldown()));
        }
        return defaultRequest;
    }
}
