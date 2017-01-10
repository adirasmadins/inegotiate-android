package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.TerminateInstanceInAutoScalingGroupResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class TerminateInstanceInAutoScalingGroupResultStaxUnmarshaller implements Unmarshaller<TerminateInstanceInAutoScalingGroupResult, StaxUnmarshallerContext> {
    private static TerminateInstanceInAutoScalingGroupResultStaxUnmarshaller instance;

    public static TerminateInstanceInAutoScalingGroupResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new TerminateInstanceInAutoScalingGroupResultStaxUnmarshaller();
        }
        return instance;
    }

    public TerminateInstanceInAutoScalingGroupResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        TerminateInstanceInAutoScalingGroupResult terminateInstanceInAutoScalingGroupResult = new TerminateInstanceInAutoScalingGroupResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return terminateInstanceInAutoScalingGroupResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Activity", i)) {
                    terminateInstanceInAutoScalingGroupResult.setActivity(ActivityStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return terminateInstanceInAutoScalingGroupResult;
            }
        }
    }
}
