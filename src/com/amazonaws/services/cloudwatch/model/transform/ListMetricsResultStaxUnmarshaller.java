package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.cloudwatch.model.ListMetricsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ListMetricsResultStaxUnmarshaller implements Unmarshaller<ListMetricsResult, StaxUnmarshallerContext> {
    private static ListMetricsResultStaxUnmarshaller instance;

    public static ListMetricsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListMetricsResultStaxUnmarshaller();
        }
        return instance;
    }

    public ListMetricsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ListMetricsResult listMetricsResult = new ListMetricsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return listMetricsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Metrics/member", i)) {
                    listMetricsResult.getMetrics().add(MetricStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    listMetricsResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return listMetricsResult;
            }
        }
    }
}
