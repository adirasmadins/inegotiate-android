package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeAlarmHistoryResultStaxUnmarshaller implements Unmarshaller<DescribeAlarmHistoryResult, StaxUnmarshallerContext> {
    private static DescribeAlarmHistoryResultStaxUnmarshaller instance;

    public static DescribeAlarmHistoryResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeAlarmHistoryResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeAlarmHistoryResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeAlarmHistoryResult describeAlarmHistoryResult = new DescribeAlarmHistoryResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeAlarmHistoryResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AlarmHistoryItems/member", i)) {
                    describeAlarmHistoryResult.getAlarmHistoryItems().add(AlarmHistoryItemStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    describeAlarmHistoryResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeAlarmHistoryResult;
            }
        }
    }
}
