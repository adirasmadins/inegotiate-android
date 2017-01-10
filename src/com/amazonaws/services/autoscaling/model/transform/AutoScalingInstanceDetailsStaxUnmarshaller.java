package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.AutoScalingInstanceDetails;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AutoScalingInstanceDetailsStaxUnmarshaller implements Unmarshaller<AutoScalingInstanceDetails, StaxUnmarshallerContext> {
    private static AutoScalingInstanceDetailsStaxUnmarshaller instance;

    public static AutoScalingInstanceDetailsStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingInstanceDetailsStaxUnmarshaller();
        }
        return instance;
    }

    public AutoScalingInstanceDetails unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AutoScalingInstanceDetails autoScalingInstanceDetails = new AutoScalingInstanceDetails();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return autoScalingInstanceDetails;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("InstanceId", i)) {
                    autoScalingInstanceDetails.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AutoScalingGroupName", i)) {
                    autoScalingInstanceDetails.setAutoScalingGroupName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AvailabilityZone", i)) {
                    autoScalingInstanceDetails.setAvailabilityZone(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("LifecycleState", i)) {
                    autoScalingInstanceDetails.setLifecycleState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("HealthStatus", i)) {
                    autoScalingInstanceDetails.setHealthStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("LaunchConfigurationName", i)) {
                    autoScalingInstanceDetails.setLaunchConfigurationName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return autoScalingInstanceDetails;
            }
        }
    }
}
