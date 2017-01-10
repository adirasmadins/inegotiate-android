package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingInstancesResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeAutoScalingInstancesResultStaxUnmarshaller implements Unmarshaller<DescribeAutoScalingInstancesResult, StaxUnmarshallerContext> {
    private static DescribeAutoScalingInstancesResultStaxUnmarshaller instance;

    public static DescribeAutoScalingInstancesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeAutoScalingInstancesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeAutoScalingInstancesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeAutoScalingInstancesResult describeAutoScalingInstancesResult = new DescribeAutoScalingInstancesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeAutoScalingInstancesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AutoScalingInstances/member", i)) {
                    describeAutoScalingInstancesResult.getAutoScalingInstances().add(AutoScalingInstanceDetailsStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    describeAutoScalingInstancesResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeAutoScalingInstancesResult;
            }
        }
    }
}
