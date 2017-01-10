package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class GetMetricStatisticsResultStaxUnmarshaller implements Unmarshaller<GetMetricStatisticsResult, StaxUnmarshallerContext> {
    private static GetMetricStatisticsResultStaxUnmarshaller instance;

    public static GetMetricStatisticsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetMetricStatisticsResultStaxUnmarshaller();
        }
        return instance;
    }

    public GetMetricStatisticsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetMetricStatisticsResult getMetricStatisticsResult = new GetMetricStatisticsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return getMetricStatisticsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Label", i)) {
                    getMetricStatisticsResult.setLabel(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Datapoints/member", i)) {
                    getMetricStatisticsResult.getDatapoints().add(DatapointStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return getMetricStatisticsResult;
            }
        }
    }
}
