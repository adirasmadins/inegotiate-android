package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeAlarmsForMetricResultStaxUnmarshaller implements Unmarshaller<DescribeAlarmsForMetricResult, StaxUnmarshallerContext> {
    private static DescribeAlarmsForMetricResultStaxUnmarshaller instance;

    public static DescribeAlarmsForMetricResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeAlarmsForMetricResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeAlarmsForMetricResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeAlarmsForMetricResult describeAlarmsForMetricResult = new DescribeAlarmsForMetricResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeAlarmsForMetricResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("MetricAlarms/member", i)) {
                    describeAlarmsForMetricResult.getMetricAlarms().add(MetricAlarmStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeAlarmsForMetricResult;
            }
        }
    }
}
