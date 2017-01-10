package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.MonitorInstancesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class MonitorInstancesResultStaxUnmarshaller implements Unmarshaller<MonitorInstancesResult, StaxUnmarshallerContext> {
    private static MonitorInstancesResultStaxUnmarshaller instance;

    public static MonitorInstancesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new MonitorInstancesResultStaxUnmarshaller();
        }
        return instance;
    }

    public MonitorInstancesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        MonitorInstancesResult monitorInstancesResult = new MonitorInstancesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return monitorInstancesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instancesSet/item", i)) {
                    monitorInstancesResult.getInstanceMonitorings().add(InstanceMonitoringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return monitorInstancesResult;
            }
        }
    }
}
