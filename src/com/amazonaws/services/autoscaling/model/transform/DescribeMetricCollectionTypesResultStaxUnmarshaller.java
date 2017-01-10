package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.DescribeMetricCollectionTypesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeMetricCollectionTypesResultStaxUnmarshaller implements Unmarshaller<DescribeMetricCollectionTypesResult, StaxUnmarshallerContext> {
    private static DescribeMetricCollectionTypesResultStaxUnmarshaller instance;

    public static DescribeMetricCollectionTypesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeMetricCollectionTypesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeMetricCollectionTypesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeMetricCollectionTypesResult describeMetricCollectionTypesResult = new DescribeMetricCollectionTypesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeMetricCollectionTypesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Metrics/member", i)) {
                    describeMetricCollectionTypesResult.getMetrics().add(MetricCollectionTypeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Granularities/member", i)) {
                    describeMetricCollectionTypesResult.getGranularities().add(MetricGranularityTypeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeMetricCollectionTypesResult;
            }
        }
    }
}
