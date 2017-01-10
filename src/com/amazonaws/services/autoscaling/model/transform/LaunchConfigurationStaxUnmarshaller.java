package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.LaunchConfiguration;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class LaunchConfigurationStaxUnmarshaller implements Unmarshaller<LaunchConfiguration, StaxUnmarshallerContext> {
    private static LaunchConfigurationStaxUnmarshaller instance;

    public static LaunchConfigurationStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LaunchConfigurationStaxUnmarshaller();
        }
        return instance;
    }

    public LaunchConfiguration unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        LaunchConfiguration launchConfiguration = new LaunchConfiguration();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return launchConfiguration;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("LaunchConfigurationName", i)) {
                    launchConfiguration.setLaunchConfigurationName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("LaunchConfigurationARN", i)) {
                    launchConfiguration.setLaunchConfigurationARN(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ImageId", i)) {
                    launchConfiguration.setImageId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("KeyName", i)) {
                    launchConfiguration.setKeyName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("SecurityGroups/member", i)) {
                    launchConfiguration.getSecurityGroups().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("UserData", i)) {
                    launchConfiguration.setUserData(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("InstanceType", i)) {
                    launchConfiguration.setInstanceType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("KernelId", i)) {
                    launchConfiguration.setKernelId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("RamdiskId", i)) {
                    launchConfiguration.setRamdiskId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("BlockDeviceMappings/member", i)) {
                    launchConfiguration.getBlockDeviceMappings().add(BlockDeviceMappingStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("InstanceMonitoring", i)) {
                    launchConfiguration.setInstanceMonitoring(InstanceMonitoringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("SpotPrice", i)) {
                    launchConfiguration.setSpotPrice(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("IamInstanceProfile", i)) {
                    launchConfiguration.setIamInstanceProfile(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("CreatedTime", i)) {
                    launchConfiguration.setCreatedTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return launchConfiguration;
            }
        }
    }
}
