package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingNotificationTypesResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeAutoScalingNotificationTypesResultStaxUnmarshaller implements Unmarshaller<DescribeAutoScalingNotificationTypesResult, StaxUnmarshallerContext> {
    private static DescribeAutoScalingNotificationTypesResultStaxUnmarshaller instance;

    public static DescribeAutoScalingNotificationTypesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeAutoScalingNotificationTypesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeAutoScalingNotificationTypesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeAutoScalingNotificationTypesResult describeAutoScalingNotificationTypesResult = new DescribeAutoScalingNotificationTypesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeAutoScalingNotificationTypesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AutoScalingNotificationTypes/member", i)) {
                    describeAutoScalingNotificationTypesResult.getAutoScalingNotificationTypes().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeAutoScalingNotificationTypesResult;
            }
        }
    }
}
