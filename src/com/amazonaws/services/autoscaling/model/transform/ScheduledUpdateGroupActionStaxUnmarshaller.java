package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.ScheduledUpdateGroupAction;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ScheduledUpdateGroupActionStaxUnmarshaller implements Unmarshaller<ScheduledUpdateGroupAction, StaxUnmarshallerContext> {
    private static ScheduledUpdateGroupActionStaxUnmarshaller instance;

    public static ScheduledUpdateGroupActionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ScheduledUpdateGroupActionStaxUnmarshaller();
        }
        return instance;
    }

    public ScheduledUpdateGroupAction unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ScheduledUpdateGroupAction scheduledUpdateGroupAction = new ScheduledUpdateGroupAction();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return scheduledUpdateGroupAction;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AutoScalingGroupName", i)) {
                    scheduledUpdateGroupAction.setAutoScalingGroupName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ScheduledActionName", i)) {
                    scheduledUpdateGroupAction.setScheduledActionName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ScheduledActionARN", i)) {
                    scheduledUpdateGroupAction.setScheduledActionARN(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Time", i)) {
                    scheduledUpdateGroupAction.setTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("StartTime", i)) {
                    scheduledUpdateGroupAction.setStartTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("EndTime", i)) {
                    scheduledUpdateGroupAction.setEndTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Recurrence", i)) {
                    scheduledUpdateGroupAction.setRecurrence(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MinSize", i)) {
                    scheduledUpdateGroupAction.setMinSize(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MaxSize", i)) {
                    scheduledUpdateGroupAction.setMaxSize(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("DesiredCapacity", i)) {
                    scheduledUpdateGroupAction.setDesiredCapacity(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return scheduledUpdateGroupAction;
            }
        }
    }
}
