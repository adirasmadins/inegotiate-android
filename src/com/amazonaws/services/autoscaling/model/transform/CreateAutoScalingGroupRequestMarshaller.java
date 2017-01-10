package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.CreateAutoScalingGroupRequest;
import com.amazonaws.services.autoscaling.model.Tag;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateAutoScalingGroupRequestMarshaller implements Marshaller<Request<CreateAutoScalingGroupRequest>, CreateAutoScalingGroupRequest> {
    public Request<CreateAutoScalingGroupRequest> marshall(CreateAutoScalingGroupRequest createAutoScalingGroupRequest) {
        int i = 1;
        if (createAutoScalingGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateAutoScalingGroupRequest> defaultRequest = new DefaultRequest(createAutoScalingGroupRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "CreateAutoScalingGroup");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (createAutoScalingGroupRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(createAutoScalingGroupRequest.getAutoScalingGroupName()));
        }
        if (createAutoScalingGroupRequest.getLaunchConfigurationName() != null) {
            defaultRequest.addParameter("LaunchConfigurationName", StringUtils.fromString(createAutoScalingGroupRequest.getLaunchConfigurationName()));
        }
        if (createAutoScalingGroupRequest.getMinSize() != null) {
            defaultRequest.addParameter("MinSize", StringUtils.fromInteger(createAutoScalingGroupRequest.getMinSize()));
        }
        if (createAutoScalingGroupRequest.getMaxSize() != null) {
            defaultRequest.addParameter("MaxSize", StringUtils.fromInteger(createAutoScalingGroupRequest.getMaxSize()));
        }
        if (createAutoScalingGroupRequest.getDesiredCapacity() != null) {
            defaultRequest.addParameter("DesiredCapacity", StringUtils.fromInteger(createAutoScalingGroupRequest.getDesiredCapacity()));
        }
        if (createAutoScalingGroupRequest.getDefaultCooldown() != null) {
            defaultRequest.addParameter("DefaultCooldown", StringUtils.fromInteger(createAutoScalingGroupRequest.getDefaultCooldown()));
        }
        int i2 = 1;
        for (String str : createAutoScalingGroupRequest.getAvailabilityZones()) {
            if (str != null) {
                defaultRequest.addParameter("AvailabilityZones.member." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        i2 = 1;
        for (String str2 : createAutoScalingGroupRequest.getLoadBalancerNames()) {
            if (str2 != null) {
                defaultRequest.addParameter("LoadBalancerNames.member." + i2, StringUtils.fromString(str2));
            }
            i2++;
        }
        if (createAutoScalingGroupRequest.getHealthCheckType() != null) {
            defaultRequest.addParameter("HealthCheckType", StringUtils.fromString(createAutoScalingGroupRequest.getHealthCheckType()));
        }
        if (createAutoScalingGroupRequest.getHealthCheckGracePeriod() != null) {
            defaultRequest.addParameter("HealthCheckGracePeriod", StringUtils.fromInteger(createAutoScalingGroupRequest.getHealthCheckGracePeriod()));
        }
        if (createAutoScalingGroupRequest.getPlacementGroup() != null) {
            defaultRequest.addParameter("PlacementGroup", StringUtils.fromString(createAutoScalingGroupRequest.getPlacementGroup()));
        }
        if (createAutoScalingGroupRequest.getVPCZoneIdentifier() != null) {
            defaultRequest.addParameter("VPCZoneIdentifier", StringUtils.fromString(createAutoScalingGroupRequest.getVPCZoneIdentifier()));
        }
        i2 = 1;
        for (String str22 : createAutoScalingGroupRequest.getTerminationPolicies()) {
            if (str22 != null) {
                defaultRequest.addParameter("TerminationPolicies.member." + i2, StringUtils.fromString(str22));
            }
            i2++;
        }
        for (Tag tag : createAutoScalingGroupRequest.getTags()) {
            if (tag != null) {
                if (tag.getResourceId() != null) {
                    defaultRequest.addParameter("Tags.member." + i + ".ResourceId", StringUtils.fromString(tag.getResourceId()));
                }
                if (tag.getResourceType() != null) {
                    defaultRequest.addParameter("Tags.member." + i + ".ResourceType", StringUtils.fromString(tag.getResourceType()));
                }
                if (tag.getKey() != null) {
                    defaultRequest.addParameter("Tags.member." + i + ".Key", StringUtils.fromString(tag.getKey()));
                }
                if (tag.getValue() != null) {
                    defaultRequest.addParameter("Tags.member." + i + ".Value", StringUtils.fromString(tag.getValue()));
                }
                if (tag.isPropagateAtLaunch() != null) {
                    defaultRequest.addParameter("Tags.member." + i + ".PropagateAtLaunch", StringUtils.fromBoolean(tag.isPropagateAtLaunch()));
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
