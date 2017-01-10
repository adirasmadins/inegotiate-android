package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.AvailabilityZone;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AvailabilityZoneStaxUnmarshaller implements Unmarshaller<AvailabilityZone, StaxUnmarshallerContext> {
    private static AvailabilityZoneStaxUnmarshaller instance;

    public static AvailabilityZoneStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AvailabilityZoneStaxUnmarshaller();
        }
        return instance;
    }

    public AvailabilityZone unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AvailabilityZone availabilityZone = new AvailabilityZone();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return availabilityZone;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("zoneName", i)) {
                    availabilityZone.setZoneName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("zoneState", i)) {
                    availabilityZone.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("regionName", i)) {
                    availabilityZone.setRegionName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("messageSet/item", i)) {
                    availabilityZone.getMessages().add(AvailabilityZoneMessageStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return availabilityZone;
            }
        }
    }
}
