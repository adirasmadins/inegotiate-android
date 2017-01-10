package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.AttachVolumeResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AttachVolumeResultStaxUnmarshaller implements Unmarshaller<AttachVolumeResult, StaxUnmarshallerContext> {
    private static AttachVolumeResultStaxUnmarshaller instance;

    public static AttachVolumeResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AttachVolumeResultStaxUnmarshaller();
        }
        return instance;
    }

    public AttachVolumeResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AttachVolumeResult attachVolumeResult = new AttachVolumeResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return attachVolumeResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(".", i)) {
                    attachVolumeResult.setAttachment(VolumeAttachmentStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return attachVolumeResult;
            }
        }
    }
}
