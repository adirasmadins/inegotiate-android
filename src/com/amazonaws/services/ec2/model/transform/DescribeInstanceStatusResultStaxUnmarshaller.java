package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeInstanceStatusResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeInstanceStatusResultStaxUnmarshaller implements Unmarshaller<DescribeInstanceStatusResult, StaxUnmarshallerContext> {
    private static DescribeInstanceStatusResultStaxUnmarshaller instance;

    public static DescribeInstanceStatusResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeInstanceStatusResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeInstanceStatusResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeInstanceStatusResult describeInstanceStatusResult = new DescribeInstanceStatusResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeInstanceStatusResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instanceStatusSet/item", i)) {
                    describeInstanceStatusResult.getInstanceStatuses().add(InstanceStatusStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("nextToken", i)) {
                    describeInstanceStatusResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeInstanceStatusResult;
            }
        }
    }
}
