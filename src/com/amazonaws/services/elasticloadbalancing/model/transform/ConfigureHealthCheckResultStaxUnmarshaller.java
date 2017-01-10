package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.ConfigureHealthCheckResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ConfigureHealthCheckResultStaxUnmarshaller implements Unmarshaller<ConfigureHealthCheckResult, StaxUnmarshallerContext> {
    private static ConfigureHealthCheckResultStaxUnmarshaller instance;

    public static ConfigureHealthCheckResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConfigureHealthCheckResultStaxUnmarshaller();
        }
        return instance;
    }

    public ConfigureHealthCheckResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ConfigureHealthCheckResult configureHealthCheckResult = new ConfigureHealthCheckResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return configureHealthCheckResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("HealthCheck", i)) {
                    configureHealthCheckResult.setHealthCheck(HealthCheckStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return configureHealthCheckResult;
            }
        }
    }
}
