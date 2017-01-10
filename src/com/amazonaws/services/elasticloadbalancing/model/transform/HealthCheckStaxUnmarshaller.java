package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.HealthCheck;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class HealthCheckStaxUnmarshaller implements Unmarshaller<HealthCheck, StaxUnmarshallerContext> {
    private static HealthCheckStaxUnmarshaller instance;

    public static HealthCheckStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new HealthCheckStaxUnmarshaller();
        }
        return instance;
    }

    public HealthCheck unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        HealthCheck healthCheck = new HealthCheck();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return healthCheck;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Target", i)) {
                    healthCheck.setTarget(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Interval", i)) {
                    healthCheck.setInterval(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Timeout", i)) {
                    healthCheck.setTimeout(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("UnhealthyThreshold", i)) {
                    healthCheck.setUnhealthyThreshold(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("HealthyThreshold", i)) {
                    healthCheck.setHealthyThreshold(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return healthCheck;
            }
        }
    }
}
