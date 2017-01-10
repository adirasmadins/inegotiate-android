package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.DescribeAdjustmentTypesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeAdjustmentTypesResultStaxUnmarshaller implements Unmarshaller<DescribeAdjustmentTypesResult, StaxUnmarshallerContext> {
    private static DescribeAdjustmentTypesResultStaxUnmarshaller instance;

    public static DescribeAdjustmentTypesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeAdjustmentTypesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeAdjustmentTypesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeAdjustmentTypesResult describeAdjustmentTypesResult = new DescribeAdjustmentTypesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeAdjustmentTypesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AdjustmentTypes/member", i)) {
                    describeAdjustmentTypesResult.getAdjustmentTypes().add(AdjustmentTypeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeAdjustmentTypesResult;
            }
        }
    }
}
