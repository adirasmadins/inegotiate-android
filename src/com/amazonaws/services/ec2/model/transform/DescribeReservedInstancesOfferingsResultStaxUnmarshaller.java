package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesOfferingsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeReservedInstancesOfferingsResultStaxUnmarshaller implements Unmarshaller<DescribeReservedInstancesOfferingsResult, StaxUnmarshallerContext> {
    private static DescribeReservedInstancesOfferingsResultStaxUnmarshaller instance;

    public static DescribeReservedInstancesOfferingsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeReservedInstancesOfferingsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeReservedInstancesOfferingsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeReservedInstancesOfferingsResult describeReservedInstancesOfferingsResult = new DescribeReservedInstancesOfferingsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeReservedInstancesOfferingsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("reservedInstancesOfferingsSet/item", i)) {
                    describeReservedInstancesOfferingsResult.getReservedInstancesOfferings().add(ReservedInstancesOfferingStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("nextToken", i)) {
                    describeReservedInstancesOfferingsResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeReservedInstancesOfferingsResult;
            }
        }
    }
}
