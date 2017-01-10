package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeReservedInstancesResultStaxUnmarshaller implements Unmarshaller<DescribeReservedInstancesResult, StaxUnmarshallerContext> {
    private static DescribeReservedInstancesResultStaxUnmarshaller instance;

    public static DescribeReservedInstancesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeReservedInstancesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeReservedInstancesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeReservedInstancesResult describeReservedInstancesResult = new DescribeReservedInstancesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeReservedInstancesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("reservedInstancesSet/item", i)) {
                    describeReservedInstancesResult.getReservedInstances().add(ReservedInstancesStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeReservedInstancesResult;
            }
        }
    }
}
