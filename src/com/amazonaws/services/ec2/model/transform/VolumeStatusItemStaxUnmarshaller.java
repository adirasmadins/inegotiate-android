package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.VolumeStatusItem;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class VolumeStatusItemStaxUnmarshaller implements Unmarshaller<VolumeStatusItem, StaxUnmarshallerContext> {
    private static VolumeStatusItemStaxUnmarshaller instance;

    public static VolumeStatusItemStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VolumeStatusItemStaxUnmarshaller();
        }
        return instance;
    }

    public VolumeStatusItem unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        VolumeStatusItem volumeStatusItem = new VolumeStatusItem();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return volumeStatusItem;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("volumeId", i)) {
                    volumeStatusItem.setVolumeId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("availabilityZone", i)) {
                    volumeStatusItem.setAvailabilityZone(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("volumeStatus", i)) {
                    volumeStatusItem.setVolumeStatus(VolumeStatusInfoStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("eventsSet/item", i)) {
                    volumeStatusItem.getEvents().add(VolumeStatusEventStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("actionsSet/item", i)) {
                    volumeStatusItem.getActions().add(VolumeStatusActionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return volumeStatusItem;
            }
        }
    }
}
