package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.UnmonitorInstancesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class UnmonitorInstancesResultStaxUnmarshaller implements Unmarshaller<UnmonitorInstancesResult, StaxUnmarshallerContext> {
    private static UnmonitorInstancesResultStaxUnmarshaller instance;

    public static UnmonitorInstancesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UnmonitorInstancesResultStaxUnmarshaller();
        }
        return instance;
    }

    public UnmonitorInstancesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        UnmonitorInstancesResult unmonitorInstancesResult = new UnmonitorInstancesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return unmonitorInstancesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instancesSet/item", i)) {
                    unmonitorInstancesResult.getInstanceMonitorings().add(InstanceMonitoringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return unmonitorInstancesResult;
            }
        }
    }
}
