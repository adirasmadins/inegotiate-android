package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceAttribute;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceAttributeStaxUnmarshaller implements Unmarshaller<InstanceAttribute, StaxUnmarshallerContext> {
    private static InstanceAttributeStaxUnmarshaller instance;

    public static InstanceAttributeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceAttributeStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceAttribute unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceAttribute instanceAttribute = new InstanceAttribute();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceAttribute;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instanceId", i)) {
                    instanceAttribute.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceType/value", i)) {
                    instanceAttribute.setInstanceType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("kernel/value", i)) {
                    instanceAttribute.setKernelId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ramdisk/value", i)) {
                    instanceAttribute.setRamdiskId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("userData/value", i)) {
                    instanceAttribute.setUserData(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("disableApiTermination/value", i)) {
                    instanceAttribute.setDisableApiTermination(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceInitiatedShutdownBehavior/value", i)) {
                    instanceAttribute.setInstanceInitiatedShutdownBehavior(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("rootDeviceName/value", i)) {
                    instanceAttribute.setRootDeviceName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("blockDeviceMapping/item", i)) {
                    instanceAttribute.getBlockDeviceMappings().add(InstanceBlockDeviceMappingStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("productCodes/item", i)) {
                    instanceAttribute.getProductCodes().add(ProductCodeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ebsOptimized/value", i)) {
                    instanceAttribute.setEbsOptimized(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceAttribute;
            }
        }
    }
}
