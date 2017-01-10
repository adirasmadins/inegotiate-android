package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.VolumeAttachment;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class VolumeAttachmentStaxUnmarshaller implements Unmarshaller<VolumeAttachment, StaxUnmarshallerContext> {
    private static VolumeAttachmentStaxUnmarshaller instance;

    public static VolumeAttachmentStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VolumeAttachmentStaxUnmarshaller();
        }
        return instance;
    }

    public VolumeAttachment unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        VolumeAttachment volumeAttachment = new VolumeAttachment();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return volumeAttachment;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("volumeId", i)) {
                    volumeAttachment.setVolumeId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceId", i)) {
                    volumeAttachment.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("device", i)) {
                    volumeAttachment.setDevice(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression(DBAdapter.STATUS, i)) {
                    volumeAttachment.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("attachTime", i)) {
                    volumeAttachment.setAttachTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("deleteOnTermination", i)) {
                    volumeAttachment.setDeleteOnTermination(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return volumeAttachment;
            }
        }
    }
}
