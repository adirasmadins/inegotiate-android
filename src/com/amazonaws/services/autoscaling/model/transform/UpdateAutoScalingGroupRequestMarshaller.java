package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.UpdateAutoScalingGroupRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class UpdateAutoScalingGroupRequestMarshaller implements Marshaller<Request<UpdateAutoScalingGroupRequest>, UpdateAutoScalingGroupRequest> {
    public Request<UpdateAutoScalingGroupRequest> marshall(UpdateAutoScalingGroupRequest updateAutoScalingGroupRequest) {
        int i = 1;
        if (updateAutoScalingGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<UpdateAutoScalingGroupRequest> defaultRequest = new DefaultRequest(updateAutoScalingGroupRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "UpdateAutoScalingGroup");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (updateAutoScalingGroupRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(updateAutoScalingGroupRequest.getAutoScalingGroupName()));
        }
        if (updateAutoScalingGroupRequest.getLaunchConfigurationName() != null) {
            defaultRequest.addParameter("LaunchConfigurationName", StringUtils.fromString(updateAutoScalingGroupRequest.getLaunchConfigurationName()));
        }
        if (updateAutoScalingGroupRequest.getMinSize() != null) {
            defaultRequest.addParameter("MinSize", StringUtils.fromInteger(updateAutoScalingGroupRequest.getMinSize()));
        }
        if (updateAutoScalingGroupRequest.getMaxSize() != null) {
            defaultRequest.addParameter("MaxSize", StringUtils.fromInteger(updateAutoScalingGroupRequest.getMaxSize()));
        }
        if (updateAutoScalingGroupRequest.getDesiredCapacity() != null) {
            defaultRequest.addParameter("DesiredCapacity", StringUtils.fromInteger(updateAutoScalingGroupRequest.getDesiredCapacity()));
        }
        if (updateAutoScalingGroupRequest.getDefaultCooldown() != null) {
            defaultRequest.addParameter("DefaultCooldown", StringUtils.fromInteger(updateAutoScalingGroupRequest.getDefaultCooldown()));
        }
        int i2 = 1;
        for (String str : updateAutoScalingGroupRequest.getAvailabilityZones()) {
            if (str != null) {
                defaultRequest.addParameter("AvailabilityZones.member." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        if (updateAutoScalingGroupRequest.getHealthCheckType() != null) {
            defaultRequest.addParameter("HealthCheckType", StringUtils.fromString(updateAutoScalingGroupRequest.getHealthCheckType()));
        }
        if (updateAutoScalingGroupRequest.getHealthCheckGracePeriod() != null) {
            defaultRequest.addParameter("HealthCheckGracePeriod", StringUtils.fromInteger(updateAutoScalingGroupRequest.getHealthCheckGracePeriod()));
        }
        if (updateAutoScalingGroupRequest.getPlacementGroup() != null) {
            defaultRequest.addParameter("PlacementGroup", StringUtils.fromString(updateAutoScalingGroupRequest.getPlacementGroup()));
        }
        if (updateAutoScalingGroupRequest.getVPCZoneIdentifier() != null) {
            defaultRequest.addParameter("VPCZoneIdentifier", StringUtils.fromString(updateAutoScalingGroupRequest.getVPCZoneIdentifier()));
        }
        for (String str2 : updateAutoScalingGroupRequest.getTerminationPolicies()) {
            if (str2 != null) {
                defaultRequest.addParameter("TerminationPolicies.member." + i, StringUtils.fromString(str2));
            }
            i++;
        }
        return defaultRequest;
    }
}
