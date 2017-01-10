package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.AutoScalingGroup;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AutoScalingGroupStaxUnmarshaller implements Unmarshaller<AutoScalingGroup, StaxUnmarshallerContext> {
    private static AutoScalingGroupStaxUnmarshaller instance;

    public static AutoScalingGroupStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingGroupStaxUnmarshaller();
        }
        return instance;
    }

    public AutoScalingGroup unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AutoScalingGroup autoScalingGroup = new AutoScalingGroup();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return autoScalingGroup;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AutoScalingGroupName", i)) {
                    autoScalingGroup.setAutoScalingGroupName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AutoScalingGroupARN", i)) {
                    autoScalingGroup.setAutoScalingGroupARN(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("LaunchConfigurationName", i)) {
                    autoScalingGroup.setLaunchConfigurationName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MinSize", i)) {
                    autoScalingGroup.setMinSize(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MaxSize", i)) {
                    autoScalingGroup.setMaxSize(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("DesiredCapacity", i)) {
                    autoScalingGroup.setDesiredCapacity(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("DefaultCooldown", i)) {
                    autoScalingGroup.setDefaultCooldown(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AvailabilityZones/member", i)) {
                    autoScalingGroup.getAvailabilityZones().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("LoadBalancerNames/member", i)) {
                    autoScalingGroup.getLoadBalancerNames().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("HealthCheckType", i)) {
                    autoScalingGroup.setHealthCheckType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("HealthCheckGracePeriod", i)) {
                    autoScalingGroup.setHealthCheckGracePeriod(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Instances/member", i)) {
                    autoScalingGroup.getInstances().add(InstanceStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("CreatedTime", i)) {
                    autoScalingGroup.setCreatedTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("SuspendedProcesses/member", i)) {
                    autoScalingGroup.getSuspendedProcesses().add(SuspendedProcessStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("PlacementGroup", i)) {
                    autoScalingGroup.setPlacementGroup(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("VPCZoneIdentifier", i)) {
                    autoScalingGroup.setVPCZoneIdentifier(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("EnabledMetrics/member", i)) {
                    autoScalingGroup.getEnabledMetrics().add(EnabledMetricStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Status", i)) {
                    autoScalingGroup.setStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Tags/member", i)) {
                    autoScalingGroup.getTags().add(TagDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("TerminationPolicies/member", i)) {
                    autoScalingGroup.getTerminationPolicies().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return autoScalingGroup;
            }
        }
    }
}
