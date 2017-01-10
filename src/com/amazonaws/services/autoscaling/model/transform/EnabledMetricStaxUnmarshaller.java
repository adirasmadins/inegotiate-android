package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.EnabledMetric;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class EnabledMetricStaxUnmarshaller implements Unmarshaller<EnabledMetric, StaxUnmarshallerContext> {
    private static EnabledMetricStaxUnmarshaller instance;

    public static EnabledMetricStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new EnabledMetricStaxUnmarshaller();
        }
        return instance;
    }

    public EnabledMetric unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        EnabledMetric enabledMetric = new EnabledMetric();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return enabledMetric;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Metric", i)) {
                    enabledMetric.setMetric(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Granularity", i)) {
                    enabledMetric.setGranularity(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return enabledMetric;
            }
        }
    }
}
