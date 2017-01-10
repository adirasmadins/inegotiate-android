package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.MetricGranularityType;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class MetricGranularityTypeStaxUnmarshaller implements Unmarshaller<MetricGranularityType, StaxUnmarshallerContext> {
    private static MetricGranularityTypeStaxUnmarshaller instance;

    public static MetricGranularityTypeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new MetricGranularityTypeStaxUnmarshaller();
        }
        return instance;
    }

    public MetricGranularityType unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        MetricGranularityType metricGranularityType = new MetricGranularityType();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return metricGranularityType;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Granularity", i)) {
                    metricGranularityType.setGranularity(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return metricGranularityType;
            }
        }
    }
}
