package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CancelReservedInstancesListingResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CancelReservedInstancesListingResultStaxUnmarshaller implements Unmarshaller<CancelReservedInstancesListingResult, StaxUnmarshallerContext> {
    private static CancelReservedInstancesListingResultStaxUnmarshaller instance;

    public static CancelReservedInstancesListingResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CancelReservedInstancesListingResultStaxUnmarshaller();
        }
        return instance;
    }

    public CancelReservedInstancesListingResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CancelReservedInstancesListingResult cancelReservedInstancesListingResult = new CancelReservedInstancesListingResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return cancelReservedInstancesListingResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("reservedInstancesListingsSet/item", i)) {
                    cancelReservedInstancesListingResult.getReservedInstancesListings().add(ReservedInstancesListingStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return cancelReservedInstancesListingResult;
            }
        }
    }
}
