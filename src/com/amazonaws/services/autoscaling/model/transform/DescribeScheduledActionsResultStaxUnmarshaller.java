package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.DescribeScheduledActionsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeScheduledActionsResultStaxUnmarshaller implements Unmarshaller<DescribeScheduledActionsResult, StaxUnmarshallerContext> {
    private static DescribeScheduledActionsResultStaxUnmarshaller instance;

    public static DescribeScheduledActionsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeScheduledActionsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeScheduledActionsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeScheduledActionsResult describeScheduledActionsResult = new DescribeScheduledActionsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeScheduledActionsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("ScheduledUpdateGroupActions/member", i)) {
                    describeScheduledActionsResult.getScheduledUpdateGroupActions().add(ScheduledUpdateGroupActionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    describeScheduledActionsResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeScheduledActionsResult;
            }
        }
    }
}
