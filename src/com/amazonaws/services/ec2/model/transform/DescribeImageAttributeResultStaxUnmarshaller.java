package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeImageAttributeResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeImageAttributeResultStaxUnmarshaller implements Unmarshaller<DescribeImageAttributeResult, StaxUnmarshallerContext> {
    private static DescribeImageAttributeResultStaxUnmarshaller instance;

    public static DescribeImageAttributeResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeImageAttributeResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeImageAttributeResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeImageAttributeResult describeImageAttributeResult = new DescribeImageAttributeResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeImageAttributeResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(".", i)) {
                    describeImageAttributeResult.setImageAttribute(ImageAttributeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeImageAttributeResult;
            }
        }
    }
}
