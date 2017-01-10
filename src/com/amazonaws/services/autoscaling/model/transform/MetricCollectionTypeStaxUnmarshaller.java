package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.MetricCollectionType;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class MetricCollectionTypeStaxUnmarshaller implements Unmarshaller<MetricCollectionType, StaxUnmarshallerContext> {
    private static MetricCollectionTypeStaxUnmarshaller instance;

    public static MetricCollectionTypeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new MetricCollectionTypeStaxUnmarshaller();
        }
        return instance;
    }

    public MetricCollectionType unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        MetricCollectionType metricCollectionType = new MetricCollectionType();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return metricCollectionType;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Metric", i)) {
                    metricCollectionType.setMetric(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return metricCollectionType;
            }
        }
    }
}
