package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.LaunchSpecification;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class LaunchSpecificationStaxUnmarshaller implements Unmarshaller<LaunchSpecification, StaxUnmarshallerContext> {
    private static LaunchSpecificationStaxUnmarshaller instance;

    public static LaunchSpecificationStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LaunchSpecificationStaxUnmarshaller();
        }
        return instance;
    }

    public LaunchSpecification unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        LaunchSpecification launchSpecification = new LaunchSpecification();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return launchSpecification;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("imageId", i)) {
                    launchSpecification.setImageId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("keyName", i)) {
                    launchSpecification.setKeyName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupSet/item", i)) {
                    launchSpecification.getAllSecurityGroups().add(GroupIdentifierStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupSet/item/groupName", i)) {
                    launchSpecification.getSecurityGroups().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("userData", i)) {
                    launchSpecification.setUserData(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("addressingType", i)) {
                    launchSpecification.setAddressingType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceType", i)) {
                    launchSpecification.setInstanceType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("placement", i)) {
                    launchSpecification.setPlacement(SpotPlacementStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("kernelId", i)) {
                    launchSpecification.setKernelId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ramdiskId", i)) {
                    launchSpecification.setRamdiskId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("blockDeviceMapping/item", i)) {
                    launchSpecification.getBlockDeviceMappings().add(BlockDeviceMappingStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("monitoring/enabled", i)) {
                    launchSpecification.setMonitoringEnabled(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("subnetId", i)) {
                    launchSpecification.setSubnetId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("networkInterfaceSet/item", i)) {
                    launchSpecification.getNetworkInterfaces().add(InstanceNetworkInterfaceSpecificationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("iamInstanceProfile", i)) {
                    launchSpecification.setIamInstanceProfile(IamInstanceProfileSpecificationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ebsOptimized", i)) {
                    launchSpecification.setEbsOptimized(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return launchSpecification;
            }
        }
    }
}
