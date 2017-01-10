package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.BlockDeviceMapping;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class BlockDeviceMappingStaxUnmarshaller implements Unmarshaller<BlockDeviceMapping, StaxUnmarshallerContext> {
    private static BlockDeviceMappingStaxUnmarshaller instance;

    public static BlockDeviceMappingStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BlockDeviceMappingStaxUnmarshaller();
        }
        return instance;
    }

    public BlockDeviceMapping unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        BlockDeviceMapping blockDeviceMapping = new BlockDeviceMapping();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return blockDeviceMapping;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("virtualName", i)) {
                    blockDeviceMapping.setVirtualName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("deviceName", i)) {
                    blockDeviceMapping.setDeviceName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ebs", i)) {
                    blockDeviceMapping.setEbs(EbsBlockDeviceStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("noDevice", i)) {
                    blockDeviceMapping.setNoDevice(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return blockDeviceMapping;
            }
        }
    }
}
