package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.DescribeScalingProcessTypesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeScalingProcessTypesResultStaxUnmarshaller implements Unmarshaller<DescribeScalingProcessTypesResult, StaxUnmarshallerContext> {
    private static DescribeScalingProcessTypesResultStaxUnmarshaller instance;

    public static DescribeScalingProcessTypesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeScalingProcessTypesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeScalingProcessTypesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeScalingProcessTypesResult describeScalingProcessTypesResult = new DescribeScalingProcessTypesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeScalingProcessTypesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Processes/member", i)) {
                    describeScalingProcessTypesResult.getProcesses().add(ProcessTypeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeScalingProcessTypesResult;
            }
        }
    }
}
