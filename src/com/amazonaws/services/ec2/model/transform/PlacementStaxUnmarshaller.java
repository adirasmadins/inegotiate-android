package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.Placement;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class PlacementStaxUnmarshaller implements Unmarshaller<Placement, StaxUnmarshallerContext> {
    private static PlacementStaxUnmarshaller instance;

    public static PlacementStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PlacementStaxUnmarshaller();
        }
        return instance;
    }

    public Placement unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Placement placement = new Placement();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return placement;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("availabilityZone", i)) {
                    placement.setAvailabilityZone(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupName", i)) {
                    placement.setGroupName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("tenancy", i)) {
                    placement.setTenancy(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return placement;
            }
        }
    }
}
