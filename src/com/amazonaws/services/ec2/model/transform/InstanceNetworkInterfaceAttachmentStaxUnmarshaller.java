package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceNetworkInterfaceAttachment;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class InstanceNetworkInterfaceAttachmentStaxUnmarshaller implements Unmarshaller<InstanceNetworkInterfaceAttachment, StaxUnmarshallerContext> {
    private static InstanceNetworkInterfaceAttachmentStaxUnmarshaller instance;

    public static InstanceNetworkInterfaceAttachmentStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceNetworkInterfaceAttachmentStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceNetworkInterfaceAttachment unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceNetworkInterfaceAttachment instanceNetworkInterfaceAttachment = new InstanceNetworkInterfaceAttachment();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceNetworkInterfaceAttachment;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("attachmentId", i)) {
                    instanceNetworkInterfaceAttachment.setAttachmentId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("deviceIndex", i)) {
                    instanceNetworkInterfaceAttachment.setDeviceIndex(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression(DBAdapter.STATUS, i)) {
                    instanceNetworkInterfaceAttachment.setStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("attachTime", i)) {
                    instanceNetworkInterfaceAttachment.setAttachTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("deleteOnTermination", i)) {
                    instanceNetworkInterfaceAttachment.setDeleteOnTermination(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceNetworkInterfaceAttachment;
            }
        }
    }
}
