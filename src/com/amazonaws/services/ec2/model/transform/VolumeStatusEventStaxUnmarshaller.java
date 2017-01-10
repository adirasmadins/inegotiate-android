package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.VolumeStatusEvent;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class VolumeStatusEventStaxUnmarshaller implements Unmarshaller<VolumeStatusEvent, StaxUnmarshallerContext> {
    private static VolumeStatusEventStaxUnmarshaller instance;

    public static VolumeStatusEventStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VolumeStatusEventStaxUnmarshaller();
        }
        return instance;
    }

    public VolumeStatusEvent unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        VolumeStatusEvent volumeStatusEvent = new VolumeStatusEvent();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return volumeStatusEvent;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("eventType", i)) {
                    volumeStatusEvent.setEventType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("description", i)) {
                    volumeStatusEvent.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("notBefore", i)) {
                    volumeStatusEvent.setNotBefore(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("notAfter", i)) {
                    volumeStatusEvent.setNotAfter(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("eventId", i)) {
                    volumeStatusEvent.setEventId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return volumeStatusEvent;
            }
        }
    }
}
