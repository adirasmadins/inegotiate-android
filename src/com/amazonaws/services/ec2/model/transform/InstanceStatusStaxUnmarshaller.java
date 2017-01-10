package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceStatus;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceStatusStaxUnmarshaller implements Unmarshaller<InstanceStatus, StaxUnmarshallerContext> {
    private static InstanceStatusStaxUnmarshaller instance;

    public static InstanceStatusStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceStatusStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceStatus unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceStatus instanceStatus = new InstanceStatus();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceStatus;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instanceId", i)) {
                    instanceStatus.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("availabilityZone", i)) {
                    instanceStatus.setAvailabilityZone(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("eventsSet/item", i)) {
                    instanceStatus.getEvents().add(InstanceStatusEventStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceState", i)) {
                    instanceStatus.setInstanceState(InstanceStateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("systemStatus", i)) {
                    instanceStatus.setSystemStatus(InstanceStatusSummaryStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceStatus", i)) {
                    instanceStatus.setInstanceStatus(InstanceStatusSummaryStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceStatus;
            }
        }
    }
}
