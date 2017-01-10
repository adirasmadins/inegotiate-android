package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.Monitoring;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class MonitoringStaxUnmarshaller implements Unmarshaller<Monitoring, StaxUnmarshallerContext> {
    private static MonitoringStaxUnmarshaller instance;

    public static MonitoringStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new MonitoringStaxUnmarshaller();
        }
        return instance;
    }

    public Monitoring unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Monitoring monitoring = new Monitoring();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return monitoring;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("state", i)) {
                    monitoring.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return monitoring;
            }
        }
    }
}
