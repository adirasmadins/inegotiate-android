package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceMonitoring;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceMonitoringStaxUnmarshaller implements Unmarshaller<InstanceMonitoring, StaxUnmarshallerContext> {
    private static InstanceMonitoringStaxUnmarshaller instance;

    public static InstanceMonitoringStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceMonitoringStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceMonitoring unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceMonitoring instanceMonitoring = new InstanceMonitoring();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceMonitoring;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instanceId", i)) {
                    instanceMonitoring.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("monitoring", i)) {
                    instanceMonitoring.setMonitoring(MonitoringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceMonitoring;
            }
        }
    }
}
