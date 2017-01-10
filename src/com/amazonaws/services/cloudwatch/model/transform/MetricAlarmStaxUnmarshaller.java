package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.cloudwatch.model.MetricAlarm;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class MetricAlarmStaxUnmarshaller implements Unmarshaller<MetricAlarm, StaxUnmarshallerContext> {
    private static MetricAlarmStaxUnmarshaller instance;

    public static MetricAlarmStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new MetricAlarmStaxUnmarshaller();
        }
        return instance;
    }

    public MetricAlarm unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        MetricAlarm metricAlarm = new MetricAlarm();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return metricAlarm;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AlarmName", i)) {
                    metricAlarm.setAlarmName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AlarmArn", i)) {
                    metricAlarm.setAlarmArn(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AlarmDescription", i)) {
                    metricAlarm.setAlarmDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AlarmConfigurationUpdatedTimestamp", i)) {
                    metricAlarm.setAlarmConfigurationUpdatedTimestamp(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ActionsEnabled", i)) {
                    metricAlarm.setActionsEnabled(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("OKActions/member", i)) {
                    metricAlarm.getOKActions().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AlarmActions/member", i)) {
                    metricAlarm.getAlarmActions().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("InsufficientDataActions/member", i)) {
                    metricAlarm.getInsufficientDataActions().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("StateValue", i)) {
                    metricAlarm.setStateValue(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("StateReason", i)) {
                    metricAlarm.setStateReason(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("StateReasonData", i)) {
                    metricAlarm.setStateReasonData(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("StateUpdatedTimestamp", i)) {
                    metricAlarm.setStateUpdatedTimestamp(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MetricName", i)) {
                    metricAlarm.setMetricName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Namespace", i)) {
                    metricAlarm.setNamespace(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Statistic", i)) {
                    metricAlarm.setStatistic(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Dimensions/member", i)) {
                    metricAlarm.getDimensions().add(DimensionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Period", i)) {
                    metricAlarm.setPeriod(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Unit", i)) {
                    metricAlarm.setUnit(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("EvaluationPeriods", i)) {
                    metricAlarm.setEvaluationPeriods(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Threshold", i)) {
                    metricAlarm.setThreshold(DoubleStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ComparisonOperator", i)) {
                    metricAlarm.setComparisonOperator(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return metricAlarm;
            }
        }
    }
}
