package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ReservedInstancesListing;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class ReservedInstancesListingStaxUnmarshaller implements Unmarshaller<ReservedInstancesListing, StaxUnmarshallerContext> {
    private static ReservedInstancesListingStaxUnmarshaller instance;

    public static ReservedInstancesListingStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReservedInstancesListingStaxUnmarshaller();
        }
        return instance;
    }

    public ReservedInstancesListing unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ReservedInstancesListing reservedInstancesListing = new ReservedInstancesListing();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return reservedInstancesListing;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("reservedInstancesListingId", i)) {
                    reservedInstancesListing.setReservedInstancesListingId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("reservedInstancesId", i)) {
                    reservedInstancesListing.setReservedInstancesId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("createDate", i)) {
                    reservedInstancesListing.setCreateDate(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("updateDate", i)) {
                    reservedInstancesListing.setUpdateDate(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression(DBAdapter.STATUS, i)) {
                    reservedInstancesListing.setStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("statusMessage", i)) {
                    reservedInstancesListing.setStatusMessage(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceCounts/item", i)) {
                    reservedInstancesListing.getInstanceCounts().add(InstanceCountStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("priceSchedules/item", i)) {
                    reservedInstancesListing.getPriceSchedules().add(PriceScheduleStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("tagSet/item", i)) {
                    reservedInstancesListing.getTags().add(TagStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("clientToken", i)) {
                    reservedInstancesListing.setClientToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return reservedInstancesListing;
            }
        }
    }
}
