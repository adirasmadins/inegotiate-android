package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeConversionTasksResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeConversionTasksResultStaxUnmarshaller implements Unmarshaller<DescribeConversionTasksResult, StaxUnmarshallerContext> {
    private static DescribeConversionTasksResultStaxUnmarshaller instance;

    public static DescribeConversionTasksResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeConversionTasksResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeConversionTasksResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeConversionTasksResult describeConversionTasksResult = new DescribeConversionTasksResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeConversionTasksResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("conversionTasks/item", i)) {
                    describeConversionTasksResult.getConversionTasks().add(ConversionTaskStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeConversionTasksResult;
            }
        }
    }
}
