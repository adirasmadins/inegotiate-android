package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeInstancesResultStaxUnmarshaller implements Unmarshaller<DescribeInstancesResult, StaxUnmarshallerContext> {
    private static DescribeInstancesResultStaxUnmarshaller instance;

    public static DescribeInstancesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeInstancesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeInstancesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeInstancesResult describeInstancesResult = new DescribeInstancesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeInstancesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("reservationSet/item", i)) {
                    describeInstancesResult.getReservations().add(ReservationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeInstancesResult;
            }
        }
    }
}
