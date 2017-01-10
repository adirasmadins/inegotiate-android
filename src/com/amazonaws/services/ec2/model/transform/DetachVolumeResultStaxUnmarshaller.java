package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DetachVolumeResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DetachVolumeResultStaxUnmarshaller implements Unmarshaller<DetachVolumeResult, StaxUnmarshallerContext> {
    private static DetachVolumeResultStaxUnmarshaller instance;

    public static DetachVolumeResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DetachVolumeResultStaxUnmarshaller();
        }
        return instance;
    }

    public DetachVolumeResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DetachVolumeResult detachVolumeResult = new DetachVolumeResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return detachVolumeResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(".", i)) {
                    detachVolumeResult.setAttachment(VolumeAttachmentStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return detachVolumeResult;
            }
        }
    }
}
