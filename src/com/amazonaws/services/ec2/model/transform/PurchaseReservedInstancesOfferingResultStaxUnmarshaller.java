package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.PurchaseReservedInstancesOfferingResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class PurchaseReservedInstancesOfferingResultStaxUnmarshaller implements Unmarshaller<PurchaseReservedInstancesOfferingResult, StaxUnmarshallerContext> {
    private static PurchaseReservedInstancesOfferingResultStaxUnmarshaller instance;

    public static PurchaseReservedInstancesOfferingResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PurchaseReservedInstancesOfferingResultStaxUnmarshaller();
        }
        return instance;
    }

    public PurchaseReservedInstancesOfferingResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PurchaseReservedInstancesOfferingResult purchaseReservedInstancesOfferingResult = new PurchaseReservedInstancesOfferingResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return purchaseReservedInstancesOfferingResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("reservedInstancesId", i)) {
                    purchaseReservedInstancesOfferingResult.setReservedInstancesId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return purchaseReservedInstancesOfferingResult;
            }
        }
    }
}
