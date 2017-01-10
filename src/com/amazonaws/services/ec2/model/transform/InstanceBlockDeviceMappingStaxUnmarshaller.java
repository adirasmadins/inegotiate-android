package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceBlockDeviceMapping;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceBlockDeviceMappingStaxUnmarshaller implements Unmarshaller<InstanceBlockDeviceMapping, StaxUnmarshallerContext> {
    private static InstanceBlockDeviceMappingStaxUnmarshaller instance;

    public static InstanceBlockDeviceMappingStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceBlockDeviceMappingStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceBlockDeviceMapping unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceBlockDeviceMapping instanceBlockDeviceMapping = new InstanceBlockDeviceMapping();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceBlockDeviceMapping;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("deviceName", i)) {
                    instanceBlockDeviceMapping.setDeviceName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ebs", i)) {
                    instanceBlockDeviceMapping.setEbs(EbsInstanceBlockDeviceStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceBlockDeviceMapping;
            }
        }
    }
}
