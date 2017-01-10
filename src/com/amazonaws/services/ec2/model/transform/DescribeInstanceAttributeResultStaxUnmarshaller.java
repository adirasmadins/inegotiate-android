package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeInstanceAttributeResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeInstanceAttributeResultStaxUnmarshaller implements Unmarshaller<DescribeInstanceAttributeResult, StaxUnmarshallerContext> {
    private static DescribeInstanceAttributeResultStaxUnmarshaller instance;

    public static DescribeInstanceAttributeResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeInstanceAttributeResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeInstanceAttributeResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeInstanceAttributeResult describeInstanceAttributeResult = new DescribeInstanceAttributeResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeInstanceAttributeResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(".", i)) {
                    describeInstanceAttributeResult.setInstanceAttribute(InstanceAttributeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeInstanceAttributeResult;
            }
        }
    }
}
