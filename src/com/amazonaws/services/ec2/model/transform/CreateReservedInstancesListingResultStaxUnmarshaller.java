package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CreateReservedInstancesListingResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateReservedInstancesListingResultStaxUnmarshaller implements Unmarshaller<CreateReservedInstancesListingResult, StaxUnmarshallerContext> {
    private static CreateReservedInstancesListingResultStaxUnmarshaller instance;

    public static CreateReservedInstancesListingResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateReservedInstancesListingResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateReservedInstancesListingResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateReservedInstancesListingResult createReservedInstancesListingResult = new CreateReservedInstancesListingResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return createReservedInstancesListingResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("reservedInstancesListingsSet/item", i)) {
                    createReservedInstancesListingResult.getReservedInstancesListings().add(ReservedInstancesListingStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createReservedInstancesListingResult;
            }
        }
    }
}
