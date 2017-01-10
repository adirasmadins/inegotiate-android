package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.cloudwatch.model.Metric;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class MetricStaxUnmarshaller implements Unmarshaller<Metric, StaxUnmarshallerContext> {
    private static MetricStaxUnmarshaller instance;

    public static MetricStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new MetricStaxUnmarshaller();
        }
        return instance;
    }

    public Metric unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Metric metric = new Metric();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return metric;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Namespace", i)) {
                    metric.setNamespace(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MetricName", i)) {
                    metric.setMetricName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Dimensions/member", i)) {
                    metric.getDimensions().add(DimensionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return metric;
            }
        }
    }
}
