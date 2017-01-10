package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ReservedInstancesOffering;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.FloatStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ReservedInstancesOfferingStaxUnmarshaller implements Unmarshaller<ReservedInstancesOffering, StaxUnmarshallerContext> {
    private static ReservedInstancesOfferingStaxUnmarshaller instance;

    public static ReservedInstancesOfferingStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReservedInstancesOfferingStaxUnmarshaller();
        }
        return instance;
    }

    public ReservedInstancesOffering unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ReservedInstancesOffering reservedInstancesOffering = new ReservedInstancesOffering();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return reservedInstancesOffering;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("reservedInstancesOfferingId", i)) {
                    reservedInstancesOffering.setReservedInstancesOfferingId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceType", i)) {
                    reservedInstancesOffering.setInstanceType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("availabilityZone", i)) {
                    reservedInstancesOffering.setAvailabilityZone(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("duration", i)) {
                    reservedInstancesOffering.setDuration(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("usagePrice", i)) {
                    reservedInstancesOffering.setUsagePrice(FloatStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("fixedPrice", i)) {
                    reservedInstancesOffering.setFixedPrice(FloatStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("productDescription", i)) {
                    reservedInstancesOffering.setProductDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceTenancy", i)) {
                    reservedInstancesOffering.setInstanceTenancy(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("currencyCode", i)) {
                    reservedInstancesOffering.setCurrencyCode(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("offeringType", i)) {
                    reservedInstancesOffering.setOfferingType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("recurringCharges/item", i)) {
                    reservedInstancesOffering.getRecurringCharges().add(RecurringChargeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("marketplace", i)) {
                    reservedInstancesOffering.setMarketplace(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("pricingDetailsSet/item", i)) {
                    reservedInstancesOffering.getPricingDetails().add(PricingDetailStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return reservedInstancesOffering;
            }
        }
    }
}
