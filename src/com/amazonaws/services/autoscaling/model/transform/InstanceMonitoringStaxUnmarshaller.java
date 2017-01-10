package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.InstanceMonitoring;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
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
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceMonitoring;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(BucketVersioningConfiguration.ENABLED, i)) {
                    instanceMonitoring.setEnabled(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceMonitoring;
            }
        }
    }
}
