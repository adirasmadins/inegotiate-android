package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingGroupsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeAutoScalingGroupsResultStaxUnmarshaller implements Unmarshaller<DescribeAutoScalingGroupsResult, StaxUnmarshallerContext> {
    private static DescribeAutoScalingGroupsResultStaxUnmarshaller instance;

    public static DescribeAutoScalingGroupsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeAutoScalingGroupsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeAutoScalingGroupsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeAutoScalingGroupsResult describeAutoScalingGroupsResult = new DescribeAutoScalingGroupsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeAutoScalingGroupsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AutoScalingGroups/member", i)) {
                    describeAutoScalingGroupsResult.getAutoScalingGroups().add(AutoScalingGroupStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    describeAutoScalingGroupsResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeAutoScalingGroupsResult;
            }
        }
    }
}
