package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesListingsResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeReservedInstancesListingsResultStaxUnmarshaller implements Unmarshaller<DescribeReservedInstancesListingsResult, StaxUnmarshallerContext> {
    private static DescribeReservedInstancesListingsResultStaxUnmarshaller instance;

    public static DescribeReservedInstancesListingsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeReservedInstancesListingsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeReservedInstancesListingsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeReservedInstancesListingsResult describeReservedInstancesListingsResult = new DescribeReservedInstancesListingsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeReservedInstancesListingsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("reservedInstancesListingsSet/item", i)) {
                    describeReservedInstancesListingsResult.getReservedInstancesListings().add(ReservedInstancesListingStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeReservedInstancesListingsResult;
            }
        }
    }
}
