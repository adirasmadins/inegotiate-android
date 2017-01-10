package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.AvailabilityZoneMessage;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AvailabilityZoneMessageStaxUnmarshaller implements Unmarshaller<AvailabilityZoneMessage, StaxUnmarshallerContext> {
    private static AvailabilityZoneMessageStaxUnmarshaller instance;

    public static AvailabilityZoneMessageStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AvailabilityZoneMessageStaxUnmarshaller();
        }
        return instance;
    }

    public AvailabilityZoneMessage unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AvailabilityZoneMessage availabilityZoneMessage = new AvailabilityZoneMessage();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return availabilityZoneMessage;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("message", i)) {
                    availabilityZoneMessage.setMessage(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return availabilityZoneMessage;
            }
        }
    }
}
