package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.VolumeStatusAction;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class VolumeStatusActionStaxUnmarshaller implements Unmarshaller<VolumeStatusAction, StaxUnmarshallerContext> {
    private static VolumeStatusActionStaxUnmarshaller instance;

    public static VolumeStatusActionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VolumeStatusActionStaxUnmarshaller();
        }
        return instance;
    }

    public VolumeStatusAction unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        VolumeStatusAction volumeStatusAction = new VolumeStatusAction();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return volumeStatusAction;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("code", i)) {
                    volumeStatusAction.setCode(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("description", i)) {
                    volumeStatusAction.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("eventType", i)) {
                    volumeStatusAction.setEventType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("eventId", i)) {
                    volumeStatusAction.setEventId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return volumeStatusAction;
            }
        }
    }
}
