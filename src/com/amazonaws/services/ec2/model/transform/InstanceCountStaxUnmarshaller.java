package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceCount;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceCountStaxUnmarshaller implements Unmarshaller<InstanceCount, StaxUnmarshallerContext> {
    private static InstanceCountStaxUnmarshaller instance;

    public static InstanceCountStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceCountStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceCount unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceCount instanceCount = new InstanceCount();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceCount;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("state", i)) {
                    instanceCount.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceCount", i)) {
                    instanceCount.setInstanceCount(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceCount;
            }
        }
    }
}
